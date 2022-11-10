package Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StuManger {

    private ArrayList<Students> students = new ArrayList<Students>();

    static Students xiaoming;



    void addStudent() throws IOException {
        Students student = new Students();
        System.out.println("请输入学生姓名：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //java.io.InputStreamReader继承了Reader类
        String name = br.readLine();
        student.setName(name);
        System.out.println("请输入学生学号：");
        String stunum = br.readLine();
        student.setStuNumber(stunum);
        System.out.println("请输入学生年龄：");
        String agestring = br.readLine();
        int age = Integer.valueOf(agestring).intValue();
        student.setAge(age);
        System.out.println("请输入学生地址：");
        String address = br.readLine();
        student.setStuAddress(address);

        this.students.add(student);


        this.printAllStudent();
    }

    void deletStudent(String num){
        for(int i = 0;i<students.size();i++){
            if(students.get(i).StuNumber.equals(num)){
                students.remove(i);
            }
        }
    }

    void changeStudent(String num) throws IOException {
        for(int i = 0;i<students.size();i++){
            if(students.get(i).StuNumber.equals(num)){
                Students student = new Students();
                System.out.println("请输入学生姓名：");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //java.io.InputStreamReader继承了Reader类
                String name = br.readLine();
                student.setName(name);
                System.out.println("请输入学生学号：");
                String stunum = br.readLine();
                student.setStuNumber(stunum);
                System.out.println("请输入学生年龄：");
                String agestring = br.readLine();
                int age = Integer.valueOf(agestring).intValue();
                student.setAge(age);
                System.out.println("请输入学生地址：");
                String address = br.readLine();
                student.setStuAddress(address);

                students.set(i,student);
            }
        }
    }

    void printAllStudent(){
        if(students.size() == 0){
            System.out.println("暂时没有学生");
        }
        for(int i = 0;i<students.size();i++){
            System.out.println(students.get(i).getName() + ";" + students.get(i).getStuNumber() + ";" + students.get(i).getAge() + ";" + students.get(i).getStuAddress());
        }
    }


}
