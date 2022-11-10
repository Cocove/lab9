package exchange;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{

    private final int my_width = 600;
    private final int my_height = 400;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private PrinrFrame PF;
    private JLabel JL;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    private JLabel jLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private ImageIcon image;
    MainFrame(){
            this.setTitle("exchange office");
            this.setSize(my_width,my_height);
            this.setLocationRelativeTo(null);

            image = new ImageIcon("src/exchange/icon.png");
            this.setIconImage(image.getImage());

            Color myWhite = new Color(0, 200, 0);
            Container con=this.getContentPane();
            con.setBackground(Color.white);

            Dimension preferredSize = new Dimension(200,50);
            Dimension preferredSize1 = new Dimension(600,100);
            setLayout(new BorderLayout(0,30));
            jPanel1 = new JPanel();

            jPanel1.setBackground(myWhite);
            jPanel1.setPreferredSize(preferredSize1);
            jPanel1.setLayout(new BorderLayout());

            JL = new JLabel("Обменник");
            Font f = new Font("Times New Roman",Font.PLAIN,40);
            JL.setFont(f);
            JL.setHorizontalAlignment(SwingConstants.CENTER);
            jPanel1.add(JL);

            jPanel2 = new JPanel();
            jPanel2.setLayout(new GridLayout(3,1));
            jPanel2.setBackground(Color.white);

            jLabel = new JLabel();
            jLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
            jLabel1 = new JLabel();
            jLabel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            jLabel2 = new JLabel();
            jLabel2.setLayout(new FlowLayout(FlowLayout.CENTER));
            b1 = new JButton("Печать справки");
            b2 = new JButton("Конвертация");
            b3 = new JButton("Авуары");

            b1.setPreferredSize(preferredSize);
            b2.setPreferredSize(preferredSize);
            b3.setPreferredSize(preferredSize);
            jLabel.add(b1);

            jLabel1.add(b2);

            jLabel2.add(b3);


            jPanel2.add(jLabel);
            jPanel2.add(jLabel1);
            jPanel2.add(jLabel2);

            jPanel3 = new JPanel();
            jPanel3.setBackground(Color.white);
            jPanel3.setLayout(new BorderLayout());
            image.setImage(image.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
            jLabel3 = new JLabel(image);
            jLabel3.setSize(50,50);
            jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            jPanel3.add(jLabel3);


            this.add(jPanel1, BorderLayout.NORTH);
            this.add(jPanel2, BorderLayout.CENTER);
            this.add(jPanel3,BorderLayout.EAST);
            b1.addActionListener(this);

    }

    public static void main(String[] args) throws IOException {
        //主窗口
        JFrame MainFrame = new MainFrame();
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1){
            this.dispose();
            PF = new PrinrFrame();
        }
    }
}
