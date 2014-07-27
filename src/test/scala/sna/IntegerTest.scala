package sna

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import java.nio.ByteBuffer
import java.util.Arrays
import com.sun.jna.NativeLong

class IntegerTest extends FunSuite with BeforeAndAfter {

  val cLib = Library("c")

  test("atoi") {
    assert(cLib.atoi("0345")[Int] == 345)
  }

  test("atol as Int") {
    assert(cLib.atol("1234567890")[Int] == 1234567890)
  }

  test("atol as Long") {
    assert(cLib.atol("12345678900")[Long] == 12345678900L)
  }

  test("atol as NativeLong") {
    assert(NativeLong.SIZE == 8) // 64 Linux
    assert((cLib.atol("12345678900")[NativeLong]).longValue == 12345678900L)
  }

}