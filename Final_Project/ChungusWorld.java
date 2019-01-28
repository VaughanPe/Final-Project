import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class ChungusWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChungusWorld extends World
{
    public boolean addLinux = true;
    private boolean gameStart = true;
    
    private String playerOneName = "1";
    private String playerTwoName = "2";
    private int nameCount = 1;
    
    
    
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
        addObject(new HealthBar(),getWidth()/2-280,getHeight()-20);
     }
    public int dialogueCount1 = 1;
    private boolean startMessage = true;
    
    public void act()
    {
        if(nameCount == 1)
        {
         playerOneName = JOptionPane.showInputDialog( "Please enter your name, Player One:", null );
         nameCount = 0;
         showText(playerOneName,getWidth()/2-280,getHeight()-45);
       }
        
        HealthBar health = getObjects(HealthBar.class).get(0);
        
        if(startMessage == true)
        {
            showText("Press Z for 2 player and space to start game",getWidth()/2,getHeight()/2);                                               
        }
        
        if(Greenfoot.isKeyDown("space") == true && gameStart == true)
        {
            showText("",getWidth()/2,getHeight()/2);
            gameStart = false;
            startMessage = false;
        }
        if(Greenfoot.getRandomNumber(1000) <= 15)
           {
             addObject(new Bullet(),getWidth()/2+150,150);
             addObject(new Bullet(),getWidth()/2-150,150);
            addObject(new Bullet(),getWidth()/2+250,150);
            addObject(new Bullet(),getWidth()/2-250,150);
            addObject(new Bullet(),getWidth()/2+350,150);
            addObject(new Bullet(),getWidth()/2-350,150);
            
         }
        
    }
}
