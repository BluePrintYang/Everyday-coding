package socket;

import java.util.Date;

public class Person {
    private String name;
    private Date birthday;
    private String id;
    private String classId;

    @Override
    public String toString() {
        return "socket.Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", id='" + id + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
