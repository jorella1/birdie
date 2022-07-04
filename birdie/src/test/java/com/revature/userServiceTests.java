package com.revature;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.repository.userLoginDao;
import com.revature.repository.entities.userLoginEntity;
import com.revature.repository.entities.userRegisterEntity;
import com.revature.service.UserNotFoundException;

public class userServiceTests {
    
    private UserService userService;

    @Mock
    private userLoginDao mockUserLoginDao;

    private userLoginEntity dummyUserEntity1;
    private userLoginEntity dummyUserEntity2;
    private userLoginEntity nullUser;

    private User dummyUser1;
    private User dummyUser2;

    private userLoginEntity userTestEntity1;
    private userLoginEntity userTestEntity2;

    private userRegisterEntity userRegEntity1;

    @BeforeClass
   public void setup(){
       MockitoAnnotations.openMocks(this);
       this.userService = new UserService();
       userService.setLoginDao(mockUserLoginDao);

       dummyUser1 = new User(1, "fakeuserone", "Pa$sword123", "user");
       dummyUser2 = new User(4, "fakeuser4", "Fak4password!", "user");

       dummyUserEntity1 = new userLoginEntity(1, "fakeuserone", "Pa$sword123", "user");
       dummyUserEntity2 = new userLoginEntity(4, "fakeuser4", "Fak4password!", "user");

       userRegEntity1 = new userRegisterEntity(1, 1, "testname", "testlastname", "user@twitter.com", "123 fake street", 1234567890);

       when(mockUserLoginDao.select(dummyUser1.getId())).thenReturn(dummyUserEntity1);
       when(mockUserLoginDao.select(dummyUserEntity2.getId())).thenReturn(dummyUserEntity2);
        
       when(mockUserLoginDao.selectAll()).thenReturn(Arrays.asList(dummyUserEntity1, dummyUserEntity2));
   }
   //USER TESTS
   @Test
   public void testUserObject(){
     userTestEntity1 = new userLoginEntity("username", "password", "user");
     userTestEntity2 = new userLoginEntity(2,"username", "password", "user");

    Assert.assertEquals(dummyUserEntity1.toString(), "Userid: 1 Username: fakeuserone Password: Pa$sword123");
    Assert.assertEquals(userTestEntity2.getId(), 2);
    Assert.assertEquals(userTestEntity2.getuserName(), "username");
    Assert.assertEquals(userTestEntity2.getPassword(), "password");
    Assert.assertEquals(userTestEntity2.getRole(), "user");

    userTestEntity2.setId(5);
    userTestEntity2.setuserName("newusername");
    userTestEntity2.setPassword("password444");
    userTestEntity2.setRole("admin");

    Assert.assertEquals(userTestEntity2.getId(), 5);
    Assert.assertEquals(userTestEntity2.getuserName(), "newusername");
    Assert.assertEquals(userTestEntity2.getPassword(), "password444");
    Assert.assertEquals(userTestEntity2.getRole(), "admin");

   }
   //Register Entity tests for sake of completion
   @Test
   public void testRegisterEntityObject() {
    Assert.assertEquals(userRegEntity1.getInfoid(), 1);
    Assert.assertEquals(userRegEntity1.getUserid(), 1);
    Assert.assertEquals(userRegEntity1.getFirst_name(), "testname");
    Assert.assertEquals(userRegEntity1.getLast_name(), "testlastname");
    Assert.assertEquals(userRegEntity1.getEmail(), "user@twitter.com");
    Assert.assertEquals(userRegEntity1.getAddress(), "123 fake street");
    Assert.assertEquals(userRegEntity1.getPhone_number(), 1234567890);

    userRegEntity1.setInfoid(5);
    userRegEntity1.setUserid(5);
    userRegEntity1.setFirst_name("newtestname");
    userRegEntity1.setLast_name("newlastname");
    userRegEntity1.setEmail("fake@birdie.com");
    userRegEntity1.setAddress("321 unfake street");
    userRegEntity1.setPhone_number(1087654321);

    Assert.assertEquals(userRegEntity1.getInfoid(), 5);
    Assert.assertEquals(userRegEntity1.getUserid(), 5);
    Assert.assertEquals(userRegEntity1.getFirst_name(), "newtestname");
    Assert.assertEquals(userRegEntity1.getLast_name(), "newlastname");
    Assert.assertEquals(userRegEntity1.getEmail(), "fake@birdie.com");
    Assert.assertEquals(userRegEntity1.getAddress(), "321 unfake street");
    Assert.assertEquals(userRegEntity1.getPhone_number(), 1087654321);

    

   }


    @Test
    public void testGetUser() throws UserNotFoundException {
        Assert.assertEquals(userService.getUser(dummyUser1.getId()), dummyUser1);
    }

    @Test
    public void testGetUserNotFound() {
        Assert.assertThrows(UserNotFoundException.class, () -> userService.getUser(-1));
    }

    @Test
    public void testDeleteUserNotFound() throws UserNotFoundException {
        //Assert.assertThrows(UserNotFoundException.class, () -> userService.deleteUser(-1));
    }

    @Test
    public void testGetAllUsers() throws UserNotFoundException {
        Assert.assertEquals(userService.getAllUsers(), Arrays.asList(dummyUser1, dummyUser2));
    }


}
