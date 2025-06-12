/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author 343418067
 */
import processing.core.PApplet;

public class MySketch extends PApplet {
  
  //declaring "living" things 
  private Person mc;
  private Person nian; //declare the Nian monster!!
  
  //declare backgrounds
  private Background background; 
  private Background background1; 
  private Background background2; 
  private Background background3; 
  private Background titlepage; 
  private Background scene1; 
  private Background scene2;
  private Background scene3;
  private Background scene4;
  private Background scene5;
  private Background scene6;
  private Background scene7;
  private Background scene8;
  private Background scene9;
  private Background scene10;
  private Background scene11;
  private Background escape;
  
  private Background death1;
  private Background death2;
  
  private static int counter = 5; 
  private static int whichPuzzleSelected = 1;
  
  //declare items
  private Item checkpoint1;
  private Item checkpoint2;
  private Item checkpoint3;
  private Item checkpoint4;
  private Item checkpoint5;
  private Item invisibleChecker1;
  private Item invisibleChecker2;
  private Item invisibleChecker3;
  private Item invisibleChecker4;
  
  private Item puzzle1;
  private Item puzzle2;
  private Item puzzle3;
  private Item puzzle4;
  
  //setting stage to 0
  private static int stage = 0;
  
  public void settings() {
        size(350, 625); //set size of screen to background image pixel size
  }

  public void setup() {
    mc = new Person(this, 300, 120, "XiaoMing", 12, "images/mc.png");  
    nian = new Person(this, 300, 30, "Nian", 1000, "images/nian.png"); 
            
    background = new Background(this, 0,0, "images/2.png");
    background1 = new Background(this, 0,0, "images/1.png");
    background2 = new Background(this, 0,0, "images/3.png");
    background3 = new Background(this, 0,0, "images/4.png");
    titlepage = new Background(this, 0,0, "images/5.png");
    
    death1 = new Background(this, 0,0, "images/death1.png");
    death2 = new Background(this, 0,0, "images/death2.png");
    
    scene1 = new Background(this, 0,0, "images/6.png");
    scene2 = new Background(this, 0,0, "images/7.png");
    scene3 = new Background(this, 0,0, "images/8.png");
    scene4 = new Background(this, 0,0, "images/9.png");
    scene5 = new Background(this, 0,0, "images/10.png");
    escape = new Background(this, 0,0, "images/11.png");
    
    //scenes after escaping
    scene6 = new Background(this, 0,0, "images/13.png");
    scene7 = new Background(this, 0,0, "images/14.png");
    scene8 = new Background(this, 0,0, "images/15.png");
    scene9 = new Background(this, 0,0, "images/16.png");
    
    //puzzle scenes
    scene10 = new Background(this, 0,0, "images/17.png");
    scene11 = new Background(this, 0,0, "images/18.png");
    
    checkpoint1 = new Item(this, 290,200, "images/checkpoint.png");
    checkpoint2 = new Item(this, 240,260, "images/checkpoint.png");
    checkpoint3 = new Item(this, 140,340, "images/checkpoint.png");
    checkpoint4 = new Item(this, 90,440, "images/checkpoint.png");
    checkpoint5 = new Item(this, 60,520, "images/checkpoint.png");
    
    invisibleChecker1 = new Item(this, 50, 600, "images/checkpoint.png");
    invisibleChecker2 = new Item(this, 280, 500, "images/checkpoint.png");
    invisibleChecker3 = new Item(this, 260, 540, "images/checkpoint.png");
    invisibleChecker4 = new Item(this, 270, 520, "images/checkpoint.png");
    
    puzzle1 = new Item(this, 40, 250, "images/puzzle1.png" );
    puzzle2 = new Item(this, 140, 120, "images/puzzle2.png" );
    puzzle3 = new Item(this, 35, 30, "images/puzzle3.png" );
    puzzle4 = new Item(this, 170, 400, "images/puzzle4.png" );
    
    //nian = new Person(this, 200, 600, "images/nian.png");
  }
  
  public void draw() {
    if(stage == 0){  
        background.draw();
    }else if(stage == 1){
        background1.draw();
    }else if(stage == 2){
        background2.draw();
    }else if(stage == 3){
        background3.draw();
    }else if(stage == 4){
        titlepage.draw();
    }else if(stage == 5){
        scene1.draw();
    }else if(stage == 6){
        scene2.draw();
    }else if(stage == 7){
        scene3.draw();
    }else if(stage == 8){
        scene4.draw();
    }else if(stage == 9){
        scene5.draw();
    }
    
    else if(stage == 10){
        //The invisiblechecker is hidden behind the background so you can't see it
        //I use this invisbible checker to do collision detection just because it's easier
        invisibleChecker1.draw(); 
        escape.draw();
        checkpoint1.draw();
        checkpoint2.draw();
        checkpoint3.draw();
        checkpoint4.draw(); 
        checkpoint5.draw();
        mc.draw();
        nian.draw(); 
    }
    
    else if(stage == 11){     
        scene6.draw();
    }else if(stage == 12){   
        
        invisibleChecker2.draw();
        invisibleChecker3.draw();
        invisibleChecker4.draw();
        scene7.draw();
        
    }else if(stage == 14){     
        scene8.draw();
            
    }else if(stage == 15){     
        scene9.draw();
    }else if(stage == 16){     
        scene10.draw();
        puzzle1.draw();
        puzzle2.draw();
        puzzle3.draw();
        puzzle4.draw();
        
    }else if(stage == 17){     
        scene11.draw();
    }
    
    if(mc.isCollidingWith(checkpoint1)){
      checkpoint1.delete();
      counter--;
      nian.teleport(290, 100);
      //this.text("Ding!", mc.x, mc.y);
    }
    if(mc.isCollidingWith(checkpoint2)){
        checkpoint2.delete();
        counter--;
        nian.teleport(270, 150);
    }
    if(mc.isCollidingWith(checkpoint3)){
        checkpoint3.delete();
        counter--;
        nian.teleport(220, 240);
    }
    if(mc.isCollidingWith(checkpoint4)){
        checkpoint4.delete();
        counter--;
        nian.teleport(120, 340);
    }
    if(mc.isCollidingWith(checkpoint5)){
        checkpoint5.delete();
        counter--;
        nian.teleport(80,430);
    }
    if(mc.isCollidingWith(invisibleChecker1) && counter == 0){
        stage++; 
        mc.delete();
    }else if(mc.isCollidingWith(invisibleChecker1) && counter != 0){
        death1.draw();
    }
    
    if(mc.isCollidingWith(nian)){
        death2.draw();
    }
    if(keyPressed){ //meaning if any of the keyboard inputs are made
        //moving at 2 pixels towards the direction if that specific arrow key is pressed
        //the direction of movement just depends on the x and y coordinate
        if(keyCode == LEFT){
            mc.move(-2,0); 
        }else if(keyCode == RIGHT){
            mc.move(2,0);
        }else if(keyCode == DOWN){
            mc.move(0,2);
        }else if(keyCode == UP){
            mc.move(0, -2);
        }
    }
    
  }
    
   public void mousePressed(){
       if(background.isClicked(mouseX, mouseY) && stage < 10){
           stage++;
       }
       if(scene6.isClicked(mouseX, mouseY) && stage > 10 && stage < 12){
           stage++;
       }
       
       if(invisibleChecker2.isClicked(mouseX, mouseY) || invisibleChecker3.isClicked(mouseX, mouseY) || invisibleChecker4.isClicked(mouseX, mouseY)){
                stage++;
                invisibleChecker2.delete();
                invisibleChecker3.delete();
                invisibleChecker4.delete();
       }
       
       if(scene8.isClicked(mouseX, mouseY) && stage > 12 && stage < 16){
           stage++;
       }
       
       if(stage == 16 && whichPuzzleSelected == 1){
           if(puzzle1.move(mouseX, mouseY, true)){
               puzzle1.x = mouseX - 80;
               puzzle1.y = mouseY - 80;
               
               boolean xcf = false;
               boolean ycf = false; 
               
               if(puzzle1.x < 93 && puzzle1.x > 83){
                   xcf = true;
               }
               if(puzzle1.y < 22 && puzzle1.y > 12){
                   ycf = true; 
               }
               
               if(xcf == true && ycf == true){
                   whichPuzzleSelected = 2;
               }
           }
       }
       if(stage == 16 && whichPuzzleSelected == 2){
           if(puzzle2.move(mouseX, mouseY, true)){
               puzzle2.x = mouseX - 80;
               puzzle2.y = mouseY - 80;
               
               boolean xcf = false;
               boolean ycf = false; 
               
               if(puzzle2.x < 93 && puzzle2.x > 83){
                   xcf = true;
               }
               if(puzzle2.y < 124 && puzzle2.y > 110){
                   ycf = true;
               }
               
               if(xcf == true && ycf == true){
                   whichPuzzleSelected = 3;
               }
           }
       }
       if(stage == 16 && whichPuzzleSelected == 3){
           if(puzzle3.move(mouseX, mouseY, true)){
               puzzle3.x = mouseX - 80;
               puzzle3.y = mouseY - 80;
               
               boolean xcf = false;
               boolean ycf = false; 
               System.out.println(puzzle3.x);
               System.out.println(puzzle3.y);
               
               if(puzzle3.x < 93 && puzzle3.x > 83){
                   xcf = true;
                   
               }
               if(puzzle3.y < 247 && puzzle3.y > 235){
                   ycf = true;
               }
               
               if(xcf == true && ycf == true){
                   whichPuzzleSelected = 4;
               }
           }
       }
       if(stage == 16 && whichPuzzleSelected == 4){
           if(puzzle4.move(mouseX, mouseY, true)){
               puzzle4.x = mouseX - 80;
               puzzle4.y = mouseY - 80;
               
               boolean xcf = false;
               boolean ycf = false; 
               System.out.println(puzzle4.x);
               System.out.println(puzzle4.y);
               
               if(puzzle4.x < 93 && puzzle4.x > 83){
                   xcf = true;
                   
               }
               if(puzzle4.y < 387 && puzzle4.y > 381){
                   ycf = true;
               }
               
               if(xcf == true && ycf == true){
                   whichPuzzleSelected = 5;
               }
           }
       }
       
       if(whichPuzzleSelected == 5){
           stage++;
       }
       
    }
    
}//end class




