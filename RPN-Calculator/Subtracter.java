
import java.awt.*;
import java.util.Stack;

public class Subtracter extends Operator{
    static public TextField display;
    public Subtracter(Stack<Double> st,TextField display){
        super(st);
        RpnCalculatorGui.display=display;
    }
    public void operate(){
        if(st.isEmpty()==false){ Double subtrahend = (Double)st.pop();
            st.push((Double)st.pop() - subtrahend);}
        else{ RpnCalculatorGui.display.setText("Empty Stack");}

    }
}