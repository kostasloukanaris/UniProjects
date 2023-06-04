public class GateOnBoard {
    Gate gate;
    int column;
    int input1Pin;
    int input2Pin;
    int outputPin;

    public GateOnBoard(Gate gate, int column, int in1Pin, int in2Pin, int outPin){
        this.gate=gate;
        this.column=column;
        input1Pin=in1Pin;
        input2Pin=in2Pin;
        outputPin=outPin;
    }
    public Gate getGate() {
        return gate;
    }
    public boolean calculateOutput(boolean a, boolean b){
        gate.setIn(0, a);
        gate.setIn(1, b);
        gate.calculateOutput();
        return gate.isOut();
    }
}
