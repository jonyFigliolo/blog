package com.example.blog.commons;

import java.io.Serializable;

import java.util.List;

public interface GenericServiceApi<T,ID extends Serializable> {
	
	T save(T entity);
	
	void deltete(ID ID);
	
	T get(ID ID);
	
	List<T> getAll();

}
