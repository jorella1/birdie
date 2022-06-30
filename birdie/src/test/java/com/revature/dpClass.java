package com.revature;

import org.testng.annotations.DataProvider;

public class dpClass {
    @DataProvider(name= "test-username-correct")
    public Object[][] usernameCorrectProvider(){
        return new Object[][] {
            {"abc12"},{"smith"},{"jimmothy999"},{"twitter9000"}
        };
    }
    @DataProvider(name= "test-username-incorrect")
    public Object[][] usernameincorrectProvider(){
        return new Object[][] {
            {"-09-09../.,"},{"1234567890123456"},{"++++++++"},{"apple#"},
            {"1"},{"a"},{"ab"}
        };
    }
    @DataProvider(name= "test-password-correct")
    public Object[][] passwordCorrectProvider(){
        return new Object[][] {
            {"Password123!"},{"passW0rd?"},{"iama%passworD3"},{"1nsecure$Maybe"}
        };
    }
    @DataProvider(name= "test-password-incorrect")
    public Object[][] passwordIncorrectProvider(){
        return new Object[][] {
            {"pa,ssword12#3"},{"password---"},{"iamapas,,sword"},{"i"},
            {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"},{"[][]]"},{"11"},{"i"}
        };
    }
    @DataProvider(name= "test-firstname-correct")
    public Object[][] firstnameCorrectProvider(){
        return new Object[][] {
            {"bob"},{"sophia"},{"modesto"},{"omar"},
            {"john"},{"joe"},{"bbbbbbbb"},{"abcdfghjertlasdmgndk"}
        };
    }
    @DataProvider(name= "test-firstname-incorrect")
    public Object[][] firstnameIncorrectProvider(){
        return new Object[][] {
            {"a"},{"ba"},{"1"},{"123"},
            {"(((((((john)))))))"},{"{john}"},{"abcnbmdlskdopaodasldk"},{"emda/llaskd"}
        };
    }
    @DataProvider(name= "test-lastname-correct")
    public Object[][] lastNameCorrectProvider(){
        return new Object[][] {
            {"bob"},{"sophia"},{"modesto"},{"omar"},
            {"john"},{"joe"},{"bbbbbbbb"},{"emdallaskd"}
        };
    }
    @DataProvider(name= "test-lastname-incorrect")
    public Object[][] lastNameIncorrectProvider(){
        return new Object[][] {
            {"a"},{"b"},{"1"},{"123"},
            {"(((((((john)))))))"},{"{john}"},{"lasdjkfhadskljfhalskjfhlakdf"},{"emda/llaskd"}
        };
    }
    //TODO do we need validation here?
    @DataProvider(name= "test-address-correct")
    public Object[][] addressCorrectProvider(){
        return new Object[][] {
            
        };
    }

    @DataProvider(name= "test-email-correct")
    public Object[][] emailCorrectProvider(){
        return new Object[][] {
            {"tim@apple.com"}, {"twitter@twitter.com"}
        };
    }
    @DataProvider(name= "test-email-incorrect")
    public Object[][] emailIncorrectProvider(){
        return new Object[][] {
            {"timapple.com"}, {"@twitter.com"},{"tim@apple..com"}, {"_@twitter.com"},
            {"123"}, {"a"},{".com"}, {"_@twittecom"}
        };
    }
    @DataProvider(name= "test-phone-correct")
    public Object[][] phoneCorrectProvider(){
        return new Object[][] {
            {"2021112222"},{"5555555555"},{"1234567890"},{"0123456789"}
        };
    }
    @DataProvider(name= "test-phone-incorrect")
    public Object[][] phoneIncorrectProvider(){
        return new Object[][] {
            {"20211122221"},{"555555555"},{"2345678"},{"0123456789111"},
            {"2"},{"55"},{"abc"},{"-----"}
        };
    }
    @DataProvider(name= "test-postlength-correct")
    public Object[][] postLengthCorrectProvider(){
        String a = "a";
        return new Object[][] {
            {"This is a great tweet"},{"This is a better tweet"},{new String(new char[280]).replace("\0", a)}
        };
    }
    @DataProvider(name= "test-postlength-incorrect")
    public Object[][] postLengthIncorrectProvider(){
        String a = "a";
        return new Object[][] {
            {new String(new char[281]).replace("\0", a)}
        };
    }
}
