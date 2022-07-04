package com.revature;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.service.validationService;

public class postValidationTests {
    validationService vs = new validationService();
    public static final int MAX_LENGTH = 250;

    @BeforeSuite
    public void testStart(){
        System.out.println("Starting birdie post validation tests.");
    }

    @Test(dataProvider = "test-postlength-correct", dataProviderClass = dpClass.class)
    public void testCorrectLength(String post){
        Assert.assertTrue(vs.validatePostLength(post));
    }
    @Test(dataProvider = "test-postlength-incorrect", dataProviderClass = dpClass.class)
    public void testIncorrectLength(String post){
        Assert.assertFalse(vs.validatePostLength(post));
    }

/*     @Test
    public void testCorrectComment(){

    }
    @Test
    public void testIncorrectComment(){
        
    } */
}
