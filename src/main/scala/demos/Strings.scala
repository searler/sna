/* Copyright (c) 20010-2014 Sanjay Dasgupta, All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */

package demos

import sna.Library
import com.sun.jna.Pointer
import com.sun.jna.Native
import java.nio.Buffer
import java.nio.ByteBuffer

object Strings extends App {

  val cLib = Library("c")

  println(cLib.strdup("dup\n")[String])

  val buffer = ByteBuffer.allocateDirect(100)

  println(cLib.strcpy(buffer, "Hell")[String])

  val bytes = new Array[Byte](100)
  buffer.get(bytes)

  println(new String(bytes))

  
}
