import java.util.Scanner;

public class Main {
    public static void main(String[] argv){
        Scanner scan = new Scanner (System.in);
        World world = new World(20);
        
        world.AssignCritters(10, 5);
        world.Display();
        System.out.println("\n\n");
        
        while (true){
            System.out.println("Press enter for next step");
            scan.nextLine();
            world.oneStepSimulation();
            world.Display();
            System.out.println();
        }   
        
    }
}