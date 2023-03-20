package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.service.MyBookService;

@Controller
public class MyBookController {
	@Autowired
	private MyBookService myBookServ;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyBookById(@PathVariable("id") long id ) {
		myBookServ.deleteBookByid(id);
		return "redirect:/my_list";
	}

}
