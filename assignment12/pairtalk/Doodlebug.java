public class Doodlebug extends Critter {
    private int BreedTick = 0;
    private int starveCounter = 0;
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
            super.move();
            setMoved(true);
            //System.out.println("Moving a doodlebug!");
            BreedTick++;
            
            if (hasEaten){
                starveCounter = 0;
                //System.out.println("Resetting counter!");
                super.setHasEaten(false);
            } else if (!hasEaten) {
                if (starveCounter == 3){
                super.starve();
            } else{
                starveCounter++;
                //System.out.println("Starve counter = " + starveCounter);
              }
            }
            if (BreedTick == 8)
            {
                super.breed();
                BreedTick = 0;
            }
        }
    }

    @Override
    public void display() {
        System.out.print("D ");
    }
}