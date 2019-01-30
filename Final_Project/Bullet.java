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
        //sets the direction the objects is facing
        setRotation(Greenfoot.getRandomNumber(180));
        //sets the size of the image/object
        getImage().scale(30,30);

    }
     
    

    /**
     * Method checkHit
     * Checks if the bullet is touching the player
     * If it is, it takes away 1 from the health bar and deletes the object.
     * If it's touching the bottom of the world, it deletes the object.
     * If points gets to 1000 it ends the game and displays Victory text, then stops the scenario.
     */
    private void checkHit()
    {
        
        HealthBar health = (HealthBar)getWorld().getObjects(HealthBar.class).get(0);
        //if bullet is touching chungus
        if(isTouching(Chungus.class) == true)
        {
            //take away 1 health
            health.add(-1);
            //delete the bullet touching chungus
            getWorld().removeObject(this);

        }
        //otherwise if bullet is touching the bottom of the world
        else if(getY() == 690)
        {
            //delete the object touching the bottom
            getWorld().removeObject(this);
        }
        //if your health is zero
        if(health.getCurrent() == 0)
        {

            //place text telling the player they lost
            getWorld().showText("You Lose",getWorld().getWidth()/2,getWorld().getHeight()/2);
            //stop the program
            Greenfoot.stop();
        }
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        move(5);
        
        checkHit();
        

    }    
}
