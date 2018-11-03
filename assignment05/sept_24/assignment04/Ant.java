import java.util.Random;

public class Ant extends Critter {
    public Ant(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }
    public void move(){
        //todo:
        // Check whether the cell below is available
        //
        // If the cell below is available (the cell is not out of boundary and is empty), put the ant to the next cell
        // Else: the ant does not move
        
        int gridsize = this.myWorld.getGridSize();
        int newy = this.y+1;
        int newx = this.x+1;
        if(newy >= gridsize && newx >= gridsize)
        {
            return;
        }
        
        Critter cellR = this.myWorld.getCell(this.x, this.y+1);
        Critter cellL = this.myWorld.getCell(this.x, this.y+1);
        Critter cellU = this.myWorld.getCell(this.x+1, this.y);
        Critter cellD = this.myWorld.getCell(this.x-1, this.y);
        
        Random r = new Random();
        int rand = r.nextInt(3);
        
        switch (rand)
        {
            case 0: // move the critter right
                if(cellR == null)
                {
                    this.myWorld.setCell(this.x, this.y+1, this);
                    this.myWorld.setCell(this.x, this.y, null);
                }
                break;
                
            case 1:
                if(cellL == null) //move the critter lect
                {
                    this.myWorld.setCell(this.x, this.y-1, this);
                    this.myWorld.setCell(this.x, this.y, null);
                }
                break;
            
            case 2:
        }
        //System.out.print("moving");
    }
    public void display()
    {
        //@override
        System.out.print("A ");
    }
}