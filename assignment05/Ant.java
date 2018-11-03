
public class Ant extends Critter {
    public Ant(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }

    public void move(){
        int x_direction = 1;
        int y_direction = 0;

        inner_move(x_direction, y_direction);
    }

    private void inner_move(int x_direction, int y_direction) {
        int newX = x + x_direction;
        int newY = y + y_direction;

        if (myWorld.OutOfBound(newX, newY)){
            return;
        }

        if (myWorld.getCell(newX, newY) == null) {
            myWorld.setCell(newX, newY, this);
            myWorld.setCell(x, y, null);
            this.x = newX;
            this.y = newY;
        }
    }


    @Override
    public void display() {
        System.out.print("A ");
    }
}