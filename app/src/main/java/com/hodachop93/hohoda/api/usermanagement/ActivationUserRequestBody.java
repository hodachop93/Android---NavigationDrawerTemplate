package com.hodachop93.hohoda.api.usermanagement;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hop on 08/03/2016.
 */
public class ActivationUserRequestBody {
    @SerializedName("wallet_id")
    private String walletId;
    private String otp;

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
