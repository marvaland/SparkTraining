

package spark_streaming


// Add this lines
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ // not necessary since Spark 1.3
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.{Seconds, StreamingContext}

//Base
import org.apache.spark.sql.SparkSession
import java.util.concurrent.Executors
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, _}
import scala.util.control.NonFatal

object Twitter {

  def main(args: Array[String]): Unit = {


   var Consumer_Key =	""
   var  Consumer_Secret =	""
   var Access_Token =""
   var Access_Token_Secret	=""

    // Create a local StreamingContext with two working thread and batch interval of 1 second.
    // The master requires 2 cores to prevent from a starvation scenario.

    val conf = new SparkConf().setMaster("local[*]").setAppName("Spark Streaming - PopularHashTags")
    val sc = new SparkContext(conf)

   sc.setLogLevel("WARN")

  //  val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters =Seq("Environment")// args.takeRight(args.length - 4)

    // Set the system properties so that Twitter4j library used by twitter stream
    // can use them to generat OAuth credentials
    System.setProperty("twitter4j.oauth.consumerKey", Consumer_Key)
    System.setProperty("twitter4j.oauth.consumerSecret", Consumer_Secret)
    System.setProperty("twitter4j.oauth.accessToken", Access_Token)
    System.setProperty("twitter4j.oauth.accessTokenSecret", Access_Token_Secret)

    // Set the Spark StreamingContext to create a DStream for every 5 seconds
    val ssc = new StreamingContext(sc, Seconds(5))
    // Pass the filter keywords as arguements

    //  val stream = FlumeUtils.createStream(ssc, args(0), args(1).toInt)
    val stream = TwitterUtils.createStream(ssc, None, filters)

    // Split the stream on space and extract hashtags
    val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))

    // Get the top hashtags over the previous 60 sec window
    val topCounts60 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(60))
      .map { case (topic, count) => (count, topic) }
      .transform(_.sortByKey(false))

    // Get the top hashtags over the previous 10 sec window
    val topCounts10 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(10))
      .map { case (topic, count) => (count, topic) }
      .transform(_.sortByKey(false))

    // print tweets in the currect DStream
    stream.print()

    // Print popular hashtags
    topCounts60.foreachRDD(rdd => {
      val topList = rdd.take(10)
      println("\nPopular topics in last 60 seconds (%s total):".format(rdd.count()))
      topList.foreach { case (count, tag) => println("%s (%s tweets)".format(tag, count)) }
    })
    topCounts10.foreachRDD(rdd => {
      val topList = rdd.take(10)
      println("\nPopular topics in last 10 seconds (%s total):".format(rdd.count()))
      topList.foreach { case (count, tag) => println("%s (%s tweets)".format(tag, count)) }
    })

    ssc.start()
    ssc.awaitTermination()




  }
}
