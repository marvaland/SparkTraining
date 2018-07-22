package spark_SQL

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.SQLContext


object _Test {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("xxxxx").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext

    val st_time  = spark.sql(s""" select CURRENT_TIMESTAMP """).take(1)(0).get(0).toString

    println("TestSuccessfull");
  }
}
