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


    @BeforeClass
   public void setup(){
       MockitoAnnotations.openMocks(this);
       this.userService = new UserService();
       userService.setLoginDao(mockUserLoginDao);

       dummyUser1 = new User(1, "fakeuserone", "Pa$sword123", "user");
       dummyUser2 = new User(4, "fakeuser4", "Fak4password!", "user");

       dummyUserEntity1 = new userLoginEntity(1, "fakeuserone", "Pa$sword123", "user");
       dummyUserEntity2 = new userLoginEntity(4, "fakeuser4", "Fak4password!", "user");


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

    /* @Test
    public void testConvertUserModel() throws UserNotFoundException {
        Assert.assertEquals(userService.convertUserModel(dummyUserEntity1), dummyUser1);
    }

    @Test
    public void testConvertUserModelNotNull() throws UserNotFoundException {
        nullUser = null;
        Assert.assertThrows(UserNotFoundException.class, () -> UserService.convertUserModel(nullUser));

    } */
}
