package com.gr03.amos.bikerapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserRegistrationValidationTest {

    @Test
    public void testEmailValidation(){
        String mail1 = "test@mail.com";
        String mail2 = "test.test@mail.de";
        String mail3 = "test@mail";
        String mail4 = "test";
        String mail5 = "@gmail.de";
        String mail6 = "test@.de";

        Assert.assertTrue(SignUpActivity.isValidEmail(mail1));
        Assert.assertTrue(SignUpActivity.isValidEmail(mail2));
        Assert.assertFalse(SignUpActivity.isValidEmail(mail3));
        Assert.assertFalse(SignUpActivity.isValidEmail(mail4));
        Assert.assertFalse(SignUpActivity.isValidEmail(mail5));
        Assert.assertFalse(SignUpActivity.isValidEmail(mail6));
    }
}
