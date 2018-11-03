import java.util.Random;

public class World
{
    private Critter [] [] grid;
    
    public World (int gridsize)
    {
        grid = new Critter [gridsize] [gridsize];
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                grid [i] [j] = null;
            }
        }
    }
    public void AssignCritters (int antNumber, int doodlebugNumber)
    {
        Critter Ant = new Ant();
        Critter Doodlebug = new Doodlebug();
        
        Random randNum = new Random();
        
        for (int i = antNumber; i > 0; i--)
        {
            //System.out.print("...");  
            grid [randNum.nextInt(20)] [randNum.nextInt(20)] = Ant;
        }
        for (int i = doodlebugNumber; i > 0; i--)
        {
            grid [randNum.nextInt(20)] [randNum.nextInt(20)] = Doodlebug;
        }
    }
    public void Display()
    {
        //System.out.print("...");
        
        for (int i = 0; i < grid.length; i ++)
        {
            System.out.println();
            
            for (int j = 0; j < grid.length; j++)
            {
                //System.out.print("...");
                if (grid [i] [j] == null)
                {
                    System.out.print(".");
                }
                else if (grid [i] [j].getClass() == Ant.class)
                {
                    System.out.print("x");
                }
                 else 
                {
                    System.out.print("o");
                }
            }
        }
        }
    }
