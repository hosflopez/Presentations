package griffonevo

import org.jzy3d.chart.Chart
import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.Builder
import org.jzy3d.plot3d.builder.Mapper
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape
import org.jzy3d.plot3d.rendering.legends.colorbars.ColorbarLegend

class SecondChart3D {
    void mvcGroupInit(Map<String, Object> args) {
        initChart()
    }

    void initChart(){
        Mapper mapper = new Mapper(){
            public double f(double x, double y) {
                double sigma = 10
                return Math.exp(-(x*x+y*y)/sigma) * Math.abs(Math.cos(2*Math.PI*(x*x + y*y)))
            }
        }

        Range range = new Range(-0.5, 0.5)
        int steps = 50
        
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper)
        surface.colorMapper = new ColorMapper(new ColorMapRainbow(), surface.bounds.zmin, surface.bounds.zmax)
        surface.faceDisplayed = true
        surface.wireframeDisplayed = true
        surface.wireframeColor = Color.BLACK
        
        chart.scene.graph.add(surface)
        ColorbarLegend cbar = new ColorbarLegend(surface, chart.view.axe.layout)
        surface.legend = cbar
    }
}
