sna
===

Scala Native Access

Based on [scala-native-access](https://code.google.com/p/scala-native-access/).
That website indicates the code was developed for JNA 4.0.0. The modified Structure.java matches
neither the 4.0.0 nor 4.1.0 versions, but does include some code that only appears in 4.1.0. Testing indicates that it
appears to work with 4.1.0.

Library.scala contains a cache, implemented using a mutable map.
The cache is not thread safe.


