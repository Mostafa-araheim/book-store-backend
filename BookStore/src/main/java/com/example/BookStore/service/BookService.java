package com.example.BookStore.service;

import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book getBookById(Long id) { return bookRepository.findById(id).orElse(null); }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }


}
