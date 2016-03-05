package com.hodachop93.hohoda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;

import java.util.List;

public class Job implements ClusterItem, Parcelable {
    private static double LAT_LNG_ERR = 0;
    public static final String JOB_PENDING = "PENDING";
    public static final String JOB_OPENED = "OPENED";
    public static final String JOB_CLOSED = "CLOSED";

    private String id;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("assigner_id")
    private String assignerId;
    private String price;
    private String title;
    private String description;
    @SerializedName("available_time")
    private String availableTime;
    @SerializedName("start_date")
    private long startDate;
    private String duration;
    private double lat = LAT_LNG_ERR;
    private double lng = LAT_LNG_ERR;
    private String address;
    private String city;
    private String country;
    @SerializedName("bid_count")
    private int bidCount;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("updated_at")
    private long updatedAt;
    private int status;
    private List<HashTag> hashtags;
    @SerializedName("proposal")
    private List<Proposal> proposals;


    public Job() {

    }

    protected Job(Parcel in) {
        id = in.readString();
        ownerId = in.readString();
        assignerId = in.readString();
        price = in.readString();
        title = in.readString();
        description = in.readString();
        availableTime = in.readString();
        startDate = in.readLong();
        duration = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
        address = in.readString();
        city = in.readString();
        country = in.readString();
        bidCount = in.readInt();
        createdAt = in.readLong();
        updatedAt = in.readLong();
        status = in.readInt();
        hashtags = in.createTypedArrayList(HashTag.CREATOR);
        proposals = in.createTypedArrayList(Proposal.CREATOR);
    }

    public static final Creator<Job> CREATOR = new Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    @Override
    public LatLng getPosition() {
        if (lat != LAT_LNG_ERR && lng != LAT_LNG_ERR) {
            return new LatLng(lat, lng);
        } else {
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<HashTag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<HashTag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getAssignerId() {
        return assignerId;
    }

    public void setAssignerId(String assignerId) {
        this.assignerId = assignerId;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        String result;
        switch (status) {
            case 0:
                //pending
                result = JOB_PENDING;
                break;
            case 1:
                //opened
                result = JOB_OPENED;
                break;
            case 2:
                //closed
                result = JOB_CLOSED;
                break;
            default:
                result = null;
        }
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    public int getBidCount() {
        return this.bidCount;
    }

    public void setBidCount(int bidCount) {
        this.bidCount = bidCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(ownerId);
        dest.writeString(assignerId);
        dest.writeString(price);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(availableTime);
        dest.writeLong(startDate);
        dest.writeString(duration);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(country);
        dest.writeInt(bidCount);
        dest.writeLong(createdAt);
        dest.writeLong(updatedAt);
        dest.writeInt(status);
        dest.writeTypedList(hashtags);
        dest.writeTypedList(proposals);
    }
}
