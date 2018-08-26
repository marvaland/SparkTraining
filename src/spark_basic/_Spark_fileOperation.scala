package spark_basic


import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.SQLContext

object _Spark_fileOperation {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext
    spark.conf.set(
      "fs.azure.account.key.<your-storage-account-name>.blob.core.windows.net",
      "<your-storage-account-access-key>")
    spark.sparkContext.hadoopConfiguration.set(
      "fs.azure.account.key.<your-storage-account-name>.blob.core.windows.net",
      "<your-storage-account-access-key>"
    )

  //read
    val sample =spark.sqlContext.read.textFile("file:D:\\Training\\HDinsight_Spark\\sample.txt")

    val json_source = spark.read.json("file:\\D:\\sample data\\V18\\sample.json")
    val csv_source = spark.read.csv("wasb://xxxx@xxxx.blob.core.windows.net/test/file.csv")

    var df = spark.read.json("logs.json")
    val showdlyparq = sqlcontext.read.parquet("wasb://xxxxxx@xxxxxxxxx.blob.core.windows.net/xxxx/xxxx/")

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



