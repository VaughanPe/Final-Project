import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChungusBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChungusBullet extends Chungus
{
    public void checkHit()
    {
        //Checks if the bullet has hit the enemy and updates it's hp
        if(isTouching(ChungusHunter.class) == true)
        {
            
            ((ChungusWorld)getWorld()).update();
            getWorld().removeObject(this);
        }
        //if this object is at the edge of the world
        else if(isAtEdge() == true)
        {
            //remove this object
            getWorld().removeObject(this);
            }
        }
    /**
     * Act - do whatever the ChungusBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChungusBullet()
    {
        //sets the size of the image
        getImage().scale(10,10);
        
    }
    
    public void act() 
    {
        //moves the bullet up continuously
        setLocation(getX(),getY()-15);
        //checks if it has hit the enemy and takes away health if it has
        checkHit();
        
    }    
}
