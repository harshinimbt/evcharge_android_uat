package com.example.evcharge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("otp")
    @Expose
    private Integer otp;
    @SerializedName("user")
    @Expose
    private User user;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public class User {

        @SerializedName("user_uid")
        @Expose
        private String userUid;
        @SerializedName("is_mobile_verified")
        @Expose
        private String isMobileVerified;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("is_active")
        @Expose
        private String isActive;
        @SerializedName("is_deleted")
        @Expose
        private String isDeleted;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public String getUserUid() {
            return userUid;
        }

        public void setUserUid(String userUid) {
            this.userUid = userUid;
        }

        public String getIsMobileVerified() {
            return isMobileVerified;
        }

        public void setIsMobileVerified(String isMobileVerified) {
            this.isMobileVerified = isMobileVerified;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
