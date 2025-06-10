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
    public class Person {
        public int x, y;
        private PApplet app;
        private String name; // name of the person
        private int age; // age of the person
        public PImage image;
        
        public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
            this.app = p;
            this.x = x;
            this.y = y; 
            this.name = name;
            this.age = age;
            this.image = app.loadImage(imagePath);
        }
        
        public void move(int dx, int dy){
            x += dx;
            y += dy;
        }
        
        public void draw(){
            app.fill(255);
            app.image(image, x, y);
        }
        
        public boolean isCollidingWith(Item other){
            int centerX = x+(image.pixelWidth/2);
            int centerY = y+(image.pixelHeight/2);
            
            int otherCenterX = other.x+(other.image.pixelWidth/2);
            int otherCenterY = other.y+(other.image.pixelHeight/2);
            
            float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY);
            
            return d < 32;
        }    
        
        public boolean isCollidingWith(Person other){
            int centerX = x+(image.pixelWidth/2);
            int centerY = y+(image.pixelHeight/2);
            
            int otherCenterX = other.x+(other.image.pixelWidth/2);
            int otherCenterY = other.y+(other.image.pixelHeight/2);
            
            float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY);
            
            return d < 32;
        }    
        
        public void delete(){
            x = 1000;
            y = 1000;      
        }
        
        public void teleport(int newx, int newy){
            x = newx;
            y = newy;      
        }
        
        public boolean isClicked(int mouseX, int mouseY){
            int centerX = x+(image.pixelWidth/2);
            int centerY = y+(image.pixelHeight/2);
            float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
            
            System.out.println("image height" + image.pixelHeight);
            System.out.println("image width"+image.pixelWidth);
            
            return d < 16;
        }
        
        public void displayInfo(PApplet p){
            app.fill(0); 
            
            app.text("Name" + name, x, y - 50);
            app.text("Age: " + age, x, y - 30);
        }
        
}//end class


