import java.awt.*;
import java.util.Stack;

public class Adder extends Operator{
    static public TextField display;
    public Adder(Stack<Double> st,TextField display){
        super(st);
        RpnCalculatorGui.display=display;
    }
    public void operate(){
        if(st.isEmpty()==false){st.push((Double)st.pop() + (Double)st.pop());}
        else{ RpnCalculatorGui.display.setText("Empty Stack");}
    }
}
