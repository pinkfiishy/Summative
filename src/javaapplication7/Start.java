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
public class Start {
    public int x, y;
    private PApplet app;
    private PImage image;
    
    public Start(PApplet p, int x, int y, String imagePath) {
            this.app = p;
            this.x = x;
            this.y = y; 
            this.image = app.loadImage(imagePath);
        }
    
    public void draw(){
            app.fill(255);
            app.image(image, x, y);
        }
}
