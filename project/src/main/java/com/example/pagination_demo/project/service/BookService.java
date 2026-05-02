package com.example.pagination_demo.project.service;

import com.example.pagination_demo.project.dto.BookDto;
import com.example.pagination_demo.project.entity.Book;
import com.example.pagination_demo.project.response.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    PaginatedResponse<BookDto>getAllBooks(Pageable pageable);

    Book saveBook(Book book);

    List<Book> getBooksById(Long id);


}
