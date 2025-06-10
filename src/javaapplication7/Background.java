/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 343418067
 */
public class Background {
    public int x, y;
    private PApplet app;
    private PImage image;
    
    public Background(PApplet p, int x, int y, String imagePath) {
            this.app = p;
            this.x = x;
            this.y = y; 
            this.image = app.loadImage(imagePath);
        }
    
    public void draw(){
            app.fill(255);
            app.image(image, x, y);
        }
    
    public boolean isClicked(int mouseX, int mouseY){
            int centerX = x+(image.pixelWidth/2);
            int centerY = y+(image.pixelHeight/2);
            float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
            
            System.out.println("Clicked.");
            
            return d < 1000;
    }
    
    public void delete(){
       x = 1000;
       y = 1000;      
    }
}
