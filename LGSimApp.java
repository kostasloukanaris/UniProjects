import java.util.Scanner;

public class LGSimApp {
    static boolean [] inputs= new boolean[6];
    static Circuit circuit;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        for (int i = 0; i <6; i++) {
            System.out.print("Enter a boolean value (true/false) for index " + i + ": ");
            inputs[i] = sc.nextBoolean();
        }
        int columns=4;
        int rows=10;
        Breadboard bb = new Breadboard(columns,rows);
        circuit = new Circuit(bb);
        circuit.defineCircuit();
//        System.out.println(circuit);

        circuit.defineInputs(inputs);
        circuit.calculateOutput();
    }
}
