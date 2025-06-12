
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;
import processing.core.PApplet;
import processing.core.PImage;
/**
/**
 *
 * @author 343418067
 */
public class Item {
    public int x, y;
    private PApplet app;
    public PImage image;
    
    public Item(PApplet p, int x, int y, String imagePath) {
            this.app = p;
            this.x = x;
            this.y = y; 
            this.image = app.loadImage(imagePath);
        }
    
    public void draw(){
            app.fill(255);
            app.image(image, x, y);
        }
    
    public void delete(){
       x = 1000;
       y = 1000;      
    }
    
    public boolean isClicked(int mouseX, int mouseY){
            int centerX = x+(image.pixelWidth/2);
            int centerY = y+(image.pixelHeight/2);
            float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
            
            return d < 30;
    }
    
    
    public void teleport(int newx, int newy){
            x = newx;
            y = newy;      
        }
    
    public boolean move(int newx, int newy, boolean ans){
        if(ans == true){
            x = newx; 
            y = newy; 
        }
        return true;
    }
    
    public boolean isCollidingWith(Person other){
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
            
        int otherCenterX = other.x+(other.image.pixelWidth/2);
        int otherCenterY = other.y+(other.image.pixelHeight/2);
            
        float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY);
            
        return d < 32;
    }    
}
