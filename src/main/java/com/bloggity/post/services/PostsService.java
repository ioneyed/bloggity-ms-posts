package com.bloggity.post.services;

import com.bloggity.post.beans.Post;

import java.util.List;
import java.util.UUID;

public interface PostsService {

  Post createPost(Post post);

  Post updatePost(Post post);

  boolean deletePost(UUID postId);

  List<Post> findAll();

  Post getPostById(UUID postId);

}
