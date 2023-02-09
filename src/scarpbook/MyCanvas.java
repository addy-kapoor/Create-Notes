package scarpbook;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
public class MyCanvas extends Canvas {
   private String imgpath;
   public void setImgpath(String imgpath) {
	this.imgpath = imgpath;
	}
   public MyCanvas(String imgpath) {
	   super();
	   this.imgpath = imgpath;
   }
   public void paint(Graphics g) {
	   Toolkit t = Toolkit.getDefaultToolkit();
	   Image i = t.getImage(imgpath);
	   g.drawImage(i, 0, 0, 250, 250,this);
   } 
}

