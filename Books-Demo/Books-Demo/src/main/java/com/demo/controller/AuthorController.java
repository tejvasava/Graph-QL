package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AuthorInputDto;
import com.demo.entity.Author;
import com.demo.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	public AuthorService authorService;

	@GetMapping("/all")
	public List<Author> getAll() {
		return authorService.getAllAuthor();
	}

	@PostMapping("/save")
	public Author saveAuthor(@RequestBody AuthorInputDto author) 
	{
		Author author2 =  new Author();
		author2.setName(author.getName());
		return authorService.createAuthor(author2);
	}

	@GetMapping("/getById/{id}")
	public Author getById(@PathVariable("id") Long id) {

		return authorService.getAuthorById(id);
	}

	@PostMapping("/update")
	public Author updateAuthor(@RequestBody Author input) {
		Author author = new Author();
		author.setId(input.getId());
		author.setName(input.getName());
		return authorService.updateAuthor(author);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteBook(@PathVariable("id") Long id) {

		return authorService.deleteAuthorById(id);
	}

}
