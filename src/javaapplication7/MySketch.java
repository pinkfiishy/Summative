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
  
  //declare backgrounds and scenes
  //Basically this is what shows up behind the interactable stuff 
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
  
  //Death scenes once these are reached you're cooked gotta start all over again
  //Because nothing comes after these scenes no matter what you click
  private Background death1;
  private Background death2;
  
  //Global variables that I use to keep track of things like how many yellow dots did the user pick up during the escape scene
  //And which puzzle piece are we on for the puzzle scene
  private static int counter = 5; 
  private static int whichPuzzleSelected = 1;
  
  //declare items
  //Yellow dots are used for all of these except the invisible ones are hidden behind background later
  //So checkpoints are visible to the player but invisibleCheckers aren't 
  //Otherwise they're the same thing, they're just for hitbox detection
  private Item checkpoint1;
  private Item checkpoint2;
  private Item checkpoint3;
  private Item checkpoint4;
  private Item checkpoint5;
  
  private Item invisibleChecker1;
  private Item invisibleChecker2;
  private Item invisibleChecker3;
  private Item invisibleChecker4;
  
  //Puzzle pieces aren't the same as yellow dots, they're only used for the puzzle scene and nothing else
  private Item puzzle1;
  private Item puzzle2;
  private Item puzzle3;
  private Item puzzle4;
  
  //setting stage to 0 since I need to use stage to swap between each scene/background
  private static int stage = 0;
  
  public void settings() { 
      //Since my backgrounds are all just a solid image I don't need to set the colour of my background in settings() method
        size(350, 625); //set size of screen to background image pixel size
  }

  public void setup() {
    //Setup method is the place where I create all of my objects
    //Starting with the person objects I make sure I make them so that they spawn exactly where I want them to spawn the scene that they're drawn
    //You'll notice that the mc XiaoMing will show up even in places I didn't draw her 
    //That's because in those scenes she's part of the background image I made
    //Since she doesn't need to move making her part of the background instead of a person object saves a lot of time
    mc = new Person(this, 300, 120, "XiaoMing", 12, "images/mc.png");  
    nian = new Person(this, 300, 30, "Nian", 1000, "images/nian.png"); 
    
    //The background location is always gonna be 0,0 since it's gonna fill out the whole screen
    //You want the centre of the background image to be alined with the scenre of the gamescreen
    //For each background I named it a certain number which is at first associated with which stage it's supposed to be on
    //But as my canva pages increased the numbers got a bit messed up lol now they're just random
    
    //Beginning cut scenes
    background = new Background(this, 0,0, "images/2.png");
    background1 = new Background(this, 0,0, "images/1.png");
    background2 = new Background(this, 0,0, "images/3.png");
    background3 = new Background(this, 0,0, "images/4.png");
    titlepage = new Background(this, 0,0, "images/5.png");
    
    //Death scenes
    death1 = new Background(this, 0,0, "images/death1.png");
    death2 = new Background(this, 0,0, "images/death2.png");
    
    //Meeting Nian for the first time scenes
    scene1 = new Background(this, 0,0, "images/6.png");
    scene2 = new Background(this, 0,0, "images/7.png");
    scene3 = new Background(this, 0,0, "images/8.png");
    scene4 = new Background(this, 0,0, "images/9.png");
    scene5 = new Background(this, 0,0, "images/10.png");
    
    //escape scene's background
    escape = new Background(this, 0,0, "images/11.png");
    
    //scenes after escaping
    scene6 = new Background(this, 0,0, "images/13.png");
    scene7 = new Background(this, 0,0, "images/14.png");
    scene8 = new Background(this, 0,0, "images/15.png");
    scene9 = new Background(this, 0,0, "images/16.png");
    
    //puzzle scenes
    scene10 = new Background(this, 0,0, "images/17.png");
    scene11 = new Background(this, 0,0, "images/18.png");
    
    //Moving on from the Background objects we now have checkpoints we need to declear that are Item objects
    //Every checkpoint and invisibleChecker uses the yellow dot image
    //They spawn in different locations dependong on what I use them for
    
    //Checkpoints for the escape scene
    checkpoint1 = new Item(this, 290,200, "images/checkpoint.png");
    checkpoint2 = new Item(this, 240,260, "images/checkpoint.png");
    checkpoint3 = new Item(this, 140,340, "images/checkpoint.png");
    checkpoint4 = new Item(this, 90,440, "images/checkpoint.png");
    checkpoint5 = new Item(this, 60,520, "images/checkpoint.png");
    
    //First invisible checker is for the escape scene 
    //If user walks into it it'll move onto the next scene
    invisibleChecker1 = new Item(this, 50, 600, "images/checkpoint.png");
    
    //These three invisible checkers are for click detection
    //I placed them behind the scroll so that if you click it it'll move to the next scene
    invisibleChecker2 = new Item(this, 280, 500, "images/checkpoint.png");
    invisibleChecker3 = new Item(this, 260, 540, "images/checkpoint.png");
    invisibleChecker4 = new Item(this, 270, 520, "images/checkpoint.png");
    
    //Puzzle pieces for the puzzle scene
    puzzle1 = new Item(this, 40, 250, "images/puzzle1.png" );
    puzzle2 = new Item(this, 140, 120, "images/puzzle2.png" );
    puzzle3 = new Item(this, 35, 30, "images/puzzle3.png" );
    puzzle4 = new Item(this, 170, 400, "images/puzzle4.png" );
    
  }//End of setup
  
  public void draw() {
    //The draw() method is where I am summoning my graphics 
    //Stage will increase from the if statements below in the mousePressed() method
    //As stage increases, I have if and else if statements to draw a different background on top of the previous
    //I don't bother deleting any of them because it actually saves me more time if I use the same if detection for the stage changes
    //I'll talk more about that later in the mousePressed() method
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
    
    //Stage 10 is the escape scene and it's different because there's more to draw
    //But also because it's the first thing the user interacts with
    else if(stage == 10){
        //The invisiblechecker is hidden behind the background so you can't see it
        //I use this invisbible checker to do collision detection just because it's easier
        //I've realized that if you draw something in a certain order, that's how the program layers it
        //The thing drawn will still exist, you just won't see it because it's behind another larger object
        invisibleChecker1.draw(); 
        
        //Background
        escape.draw();
        
        //Our big chunky yellow dots that the user must munch like pac-man 
        checkpoint1.draw();
        checkpoint2.draw();
        checkpoint3.draw();
        checkpoint4.draw(); 
        checkpoint5.draw();
        
        //Nian will skidaddle down the path as the user is eating yellow dots
        mc.draw();
        nian.draw(); 
    }
    
    //After escape scenes, same deal as the backgrounds before escape scene
    else if(stage == 11){     
        scene6.draw();
        
    //This is the scene where only clicking the scroll will work
    //I managed this by using my invisible checkers as click detectors
    //By layering them behind the thing I want to press, even if the thing itself is part of the background and not an object,
    //I can still have the program regonize that it's clicked
    }else if(stage == 12){   
        invisibleChecker2.draw();
        invisibleChecker3.draw();
        invisibleChecker4.draw();
        scene7.draw();
        
    //Same thing, same thing. Yawn. 
    }else if(stage == 14){     
        scene8.draw();
    }else if(stage == 15){     
        scene9.draw();
        
    //WHOA PUZZLE SCENE MY FAV
    //Ok in terms of drawing it's really easy. I need the background and the puzzle pieces themselves.
    //More explained later
    }else if(stage == 16){     
        scene10.draw();
        puzzle1.draw();
        puzzle2.draw();
        puzzle3.draw();
        puzzle4.draw();
       
    //Completed puzzle scene    
    }else if(stage == 17){     
        scene11.draw();
    }
    
    //COLLISION DETECTION! 
    //These first few if statements are for the escape scene
    //Where I want the user to eat the yellow dots because that would mean they're actually walking the path
    if(mc.isCollidingWith(checkpoint1)){
      //If the user steps on the first checkpoint, the checkpoint dissapears
      checkpoint1.delete();
      //counter begins to subtract from 5, since there are a total of 5 yellow dots <---- this will be important later
      counter--;
      //Nian will teleport a bit closer to the user each time they eat a yellow dot so it feels more like a chase
      nian.teleport(290, 100);
    }//end if statement
    
    //Same thing is repeated for every checkpoint
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
    
    //Now, this is where you get to the invisible checker at the end of the escape path
    //The counter gets important here because it tells the program if you actually did what you were supposed to do
    //If you got to the end without collecitng all five, you get a death scene because you cheated. 
    if(mc.isCollidingWith(invisibleChecker1) && counter == 0){
        stage++; //moves on since the counter counted down from 5 to 0 
        mc.delete(); //I have to delete mc since it'll keep triggering the collision and add stages when you're no longer moving her 
        
    }else if(mc.isCollidingWith(invisibleChecker1) && counter != 0){
        death1.draw(); //First ending is here
    }
    
    //Second death scene is made when you bump into Nian during the escape scene
    //This death scene is different from the first which is why there's seperate code for it
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
   //The mousePressed() method within our sketch class is responsible for all mouse activity if it involves the mouse being pressed
   public void mousePressed(){
       
       //Throughout the program, I made clicking the method to go from one stage to another
       //To control the stages and prevent a single click from adding too many stages, I use logial operators to set the exact conditions I want the stage to increase
       //This way even though my isClicked() method always returns true, it won't add stages I don't want
       if(background.isClicked(mouseX, mouseY) && stage < 10){
           stage++;
       }
       
       //The reason why this if statement is seperated from the other if statement is because something user-interaction related is happening inbetween
       //So it's just easier to create another if statement then to figure out how to skip a stage on a single if statement
       if(scene6.isClicked(mouseX, mouseY) && stage > 10 && stage < 12){
           stage++;
       }
       
       //This is the part where the user is met with the scroll clicking 
       //Since for some reason if a Background object is clicked it just has to return true or it'll break the program
       //So what I did was that I created a manual hitbox to fit the shape of the scroll 
       //And then I hid the images I used to make the hitbox behind the background so it's invisible
       //That way the stage only appears IF the invisible hitbox is clicked
       if(invisibleChecker2.isClicked(mouseX, mouseY) || invisibleChecker3.isClicked(mouseX, mouseY) || invisibleChecker4.isClicked(mouseX, mouseY)){
                stage++;
                invisibleChecker2.delete();
                invisibleChecker3.delete();
                invisibleChecker4.delete();
       }
       
       //Same as the first two if statements
       if(scene8.isClicked(mouseX, mouseY) && stage > 12 && stage < 16){
           stage++;
       }
       
       //The following four if statements is the same, but just adjusted to the location of each puzzle piece
       //Because the click and drag thing didn't work out, I'm gonna set it so that if it's in the relative right spot it just moves on to the next piece
       if(stage == 16 && whichPuzzleSelected == 1){
           //Whatever the x value is, I set that to the x value of puzzle1. 
           //Except I have to minus values until it looks like it's in the centre of the image
           //The value I minus depends on the image size and image dimentions
               puzzle1.x = mouseX - 80;
               puzzle1.y = mouseY - 80;
               
               //The reason why I initialize xconfirm and yconfirm inside is because it resets to false for each if statement
               boolean xcf = false;
               boolean ycf = false; 
               
               //If the x value of the puzzle is within a certain rage, the xconfirm will be true
               //Since this is a vertical puzzle this x value doesn't change throughout the if statements
               if(puzzle1.x < 93 && puzzle1.x > 83){
                   xcf = true;
               }
               //Same goes for the y value but it's values will change
               if(puzzle1.y < 22 && puzzle1.y > 12){
                   ycf = true; 
               }
               //Once you have both x and y in the generally correct spot, it triggers this if statement
               //This if statement helps the program understand it's time to move on to puzzle piece 2
               //And since the conditions for puzzle piece 1 to move isn't met anymore, puzzle piece 1 stays in place
               if(xcf == true && ycf == true){
                   whichPuzzleSelected = 2;
               }
           
       } // Now as you can see, whichPuzzleSelected is now equal to two. 
       //This whole loop is repeated four times for each puzzle piece with slightly adjusted values.
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
       
       //After the four if statements for the four puzzle pieces, when whichPuzzleSelected becomes five, I use that as an oppertunity to change stages.
       if(whichPuzzleSelected == 5){
           stage++;
       }
       
       //Attemping to swap to a Jframe (thanks for teaching me Lily)
       if(stage == 18){
        //I decided to comment these two lines out because I want the jFrame to exist simultainiously with the game
            //this.noLoop();
            //this.getSurface().setVisible(false);
            new EndPage().setVisible(true);
       }
    }
    
}//end class




