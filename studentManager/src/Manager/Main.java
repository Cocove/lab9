package Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    

    public static void main(String[] args) throws IOException {
        StuManger stuManger = new StuManger();

        while(true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.查看学生");
            System.out.println("4.修改学生");
            System.out.println("5.退出系统");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //java.io.InputStreamReader继承了Reader类

            String num = br.readLine();

            int i = Integer.valueOf(num).intValue();

            switch (i) {
                case 1: {
                    System.out.println("您选择了添加学生");
                    stuManger.addStudent();
                    break;
                }
                case 2: {
                    System.out.println("您选择了删除学生");
                    String num1 = br.readLine();
                    stuManger.deletStudent(num1);
                    break;
                }
                case 3: {
                    System.out.println("您选择了查看学生");
                    stuManger.printAllStudent();
                    break;
                }
                case 4: {
                    System.out.println("您选择了修改学生");
                    String num1 = br.readLine();
                    stuManger.changeStudent(num1);
                    break;
                }

                case 5: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("您选择了错误选项");
                }
            }
        }
    }
}
