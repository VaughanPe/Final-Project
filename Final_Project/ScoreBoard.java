import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    public int points;
    private BigBullet big = new BigBullet();
    
    private Font font = new Font("Times New Roman",20);
    
    public ScoreBoard()
    {
        
        //sets the default point number
        points = 0;
        //adds a new image
        GreenfootImage picture = new GreenfootImage(200,100);
        //sets the color of the text
        picture.setColor(Color.RED);
        //sets the font of the text
        picture.setFont(font);
        //draws the text on the image
        picture.drawString("Points: "+points,70,20);
        //sets the image of the object to the text
        setImage(picture);
    }
    
    /**
     * Method addToScore
     * Adds points when other classes tell it to until it gets to 1000.
     * When the points get to 1000 it displays Victory text and stops the program.
     */
    public void addToScore()
    {
        
        points++;
        GreenfootImage picture = getImage();
        picture.clear();
        //if the point number is less than 1000
        if(points <= 1000)
        {
            //place the text in the world
            picture.drawString("Points: "+points,70,20);

        }
        //otherwise
        else
        {
            //tells the player they won
            getWorld().showText("Victory",400,350);
            //stops the program
            Greenfoot.stop();
        }
    }
    
    /**
     * Method bigBulletUse
     * Checks if points is over 250.
     * If it is, it gets a random number out of 1000.
     * If this number is equal to 1 it adds a BigBullet object to the world.
     */
    private void bigBulletUse()
    {
        
        
        //if the hunter is down past 250 points,
        if(points > 250)
        {
            //if this random number is equal to one
            if(Greenfoot.getRandomNumber(1000) == 1)
            {
                //add a big bullet object to the world
                getWorld().addObject(new BigBullet(),getWorld().getWidth(),getWorld().getHeight()/2-240);
            }
        }
        }
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        bigBulletUse();
        
    }    
}
