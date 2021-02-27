package com.example.blog.commons;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericServiceApi<T,ID> {

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void deltete(ID ID) {
		getDao().deleteById(ID);
		
	}

	@Override
	public T get(ID ID) {
		Optional<T> obj=getDao().findById(ID);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> returnList= new ArrayList<>();
		getDao().findAll().forEach(obj->returnList.add(obj));
		return returnList;
	}
	
	
	public abstract CrudRepository<T,ID>getDao();
	

}
