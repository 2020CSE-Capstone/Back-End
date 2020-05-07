package cse.capstonedesign.Capstone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.model.Book;
import cse.capstonedesign.Capstone.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("")
	public boolean saveBook(@RequestBody Book newBook) {
		return bookService.saveBook(newBook);
	}

	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId) {
		return bookService.getBookById(bookId);
	}

	@PutMapping("/{bookId}")
	public boolean putBook(@PathVariable("bookId") int bookId, @RequestBody Book puttedBook) {
		return bookService.putBook(bookId, puttedBook);
	}

	@DeleteMapping("/{bookId}")
	public boolean deleteBook(@PathVariable("bookId") int bookId) {
		return bookService.deleteBook(bookId);
	}
}