name := "Scala Native Access"

version := "0.1"

scalaVersion := "2.10.4"



libraryDependencies ++= Seq(
   "net.java.dev.jna" % "jna" % "4.1.0",
   "org.scalatest" %% "scalatest" % "2.1.3" % "test",
   "org.scalacheck" %% "scalacheck" % "1.11.3" % "test"
)

