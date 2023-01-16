import javax.swing.*;
public class call
{
    public static void main(String[] args)
    {
        ballbounce s = new ballbounce();
        JFrame f = new JFrame();
        f.add(s);
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
