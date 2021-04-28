package com.example.myapplication5;

import android.os.Parcel;
import android.os.Parcelable;

public class Drama implements Parcelable {
    private String sName, sDetail, sImage, sEpisode;

    public Drama (String sName, String sDetail, String sImage, String sEpisode) {
        this.sName = sName;
        this.sDetail = sDetail;
        this.sImage = sImage;
        this.sEpisode = sEpisode;
    }

    public Drama() {
    }

    protected Drama(Parcel in) {
        sName = in.readString();
        sDetail = in.readString();
        sImage = in.readString();
        sEpisode = in.readString();
    }

    public static final Creator<Drama> CREATOR = new Creator<Drama>() {
        @Override
        public Drama createFromParcel(Parcel in) {
            return new Drama(in);
        }

        @Override
        public Drama[] newArray(int size) {
            return new Drama[size];
        }
    };

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDetail() {
        return sDetail;
    }

    public void setsDetail(String sDetail) {
        this.sDetail = sDetail;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsEpisode() { return sEpisode; }

    public void setsEpisode(String sEpisode) {
        this.sEpisode = sEpisode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sName);
        dest.writeString(sDetail);
        dest.writeString(sImage);
        dest.writeString(sEpisode);

    }
}
