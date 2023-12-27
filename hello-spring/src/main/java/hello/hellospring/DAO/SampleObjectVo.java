package hello.hellospring.DAO;

public class SampleObjectVo {
    private String name;
    private int age;

    public SampleObjectVo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public SampleObjectVo() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "SampleObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
