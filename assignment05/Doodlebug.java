

public class Doodlebug extends Critter {
    public Doodlebug(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }

    public void move(){
    }

    @Override
    public void display() {
        System.out.print("D ");
    }
}