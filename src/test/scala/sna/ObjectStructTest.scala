package sna

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import java.nio.ByteBuffer
import java.util.Arrays
import com.sun.jna.NativeLong
import com.sun.jna.Structure

class ObjectStructTest extends FunSuite with BeforeAndAfter {

  val cLib = Library("c")

  object tm extends Structure {
    var tm_sec: Int = _ /* seconds after the minute (0 to 61) */
    var tm_min: Int = _ /* minutes after the hour (0 to 59) */
    var tm_hour: Int = _ /* hours since midnight (0 to 23) */
    var tm_mday: Int = _ /* day of the month (1 to 31) */
    var tm_mon: Int = _ /* months since January (0 to 11) */
    var tm_year: Int = _ /* years since 1900 */
    var tm_wday: Int = _ /* days since Sunday (0 to 6 Sunday=0) */
    var tm_yday: Int = _ /* days since January 1 (0 to 365) */
    var tm_isdst: Int = _ /* Daylight Savings Time */
  }

  test("one") {
    tm.tm_year = 2014 - 1900
    tm.tm_mon = 6
    tm.tm_mday = 1
    assert(cLib.asctime(tm)[String] == "Sun Jul  1 00:00:00 2014\n")
  }

}