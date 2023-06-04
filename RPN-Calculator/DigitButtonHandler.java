import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DigitButtonHandler implements ActionListener {
    String s;
    public DigitButtonHandler(String s) { this.s=s;}
    public void actionPerformed(ActionEvent pushingButton0){
        RpnCalculatorGui.op.addDigit(s.charAt(0)); }
}
