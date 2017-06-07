
/**
 * Write a description of class Main here.
 *
 * @author (rAJA)
 * @version (a version number or a date)
 */
public class Main
{
   public static void main(String args[]){
       Display display = new Display(800,600, "Software Rendering");
       RenderContext target = display.GetFrameBuffer();
       //Star3D stars = new Star3D(4096,64.0f,20.0f);
       
       Vertex minYVert = new Vertex(100,100);
       Vertex midYVert = new Vertex(150,200);
       Vertex maxYVert = new Vertex(80,300);
       
       long previousTime = System.nanoTime();
       
       while(true){
           long currentTime = System.nanoTime();
           float delta = (float)((currentTime - previousTime)/1000000000.0f);
           previousTime = currentTime;
           
           target.Clear((byte)0x00);
           
           /*
           for(int j=100;j<200;j++){
               target.DrawScanBuffer(j,300-j,300+j);
           }
           */
          
          target.ScanConvertTriangle(minYVert, midYVert, maxYVert, 0);
          target.FillShape(100,300);
           
           //stars.UpdateAndRender(target,delta);
           display.SwapBuffers();
        }
   }
}
