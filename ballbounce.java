import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
class ballbounce extends JPanel implements ActionListener, KeyListener
{
    int count=0;
    Timer t = new Timer(10,this);
    double x=200,y=430,velx=0,vely=0;
    private int val=0;
    Timer timer = new Timer(100,new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            val++;
        }
    }
    );
    public ballbounce()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);        
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.RED);
        g2.fill(new Rectangle2D.Double(0,0,600,600));
        g2.setPaint(Color.WHITE);
        g2.fill(new Rectangle2D.Double(50,50,500,500));
        Ellipse2D ball = new Ellipse2D.Double(x,y,100,100);
        g2.setPaint(Color.BLUE);
        g2.fill(ball);
        g2.setPaint(Color.BLACK);
        g2.draw(new Line2D.Double(300,400,300,600));
        g2.draw(new Line2D.Double(302,400,302,600));
        g2.draw(new Line2D.Double(301,400,301,600));
        g2.setPaint(Color.RED);
        Rectangle2D rect = new Rectangle2D.Double(200,200,200,200);
        g2.fill(rect);        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(x<395 && x>105 && y<395 && y>105)
        {
            velx*=-1;
            vely*=-1;
        }        
        else if(x<50 && x>530 && y<50 && y>530)
        {
            velx*=-1;
            vely*=-1;
        }
        if(x == 300 && (y>=380&&y<=600) && count == 0)
        {
            timer.start();
            count++;
        }
        else if(x == 300 && (y>=380&&y<=600) && count==1)
        {
            timer.stop();
            velx=0;
            vely=0;
            x=200;
            y=430;
            int milliseconds = Integer.valueOf(val) %10;
            int seconds = Integer.valueOf(val) /10;
            JOptionPane.showMessageDialog(null,seconds + "." + milliseconds + " seconds");

            val = 0;
            count=0;
        }
        repaint();
        x+=velx;
        y+=vely;
    }

    public void up()
    {
        vely=-2;
        velx= 0;
    }

    public void down()
    {
        vely= 2;
        velx= 0;
    }

    public void left()
    {
        vely= 0;
        velx=-2;
    }

    public void right()
    {
        vely= 0;
        velx= 2;
    }

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_UP)
        {
            up();
        }
        else if(code==KeyEvent.VK_DOWN)
        {
            down();
        }
        else if(code==KeyEvent.VK_LEFT)
        {
            left();
        }
        else if(code==KeyEvent.VK_RIGHT)
        {
            right();
        }
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }
}