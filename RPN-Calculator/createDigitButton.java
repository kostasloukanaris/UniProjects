import java.awt.*;
public class createDigitButton extends Button {
    String s;
    public createDigitButton(String s, int[] dbc2, DigitButtonHandler dbh, Frame f) {
        super(s);
        this.s=s;
        setBounds(dbc2[0], dbc2[1], 35, 28);
        setFont(new Font("TimesRoman", Font.BOLD, 14));
        setForeground(Color.black);
        addActionListener(dbh);
        f.add(this);
    }
}