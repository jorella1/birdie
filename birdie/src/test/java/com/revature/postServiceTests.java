package com.revature;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repository.postDao;
import com.revature.repository.userLoginDao;
import com.revature.repository.entities.postEntity;
import com.revature.repository.entities.userLoginEntity;
import com.revature.service.PostNotFoundException;
import com.revature.service.UserNotFoundException;
import com.revature.service.PostService;;

public class postServiceTests {
    private PostService postService;
    @Mock
    private userLoginDao mockUserLoginDao;
    private postDao mockPostDao;
    private userLoginEntity dummyUserEntity1;
    private userLoginEntity dummyUserEntity2;
    private userLoginEntity nullUser;

    private postEntity dummyPostEntity1;
    private postEntity dummyPostEntity2;
    private postEntity nullPost;

    private User dummyUser1;
    private User dummyUser2;

    private Post dummyPost1;
    private Post dummyPost2;
    private String updateText;
    
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.postService = new PostService();
        // TODO add this method to postdao
        //PostService.setPostDao(mockPostDao);
        dummyPost1 = new Post(1, "this is the post", 1);
        dummyPost2 = new Post(2, "this is the second post", 5);

        dummyPostEntity1 = new postEntity(1, 2, "this is the post", 1);
        
        updateText = "this is updated text";

        when(mockPostDao.select(dummyPost1.getId())).thenReturn(dummyPostEntity1);
        when(mockPostDao.select(dummyPost2.getId())).thenReturn(dummyPostEntity2);

        when(mockPostDao.selectAll()).thenReturn(Arrays.asList(dummyPostEntity1, dummyPostEntity2));

        //Should updateText return something for confirmation? or remain void
        //when(mockPostDao.updateText(dummyPost1.getId(), updateText)).thenReturn()

        //same with updateLikes
        //when(mockPostDao.updateLikes(dummyPost1.getId(), 5)).thenReturn();
    }
    @Test
    public void testGetPost() throws PostNotFoundException{
        Assert.assertEquals(postService.getPost(1), dummyPost1);
    }
    @Test
    public void testGetPostNotFound() throws PostNotFoundException{
        Assert.assertThrows(UserNotFoundException.class, () -> postService.getPost(-1));
    }
    @Test
    public void testDeletePostNotFound() throws PostNotFoundException{
        Assert.assertThrows(UserNotFoundException.class, () -> postService.deletePost(-1));
    }
    @Test
    public void testGetAllPosts() throws PostNotFoundException{
        Assert.assertEquals(postService.getAllPosts(), Arrays.asList(dummyPost1, dummyPost2));
    }
    @Test
    public void testEditPost() throws PostNotFoundException{
        
    }
    @Test
    public void testConvertPostModelPost() throws PostNotFoundException{
        Assert.assertEquals(postService.convertPostModel(dummyPostEntity1), dummyPost1);
    }
    


}
