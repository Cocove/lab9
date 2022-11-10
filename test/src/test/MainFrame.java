package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class MainFrame extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private JComboBox<String> comboBox;
    private String[] qianArray = {"USD" , "AED" , "AFN" , "ALL" , "AMD" , "ANG" , "AOA" , "ARS" , "AUD" , "AWG" , "AZN" , "BAM" , "BBD" , "BDT" , "BGN" , "BHD" , "BIF" , "BMD" ,
            "BND" , "BOB" , "BRL" , "BSD" , "BTN" , "BWP" , "BYN" , "BZD" , "CAD" , "CDF" , "CHF" , "CLP" , "CNY" , "COP" , "CRC" , "CUP" , "CVE" , "CZK" , "DJF" , "DKK" , "DOP" ,
            "DZD" , "EGP" , "ERN" , "ETB" , "EUR" , "FJD" , "FKP" , "FOK" , "GBP" , "GEL" , "GGP" , "GHS" , "GIP" , "GMD" , "GNF" , "GTQ" , "GYD" , "HKD" , "HNL" , "HRK" , "HTG" ,
            "HUF" , "IDR" , "ILS" , "IMP" , "INR" , "IQD" , "IRR" , "ISK" , "JEP" , "JMD" , "JOD" , "JPY" , "KES" , "KGS" , "KHR" , "KID" , "KMF" , "KRW" , "KWD" , "KYD" , "KZT" ,
            "LAK" , "LBP" , "LKR" , "LRD" , "LSL" , "LYD" , "MAD" , "MDL" , "MGA" , "MKD" , "MMK" , "MNT" , "MOP" , "MRU" , "MUR" , "MVR" , "MWK" , "MXN" , "MYR" , "MZN" , "NAD" ,
            "NGN" , "NIO" , "NOK" , "NPR" , "NZD" , "OMR" , "PAB" , "PEN" , "PGK" , "PHP" , "PKR" , "PLN" , "PYG" , "QAR" , "RON" , "RSD" , "RUB" , "RWF" , "SAR" , "SBD" , "SCR" ,
            "SDG" , "SEK" , "SGD" , "SHP" , "SLL" , "SOS" , "SRD" , "SSP" , "STN" , "SYP" , "SZL" , "THB" , "TJS" , "TMT" , "TND" , "TOP" , "TRY" , "TTD" , "TVD" , "TWD" , "TZS" ,
            "UAH" , "UGX" , "UYU" , "UZS" , "VES" , "VND" , "VUV" , "WST" , "XAF" , "XCD" , "XDR" , "XOF" , "XPF" , "YER" , "ZAR" , "ZMW" , "ZWL"};
    private JComboBox<String> comboBox1;
    private JLabel label;
    private JButton Sumbit;
    private JButton Clear;
    private JButton Jiaohuan;
    private APItest HuiLv;

    private JLabel jl1;
    private JTextField jtf1;


    private JLabel jl2;
    private JTextField jtf2;

    private String xuanzhong1;
    private String xuanzhong2;

    private  double num1;
    private double num2;

    private double huilv;

    //string 转 int
    public  double stringToInt(String intstr)
    {
        Double Adouble;
        Adouble = Double.parseDouble(intstr);
        return Adouble;
    }
    //int 转 String
    public String doubleToString(double value)
    {
        Double aDouble = new Double(value);
        return aDouble.toString();

    }

    public MainFrame() throws IOException {
        super("汇率");
        setSize(WIDTH,HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width-WIDTH)/2,(kit.getScreenSize().height - HEIGHT)/2);

        label = new JLabel("换钱系统：");
        label.setFont(new Font("宋体",Font.PLAIN,14));
        label.setBounds(1,1,100,23);


        Box huanqian = Box.createHorizontalBox();
        huanqian.add(Box.createHorizontalGlue());
        huanqian.add(label);
        huanqian.add(Box.createHorizontalGlue());
        getContentPane().add(huanqian,BorderLayout.NORTH);

        JPanel jPanel = new JPanel(new GridLayout(3, 2,20,10));

        comboBox = new JComboBox<String>();
        for(String item : qianArray){
            comboBox.addItem(item);
        }
        comboBox.setPreferredSize(new Dimension(10,10));
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if(e.getStateChange() == ItemEvent.SELECTED){
                    xuanzhong1 =  (String) comboBox.getSelectedItem();
                    APItest.setHuobi1(xuanzhong1);

                }
            }
        });

        comboBox1 = new JComboBox<String>();
        for(String item : qianArray){
            comboBox1.addItem(item);
        }
        comboBox1.setPreferredSize(new Dimension(10,10));
        comboBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e1) {

                if(e1.getStateChange() == ItemEvent.SELECTED){
                    xuanzhong2 =  (String) comboBox1.getSelectedItem();
                    APItest.setHuobi2(xuanzhong2);
                }
            }
        });
        jPanel.add(comboBox);
        jPanel.add(comboBox1);

        jl1 = new JLabel("输入您想换的金额:");
        jl1.setFont(new Font("宋体",Font.PLAIN,14));
        jl1.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf1 = new JTextField(10);
        jtf1.setText("0");
        jPanel.add(jl1);
        jPanel.add(jtf1);

        jl2 = new JLabel("您换到的金额:");
        jl2.setFont(new Font("宋体",Font.PLAIN,14));
        jl2.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf2 = new JTextField(10);
        jtf2.setText("0");
        jPanel.add(jl2);
        jPanel.add(jtf2);


        Box qianBox = Box.createHorizontalBox();
        qianBox.add(Box.createHorizontalGlue());
        qianBox.add(jPanel);
        qianBox.add(Box.createHorizontalGlue());


        getContentPane().add(qianBox,BorderLayout.CENTER);

        Sumbit = new JButton("查询");
        Sumbit.setFont(new Font("宋体",Font.PLAIN,14));
        Sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String str = jtf1.getText();
                    try {
                        huilv = stringToInt(APItest.getHuilv());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    num1 = stringToInt(str);
                    num2 = huilv * num1;
                    String str2 = doubleToString(num2);
                    jtf2.setText(str2);
            }
        });

        Clear = new JButton("清除");
        Clear.setFont(new Font("宋体",Font.PLAIN,14));
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox.setSelectedIndex(0);
                comboBox1.setSelectedIndex(0);
                jtf1.setText("0");
                jtf2.setText("0");
            }
        });
        Jiaohuan = new JButton("交换");
        Jiaohuan.setFont(new Font("宋体",Font.PLAIN,14));
        Jiaohuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1 =  comboBox.getSelectedIndex();
                int index2 =  comboBox1.getSelectedIndex();
                comboBox.setSelectedIndex(index2);
                comboBox1.setSelectedIndex(index1);
            }
        });


        Box boxDown = Box.createHorizontalBox();
        boxDown.add(Box.createHorizontalGlue());
        boxDown.add(Sumbit);
        boxDown.add(Box.createHorizontalGlue());
        boxDown.add(Jiaohuan);
        boxDown.add(Box.createHorizontalGlue());
        boxDown.add(Clear);
        boxDown.add(Box.createHorizontalGlue());
        getContentPane().add(boxDown,BorderLayout.SOUTH);

    }

    public static void main(String[] args) throws IOException {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
