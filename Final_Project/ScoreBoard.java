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
    private SideBullet side = new SideBullet();
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
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
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
        //if the hunter is down past 750 points,
        if(points > 750)
        {
            //if this random number is below or equal to 5
            if(Greenfoot.getRandomNumber(1000) <= 5)
            {
                //add a side bullet object to the left side of the world
                getWorld().addObject(new SideBullet(),0,getWorld().getHeight()/2+200);
            }
            //if this random number is below or equal to 15
            else if(Greenfoot.getRandomNumber(1000)+10 <= 15)
            {
                //add a side bullet object to the right side of the world
                getWorld().addObject(new SideBullet(),800,getWorld().getHeight()/2+200);
            }
        }
    }    
}
