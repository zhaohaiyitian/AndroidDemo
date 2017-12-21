package com.wj.wjnews.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wj on 17-12-16.
 */

public class HomeGridInfo implements Parcelable{
    public int imgId;
    public String name;

    protected HomeGridInfo(Parcel in) {
        imgId = in.readInt();
        name = in.readString();
    }

    public static final Creator<HomeGridInfo> CREATOR = new Creator<HomeGridInfo>() {
        @Override
        public HomeGridInfo createFromParcel(Parcel in) {
            return new HomeGridInfo(in);
        }

        @Override
        public HomeGridInfo[] newArray(int size) {
            return new HomeGridInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgId);
        parcel.writeString(name);
    }
}
