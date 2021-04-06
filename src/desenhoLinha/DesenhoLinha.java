
package desenhoLinha;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.util.Random;

public class DesenhoLinha implements GLEventListener{

 @Override
 public void display(GLAutoDrawable drawable) {
  
  GL2 gl = drawable.getGL().getGL2();
  
  gl.glClear(GL.GL_COLOR_BUFFER_BIT);
  gl.glColor3f(0, 1f, 0);
 
  float i = 1;
  
  Random gerador = new Random();
  int X = 20;
  
  while(i<=X){
    gl.glColor3f(gerador.nextFloat(), gerador.nextFloat(),gerador.nextFloat());
    gl.glLineWidth(50);
    gl.glEnable(GL2.GL_LINE_STIPPLE);
    gl.glLineStipple(gerador.nextInt(255), (short)gerador.nextInt(255));
    gl.glBegin(GL.GL_LINES);
    gl.glVertex2f(0+10*i, 0);
    gl.glVertex2f(0+10*i, 149);
    gl.glEnd();
    gl.glDisable(GL2.GL_LINE_STIPPLE);
    i=i+1; 
          
    gl.glEnd();
  }
  
  gl.glFlush();
   
 }

 @Override
 public void dispose(GLAutoDrawable arg0) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void init(GLAutoDrawable drawable) {
  
  GL2 gl = drawable.getGL().getGL2();
  
  gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
  gl.glMatrixMode(GL2.GL_MATRIX_MODE);
  gl.glLoadIdentity();
  
  GLU glu = new GLU();
  glu.gluOrtho2D(0, 200f, 0f, 150f);
  
 }

 @Override
 public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
  // TODO Auto-generated method stub
  
 }
 
 public static void main(String[] args) {
  
 
    GLProfile profile = GLProfile.get(GLProfile.GL2);
    
    GLCapabilities caps = new GLCapabilities(profile);
    
    GLCanvas canvas = new GLCanvas(caps); 
    canvas.addGLEventListener(new DesenhoLinha()); 
   
   
  
  JFrame frame = new JFrame("Desenho Linha");
  
  frame.add(canvas);
  frame.setSize(400, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  
 }

}