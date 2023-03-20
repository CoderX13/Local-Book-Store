package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.MyBookList;
import com.backend.repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	private MyBookRepository myBookRepo;
	
	public void saveMyBook(MyBookList myBookList) {
		myBookRepo.save(myBookList);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return myBookRepo.findAll();
	}
	
	public void deleteBookByid(long id) {
		myBookRepo.deleteById(id);
	}

}
