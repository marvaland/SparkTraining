package spark_basic


import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.SQLContext

object _Spark_fileOperation {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext


  //read


    val json_source = spark.read.json("wasb://xxxx@xxxx.blob.core.windows.net/voot/jsonTest/arb-data-c09-s01-r02_2017-01-31.arb.json")
    val csv_source = spark.read.csv("wasb://xxxx@xxxx.blob.core.windows.net/test/file.csv")

    var df = spark.read.json("logs.json")
    val showdlyparq = sqlcontext.read.parquet("wasb://viacom18@v18biblobstorprod.blob.core.windows.net/voot/DAILY_DWH_TO_BLOB_CONTENT_MAPPER/")

    val dataFrame1 = spark.read.json("example.json")
    val dataFrame2 = spark.read.csv("example.csv")
    val dataFrame3 = spark.read.parquet("example.parquet")
    val dataFrame = spark.read.orc("example.orc")




    //write
    showdlyparq.write.format("parquet").mode("append").option("spark.sql.parquet.compression.codec", "snappy").save(args(0))


    //write - partition

    //

    println("TestSuccessfull");
  }
}

