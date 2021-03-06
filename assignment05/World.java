import java.util.Random;

public class World {
    private Critter[][] grid;	// Array of organisms for each getCell

    public int getGridSize(){return grid.length;}

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
        // loop through the 2-dimensional array: grid
        for (int i = 0; i < grid.length; i++){
            // for each row of the grid
            // loop through each cell in the row
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == null){
                    // if the cell [i, j] is empty (==null)
                    // print ". "
                    System.out.print(". ");
                } else {
                    // if the cell is not empty
                    // call the method display of this cell's Critter instance
                    grid[i][j].display();
                }
            }
            // end of each row, print a newline character
            System.out.println();
        }
    }

    public void AssignCritters(int antNumber, int doodlebugNumber) {
        AssignCritters_inner(antNumber, "Ant");
        AssignCritters_inner(doodlebugNumber, "Doodlebug");
    }

    private void AssignCritters_inner(int critterNumber, String critterType) {
        Random random = new Random();
        for (int i = 0; i < critterNumber; i++){
            int rowIndex = random.nextInt(grid.length);
            int columnIndex = random.nextInt(grid[rowIndex].length);

            if(grid[rowIndex][columnIndex] == null){
                if (critterType.equals("Ant")){
                    grid[rowIndex][columnIndex] = new Ant(this, rowIndex, columnIndex);
                } else if (critterType.equals("Doodlebug")){
                    grid[rowIndex][columnIndex] = new Doodlebug(this, rowIndex, columnIndex);
                }
            } else {
                i --;
            }
        }
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

    public boolean OutOfBound(int x, int y) {
        if (x >=0 && x < grid.length // x is in bound
                && y >= 0 && y < grid[x].length // y is in bound
        ){
            return false; // NOT out of bound
        } else {
            return true; // YES, out of bound
        }
    }
}