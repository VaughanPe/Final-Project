import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SideBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SideBullet extends Actor
{
    public SideBullet()
    {
        getImage().scale(100,100);
        setRotation(315);
    }

    public void act() 
    {
        //if the x location of the anchor is less than 400, move right
        if(getX() < 400)
        {
            setLocation(getX()+5,getWorld().getHeight()/2);
        }
        //if the x location of the anchor is more than 400, move left, and change the angle it's at
        else if(getX() > 400)
        {
            setRotation(135);
            setLocation(getX()-5,getWorld().getHeight()/2);  
        }
        HealthBar health = (HealthBar)getWorld().getObjects(HealthBar.class).get(0);
        if(isTouching(Chungus.class) == true)
        {
            //take away 1 health
            health.add(-3);
            //delete the bullet touching chungus
            getWorld().removeObject(this);

            
        }
        //otherwise if bullet is touching the bottom of the world
        else if(getX() == getWorld().getWidth()/2+10)
        {
            //delete the object touching the bottom
            getWorld().removeObject(this);
        }
        else if(getX() == getWorld().getWidth()/2-10)
        {
            //delete the object touching the bottom
            getWorld().removeObject(this);
        }
    }    
}
