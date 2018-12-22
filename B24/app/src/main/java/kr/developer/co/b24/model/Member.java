package kr.developer.co.b24.model;

import android.support.annotation.NonNull;

public class Member {
    int age;
    boolean gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Member() {
    }

    public Member(int age, boolean gender) {
        this.age = age;
        this.gender = gender;
    }

    @NonNull
    @Override
    public String toString() {
        return age + (gender ? "남":"여");
    }
}
