Scala Native Access
===================

Based on [scala-native-access](https://code.google.com/p/scala-native-access/).
That website indicates the code was developed for JNA 4.0.0. The modified Structure.java matches
neither the 4.0.0 nor 4.1.0 versions, but does include some code that only appears in 4.1.0. Testing indicates that it
appears to work with 4.1.0.

Library.scala contains a cache, implemented using a mutable map.
The cache is not thread safe.

Conclusion
----------
A clever hack but probably not that useful.

The need to modify the actual JNA source code makes this brittle and harder to deploy. 
The licensing consequences might also be a concern.

The dynamic call implementation is clever but greatly increases the likelyhood of
making a call with the wrong arguments. That is not at all ideal given the already
brittle and error prone nature of Java/native interactions. 

Eliminating the need to define a Java class to represent the data flowing across the Java/native
boundary is convenient, but not generally a big deal.

