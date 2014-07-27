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

object TestLib extends App {

  val cLib = Library("testlib")

  val buf = java.nio.ByteBuffer.allocate(1024).order(java.nio.ByteOrder.nativeOrder());
  val MAGIC: Byte = 'X'.asInstanceOf[Byte];
  cLib.fillInt8Buffer(buf, 10, MAGIC)[Int];

  val bytes = new Array[Byte](10);
  buf.get(bytes);
  println(new String(bytes));

}
