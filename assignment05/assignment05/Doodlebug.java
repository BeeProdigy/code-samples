public class Doodlebug extends Critter {
    public Doodlebug(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }
    public void move(){
        /**System.out.println("doodlebug move");
        int gridsize = this.myWorld.getGridSize();
        int newx = this.x+1;
        if(newx > gridsize)
        {
            return;
        }
        
        Critter cell = this.myWorld.getCell(this.x+1, this.y);
        
        if(cell == null)
        {
            this.myWorld.setCell(this.x+1, this.y, this);
            this.myWorld.setCell(this.x+1, this.y, null);
        }*/
    }
    public void display()
    {
        System.out.print("D ");
    }
}