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

object _Operator_symbol {

  def main(args: Array[String]) {




    val conf:SparkConf = new SparkConf().setAppName("Histogram").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)


    //map(x, y => x._2 + y._2) = >  map(_._2 + _._2)

   // First '_' is for placeholder of anonymous function; Second '_2' is member of case class

   // reduceByKey((a,b) => a+b) => reduceByKey(_ + _)

    println("TestSuccessfull");
  }
}

