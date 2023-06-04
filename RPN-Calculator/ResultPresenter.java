
import java.util.Stack;
import java.awt.*;
public class ResultPresenter extends Operator {
    static public TextField display;

    public ResultPresenter(Stack<Double> st, TextField display) {
        super(st);
        RpnCalculatorGui.display = display;
    }

    public void operate() {
        if (st.isEmpty() == false) {
            Double val = (Double) st.pop();
            RpnCalculatorGui.display.setText(Double.toString(val));
        } else {
            RpnCalculatorGui.display.setText("Empty Stack");
        }
    }
}