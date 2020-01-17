1+2
case class Person(name : String = "Dieter"){
}
val p1 = Person()
p1.name


case class Start(time: Int){
}
case class End(endtime: Int){
}

val start = Start(20)
val ende = End(start.time + 40)
start.time

var matrix = Array(20, 30, 20, 5, 234, 54, 32, 5, 4, 3)
var myList = Array(Range(10, 20))
matrix(0) = 100

matrix
myList

  var x = myList(5)+matrix(5)
  x

object würfel(){
  var groesse = 6
  var zahlen = Array(Range(1, groesse))
}