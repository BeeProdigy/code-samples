abstract public class Critter {
    protected World myWorld; // know in which world the critter lives
    protected int x, y; // Position in the world

    abstract public void move();
    public Critter(World world, int rowIndex, int columnIndex){
        myWorld = world;
        x = rowIndex;
        y = columnIndex;
    }
    abstract public void display();
}