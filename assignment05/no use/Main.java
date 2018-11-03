public class Main
{
    public static void main (String [] argv)
    {
        //Critter critter1 = new Ant();
        //Critter critter2 = new Doodlebug();
        
        //critter1.move();
        //critter2.move();
        
        World world = new World(20);
        world.AssignCritters (10,1);
        world.Display();
        //System.out.print("...");
        
    }
}