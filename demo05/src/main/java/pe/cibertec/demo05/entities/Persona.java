package pe.cibertec.demo05.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class Persona implements Parcelable {
    private int id;
    private String name;
    private String last;
    private String phone;
    private String doc;
    private int age;

//    public Persona(int id, String name, String last, String phone, String doc, int age) {
//        this.id = id;
//        this.name = name;
//        this.last = last;
//        this.phone = phone;
//        this.doc = doc;
//        this.age = age;
//    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.last);
        dest.writeString(this.phone);
        dest.writeString(this.doc);
        dest.writeInt(this.age);
    }

    protected Persona(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.last = in.readString();
        this.phone = in.readString();
        this.doc = in.readString();
        this.age = in.readInt();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel source) {
            return new Persona(source);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
