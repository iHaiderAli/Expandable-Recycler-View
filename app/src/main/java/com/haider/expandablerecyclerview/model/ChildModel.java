package com.haider.expandablerecyclerview.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class ChildModel implements Parcelable{

    private String name;
    private Drawable userImage;

    public ChildModel(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildModel(String name, Drawable userImage) {
        setName(name);
        setUserImage(userImage);
    }


    public Drawable getUserImage() {
        return userImage;
    }

    public void setUserImage(Drawable userImage) {
        this.userImage = userImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChildModel> CREATOR = new Creator<ChildModel>() {
        @Override
        public ChildModel createFromParcel(Parcel in) {
            return new ChildModel(in);
        }

        @Override
        public ChildModel[] newArray(int size) {
            return new ChildModel[size];
        }
    };
}
