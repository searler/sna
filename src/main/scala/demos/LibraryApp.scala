package demos

import sna.Library
import sna.Library
import sna.Library

object LibraryApp extends App {
 
  val myLib = Library("c")
  println(myLib.atol("0345")[Int])
  println(myLib.malloc(1000)[Long])
  myLib.printf("[printf] clock: %ld\n", myLib.clock().asInstanceOf[Int]).as[Unit]
  myLib.printf("value: %d %f", 123, 3.12).as[Unit]
}