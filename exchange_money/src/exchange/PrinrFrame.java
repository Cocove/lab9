package exchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrinrFrame extends JFrame implements ActionListener{
    private final int my_width = 600;
    private final int my_height = 400;

    private JButton b1;
    private JButton b2;


    PrinrFrame(){
        this.setTitle("打印凭条");
        this.setSize(my_width,my_height);
        this.setLocationRelativeTo(null);

        setLayout(new FlowLayout());
        b1 = new JButton("打印凭条");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(b1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
