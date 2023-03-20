package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backend.entity.Book;
import com.backend.entity.MyBookList;
import com.backend.service.BookService;
import com.backend.service.MyBookService;


@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookServ;
	
	@GetMapping("/")
	public String name() {
		return "hello";
	}
	
	@GetMapping("/register")
	public String bookRegister() {
		return "book_registration";
	}
	
	
	@GetMapping("/book_List")
	public ModelAndView bookList() {
		List<Book> books = bookService.getAllBooks();
		return new ModelAndView("bookList", "book", books);
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
	bookService.save(book);
		return "redirect:/book_List";	
	}
	
	@GetMapping("my_list")
	public String myBooks(Model model) {
		List<MyBookList> list = myBookServ.getAllMyBooks();
		model.addAttribute("book", list);
		return "mybooks";
	}
	
	@RequestMapping("/my_list/{id}")
	public String getMyList(@PathVariable("id") long id) {
		Book book = bookService.getBookById(id);
		MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookServ.saveMyBook(myBookList);
		return "redirect:/my_list";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBookById(@PathVariable("id") long id) {
		bookService.deleteById(id);
		return "redirect:/book_List";
	}
	
	
	
	

}
