import java.util.Random;

abstract public class Critter {
    protected World myWorld; // know in which world the critter lives
    protected int x, y; // Position in the world
    public boolean moved = false;
    
    public boolean moved(){
        return moved;
    }
    public void setMoved (boolean m){
        moved = m;
    }
    public void move(){
        if (!moved){
            Random random = new Random();
            int x_direction = random.nextInt(2);
            int y_direction = random.nextInt(2);
            
            inner_move(x_direction, y_direction);
        }
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
                myWorld.setCell(x+1, y, this);
                myWorld.setCell(x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x-1, y) && myWorld.getCell(x-1, y) == null){
                myWorld.setCell(x-1, y, this);
                myWorld.setCell(x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x, y+1) && myWorld.getCell(x, y+1) == null){
                myWorld.setCell(x, y+1, this);
                myWorld.setCell(x, y, this);
                setMoved(true);
                return;
            }else if (!myWorld.OutOfBound(x, y-1) && myWorld.getCell(x, y-1) == null){
                myWorld.setCell(x, y-1, this);
                myWorld.setCell(x, y, this);
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
           }else if (myWorld.isCellAnt(x-1,y) == true){
                   myWorld.setCell(this.x-1, this.y, this);
                   myWorld.setCell(this.x, this.y, null);
                   setMoved(true);
           }else if (myWorld.isCellAnt(x, y+1) == true){
                    myWorld.setCell(this.x, this.y+1, this);
                    myWorld.setCell(this.x, this.y, null);
                    setMoved(true);
           }else if (myWorld.isCellAnt(x, y-1) == true){
                    myWorld.setCell(this.x, this.y-1, this);
                    myWorld.setCell(this.x, this.y, null);
                    setMoved(true);
           }
        }
        //System.out.println("Nom, nom, nom");
        if (!moved){
            if (myWorld.getCell(x+1, y) == null || myWorld.OutOfBound(x+1, y)){
                return;
            }else if (myWorld.getCell(x-1, y) == null || myWorld.OutOfBound(x-1, y)){
                return;
            }else if (myWorld.getCell(x, y+1) == null || myWorld.OutOfBound(x, y+1)){
                return;
            }else if (myWorld.getCell(x, y-1) == null || myWorld.OutOfBound(x, y-1)){
                return;
            }
        }
    }
    abstract public void display();

    public Critter(World world, int rowIndex, int columnIndex){
        myWorld = world;
        x = rowIndex;
        y = columnIndex;
    }

}