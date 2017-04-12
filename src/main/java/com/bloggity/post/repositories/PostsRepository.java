package com.bloggity.post.repositories;


import com.bloggity.post.beans.Post;

import java.util.List;
import java.util.UUID;

public interface PostsRepository {

  Post createPost(Post post);

  Post updatePost(Post post);

  void deletePost(UUID postId);

  List<Post> findAll();

  Post getPostById(UUID postId);


}
