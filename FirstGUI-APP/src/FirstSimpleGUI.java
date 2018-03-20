import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstSimpleGUI{
    JFrame frame;
    JButton button;
    JButton label;
    JButton color;

    int x = 30;
    int y = 30;
    int count = 0;

    public static void main( String[] args ) {
        FirstSimpleGUI gui = new FirstSimpleGUI();
        gui.display();
    }

    public void display() {
        try {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            button = new JButton("Click button!");
            label = new JButton("Cliack label!");
            button.addActionListener(new ActionButtonListener());
            label.addActionListener(new ActionLabelListener());
            color = new JButton("Click to change color!");
            color.addActionListener(new ActionColorListener());

            MyPanel panel = new MyPanel();

            frame.getContentPane().add(BorderLayout.SOUTH, button);
            frame.getContentPane().add(BorderLayout.EAST, label);
            frame.getContentPane().add(BorderLayout.NORTH, color);
            frame.getContentPane().add(BorderLayout.CENTER, panel);

            frame.setSize(1000, 700);
            frame.setVisible(true);

            while (true) {
                panel.repaint();
                try {
                    Thread.sleep(500);
                } catch (Exception e) { e.printStackTrace(); }
                count ++;
                x += 45;
                y += 45;
                if ( count >= 10 ) break;
            }

        } catch (Exception e) { e.printStackTrace(); }
    }

    class ActionButtonListener implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            button.setText("Button has been clicked!");
        }
    }

    class ActionLabelListener implements ActionListener {
        public void actionPerformed( ActionEvent event) {
            label.setText("Label has been clicked1");
        }
    }

    class ActionColorListener implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            frame.repaint();
        }
    }

    class MyPanel extends JPanel {
        /*
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor( Color.white );
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            int red = (int) (Math.random()*256);
            int green = (int) (Math.random()*256);
            int blue = (int) ( Math.random()*256);
            int width = (int) (Math.random()*100);
            int height = (int) (Math.random()*100);
            g2d.setColor( new Color(red, green, blue));
            g2d.fillRect(x, y, width, height);
        }
        */

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor( Color.white );
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            Image image = new ImageIcon("G:\\AndroidWorkspace\\HelloJava\\src\\test.jpg").getImage();
            g2d.drawImage( image, 0, 0, 100,100,this);
        }

    }
}
