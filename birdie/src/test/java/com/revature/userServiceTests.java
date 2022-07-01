package com.revature;

import static org.mockito.Mockito.when;

import java.util.Arrays;

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
    // 
    private UserService userService;

    @Mock
    private userLoginDao mockUserLoginDao;

    private userLoginEntity dummyUserEntity1;
    private userLoginEntity dummyUserEntity2;
    private userLoginEntity nullUser;

    private User dummyUser1;
    private User dummyUser2;

   public void setup(){
       MockitoAnnotations.openMocks(this);
       this.userService = new UserService();
        // TODO add this to logindao
       //UserService.setLoginDao(mockUserLoginDao);

       dummyUser1 = new User(1, "fakeuserone", "Pa$sword123")
       dummyUser2 = new User(4, "fakeuser4", "Fak4password!")

       dummyUserEntity1 = new userLoginEntity(1, "fakeuserone", "Pa$sword123");
       dummyUserEntity2 = new userLoginEntity(2, "fakeusertwo", "Pa$$word123!");


       when(mockUserLoginDao.select(dummyUserEntity1.getId())).thenReturn(dummyUserEntity1);
       when(mockUserLoginDao.select(dummyUserEntity2.getId())).thenReturn(dummyUserEntity2);
        
       when(mockUserLoginDao.selectAll()).thenReturn(Arrays.asList(dummyUserEntity1, dummyUserEntity2));
   }

    @Test
    public void testGetUser() throws UserNotFoundException {
        Assert.assertEquals(userService.getUser(dummyUserEntity1.getId()), 1);
    }

    @Test
    public void testGetUserNotFound() {
        Assert.assertThrows(UserNotFoundException.class, () -> userService.getUser(-1));
    }

    @Test
    public void testDeleteUserNotFound() throws UserNotFoundException {
        Assert.assertThrows(UserNotFoundException.class, () -> userService.deleteUser(-1));
    }

    @Test
    public void testGetAllUsers() throws UserNotFoundException {
        Assert.assertEquals(userService.getAllUsers(), Arrays.asList(dummyUserEntity1, dummyUserEntity2));
    }

    @Test
    public void testConvertUserModel() throws UserNotFoundException {
        Assert.assertEquals(userService.convertUserModel(dummyUserEntity1), dummyUser1);
    }

    @Test
    public void testConvertUserModelNotNull() throws UserNotFoundException {
        nullUser = null;
        Assert.assertThrows(UserNotFoundException.class, () -> UserService.convertUserModel(nullUser));

    }
}
