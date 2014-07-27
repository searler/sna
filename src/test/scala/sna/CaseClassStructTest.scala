package sna

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import java.nio.ByteBuffer
import java.util.Arrays
import com.sun.jna.NativeLong
import com.sun.jna.Structure

class CaseClassStructTest extends FunSuite with BeforeAndAfter {

  var cLib = Library("c")

  // must be var
  case class TM(var tm_sec: Int = 0,
    var tm_min: Int = 0,
    var tm_hour: Int = 0,
    var tm_mday: Int = 0,
    var tm_mon: Int = 0,
    var tm_year: Int = 0,
    var tm_wday: Int = 0,
    var tm_yday: Int = 0,
    var tm_isdst: Int = 0) extends Structure

  test("one") {
    var tm = TM(tm_year = 2014 - 1900,
      tm_mon = 6,
      tm_mday = 1)

    assert(cLib.asctime(tm)[String] == "Sun Jul  1 00:00:00 2014\n")
  }

}