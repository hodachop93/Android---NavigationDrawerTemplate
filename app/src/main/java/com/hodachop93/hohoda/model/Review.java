package com.hodachop93.hohoda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Review implements Parcelable {

    private String id;
    private int rate;
    private String comment;
    @SerializedName("from_job")
    private Job fromJob;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("update_at")
    private long updateAt;
    private Profile reviewer;

    protected Review(Parcel in) {
        id = in.readString();
        rate = in.readInt();
        comment = in.readString();
        fromJob = in.readParcelable(Job.class.getClassLoader());
        createdAt = in.readLong();
        updateAt = in.readLong();
        reviewer = in.readParcelable(Profile.class.getClassLoader());
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public Profile getReviewer() {
        return reviewer;
    }

    public void setReviewer(Profile reviewer) {
        this.reviewer = reviewer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(rate);
        dest.writeString(comment);
        dest.writeParcelable(fromJob, flags);
        dest.writeLong(createdAt);
        dest.writeLong(updateAt);
        dest.writeParcelable(reviewer, flags);
    }

    public Job getFromJob() {
        return fromJob;
    }

    public void setFromJob(Job fromJob) {
        this.fromJob = fromJob;
    }
}
