import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chungus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chungus extends Actor
{
    //tells the program the game hasn't started yet
    private boolean gameStart = false;
    private int index = 1;

    
    /**
     * Method gameStart
     * Tells the actor the game has started when the space key is pressed.
     */
    private void gameStart()
    {
        
        //if the space key is pressed
        if(Greenfoot.isKeyDown("space") == true)
        {
            //tell the actor that game has started
            gameStart = true;
        }
    }

    public Chungus()
    {
        //sets the size of the image
        getImage().scale(50,50);

    }
    
    /**
     * Method characterSwitch
     * Switches your character between 2 images when q and e are pressed.
     */
    private void characterSwitch()
    {
        
        GreenfootImage[] characters; 
        characters = new GreenfootImage[]{new GreenfootImage("chungus 2 2.0.png"),new GreenfootImage("tux.png")};
        //if the q key is pressed, set index to one and change the image to idx 1, then set the size of the image
        if(Greenfoot.isKeyDown("q") == true)
        {
            setImage(characters[1]);
            getImage().scale(50,50);
            index = 1;
        }
        //if the e key is pressed, set index to zero and change the image to idx 0, then set the size of the image
        if(Greenfoot.isKeyDown("e") == true)
        {
            setImage(characters[0]);
            getImage().scale(50,50);
            index = 0;
        }
    }
   
    /**
     * Method fire
     * Fires bullets from the players location when the k key is pressed.
     * When second character is being used, activates second firing mode (multiple bullets, wider spread).
     */
    private void fire()
    {
        
        //when the K key is pressed
        //if idx is 1, the k key is down, and the game has started, shoot one bullet
        if(Greenfoot.isKeyDown("k") == true && gameStart == true && index == 1)
        {
            //fire bullets
            getWorld().addObject(new ChungusBullet(),getX(),getY());
        }
        //if idx is 0, the k key is down, and the game has started, shoot 2 bullets
        else if(Greenfoot.isKeyDown("k") == true && gameStart == true && index == 0)
        {

            getWorld().addObject(new ChungusBullet(),getX()-10,getY());
            getWorld().addObject(new ChungusBullet(),getX()+10,getY());

        }
    }

    /**
     * Method movement
     * Moves the character up, left, right, and down then the WASD keys are pressed.
     * W = up.
     * S = down.
     * A = left.
     * D = right.
     */
    private void movement()
    {
        
        //when the D key is pressed
        if(Greenfoot.isKeyDown("d") == true)
        {
            //move the actor to the right
            move(5);

        }
        //when the A key is pressed
        if(Greenfoot.isKeyDown("a") == true)
        {
            //move the actor to the left
            move(-5);
        }
        //when the W key is pressed
        if(Greenfoot.isKeyDown("w") == true)
        {
            //move the actor up
            setLocation(getX(),getY()-5);
        } 
        //when the S key is pressed
        if(Greenfoot.isKeyDown("s") == true)
        {
            //move the actor down
            setLocation(getX(),getY()+5);
        }
        if(getY() < 150)
        {
            setLocation(400,600);
            }
    }

    /**
     * Act - do whatever the Chungus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gameStart();
        movement();
        characterSwitch();
        fire();

    }    
}
