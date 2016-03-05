package com.hodachop93.hohoda.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Proposal implements Parcelable {

    public static final Creator<Proposal> CREATOR = new Creator<Proposal>() {
        @Override
        public Proposal createFromParcel(Parcel in) {
            return new Proposal(in);
        }

        @Override
        public Proposal[] newArray(int size) {
            return new Proposal[size];
        }
    };
    private String id;
    private String description;
    @SerializedName("create_at")
    private long createdAt;
    @SerializedName("update_at")
    private long updateAt;
    @SerializedName("posted_at")
    private Profile user;

    protected Proposal(Parcel in) {
        id = in.readString();
        description = in.readString();
        createdAt = in.readLong();
        updateAt = in.readLong();
        user = in.readParcelable(Profile.class.getClassLoader());
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public Profile getUser() {
        return user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
        dest.writeLong(createdAt);
        dest.writeLong(updateAt);
        dest.writeParcelable(user, flags);
    }
}
