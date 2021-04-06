
package desenhoPoligono1;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class DesenhoPoligono1 implements GLEventListener{

 @Override
 public void display(GLAutoDrawable drawable) {
  
  GL2 gl = drawable.getGL().getGL2();
  
  gl.glClear(GL.GL_COLOR_BUFFER_BIT);
  gl.glColor3f(1f, 0, 0);
  
  gl.glBegin(GL.GL_TRIANGLES);
  gl.glVertex2f(70, 53);
  gl.glVertex2f(100,113);
  gl.glVertex2f(130, 53);

  gl.glEnd();
  
  gl.glFlush();
   
 }

 @Override
 public void dispose(GLAutoDrawable arg0) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void init(GLAutoDrawable drawable) {
  
  GL2 gl = drawable.getGL().getGL2();
  
  gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
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
    canvas.addGLEventListener(new DesenhoPoligono1()); 
   
   
  
  JFrame frame = new JFrame("Poligno 1");
  
  frame.add(canvas);
  frame.setSize(400, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  
 }

}