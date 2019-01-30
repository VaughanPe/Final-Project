import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChungusBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChungusBullet extends Chungus
{
    /**
     * Method checkHitChungusBullet
     * Checks whether the bullet has hit the enemy or the top of the world.
     * If it hits the enemy it adds 1 point to your score (1000 points to win) and deletes the object.
     * If it hits the top of the world it deletes the object.
     */
    public void checkHitChungusBullet()
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
        checkHitChungusBullet();
        
    }    
}
