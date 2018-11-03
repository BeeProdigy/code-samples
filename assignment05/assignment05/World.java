import java.util.Random;

public class World {
    private Critter[][] grid;	// Array of organisms for each getCell

    public int getGridSize()
    {
        return grid.length;
    }

    public Critter getCell(int i, int j){
        return grid[i][j];
    }

    public void setCell(int x, int y, Critter c) {
        this.grid[x][y] = c;
    }

    public World(int gridsize){
        grid = new Critter[gridsize][gridsize];
        for(int i = 0; i < gridsize; i++){
            for(int j = 0; j < gridsize; j++){
                grid[i][j] = null;
            }
        }
    }

    public void Display(){
        // todo: try to figure out another way to achieve Display
        // (different from your last submission)
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == null)
                {
                    System.out.print(". ");
                }
                else
                {
                    grid[i][j].display();
                }
            }
            System.out.println();
        }
    }

    public void AssignCritters(int antNumber, int doodlebugNumber) {
        // todo: try to figure out another way to implement AssignCritters
        // (different from your last submission)
        Random r = new Random ();
        int N = grid.length;
        r.nextInt(N+1); // random number between 0 and N
        int rIndex = r.nextInt(grid.length);
        int cIndex = r.nextInt(grid[rIndex].length);
        //grid[rIndex][cIndex]
        
        
        for (int i = 0; i < antNumber+1; i++)
        {
            rIndex = 0;
            cIndex = 0;
            while (true)
            {
                int randomI = r.nextInt(grid.length);
                int randomJ = r.nextInt(grid.length);
                //same here
                if (grid[rIndex][cIndex] == null)
                {
                    rIndex = randomI;
                    cIndex = randomJ;
                    break;
                }
            }
            grid[rIndex][cIndex] = new Ant(World.this, rIndex, cIndex);
        }
        /**for (int i = 0; i < doodlebugNumber; i++)
        {
            rIndex = 0;
            cIndex = 0;
            while (true)
            {
                int randomI = r.nextInt(grid.length-1);
                int randomJ = r.nextInt(grid.length-1);
                //same here
                if (grid[rIndex][cIndex] == null)
                {
                    rIndex = randomI;
                    cIndex = randomJ;
                    break;
                }
            }
            grid[rIndex][cIndex] = new Doodlebug(World.this, rIndex, cIndex);
        }*/
    }

    public static void main(String[] argv){
        World world = new World(5);
        world.AssignCritters(10, 15);
        world.Display();
    }

    public void oneStepSimulation(){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                if (grid[i][j]!=null){
                    grid[i][j].move();
                }
            }
        }

    }
}