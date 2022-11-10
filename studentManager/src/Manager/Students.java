package Manager;

public class Students {
    //学号
    String StuNumber;
    //姓名
    String Name;
    //年龄
    int age;
    //居住地
    String StuAddress;

    public String getStuNumber() {
        return StuNumber;
    }

    public void setStuNumber(String stuNumber) {
        StuNumber = stuNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuAddress() {
        return StuAddress;
    }

    public void setStuAddress(String stuAddress) {
        StuAddress = stuAddress;
    }
}
