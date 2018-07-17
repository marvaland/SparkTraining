package spark_basic

import org.apache.spark.sql.SparkSession
import java.util.concurrent.Executors
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, _}
import scala.util.control.NonFatal

object Test_Local {

  def main(args: Array[String]) {




   val conf:SparkConf = new SparkConf().setAppName("Histogram").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)


/*....word count....*/
    val rawData = sc.textFile(args(0))
    //convert the lines into words using flatMap operation
    val words = rawData.flatMap(line => line.split(" "))
    //count the individual words using map and reduceByKey operation
    val wordCount = words.map(word => (word, 1)).reduceByKey(_ + _)
    //Save the result
    wordCount.saveAsTextFile(args(1))
    //stop the spark context









     println("TestSuccessfull");
  }
}

