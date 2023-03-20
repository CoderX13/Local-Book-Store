package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Book;
import com.backend.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(long id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteById(long id) {
		bookRepo.deleteById(id);
	}
}
