package com.hodachop93.hohoda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Wallet implements Parcelable {
    @SerializedName("wallet_id")
    private String walletID;
    @SerializedName("token_id")
    private String tokenID;

    protected Wallet(Parcel in) {
        walletID = in.readString();
        tokenID = in.readString();
    }

    public static final Creator<Wallet> CREATOR = new Creator<Wallet>() {
        @Override
        public Wallet createFromParcel(Parcel in) {
            return new Wallet(in);
        }

        @Override
        public Wallet[] newArray(int size) {
            return new Wallet[size];
        }
    };

    public String getWalletID() {
        return walletID;
    }

    public String getTokenId() {
        return tokenID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(walletID);
        dest.writeString(tokenID);
    }
}
