import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class Circuit {
    Breadboard bb;
    ArrayList<LinkedList<GateOnBoard>> gates;
    And and = new And();

    public Circuit(Breadboard bb) {
        this.bb=bb;
        gates = new ArrayList<LinkedList<GateOnBoard>>(bb.columns-1);
        for(int i=0; i<bb.columns-1; i++) {
            gates.add(new LinkedList<GateOnBoard>());
        }
    }
    public void calculateOutput() {
        int i=1;
        for(LinkedList<GateOnBoard> ll:gates) {
            for(GateOnBoard g: ll) {
                boolean input1 = bb.bbholes[g.input1Pin][g.column];
                boolean input2 = bb.bbholes[g.input2Pin][g.column];
                boolean output = g.calculateOutput(input1, input2);
                bb.bbholes[g.outputPin][g.column + 1] = output;
                String gateName = g.getGate().getClass().getSimpleName();
                System.out.println(input1 + " " + gateName + " " + input2 + " --> " + output);
                i++;
            }
        }
    }

    public void defineCircuit() {
        try {
            FileReader file = new FileReader("testCircuit.txt");
            StringBuilder fileContent = new StringBuilder();
            int character;

            while ((character = file.read()) != -1) {
                fileContent.append((char) character);
            }

            System.out.println("\nContents of the file:");
            System.out.println(fileContent);
            System.out.println("\n");
            file.close();

            String[] splitArray = fileContent.toString().split("[,\n]");

            for (int i = 0; i < splitArray.length; i++) {
                splitArray[i] = splitArray[i].trim();
            }

            char[][] filearray = new char[splitArray.length][];
            for (int i = 0; i < splitArray.length; i++) {
                filearray[i] = splitArray[i].toCharArray();
            }

            char[][] gateArray = new char[7][];
            int i=0;
            int k=0;
            for(int j=0; j<7; j++) {
                gateArray[j] = filearray[i];
                i+=5;
                if (String.valueOf(gateArray[j]).equals("AND")) {
                    gates.get(0).add(new GateOnBoard(new And(), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k])), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k]))));
                    ++k;
                } else if (String.valueOf(gateArray[j]).equals("NOR")) {
                    gates.get(0).add(new GateOnBoard(new Nor(), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k])), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k]))));
                    ++k;
                } else if (String.valueOf(gateArray[j]).equals("XOR")) {
                    gates.get(0).add(new GateOnBoard(new Xor(), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k])), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k]))));
                    ++k;
                } else if (String.valueOf(gateArray[j]).equals("OR")) {
                    gates.get(0).add(new GateOnBoard(new Or(), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k])), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k]))));
                    ++k;
                } else if (String.valueOf(gateArray[j]).equals("NAND")) {
                    gates.get(0).add(new GateOnBoard(new Nand(), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k])), Integer.parseInt(String.valueOf(filearray[++k])),
                            Integer.parseInt(String.valueOf(filearray[++k]))));
                    ++k;
                }else {
                    System.out.println(String.valueOf(gateArray[j]));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void defineInputs ( boolean[] b){
        for (int i = 0; i < 6; i++) {
            bb.bbholes[i][0] = b[i];
        }
    }
}