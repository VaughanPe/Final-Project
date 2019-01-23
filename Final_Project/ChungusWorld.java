import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChungusWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChungusWorld extends World
{
    public boolean addLinux = true;

    /**
     * Constructor for objects of class ChungusWorld.
     * 
     */
    public ChungusWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 700, 1); 
        
        addObject(new ChungusHunter(),getWidth()/2,getHeight()/2-280);
        addObject(new Chungus(),getWidth()/2,600);
        addObject(new MiniChungusHunter(),getWidth()/2+150,150);
        addObject(new MiniChungusHunter(),getWidth()/2-150,150);
        addObject(new MiniChungusHunter(),getWidth()/2+250,150);
        addObject(new MiniChungusHunter(),getWidth()/2-250,150);
        addObject(new MiniChungusHunter(),getWidth()/2+350,150);
        addObject(new MiniChungusHunter(),getWidth()/2-350,150);
    }
    public int dialogueCount1 = 1;
    private boolean startMessage = true;
    public void linuxAdd1()
    {
        if(Greenfoot.isKeyDown("z") == true && addLinux == true)
        {
            addObject(new LinuxChungus(),450,600);
            addLinux = false;

        }
    }

    public void act()
    {
        if(startMessage == true)
        {
            showText("Press Z for 2 player and space to start game",getWidth()/2,getHeight()/2);                                               
        }
        linuxAdd1();

        
    }
}
