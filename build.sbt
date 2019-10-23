name := "test"

version := "0.1"

scalaVersion := "2.12.10"
val geotrellisVersion = "3.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies ++= Seq(
  "org.locationtech.geotrellis" %% "geotrellis-raster" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark" % geotrellisVersion
)
