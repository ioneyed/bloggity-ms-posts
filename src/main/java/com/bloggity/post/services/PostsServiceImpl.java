package com.bloggity.post.services;

import com.bloggity.post.beans.Post;
import com.bloggity.post.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostsServiceImpl implements PostsService {

  @Autowired
  private PostsRepository postRepository;

  @Override
  public Post createPost(Post post) {
    return postRepository.createPost(post);
  }

  @Override
  public Post updatePost(Post post) {
    return postRepository.updatePost(post);
  }

  @Override
  public boolean deletePost(UUID postId) {
    try {
      postRepository.deletePost(postId);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public List<Post> findAll() {
    return null;
  }

  @Override
  public Post getPostById(UUID postId) {
    return null;
  }

}
