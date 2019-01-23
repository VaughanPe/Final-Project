import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinuxChungus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinuxChungus extends Actor
{
    public LinuxChungus()
    {
        getImage().scale(75,75);
    }
    /**
     * Act - do whatever the LinuxChungus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right") == true)
       {
           move(5);
       }
        if(Greenfoot.isKeyDown("left") == true)
       {
           move(-5);
       }
       if(Greenfoot.isKeyDown("up") == true)
       {
           setLocation(getX(),getY()-5);
       } 
       if(Greenfoot.isKeyDown("down") == true)
       {
           setLocation(getX(),getY()+5);
       }
    }    
}
