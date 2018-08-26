package spark_SQL

import org.apache.spark.sql.SparkSession
import java.util.concurrent.Executors
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, _}
import scala.util.control.NonFatal


object _Test {

  def main(args: Array[String]) {

   val spark = SparkSession.builder().appName("xxxxx").master("local[*]").enableHiveSupport().getOrCreate()
   // val spark = SparkSession.builder().appName("xxxxx").master("yarn").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext



    val st_time  = spark.sql(s""" select CURRENT_TIMESTAMP """).take(1)(0).get(0).toString

    println(st_time);
    println(spark.sparkContext.master);
  }
}
