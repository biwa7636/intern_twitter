import sbtassembly.Plugin._
import AssemblyKeys._


lazy val commonSettings = Seq(
  organization := "com.arrow",
  scalaVersion := "2.11.4"
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "twitter",
    version := "1.0",
    libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.10" % "0.9.0-incubating"
  )
