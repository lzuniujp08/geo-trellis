name := "test"

version := "0.1"

scalaVersion := "2.12.10"
val geotrellisVersion = "2.2.0"

libraryDependencies ++= Seq(
  "org.locationtech.geotrellis" %% "geotrellis-raster"     % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark"      % geotrellisVersion,
  "org.scalatest"               %% "scalatest"             % "3.0.8" % "test"
)
