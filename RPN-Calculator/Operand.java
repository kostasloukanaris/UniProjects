
import java.awt.*;
import java.util.Stack;

public class Operand {
    int val;
    Stack<Double> st;
    static public TextField display;
    public Operand(Stack<Double> st, TextField display){
        this.st=st;
        RpnCalculatorGui.display=display;
    }
    public void addDigit(char ch) {
        val*=10;
        val+=Integer.parseInt(String.valueOf(ch));
        RpnCalculatorGui.display.setText(Double.toString(val));
    }

    public void resetAll(){
        if(st.isEmpty()==false){RpnCalculator.st.removeAllElements();}
        else{RpnCalculatorGui.display.setText("Empty Stack");}
    }
    public void reset(){
        if(st.isEmpty()==false){this.st.pop();}
        else{RpnCalculatorGui.display.setText("Empty Stack");}
    }
    public void complete() {
        RpnCalculator.st.push(new Double(val));
        System.out.println(RpnCalculator.st);
        val=0;
    }
    public void deleteLastDigit(){
        if(val!=0) {
            int tempVal;
            tempVal = val / 10;
            if (tempVal == 0) {
                val = 0;
            } else {
                val = tempVal;
            }
            RpnCalculatorGui.display.setText(Double.toString(val));
        }
    }
}

