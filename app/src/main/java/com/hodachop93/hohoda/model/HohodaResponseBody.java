package com.hodachop93.hohoda.model;

import com.google.gson.annotations.SerializedName;

public class HohodaResponseBody {

    @SerializedName("wallet_id")
    private String walletID;

    public String getWalletID() {
        return walletID;
    }
}
