name := "test"

version := "0.1"

scalaVersion := "2.12.10"
val geotrellisVersion = "2.3.3"

libraryDependencies ++= Seq(
  "org.locationtech.geotrellis" %% "geotrellis-raster"     % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark"      % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark-etl"  % geotrellisVersion,
  "org.apache.spark"            %% "spark-core"            % "2.4.4",
  "org.scalatest"               %% "scalatest"             % "3.0.8" % "test"
)
