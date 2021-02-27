package com.example.blog.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.blog.model.Post;

public interface PostDaoApi extends CrudRepository<Post, Long> {

}
