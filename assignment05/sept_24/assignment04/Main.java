public class Main {
    public static void main(String[] argv){
        World world = new World(3);
        world.AssignCritters(4, 1);
        world.Display();
        System.out.println("\n\n\n\n");
        world.oneStepSimulation();
        world.Display();
    }
}