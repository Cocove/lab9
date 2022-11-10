import java.io.*;

public class Main {
    public Main() throws IOException {
    }

    public static String intToString(int value)
    {
        Integer integer = new Integer(value);
        return integer.toString();
    }
    public static BufferedReader bufread;
    //指定文件路径和名称
    private static String path = "D:/abc.txt";
    private static  File filename = new File(path);
    private static String readStr ="";


    public static void main(String[] args) throws IOException {
        FileWriter out = new FileWriter(filename);
        String []number  = new String[999999];
        for (int i = 0;i<999999;i++){
            String n1 = new String();
            if(i<10){
                n1 = "00000"+i;
            } else if (i < 100) {
                n1 = "0000"+i;
            }else if(i < 1000){
                n1 = "000"+i;
            }else if(i<10000){
                n1 = "00"+i;
            } else if (i < 100000) {
                n1 = "0"+i;
            }else{
                n1 =intToString(i);
            }
            number[i] = "130" + n1 + "61";
        }

        for (int i = 0;i<number.length;i++){
            out.write(number[i]+"\r\n");
        }


    }
}
