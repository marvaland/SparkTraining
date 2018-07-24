package spark_basic


object _OOP {   //object only one instance ie you can access without new keyword

}
trait  t1 {
  def implemented( x: Int ): Int = x+1
  def Not_implemented( x: Int )

}
trait  t2 {
  def Not_implementedT2( x: Int )

}
object o {

}
class c1 extends t1 {
  override def Not_implemented(x: Int): Unit = x+2
}

class c2 extends t1 with t2 {  //mixing i
  override def Not_implemented(x: Int): Unit = x+2
  override def Not_implementedT2(x: Int): Unit = x+3
}

