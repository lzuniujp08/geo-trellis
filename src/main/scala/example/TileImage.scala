package example

import geotrellis.raster.Tile
import geotrellis.spark._
import geotrellis.spark.etl.Etl
import geotrellis.spark.util.SparkUtils
import geotrellis.vector.ProjectedExtent

object TileImage {
  /*def main(args: Array[String]): Unit = {
    var args = Array[String](
      "--input",
      "D:\\lzugis19\\code\\geo-trellis\\config\\input.json",
      "--output",
      "D:\\lzugis19\\code\\geo-trellis\\config\\output.json",
      "--backend-profiles",
      "D:\\lzugis19\\code\\geo-trellis\\config\\backend-profiles.json"
    );
    implicit val sc = SparkUtils.createSparkContext("ETL", new SparkConf(true).setMaster("local[*]"))
    try {
      Etl.ingest[ProjectedExtent, SpatialKey, Tile](args)
    } finally {
      sc.stop
    }
  }*/
}
