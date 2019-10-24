package example

import geotrellis.proj4.LatLng
import geotrellis.vector._
import scala.util._
import geotrellis.raster._
import geotrellis.raster.mapalgebra.focal.Kernel
import geotrellis.raster.render.ColorMap
import geotrellis.raster.io.geotiff._

object KernelDensity {
  val extent = Extent(-180, -90, 180, 90)

  def randomPointFeature(extent: Extent): PointFeature[Double] = {
    def randInRange (low: Double, high: Double): Double = {
      val x = Random.nextDouble
      low * (1-x) + high * x
    }
    Feature(Point(randInRange(extent.xmin, extent.xmax), // the geometry
      randInRange(extent.ymin, extent.ymax)),
      Random.nextInt % 16 + 16) // the weight (attribute)
  }

  def main(args: Array[String]): Unit = {
    val pts = (for (i <- 1 to 10000) yield randomPointFeature(extent)).toList
    println(pts)
    val kernelWidth: Int = 9
    /* Gaussian kernel with std. deviation 1.5, amplitude 25 */
    val kern: Kernel = Kernel.gaussian(kernelWidth, 1.5, 25)
    val kde: Tile = pts.kernelDensity(kern, RasterExtent(extent, 1800, 900))
    val colorMap = ColorMap(
      (0 to kde.findMinMax._2 by 4).toArray,
      ColorRamps.HeatmapBlueToYellowToRedSpectrum
    )
    kde.renderPng(colorMap).write("result/test.png")
    GeoTiff(kde, extent, LatLng).write("result/test.tif")
  }
}
