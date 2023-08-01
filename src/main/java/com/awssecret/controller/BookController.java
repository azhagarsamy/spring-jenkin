package com.awssecret.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awssecret.entity.Book;
import com.awssecret.repository.BookRepository;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository repo;
	
	@SneakyThrows
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@SneakyThrows
	@GetMapping("/{id}")
	public Book findBook(@PathVariable int id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("BooK ID Not Found :"+ id));
	}
	
	@GetMapping
	public List<Book> findAllBooks(){
		return repo.findAll();
	}
}
