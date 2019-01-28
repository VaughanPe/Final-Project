import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    boolean bounce = true;
    
    public Bullet()    
    {
        setRotation(Greenfoot.getRandomNumber(180));
        getImage().scale(30,30);
        bounce = true;
        
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        
        HealthBar health = (HealthBar)getWorld().getObjects(HealthBar.class).get(0);
        if(isTouching(Chungus.class) == true)
        {
            getWorld().removeObject(this);
            health.add(-1);
            
        }
        
        else if(getY() == 690)
        {
            getWorld().removeObject(this);
        }
        if(health.getCurrent() == 0)
        {
            
            
            getWorld().showText("You Lose",getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
    }    
}
