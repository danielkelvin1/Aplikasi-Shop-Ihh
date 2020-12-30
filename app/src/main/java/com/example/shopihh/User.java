package com.example.shopihh;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String username;
    public String password;
    public String nama;
    public String jk;
    public String tel;
    public String email;
    public String alamat;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.nama);
        dest.writeString(this.jk);
        dest.writeString(this.tel);
        dest.writeString(this.email);
        dest.writeString(this.alamat);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.username = in.readString();
        this.password = in.readString();
        this.nama = in.readString();
        this.jk = in.readString();
        this.tel = in.readString();
        this.email = in.readString();
        this.alamat = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
