/* BASICS */
// Declaring values using var/val (mutable/immutable), try using val!
val x1 = 10
var x2 = 20
x2 = 30
// Declare type explicit
val e: Double = 1.0

/* STRING OPERATIONS */
// Basic operations (Java/Scala methods)
"hello world".length
"hello world".substring(2, 6) // chars at position 2-6
"hello world".replace("world", "moon")
"hello world".take(5) // remove everything after position 5
"hello world".drop(5) // "" starting at last char
// String Interpolation
val x3 = 10
s"We have $x3 people in this crowd!"
val x4 = Array(1, 2, 3)
s"I bought this car ${x4(0) + x4(2)} years ago!"

/* FUNCTIONS */
// Basic Declaration, name(param: type): return-type (can be guessed too)
def square(x: Int, y: Int): Int = {
  val x5 = x * y
  x5 + 1 // last result = return
}
def squareShort(x: Int, y: Int): Int = (x * y) + 1
square(1, 1)
squareShort(1, 1)
// Using parameter names
square(y=4, x=4)
// Functions with default parameters
def default(x: Int, y: Int = 5) = x + y
default(5)
// Anonymous functions, Int => Int (takes Int, returns Int)
val toTen: Int => Int = x => x * 10
toTen(10)
// Shorter definition
val toTwenty: Int => Int = _ + 20
toTwenty(10)

/* FLOW CONTROL */
// Basic range object declaration
val r1 = 1 to 5
r1.foreach(println) // do println per item
val r2 =  5 to 1 by -1
r2.foreach(println)
// While Loop
var i = 0
while (i < 10) { println("i " + i); i += 1 }
// Recursive function (needs explicit return type) Unit == void
def showNumbers(a: Int, b: Int): Unit = {
  print(a)
  if (a < b)
    showNumbers(a+1, b)
}
showNumbers(1, 12)
// Conditionals
val text = if (x1 == 10) "yeah" else "nope"

/* DATA STRUCTURES */
// Declaring an Array (immutable)
val a = Array(1, 2, 3, 4, 5)
a(0) // 1
// Declaring a Map
val m = Map("dude" -> "man", "gril" -> "women")
m("dude") // man
// Declaring a Set
val s = Set(1, 3, 3, 7)
s(0) // false
s(1) // true
// Tuples
val t1 = (x1, 1, 2, "three")
t1._1 // 10
val (t2, t3) = (1, 2)
println(t3) // 2

/* OBJECT ORIENTED PROGRAMMING */
// the only top-level constructs allowed are: objects, classes, case-classes, traits!
class Dog(br: String) {
  var breed: String = br
  def bark = "Woof! Woof!"
}
val mydog = new Dog("Schäferhund")
println(mydog.breed)
println(mydog.bark)
// "object" keyword creates type AND singleton instance of it
object Dogg {
  def knownBreeds = List("Pitbull", "Schäferhund", "Zwerg")
  def createDog(breed: String) = new Dog(breed)
}
Dogg.knownBreeds
// Case Classes: often have few mthods, methods rarely have side-effects, purpose: hold immutable data!
case class Person(name: String, phone: String)
val john = Person("John", "1337")
john.phone // getter 4 free
Person("John", "1337") == Person("Jane", "1337") //false, per field equality
val otherJohn = john.copy(phone = "1338") // easy to copy

/* FUNCTION PROGRAMMING */
// taking an Int and returning an Int
val f1: Int => Int = _ + 10
List(1, 2, 3) map f1 // map each item to function f1
// Usage of anonymous functions
List(1, 2, 3) map (x => x + 20)
// Usage of underscore if only one argument is present
List(1, 2, 3) map (_ + 30)
// if anonymous blokc and function both take on argument, omit underscore
List("John", "Jane", "Jillian") foreach println
// Combinators
val s2 = Set(1, 2, 3)
val allToTen = s.map(toTen)
allToTen.filter(_ < 10) // filter result
allToTen.sum // 110 (10 + 30 + 70)
List(1, 2, 3) filter (_ > 2) // 3
// For comprehensions
for {n <- s} yield toTen(n)

/* TESTING */

/*
result == expected
expect(true) { some_bool_function }
result should be (3)
num should not be even
one should be < 7
seven should be (7.0 +- 0.2)
string should startWith ("Hello")
string should include ("seven")
string should startWith regex "Hel*o"
traversable should be empty
traversable should contain ("five")
List(1,2,3) should contain oneOf/noneOf (1,5,7)
"howdy" should contain 'h'
List(1,2,3) should contain atLeastOneOf (2,3,4)
result should be [Player]
an [IndexOutOfBoundsException] should be thrownBy s.charAt(-1)
noException should be thrownBy 0 / 1
 */