package spark_basic
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext


object _Executor_cal {

  def main(args: Array[String]) {




    val conf:SparkConf = new SparkConf().setAppName("Histogram").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)



    println("TestSuccessfull");
  }
}
