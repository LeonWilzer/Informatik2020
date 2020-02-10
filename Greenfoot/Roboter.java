import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/* 
 *  This is class is the super class of Robby, Robita and Robson.
 *  It's only intended to house functional methods for it's sublcasses and thus shouldn't
 *  contain any code meant for exercises. Please use the previously or any other subclasses
 *  for that purpose.
 */

public class Roboter extends Actor {
    
 /**
  *  VERY IMPORTANT:
  *  There's a good chance you won't be able to compile this code, unless fix the compilation error by changing the class names in the methods below or by declaring new identical 
  *  subclasses as seen directly below (the latter is the easier solution)
  *  More information in the comments of affected methods, which are:
  *      takeBat()
  *      layScrew()
  *      wallAhead()
  *      wallLeft()
  *      wallRight()
  *      wallMover()
  */

 //Alternative fixes for standard German version
 //Replace Classes and Methods with the ones provided by your scenario
 public class Screw extends Schraube {}
 public class Battery extends Akku {}
 public class Wall extends Wand {} 
 public void bewegen()
    {go(1);}
 public void akkuAufnehmen()
    {takeBat();}
 public void schraubeAblegen()
    {layScrew();}
 public void dreheRechts()
    {turn90(1);}
 public void dreheLinks()
    {turn90(-1);}
 public boolean kannBewegen()
    {return canMove();}
 public boolean rechts()
    {return isAngle(0);}
 public boolean links()
    {return isAngle(180);}
 public boolean akkuAufFeld()
    {return batHere();}
 public boolean anGrenze()
    {return atBorder();}
 public boolean wandVorne()
    {return wallAhead();}
 public boolean wandRechts()
    {return wallRight();}
 public boolean wandLinks()
    {return wallLeft();}
    
 /**
  *  Global Settings
  */
 // Greenfoot Delay; Default: 1
 int DELAY = 1;
 /**
  *  Object's attributes are being initialized
  *  see constructor for explanation/reference
  */
 String name;
 double weight;
 int batts;
 int screws;
 int energ;
 int energMax;
 int energMin;
 char effi;
 int effiFactorAdd;
 int effiFactorSub;
 /**
  * Ein Objekt der Klasse Roboter wird exempliert bzw. instanziert.
  */
 public Roboter() {
  /**
   *  These are just example values; It is recommended to either change them here
   *  or even more preferably in a subclass
   */

  // Name of the object
  name = "Roboter";
  // Weight of the object
  weight = 9;
  // Amount of batteries the object is carrying
  batts = 99;
  // Amount of screws the object is carrying
  screws = 99;
  // Energy available to the object
  energ = 9999;
  // Maximum amount of Energy storable
  energMax = 99999;
  // Minimum amount of Energy needed
  energMin = 0;
  // Energy efficency rating
  effi = 'A';

  /** 
   *  Set energy substraction and addition values according to efficency rating
   *  (see Char variable above)
   *  These are just example values; It is strongly encouraged to change these values
   *  and comment out the unneded ratings
   */
  switch (effi) {
   case 'A':
    effiFactorAdd = 10;
    effiFactorSub = 1;
    break;
   case 'B':
    effiFactorAdd = 9;
    effiFactorSub = 2;
    break;
   case 'C':
    effiFactorAdd = 8;
    effiFactorSub = 3;
    break;
   case 'D':
    effiFactorAdd = 7;
    effiFactorSub = 4;
    break;
   case 'E':
    effiFactorAdd = 7;
    effiFactorSub = 5;
    break;
   case 'F':
    effiFactorAdd = 6;
    effiFactorSub = 6;
    break;
   case 'G':
    effiFactorAdd = 5;
    effiFactorSub = 6;
    break;
   default:
    effiFactorAdd = 0;
    effiFactorSub = 0;
    break;
  }
 }
 /**
  *  Checks if adding a positive value would exceed the energMax attribute
  *  Checks if adding a negative value would exceed the energMin attribute
  */
 public boolean checkEnerg(int checkP) {
  if (checkP > 0 && energMax < energ + checkP)
   return false;
  else if (checkP < 0 && energMin > energ + checkP)
   return false;
  return true;
 }
 /** 
  *  Adds an amount of Energy according to efficiency rating if possible.
  *  Returns a boolean which is true on success and false otherwise
  */
 public boolean energAdd() {
  if (checkEnerg(effiFactorAdd)) {
   energ += effiFactorAdd;
   return true;
  } else {
   // System.out.println may be omitted or changed freely
   System.out.println("Ich würde einen auf Samsung Galaxy Note 7 machen!");
   return false;
  }
 }
 /** 
  *  Adds an amount of Energy according to efficiency rating if possible.
  *  Returns a boolean which is true on success and false otherwise
  */
 public boolean energSub() {
  if (checkEnerg(effiFactorSub)) {
   energ -= effiFactorSub;
   return true;
  } else {
   // System.out.println may be omitted or changed freely
   System.out.println("Ich habe Angst vor der Dunkelheit!");
   return false;
  }
 }
 /**
  *  The object moves a provided amount of tiles towards the direction it's looking at.
  *  Negative values makes the object move towards the opposite viewing direction;
  */
 public void go(int parameter) {
  if (parameter > 0)
   for (int i = 0; i < parameter; i++) {
    if (energSub()) {
     move(1);
     Greenfoot.delay(DELAY);
    }
   }
  else
   for (int i = parameter; i < 0; i++) {
    if (energSub()) {
     move(-1);
     Greenfoot.delay(DELAY);
    }
   }
 }
 /**
  *  Makes the object turn by a multiple of 90
  *  Example:
  *  To turn the Robot 90 degrees clockwise:
  *      turn90(1);
  *  To turn the Robot 90 degrees anticlockwise:
  *      turn90(-1);
  */
 public void turn90(int turnP) {
  if (energSub()) {
   this.setRotation((getRotation() + (90 * turnP)) % 360);
   Greenfoot.delay(DELAY);
  }
 }
 /**
  * Object picks up Battery on it's field if one is there
  */
 public void takeBat() {
  /**  
   *  Change any case of "Battery" to the name of your Battery class; by default it is "Akku"
   *   in the German Versionn. Cases of "curBattery" may be ignored, but it might be advisable
   *   to adjust it to a value you like
   *
   *    |                       |                                       |
   *    |                       |                                       |
   *   \|/                     \|/                                     \|/              */
  Battery curBattery = (Battery) this.getOneObjectAtOffset(0, 0, Battery.class);
  if (curBattery != null && energAdd()) {
   this.getWorld().removeObject(curBattery);
   weight += 0.5;
   batts++;
  } else
   System.out.println("Here is no battery!");
 }

 /**
  *  Lays downa screw on the current field.
  */
 public void layScrew() {
  if (screws >= 0 && weight - 0.7 > 0 && energSub()) {
   int curX = this.getX();
   int curY = this.getY();
   /**
    * Change these two Classes to the name of your screw class; default for German is "Schraube"
    * See comment of pickUpBat() for more info
    *  |               |
    * \|/             \|/                */
   Screw screw = new Screw();
   this.getWorld().addObject(screw, curX, curY);
   this.getWorld().addObject(this, curX, curY);
   screws--;
   weight -= 0.7;
  }
 }

 /**
  *      Checks whether or not the object can move
  */
 private boolean canMove() {
  if (this.wallAhead())
   return false;
  if (this.getRotation() == 0 && this.getX() == this.getWorld().getWidth() - 1)
   return false;
  if (this.getRotation() == 90 && this.getY() == this.getWorld().getHeight() - 1)
   return false;
  if (this.getRotation() == 180 && this.getX() == 0)
   return false;
  if (this.getRotation() == 270 && this.getY() == 0)
   return false;
  return true;
 }
 /**
  *      Checks if object is rotated in a specific angle
  *      Example measurements relative to screen (you):
  *          Right:  0
  *          Left:   180
  *          Up:     -90
  *          Down:   90
  */
 public boolean isAngle(int pAngle) {
  if (this.getRotation() == pAngle)
   return true;
  else
   return false;
 }
 /**
  *     Checks if there is a Battery on the field
  */
 public boolean batHere() {
  if (this.getOneObjectAtOffset(0, 0, Battery.class) != null)
   return true;
  else
   return false;
 }
 /**
  *     Checks if there is a Battery on the field
  */
 public boolean screwHere() {
  if (this.getOneObjectAtOffset(0, 0, Screw.class) != null)
   return true;
  else
   return false;
 }
 /**
  * Der Sensor ueberprueft, ob sich der Roboter an der Weltgrenze befindet und zur Grenze "blickt".
  */
 public boolean atBorder() {
  if (this.getX() + 1 >= this.getWorld().getWidth() || this.getX() <= 0)
   return true;
  if (this.getY() + 1 >= this.getWorld().getHeight() || this.getY() <= 0)
   return true;
  return false;
 }
 /**
  *     Checks if a wall is in front of the object.
  */
 public boolean wallAhead() {
  int lDirection = this.getRotation();
  if (lDirection == 0 && this.getOneObjectAtOffset(1, 0, Wall.class) != null)
   return true;
  if (lDirection == 90 && this.getOneObjectAtOffset(0, 1, Wall.class) != null)
   return true;
  if (lDirection == 180 && this.getOneObjectAtOffset(-1, 0, Wall.class) != null)
   return true;
  if (lDirection == 270 && this.getOneObjectAtOffset(0, -1, Wall.class) != null)
   return true;
  return false;
 }
 /**
  * Checks if there is a wall 90 degrees clockwise of the object's view direction.
  */
 public boolean wallRight() {
  int lDirection = this.getRotation();
  if (lDirection == 0 && this.getOneObjectAtOffset(0, 1, Wall.class) != null)
   return true;
  if (lDirection == 90 && this.getOneObjectAtOffset(-1, 0, Wall.class) != null)
   return true;
  if (lDirection == 180 && this.getOneObjectAtOffset(0, -1, Wall.class) != null)
   return true;
  if (lDirection == 270 && this.getOneObjectAtOffset(1, 0, Wall.class) != null)
   return true;
  return false;
 }

 /**
  * Checks if there is a wall 90 degrees counterclockwise of the object's view direction.
  */
 public boolean wallLeft() {
  int lDirection = this.getRotation();
  if (lDirection == 0 && this.getOneObjectAtOffset(0, -1, Wall.class) != null)
   return true;
  if (lDirection == 90 && this.getOneObjectAtOffset(1, 0, Wall.class) != null)
   return true;
  if (lDirection == 180 && this.getOneObjectAtOffset(0, 1, Wall.class) != null)
   return true;
  if (lDirection == 270 && this.getOneObjectAtOffset(-1, 0, Wall.class) != null)
   return true;
  return false;
 }

 // Moves the a wall by one tile into the direction the object is facing
 // Novel and optional feature, breaks most exercises;

 /*
    public void wallMover()
    {
         int lDirection = this.getRotation();
         Wall curWall = (Wall)this.getOneObjectAtOffset(1, 0, Wall.class); 
         switch(lDirection)
         {
            case 0:
                curWall = (Wall)this.getOneObjectAtOffset(1, 0, Wall.class); 
                curWall.setLocation(getX() + 1, getY());
                break;
            case 90:
                curWall = (Wall)this.getOneObjectAtOffset(0, 1, Wall.class); 
                curWall.setLocation(getX(), getY()+1);
                break;
            case 180:
                curWall = (Wall)this.getOneObjectAtOffset(-1, 0, Wall.class); 
                curWall.setLocation(getX()-1, getY());
                break;
            case 270:
                curWall = (Wall)this.getOneObjectAtOffset(0, -1, Wall.class); 
                curWall.setLocation(getX(), getY()-1);
                break;
         }
         Greenfoot.delay(DELAY);
    }
    */
}