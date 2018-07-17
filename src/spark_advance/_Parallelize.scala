package spark_advance


import org.apache.spark.sql.{ DataFrame, Dataset, SparkSession }
import org.apache.spark.sql.{ functions => f }
import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._


object _Parallelize {

  def main(args: Array[String]) {
    import scala.util.Random

    val  spark = SparkSession.builder().appName("Ads_Content_Viewer_show").enableHiveSupport().getOrCreate()
    import spark.sqlContext.implicits._


    val df = spark.sparkContext.parallelize(List.fill(100)(Random.nextLong)).toDF
    df.agg(f.avg("value")).head()


    println("TestSuccessfull");
  }
}
