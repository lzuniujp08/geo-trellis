package example

import geotrellis.raster.Tile
import geotrellis.spark._
import geotrellis.spark.etl.Etl
import geotrellis.spark.etl.config.EtlConf
import geotrellis.spark.util.SparkUtils
import geotrellis.vector.ProjectedExtent
import org.apache.spark.SparkConf

object TileImage {
  def main(args: Array[String]): Unit = {
    var args = Array[String](
      "--input",
      "D:\\Javaworkspace\\geotrellis\\study\\testdata\\input.json",
      "--output",
      "D:\\Javaworkspace\\geotrellis\\study\\testdata\\output.json",
      "--backend-profiles",
      "D:\\Javaworkspace\\geotrellis\\study\\testdata\\backend-profiles.json"
    );
    implicit val sc = SparkUtils.createSparkContext("ETL", new SparkConf(true).setMaster("local[*]"))
    try {
      Etl.ingest[ProjectedExtent, SpatialKey, Tile](args)
    } finally {
      sc.stop
    }
  }
}
