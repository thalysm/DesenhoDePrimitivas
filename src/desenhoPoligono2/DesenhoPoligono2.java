
package desenhoPoligono2;
import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class DesenhoPoligono2 implements GLEventListener{

 @Override
 public void display(GLAutoDrawable drawable) {
  
  GL2 gl = drawable.getGL().getGL2();
  
  gl.glClear(GL.GL_COLOR_BUFFER_BIT);
  gl.glColor3f(1f, 1f, 1f);
  
  //triangulo telhado
  gl.glBegin(GL.GL_LINE_LOOP);
  gl.glVertex2f(37, 75);
  gl.glVertex2f(56, 112);
  gl.glVertex2f(75, 75);
  gl.glEnd();
  
  //PARALELOGRAMO TETO 
  gl.glBegin(GL2.GL_QUAD_STRIP);
  gl.glVertex2f(56, 112);
  gl.glVertex2f(75, 75);
  gl.glVertex2f(118, 137);
  gl.glVertex2f(137, 100);
  gl.glEnd();
  
  //front
  gl.glBegin(GL.GL_LINE_STRIP);
  gl.glVertex2f(37, 75);
  gl.glVertex2f(37, 25);
  gl.glVertex2f(75, 25);
  gl.glVertex2f(75, 75);
  gl.glEnd();
  
  //parede
  gl.glBegin(GL.GL_LINE_STRIP);
  gl.glVertex2f(75, 25);
  gl.glVertex2f(137,50);
  gl.glVertex2f(137, 100);
  gl.glEnd();
  
  //quadrado porta 
  gl.glBegin(GL2.GL_QUADS);
  gl.glVertex2f( 50, 50);
  gl.glVertex2f( 50, 25);
  gl.glVertex2f( 62, 25);
  gl.glVertex2f( 62, 50);
  gl.glEnd();
  
   //PARALELOGRAMO TETO 
  gl.glBegin(GL2.GL_QUADS);
  gl.glVertex2f(93, 50);
  gl.glVertex2f(93, 68);
  gl.glVertex2f(125, 81);
  gl.glVertex2f(125, 62);
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
  
  gl.glClearColor(0, 0, 0, 1.0f);
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
    canvas.addGLEventListener(new DesenhoPoligono2()); 
   
   
  
  JFrame frame = new JFrame("Poligono 2");
  
  frame.add(canvas);
  frame.setSize(400, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  
 }

}