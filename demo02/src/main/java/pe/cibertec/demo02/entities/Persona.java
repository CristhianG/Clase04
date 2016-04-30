package pe.cibertec.demo02.entities;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class Persona {
    private int id;
    private String name;
    private String last;
    private String phone;
    private String doc;
    private int age;

    public Persona(int id, String name, String last, String phone, String doc, int age) {
        this.id = id;
        this.name = name;
        this.last = last;
        this.phone = phone;
        this.doc = doc;
        this.age = age;
    }

    public Persona() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
