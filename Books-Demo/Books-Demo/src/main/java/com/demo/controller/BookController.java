package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.BookInputDto;
import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.repository.AuthorRepository;
import com.demo.service.AuthorService;
import com.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	public BookService bookService;

	@Autowired
	public AuthorService authorService;

	@PostMapping("/save")
	public Book saveBook(@RequestBody BookInputDto book) {

		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setDescription(book.getDescription());
		Author author = authorService.getAuthorById(book.getAuthor());
		b.setAuthor(author);
		b.setPages(book.getPages());
		b.setPrice(book.getPrice());
		Book createBook = bookService.createBook(b);
		return createBook;
	}

	@GetMapping("/getAll")
	public List<Book> getBooks() {
		List<Book> allBooks = bookService.getAllBooks();
		return allBooks;

	}

	@GetMapping("/getById/{id}")
	public Book getBooks(@PathVariable("id") Long id) {

		Book allBooks = bookService.getBookById(id);
		return allBooks;
	}

	@PostMapping("/update")
	public Book updateBook(@RequestBody Book input) {
		Book book = new Book();
		book.setId(input.getId());
		book.setTitle(input.getTitle());
		book.setPages(input.getPages());
		book.setPrice(input.getPrice());
		Book updateBook = bookService.updateBook(book);
		return updateBook;
	}

	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long bookId) {

		String deleteBookById = bookService.deleteBookById(bookId);
		return deleteBookById;
	}

}
