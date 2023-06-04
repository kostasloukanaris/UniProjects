import java.awt.*;
public class createOperatorButton extends Button {
    String s2;

public createOperatorButton(String s2, int[] obc2, OperatorButtonHandler obh, Frame f){
        super(s2);
        this.s2=s2;
        setBounds(obc2[0], obc2[1], 35, 28);
        setFont(new Font("TimesRoman", Font.PLAIN, 14));
        setForeground(Color.blue);
        addActionListener(obh);
        f.add(this);
        }
}
