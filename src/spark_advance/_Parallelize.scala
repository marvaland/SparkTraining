package spark_advance


import java.util.concurrent.Executors

import org.apache.spark.sql.{SQLContext, SparkSession}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, _}
import scala.util.control.NonFatal
object _Parallelize {

  def main(args: Array[String]) {


    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()


     val pool = Executors.newFixedThreadPool(12)
    implicit val xc = ExecutionContext.fromExecutorService(pool)


    println("TestSuccessfull");
  }
}
