name := """crossword-scan"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

libraryDependencies += "com.googlecode.json-simple" % "json-simple" % "1.1.1"
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
libraryDependencies += "com.google.code.gson" % "gson" % "1.4"
