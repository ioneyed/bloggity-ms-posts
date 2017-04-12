package com.bloggity.post.repositories;

import com.bloggity.post.beans.Post;
import com.bloggity.post.configs.CassandraConfig;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PostsRepositoryImpl implements PostsRepository {

  @Autowired
  public CassandraTemplate cassandraTemplate;

  @Override
  public Post createPost(Post post) {
    return cassandraTemplate.insert(post);
  }

  @Override
  public Post updatePost(Post post) {
    return cassandraTemplate.update(post);
  }

  @Override
  public void deletePost(UUID postId) {
    cassandraTemplate.deleteById(Post.class, postId);
  }

  @Override
  public List<Post> findAll() {
    return cassandraTemplate.selectAll(Post.class);
  }

  @Override
  public Post getPostById(UUID postId) {
    return cassandraTemplate.selectOneById(Post.class,postId);
  }

}
