package spark_basic

import org.apache.spark.{SparkConf, SparkContext}


object _Accumulator {

  def main(args: Array[String]): Unit = {
    val conf:SparkConf = new SparkConf().setAppName("Histogram").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)
    val accum = sc.accumulator(0)

  }
}
