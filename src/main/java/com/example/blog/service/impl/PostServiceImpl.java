package com.example.blog.service.impl;

import com.example.blog.service.api.PostServiceApi;
import com.example.blog.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.blog.commons.GenericServiceImpl;
import com.example.blog.dao.api.PostDaoApi;

@Service
public class PostServiceImpl extends GenericServiceImpl<Post,Long> implements PostServiceApi {
	
	@Autowired
	private PostDaoApi postDaoApi;

	@Override
	public CrudRepository<Post, Long> getDao() {
		
		return postDaoApi;
	}



}
