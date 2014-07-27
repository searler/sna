package sna

import java.nio.ByteBuffer
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import java.util.Arrays

class StringTest extends FunSuite with BeforeAndAfter {

  val cLib = Library("c")

  test("duplicate string") {
    assert(cLib.strdup("dup")[String] == "dup")
  }

  test("copy string with precise length byte array") {
    val buffer = ByteBuffer.allocateDirect(100)

    assert(cLib.strcpy(buffer, "Test")[String] == "Test")

    val bytes = new Array[Byte](4)
    buffer.get(bytes)

    assert(new String(bytes) == "Test")
  }

  test("copy string with excess byte array") {
    val buffer = ByteBuffer.allocateDirect(100)

    assert(cLib.strcpy(buffer, "Test")[String] == "Test")

    val bytes = new Array[Byte](10)
    buffer.get(bytes)

    assert(Arrays.toString(bytes) == "[84, 101, 115, 116, 0, 0, 0, 0, 0, 0]")

    assert(new String(bytes) != "Test")

    assert(new String(bytes).trim == "Test")
  }

  test("strcmp") {
    assert(cLib.strcmp("Hello", "World")[Int] < 0)
    assert(cLib.strcmp("World", "World")[Int] == 0)
  }

}