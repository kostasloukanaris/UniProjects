
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
public class RpnCalculatorGui extends Frame {
    public static Operator opt;
    public static Operand op;
    public static Adder add;
    public static Subtracter sub;
    public static Multiplier mul;
    public static Divider div;
    public static ResultPresenter rp;
    public Button buttonEnter, buttonPlus, buttonMul, buttonMinus, buttonDiv, buttonResultPresenter;
    public Button buttonBackSpace, buttonClearAll, buttonClear;
    public Button[] button = new Button[10];
    public static TextField display;
    public static int[][] dbc = {
            {64, 265},{64, 232},{104, 232},{144, 232},{64, 199},{104, 199},{144, 199},{64, 166},{104, 166},{144, 166}
    };
    public static int[][] obc = {
            {195, 265},{195, 199},{235, 232},{195, 232},{235, 265}
    };
    public RpnCalculatorGui(Operand op, Adder add, Subtracter sub, Multiplier mul, Divider div, ResultPresenter rp) {
       super("RPN Calculator");
        this.op = op;
        this.setLayout(null);
        this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        this.setBackground(Color.darkGray);

        int i;
        for(i=0; i<=9; i++) {
            String numtostring = Integer.toString(i);
            button[i] = new createDigitButton(numtostring, dbc[i], new DigitButtonHandler(numtostring), this);
        }

        buttonEnter = new Button("ENTER");
        buttonEnter.setFont(new Font("TimesRoman", Font.BOLD, 14));
        buttonEnter.setBackground(Color.orange);
        buttonEnter.setForeground(Color.black);
        buttonEnter.setBounds(204, 100, 56, 28);
        buttonEnter.addActionListener(new ButtonEnterHandler());
        this.add(buttonEnter);

        buttonBackSpace = new Button("BackSpace");
        buttonBackSpace.setFont(new Font("TimesRoman", Font.BOLD, 14));
        buttonBackSpace.setForeground(Color.blue);
        buttonBackSpace.setBounds(44, 100, 95, 28);
        buttonBackSpace.addActionListener(new ButtonBackSpaceHandler());
        RpnCalculatorGui.this.add(buttonBackSpace);

        buttonClearAll = new Button("C");
        buttonClearAll.setFont(new Font("TimesRoman", Font.BOLD, 14));
        buttonClearAll.setForeground(Color.blue);
        buttonClearAll.setBounds(144, 133, 35, 28);
        buttonClearAll.addActionListener(new ButtonClearAllHandler());
        RpnCalculatorGui.this.add(buttonClearAll);

        buttonClear = new Button("CE");
        buttonClear.setFont(new Font("TimesRoman", Font.BOLD, 14));
        buttonClear.setForeground(Color.blue);
        buttonClear.setBounds(144, 100, 35, 28);
        buttonClear.addActionListener(new ButtonClearHandler());
        RpnCalculatorGui.this.add(buttonClear);

        buttonPlus = new createOperatorButton("+", obc[0], new OperatorButtonHandler(add), this);
        buttonMul = new createOperatorButton("*", obc[1], new OperatorButtonHandler(mul), this);
        buttonDiv = new createOperatorButton("/", obc[2], new OperatorButtonHandler(div), this);
        buttonMinus = new createOperatorButton("-", obc[3], new OperatorButtonHandler(sub), this);
        buttonResultPresenter = new createOperatorButton("=", obc[4], new OperatorButtonHandler(rp), this);

        display = new TextField("0");
        display.setEditable(false);
        display.setBounds(13, 55, 257, 30);
        this.add(display);

        this.setSize(283, 320);
        this.setLocation(40, 80);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(new CloseWindowAndExit());
    }
//    private Button createDigitButton(String s, int[] dbc2, DigitButtonHandler dbh, Frame f){
//        var button = new Button(s);
//        button.setBounds(dbc2[0], dbc2[1], 35, 28);
//        button.setFont(new Font("TimesRoman", Font.BOLD, 14));
//        button.setForeground(Color.black);
//        button.addActionListener(dbh);
//        f.add(button);
//        return button;
//    }
//    private Button createOperatorButton(String s2, int[] obc2, OperatorButtonHandler obh, Frame f){
//        var button = new Button(s2);
//        button.setBounds(obc2[0], obc2[1], 35, 28);
//        button.setFont(new Font("TimesRoman", Font.PLAIN, 14));
//        button.setForeground(Color.blue);
//        button.addActionListener(obh);
//        f.add(button);
//        return button;
//    }
//    class DigitButtonHandler implements ActionListener{
//        String s;
//        public DigitButtonHandler(String s) { this.s=s;}
//        public void actionPerformed(ActionEvent pushingButton0){
//            RpnCalculatorGui.op.addDigit(s.charAt(0)); }
//    }
//    class OperatorButtonHandler implements ActionListener {
//        Operator opt;
//
//        public OperatorButtonHandler(Operator opt) {this.opt = opt;}
//        public void actionPerformed(ActionEvent pushingOperatorButton) {
//            opt.operate();
//        }
//    }
    class ButtonEnterHandler implements ActionListener{
        public ButtonEnterHandler() { }
        public void actionPerformed(ActionEvent pushingButtonEnter)
        { RpnCalculatorGui.op.complete(); }
    }
    class ButtonBackSpaceHandler implements ActionListener{
        public ButtonBackSpaceHandler() { }
        public void actionPerformed(ActionEvent pushingButtonBackSpace)
        { RpnCalculatorGui.op.deleteLastDigit(); }
    }
    class ButtonClearAllHandler implements ActionListener{
        public ButtonClearAllHandler() { }
        public void actionPerformed(ActionEvent pushingButtonClearAll){
            RpnCalculatorGui.op.resetAll();
        }
    }
    class ButtonClearHandler implements ActionListener{
        public ButtonClearHandler() { }
        public void actionPerformed(ActionEvent pushingButtonClear)
        { RpnCalculatorGui.op.reset(); }
    }
    class CloseWindowAndExit extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent CloseWindowAndExit) {
          System.exit(0);
        }
    }
}
