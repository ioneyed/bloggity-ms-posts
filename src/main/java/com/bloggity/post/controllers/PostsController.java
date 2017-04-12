package com.bloggity.post.controllers;


import com.bloggity.post.beans.Post;
import com.bloggity.post.services.PostsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/posts")
public class PostsController {

  static private Logger logger = LoggerFactory.getLogger(PostsController.class);

  @Autowired
  public PostsService postsService;

  @RequestMapping(method = GET)
  public List<Post> queryPosts(){
    return postsService.findAll();
  }

  @RequestMapping(method = POST)
  public Post createPost(@RequestBody Post post){
    return postsService.createPost(post);
  }

  @RequestMapping(method = PUT)
  public Post updatePost(@RequestBody Post post) {
    return postsService.updatePost(post);
  }

  // TODO determine status for delete return false

  @RequestMapping(path = "/{postId}", method = DELETE)
  public ResponseEntity<?> deletePost(@PathVariable("postId") UUID postId) {
//    try {
//      postsService.deletePost(postId);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
//    }
//    return ResponseEntity.ok().build();

    if(postsService.deletePost(postId)){
      return ResponseEntity.ok().build();
    }else {
      return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
  }

  @RequestMapping(path = "/{postId}", method = GET)
  public Post getPostById(@PathVariable("postId") UUID postId){
    return postsService.getPostById(postId);
  }
}
