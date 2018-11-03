import java.util.Random;

public class Ant extends Critter {
    private int BreedTick = 0;
    
    public Ant(World world, int rowIndex, int columnIndex) {
        super(world, rowIndex, columnIndex);
    }
    
    
    public void move(){
        
        if (!moved()){
            super.move();
            setMoved(true);
            //System.out.println("Moving an ant!");
            BreedTick++;
            //System.out.println("BreedTick = " + BreedTick);
            
            if (BreedTick == 3)
            {
                super.breed();
                BreedTick = 0;
            }
        }
    }
    
    @Override
    public void display() {
        System.out.print("A ");
    }
}