package spark_basic
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{Dataset, SQLContext, SparkSession}


//data set //data freame // RDD
object _Spark_DataTypes {
  case class Person(name : String , age : Int)
  def main(args: Array[String]) {


    val spark = SparkSession.builder().appName("VootMobileDataETL").enableHiveSupport().getOrCreate()

    /*----collection....*/
    val data = Array(1, 2, 3, 4, 5)
    data.map(a=>a+1).map(z=>(z,1)).map(x=>x)

    val fruit: List[String] = List("apples", "oranges", "pears")


    var s : Set[Int] = Set(1,3,5,7)

    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    val t = new Tuple3(1, "hello", Console)

    val a:Option[Int] = Some(5)

    val ita = Iterator(20,40,2,50,69, 90)


    /*   data set - data Frame --RDD */

    val personRDD = spark.sparkContext.makeRDD(Seq(Person("A",10),Person("B",20)))

    val df = spark.createDataFrame(personRDD).toDF()

   // val ds:  Dataset[Person] = df.as[Person]



    df.select("name").show()
    import spark.implicits._
    df.select($"name", $"age" + 1).show()



    println("TestSuccessfull");
  }
}
