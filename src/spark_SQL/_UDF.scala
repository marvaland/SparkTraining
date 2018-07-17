package spark_SQL;

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.SQLContext
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


class SimpleUDFExample extends UDF {
  def evaluate(input: Text) : Text = {
    if (input == null) return null
    return new Text("Hello " + input.toString)
  }
}

object _UDF {



  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()
    val sqlcontext: SQLContext = spark.sqlContext

    sqlcontext.sql("create temporary function hello as 'SimpleUDFExample'")
    val result = sqlcontext.sql("""
        select hello(name) from products_avro order by month, name, price
       """)
    result.collect.foreach(println)
  }
}

