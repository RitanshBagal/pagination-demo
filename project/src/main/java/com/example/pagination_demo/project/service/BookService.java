package com.example.pagination_demo.project.service;

import com.example.pagination_demo.project.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<Book> getAllBooks(Pageable pageable);

    Book saveBook(Book book);

    List<Book> getBooksById(Long id);


}
