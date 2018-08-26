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

  def main(args: Array[String]){

      //   val c = new SparkContext(new SparkConf().setAppName("asd"))

    println("Hello")
    val spark = SparkSession.builder().appName("ETL").enableHiveSupport().getOrCreate()
  // val spark = SparkSession.builder().appName("xxxxx").enableHiveSupport().getOrCreate()
  //  val sqlcontext: SQLContext = spark.sqlContext

   // val st_time  = spark.sql(s""" select CURRENT_TIMESTAMP """).take(1)(0).get(0).toString

   // println(st_time);
    println(spark.sparkContext.master);
 //   val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()
   //val spark = SparkSession.builder().appName("VootMobileDataETL").master("local[*]").enableHiveSupport().getOrCreate()
    //val sc = spark.sparkContext
  // val conf:SparkConf = new SparkConf().setAppName("Histogram")
//     val conf:SparkConf = new SparkConf().setAppName("Histogram").setMaster("local[*]")

   // val sparkConf =new SparkConf().setAppName("Histogram").setMaster("local[*]")
  //  val sparkSession: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
//    import sparkSession.implicits._
  //  val sc = sparkSession.sparkContext
    //val conf = new SparkConf().setAppName("appName").setMaster("local")
   // new SparkContext(conf)

   // val sc:SparkContext = new SparkContext(conf)
   //  val d=  sc.parallelize(Seq(1,2,3))
  // val config = new SparkConf()
   // config.setMaster("local[*]")
 //   import org.apache.spark.SparkConf
   // import org.apache.spark.SparkContext
   // val sparkConf = new SparkConf().setAppName("Gathering Data").setMaster("yarn")
   // val sc = new SparkContext(sparkConf)



  //  val config = new SparkConf().setAppName("HelloWorld")
  //  config.setMaster("local");
  //  val context = new SparkContext(config);

    println("Application executed!")

    //d.foreach(println)

/*....word count....*/
      /*
    val rawData = sc.textFile(args(0))
    //convert the lines into words using flatMap operation
    val words = rawData.flatMap(line => line.split(" "))
    //count the individual words using map and reduceByKey operation
    val wordCount = words.map(word => (word, 1)).reduceByKey(_ + _)
    //Save the result
    wordCount.saveAsTextFile(args(1))
    //stop the spark context

*/







     println("TestSuccessfull");
  }
}

