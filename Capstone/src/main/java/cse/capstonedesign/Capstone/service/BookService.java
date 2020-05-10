package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cse.capstonedesign.Capstone.dto.request.InsertBookRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateBookRequestDTO;
import cse.capstonedesign.Capstone.dto.response.BookDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.BookSimpleResponseDTO;
import cse.capstonedesign.Capstone.mapper.BookMapper;

@Service
public class BookService {

	private final BookMapper bookMapper;

	public BookService(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public boolean saveBook(InsertBookRequestDTO newBook) {
		return bookMapper.insertBook(newBook) != 0;
	}

	public List<BookSimpleResponseDTO> getAllBooks() {
		return bookMapper.getAllBooks().stream().map(BookSimpleResponseDTO::of).collect(Collectors.toList());
	}

	public BookDetailResponseDTO getBookById(int bookId) {
		return BookDetailResponseDTO.of(bookMapper.getBookById(bookId));
	}

	public boolean putBook(int bookId, UpdateBookRequestDTO puttedBook) {
		return bookMapper.updateBook(bookId, puttedBook) != 0;
	}

	public boolean deleteBook(int bookId) {
		return bookMapper.deleteBook(bookId) != 0;
	}
}
