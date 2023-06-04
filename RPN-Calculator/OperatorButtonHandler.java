import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OperatorButtonHandler implements ActionListener {
    Operator opt;

    public OperatorButtonHandler(Operator opt) {this.opt = opt;}
    public void actionPerformed(ActionEvent pushingOperatorButton) {
        opt.operate();
    }
}