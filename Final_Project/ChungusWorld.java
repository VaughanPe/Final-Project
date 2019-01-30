import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * 
 * 
 * Author: Vaughan Pelletier
 * Last edited: 1/29/2019
 * (Changing characters is a hidden feature)
 * (i was unable to figure out a way to use a loop here)
 */
public class ChungusWorld extends World
{

    private boolean gameStart = true;
    private ScoreBoard score;
    private String playerOneName = "1";
    private String playerTwoName = "2";
    private int nameCount = 1;
    private Chungus chungus = new Chungus();

    /**
     * Constructor for objects of class ChungusWorld.
     * Adds the basic objects to the world so the game can begin.
     */
    public ChungusWorld()
    {    
        // Creates a new world with 800x700 cells with a cell size of 1x1 pixels.
        super(800, 700, 1); 
        //adds the objects needed to start the game, such as chungus, the chungus hunters the healthbar and the scoreboard
        addObject(new ChungusHunter(),getWidth()/2,getHeight()/2-280);
        addObject(new Chungus(),getWidth()/2,600);
        
        //for loop, use index starting at 150, change index by 100 each time
        for(int i = 150; i <= 350; i = i + 100 )
        {
            addObject(new MiniChungusHunter(),getWidth()/2 + i,150);
            addObject(new MiniChungusHunter(),getWidth()/2 - i,150);
        }
              
        
        addObject(new HealthBar(),getWidth()/2-280,getHeight()-20);
        score = new ScoreBoard();
        addObject(score,getWidth()/2,200);
    }
    //an int to see whether or not dialogue has been placed yet
    public int dialogueCount1 = 1;
    //a boolean to determine whether the start message has been placed yet
    private boolean startMessage = true;
    //updates the score
    /**
     * Method update
     *When this method is called it updates the score.
     */
    public void update()
    {
        
        //add a value to the current score
        score.addToScore();
    }
    
    
    /**
     * Method nameCount
     * Allows the player to have their name displayed above the health bar.
     */
    private void nameCount()
    {
        
        //if this number is equal to one
        if(nameCount == 1)
        {
            //display a box for the player to put their name in
            playerOneName = JOptionPane.showInputDialog( "Please enter your name, Player One:", null );
            //set nameCount to 0
            nameCount = 0;
            //display the player's name in the bottom left corner
            showText(playerOneName,getWidth()/2-280,getHeight()-45);
        }
    }
    
    /**
     * Method startMessage
     * Adds text that tells the player how to play, and takes away that text when the game is started.
     */
    private void startMessage()
    {
        
        //if startmessage is true
        if(startMessage == true)
        {
            //display this text in the middle of the world
            showText("Press Z for 2 player and space to start game, W A S D to move and K to fire",getWidth()/2,getHeight()/2);
            showText("Shoot the big hunter in the middle to win" ,getWidth()/2,getHeight()/2+30);
            showText("don't hit or touch the rockets or you'll take damage",getWidth()/2,getHeight()/2+60);
        }
        //if the space key is pressed and this variable is true
        if(Greenfoot.isKeyDown("space") == true && gameStart == true)
        {
            //delete the start message
            showText("",getWidth()/2,getHeight()/2);
            showText("",getWidth()/2,getHeight()/2+30);
            showText("",getWidth()/2,getHeight()/2+60);
            //set the gameStart variable to false
            gameStart = false;
            //disable the start message from popping up again
            startMessage = false;
        }
    }
    /**
     * Method startGame
     * Checks if the game is started and if it is, begins firing bullets at the player.
     */
    private void startGame()
    {
        
        //if a random number is under 15 and this variable is false
        if(Greenfoot.getRandomNumber(1000) <= 15 && gameStart == false)
        {
            //add six new bullet objects at different locations
            addObject(new Bullet(),getWidth()/2+150,150);
            addObject(new Bullet(),getWidth()/2-150,150);
            addObject(new Bullet(),getWidth()/2+250,150);
            addObject(new Bullet(),getWidth()/2-250,150);
            addObject(new Bullet(),getWidth()/2+350,150);
            addObject(new Bullet(),getWidth()/2-350,150);

        }

    }
    
    public void act()
    {               
        //reference to the healthbar class
        HealthBar health = getObjects(HealthBar.class).get(0);
        nameCount();
        startMessage();
        startGame();
        
        
        
    }
}
