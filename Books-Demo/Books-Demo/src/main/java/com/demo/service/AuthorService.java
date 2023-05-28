package com.demo.service;

import java.util.List;

import com.demo.entity.Author;

public interface AuthorService {
	public Author createAuthor(Author author);

	public List<Author> getAllAuthor();

	public Author getAuthorById(Long id);

	public Boolean deleteAuthorById(Long id);

	public Author updateAuthor(Author author);

}
