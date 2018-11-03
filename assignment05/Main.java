public class Main {
    public static void main(String[] argv){
        World world = new World(5);
        world.AssignCritters(2, 1);
        world.Display();
        System.out.println("\n\n");
        world.oneStepSimulation();
        world.Display();
    }
}