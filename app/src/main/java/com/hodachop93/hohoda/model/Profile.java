package com.hodachop93.hohoda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile implements Parcelable {
    public static final int ACCOUNT_TYPE_NORMAL = 0;
    public static final int ACCOUNT_TYPE_FACEBOOK = 1;

    @SerializedName("wallet_id")
    private String walletID;
    private String name;
    @SerializedName("rate_average")
    private int rateAverage;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String email;
    private String address;
    private String infor;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("is_online")
    private int isOnline;
    @SerializedName("interested_hashtags")
    private List<HashTag> interestedHashtags;
    @SerializedName("account_type")
    private int accountType;

    protected Profile(Parcel in) {
        walletID = in.readString();
        name = in.readString();
        rateAverage = in.readInt();
        avatarUrl = in.readString();
        email = in.readString();
        address = in.readString();
        infor = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        userName = in.readString();
        phoneNumber = in.readString();
        isOnline = in.readInt();
        interestedHashtags = in.createTypedArrayList(HashTag.CREATOR);
        accountType = in.readInt();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRateAverage() {
        return rateAverage;
    }

    public void setRateAverage(int rateAverage) {
        this.rateAverage = rateAverage;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int isOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getInfor() {
        return infor;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        if(accountType == ACCOUNT_TYPE_NORMAL){
            return phoneNumber;
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            phoneNumber = phoneNumber.split("_")[0];

            if (phoneNumber.startsWith("null") || phoneNumber.startsWith("undefined")) {
                return null;
            }
        }

        return phoneNumber;
    }


    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public List<HashTag> getInterestedHashtags() {
        return interestedHashtags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(walletID);
        dest.writeString(name);
        dest.writeInt(rateAverage);
        dest.writeString(avatarUrl);
        dest.writeString(email);
        dest.writeString(address);
        dest.writeString(infor);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(userName);
        dest.writeString(phoneNumber);
        dest.writeInt(isOnline);
        dest.writeTypedList(interestedHashtags);
        dest.writeInt(accountType);
    }

}
