
import java.awt.*;
import java.util.Stack;

public class Divider extends Operator{
    static public TextField display;
    public Divider(Stack<Double> st, TextField display){
        super(st);
        RpnCalculatorGui.display=display;
    }
    public void operate() {
        if (st.isEmpty() == false) {
            Double divisor = (Double) this.st.pop();
            if (divisor != 0.0) {
                st.push((Double) st.pop() / divisor);
            } else {
                RpnCalculatorGui.display.setText("Cannot divide by zero!");
            }
        }
        else{ RpnCalculatorGui.display.setText("Empty Stack");}
    }
}