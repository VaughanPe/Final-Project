import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigBullet extends Actor
{
    public BigBullet()
    {
        setRotation(180);
        getImage().scale(100,100);
    }
    /**
     * Act - do whatever the BigBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */     
    public void act() 
    {
        setLocation(getWorld().getWidth()/2,getY()+10);
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }    
}
