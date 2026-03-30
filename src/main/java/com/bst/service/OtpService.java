package com.bst.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bst.util.OtpGeneration;



@Service
public class OtpService {
	@Autowired
    private EmailOtpService emailService;

    // store email and otp
    private Map<String, String> otpStorage = new HashMap<>();

    // send OTP
    public String sendOtp(String email) {

        String otp = OtpGeneration.getOtp();

        otpStorage.put(email, otp);

        emailService.sendOtpEmail(email, otp);

        return "OTP sent to email";
    }

    // verify OTP
    public String verifyOtp(String email, String enteredOtp) {

        String storedOtp = otpStorage.get(email);

        if (storedOtp == null) {
            return "OTP not found. Please request again";
        }

        if (storedOtp.equals(enteredOtp)) {
            otpStorage.remove(email);
            return "OTP Verified Successfully";
        } else {
            return "Invalid OTP";
        }
    }
}
