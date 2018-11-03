import java.util.Random;

abstract public class Critter {
    protected World myWorld; // know in which world the critter lives
    protected int x, y; // Position in the world
    public boolean moved = false;
    public boolean hasEaten = false;
    public boolean moved(){
        return moved;
    }
    public void setMoved (boolean m){
        moved = m;
    }
    public boolean hasEaten(){
        return hasEaten;
    }
    public void setHasEaten(boolean ate){
        hasEaten = ate;
    }
    public void move(){
        Random random = new Random();
        int direction = random.nextInt(4);
        int x_direction = 0;
        int y_direction = 0;
        switch (direction){
            case 0:
                x_direction = -1;
                break;
            case 1: 
                x_direction = 1;
                break;
            case 2:
                y_direction = -1;
                break;
            case 3:
                y_direction = 1;
                break;
        }
        
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
    
    public void breed(){
            //int BreedTick = 0;
            
            if (!myWorld.OutOfBound(x+1, y) && myWorld.getCell(x+1, y) == null){
                myWorld.setCell(this.x+1, y, this);
                myWorld.setCell(this.x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x-1, y) && myWorld.getCell(x-1, y) == null){
                myWorld.setCell(this.x-1, y, this);
                myWorld.setCell(this.x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x, y+1) && myWorld.getCell(x, y+1) == null){
                myWorld.setCell(this.x, y+1, this);
                myWorld.setCell(this.x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x, y-1) && myWorld.getCell(x, y-1) == null){
                myWorld.setCell(this.x, y-1, this);
                myWorld.setCell(this.x, y, this);
                setMoved(true);
                return;
            }else{
                return;
            }
            //int BreedTick = 0;
    }
    public void eat(){
        if (!moved()){ 
            if (myWorld.isCellAnt(x+1, y) == true){
                  myWorld.setCell(this.x+1, this.y, this);
                  myWorld.setCell(this.x, this.y, null);
                  setMoved(true);
                  setHasEaten(true);
           }else if (myWorld.isCellAnt(x-1,y) == true){
                   myWorld.setCell(this.x-1, this.y, this);
                   myWorld.setCell(this.x, this.y, null);
                   setMoved(true);
                   setHasEaten(true);
           }else if (myWorld.isCellAnt(x, y+1) == true){
                    myWorld.setCell(this.x, this.y+1, this);
                    myWorld.setCell(this.x, this.y, null);
                    setMoved(true);
                    setHasEaten(true);
           }else if (myWorld.isCellAnt(x, y-1) == true){
                    myWorld.setCell(this.x, this.y-1, this);
                    myWorld.setCell(this.x, this.y, null);
                    setMoved(true);
                    setHasEaten(true);
           } else {
               return;
            }
        }
        //System.out.println("Nom, nom, nom");
        // was here to check if the doodlbug was about to move out of bounds 
        // because even with the other check in place it still moved OOB
        if (!moved){
            if (myWorld.OutOfBound(x+1, y)|| myWorld.getCell(x+1, y) == null ){
                return;
            }else if (myWorld.OutOfBound(x-1, y) || myWorld.getCell(x-1, y) == null){
                return;
            }else if (myWorld.OutOfBound(x, y+1) || myWorld.getCell(x, y+1) == null){
                return;
            }else if (myWorld.OutOfBound(x, y-1) || myWorld.getCell(x, y-1) == null){
                return;
            }
        } 
    }
    public void starve(){
        myWorld.setCell(this.x, this.y, null);
    }
    abstract public void display();

    public Critter(World world, int rowIndex, int columnIndex){
        myWorld = world;
        x = rowIndex;
        y = columnIndex;
    }

}