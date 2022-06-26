package com.revature;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.service.validationService;

public class userValidationTests {
    validationService vs = new validationService();
    @BeforeSuite
    public void testStart(){
        System.out.println("Starting user validation tests.");
    }

    @Test(dataProvider = "test-username-correct", dataProviderClass = dpClass.class)
    public void testCorrectUsername(String username){
        Assert.assertTrue(vs.validateUsername(username));
    }
    @Test(dataProvider = "test-username-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectUsername(String username){
        Assert.assertFalse(vs.validateUsername(username));
    }
    @Test(dataProvider = "test-password-correct", dataProviderClass = dpClass.class)
    public void testCorrectPassword(String password){
        Assert.assertTrue(vs.validatePassword(password));
    }
    @Test(dataProvider = "test-password-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectPassword(String password){
        Assert.assertFalse(vs.validatePassword(password));
    }
    @Test(dataProvider = "test-firstname-correct", dataProviderClass = dpClass.class)
    public void testCorrectFirstname(String firstname){
        Assert.assertTrue(vs.validatePassword(firstname));
    }
    @Test(dataProvider = "test-firstname-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectFirstname(String firstname){
        Assert.assertFalse(vs.validatePassword(firstname));
    }
    @Test(dataProvider = "test-lastname-correct", dataProviderClass = dpClass.class)
    public void testCorrectLastname(String lastname){
        Assert.assertTrue(vs.validatePassword(lastname));
    }
    @Test(dataProvider = "test-lastname-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectLastname(String lastname){
        Assert.assertFalse(vs.validatePassword(lastname));
    }
    @Test(dataProvider = "test-address-correct", dataProviderClass = dpClass.class)
    public void testCorrectAddress(String address){
        Assert.assertTrue(vs.validatePassword(address));
    }
    @Test(dataProvider = "test-address-correct", dataProviderClass = dpClass.class)
    public void testCorrectEmail(String email){
        Assert.assertTrue(vs.validatePassword(email));
    }
    @Test(dataProvider = "test-phone-correct", dataProviderClass = dpClass.class)
    public void testCorrectPhone(String phone){
        Assert.assertTrue(vs.validatePassword(phone));
    }
    @Test(dataProvider = "test-phone-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectPhone(String phone){
        Assert.assertTrue(vs.validatePassword(phone));
    }
    
    
}
