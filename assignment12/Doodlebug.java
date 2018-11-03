

public class Doodlebug extends Critter {
    public Doodlebug(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }
    
    /**public boolean hasAntNeighbor(){
        
            if (myWorld.getCell(x+1, y).getClass() == Ant.class){
               return true;
           }else if (myWorld.getCell(x-1, y).getClass() == Ant.class){
               return true;
           }else if (myWorld.getCell(x, y+1).getClass() == Ant.class){
               return true;
           }else if (myWorld.getCell(x, y+1).getClass() == Ant.class){
               return true;
           }else{
               return false;
            }
    }*/

    public void move(){
        if (!moved){
            eat();
        }
        if (!moved){
            super.move();
            setMoved(true);
        }
    }

    @Override
    public void display() {
        System.out.print("D ");
    }
}