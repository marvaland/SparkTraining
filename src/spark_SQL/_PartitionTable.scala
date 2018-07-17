package spark_SQL
package _PartitionTable

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.SQLContext


object _PartitionTable {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext

    spark.sql("set hive.exec.dynamic.partition.mode=nonstrict")
    spark.sql("set hive.exec.dynamic.partition=true")


   // spark.sql(s"""insert into default.datatableloadhistory partition(date_stamp) select CURRENT_DATE,CURRENT_DATE,'$jobTime','$load_type','APP','0','$st_time','$end_time','$min','$status','VALIDATION$jobTime','$date_set' as date_stamp from DataTableloadHistory limit 1""")

    println("TestSuccessfull");
  }
}




