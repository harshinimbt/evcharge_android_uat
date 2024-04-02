package com.example.evcharge.Storage;

public class Constants {
    public static final String baseUrl ="https://dev-services-app.evcharge.ac/";
    public static String authorization = "2024202420242024";

    public static String appName = "app-ev";
    public static final String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$*]).{8,12}$";
    public static Boolean getPasswordValidate(String password) {
        if (password.trim().contentEquals("") || password.trim().length() < 8
                || password.trim().length() > 12 || !password.trim().matches(passwordPattern)) {
            return false;
        } else {
            return true;
        }
    }
    public static Boolean getMobileNumberValidate(String mobile) {
        if (mobile.trim().contentEquals("") || mobile.trim().length() < 10){
            return false;
        } else{
            return true;
        }
    }
}
