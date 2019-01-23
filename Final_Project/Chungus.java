import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chungus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chungus extends Actor
{
    public Chungus()
    {
        getImage().scale(75,75);
        
    }
    int positionReset = 1;
    /**
     * Act - do whatever the Chungus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.isKeyDown("z") == true && positionReset > 0)
       {
          setLocation(350,600); 
          
       } 
       positionReset = 0;
       if(Greenfoot.isKeyDown("d") == true)
       {
           move(5);
       }
       if(Greenfoot.isKeyDown("a") == true)
       {
           move(-5);
       }
       if(Greenfoot.isKeyDown("w") == true)
       {
           setLocation(getX(),getY()-5);
       } 
       if(Greenfoot.isKeyDown("s") == true)
       {
           setLocation(getX(),getY()+5);
       }
    }    
}
