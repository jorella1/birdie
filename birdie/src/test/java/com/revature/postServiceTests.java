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
    @Mock
    private postDao mockPostDao;
    private userLoginEntity dummyUserEntity1;
    private userLoginEntity dummyUserEntity2;
    private userLoginEntity nullUser;

    private postEntity dummyPostEntity1;
    private postEntity dummyPostEntity2;
    private postEntity nullPost;
    private postEntity dummyReplyEntity1;
    private postEntity dummyReplyEntity2;
    //leaving for additional testing later
    private User dummyUser1;
    private User dummyUser2;

    private Post dummyPost1;
    private Post dummyPost2;
    private Post dummyReplyPost1;
    private Post dummyReplyPost2;
    private String updateText;
    @BeforeClass
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.postService = new PostService();
        postService.setPostDao(mockPostDao);

        //Users
        dummyUser1 = new User(1, "dummyUser1", "Pa$sword123", "user");
        dummyUser2 = new User(2, "dummyUser2", "Fak4password!", "user");
        //Posts
        dummyPost1 = new Post(1, "this is the post", 1, "dummyUser1");
        dummyPost2 = new Post(2, "this is the second post", 5, "dummyUser2");
        //Post Entities
        dummyPostEntity1 = new postEntity(1, 1, "this is the post", 1, false, 0, "dummyUser1");
        dummyPostEntity2 = new postEntity(2, 2, "this is the second post", 1, false, 0 , "dummyUser2");
        //Reply entity posts
        dummyReplyEntity1 = new postEntity(1, 2, "this is the first reply", 1, false, 0, "dummyUser2");
        dummyReplyEntity2 = new postEntity(2, 1, "this is the second reply", 1, false, 1, "dummyUser1");
        //reply posts
        dummyReplyPost1 = new Post(1, "this is the first reply", 1, "dummyUser2");
        dummyReplyPost2 = new Post(2, "this is the second reply", 1, "dummyUser1");

        updateText = "this is updated text";

        //SINGLE SELECT
        when(mockPostDao.select(dummyPost1.getId())).thenReturn(dummyPostEntity1);
        when(mockPostDao.select(dummyPost2.getId())).thenReturn(dummyPostEntity2);
        //SELECT ALL
        when(mockPostDao.selectAll()).thenReturn(Arrays.asList(dummyPostEntity1, dummyPostEntity2));
        when(mockPostDao.selectReplies(dummyPost1.getId())).thenReturn(Arrays.asList(dummyReplyEntity1, dummyReplyEntity2));
        when(mockPostDao.selectAllFlagged()).thenReturn(Arrays.asList(dummyPostEntity1, dummyPostEntity2));

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
        Assert.assertThrows(PostNotFoundException.class, () -> postService.getPost(-1));
    }
    @Test
    public void testDeletePostNotFound() throws PostNotFoundException{
        Assert.assertThrows(PostNotFoundException.class, () -> postService.deletePost(-1));
    }
    @Test
    public void testGetAllPosts() throws PostNotFoundException{
        Assert.assertEquals(postService.getAllPosts(), Arrays.asList(dummyPost1, dummyPost2));
    }
    @Test
    public void testEditPostNotFound() throws PostNotFoundException{
        Assert.assertThrows(PostNotFoundException.class, () -> postService.editPost(-1, updateText));
    }
    @Test
    public void testGetReplies() throws PostNotFoundException {
        Assert.assertEquals(postService.getReplies(dummyPost1.getId()), Arrays.asList(dummyReplyPost1, dummyReplyPost2));
    }
    
    @Test
    public void testLikePost() throws PostNotFoundException {

    }
    @Test
    public void testLikePostNotFound() throws PostNotFoundException {
        Assert.assertThrows(PostNotFoundException.class, () -> postService.likePost(-1));
    }
    @Test
    public void testGetFlaggedPosts() throws PostNotFoundException{
        Assert.assertEquals(postService.getFlaggedPosts(), Arrays.asList(dummyPost1, dummyPost2));
    }
}
