import java.awt.*;
import java.util.Stack;
public class RpnCalculator {
    static public Stack<Double> st;
    static public TextField display;
    static Operand op;
    static Adder add;
    static Subtracter sub;
    static Multiplier mul;
    static Divider div;
    static ResultPresenter rp;
    static RpnCalculatorGui cg;
    public static void main(String[] args){
        st = new Stack<Double>();
        op = new Operand(st, display);
        add = new Adder(st, display);
        sub = new Subtracter(st, display);
        mul = new Multiplier(st, display);
        div = new Divider(st, display);
        rp = new ResultPresenter(st, display);
        cg = new RpnCalculatorGui(op, add, sub, mul, div, rp);
    }
}
