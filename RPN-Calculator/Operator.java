
import java.awt.*;
import java.util.Stack;

public abstract class Operator{
    Stack<Double> st;
    static public TextField display;
    public Operator(Stack<Double> st){
        this.st=st;
    }
    public abstract void operate();
}