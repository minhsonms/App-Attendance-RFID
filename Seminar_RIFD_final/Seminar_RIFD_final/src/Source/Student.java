/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author mthuan
 */
public class Student {
    String id;
    String EPC;
    String name;
    String birthday;
    Boolean sex;
    String classes;
    String in="";
    String out="";

    public Student(String id, String EPC, String name, String birthday, Boolean sex, String classes) {
        this.id = id;
        this.EPC = EPC;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.classes = classes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEPC() {
        return EPC;
    }

    public void setEPC(String EPC) {
        this.EPC = EPC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", EPC=" + EPC + ", name=" + name + ", birthday=" + birthday + ", sex=" + sex + ", classes=" + classes + ", in=" + in + ", out=" + out + '}';
    }
    
    

   
}
