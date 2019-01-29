import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigBullet extends Actor
{
    /**
     * Act - do whatever the BigBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BigBullet()
    {
        getImage().scale(200,200);
        setRotation(180);
    }

    public void act() 
    {

        setLocation(getWorld().getWidth()/2,getY()+10);
        HealthBar health = (HealthBar)getWorld().getObjects(HealthBar.class).get(0);
        if(isTouching(Chungus.class) == true)
        {
            //take away 1 health
            health.add(-3);
            //delete the bullet touching chungus
            getWorld().removeObject(this);

            
        }
        //otherwise if bullet is touching the bottom of the world
        else if(getY() == 690)
        {
            //delete the object touching the bottom
            getWorld().removeObject(this);
        }
    }    
}
