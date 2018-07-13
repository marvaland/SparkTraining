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



    println("TestSuccessfull");
  }
}

