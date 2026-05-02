package com.example.pagination_demo.project.controller;

import com.example.pagination_demo.project.dto.BookDto;
import com.example.pagination_demo.project.entity.Book;
import com.example.pagination_demo.project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<BookDto>> getAllBooks(Pageable pageable) {
        Page<Book> bookPage = bookService.getAllBooks(pageable);
        Page<BookDto> dtoPage = bookPage.map(book ->
                modelMapper.map(book, BookDto.class)
        );
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book savedBook = bookService.saveBook(book);
        BookDto responseDto = modelMapper.map(savedBook, BookDto.class);
        return ResponseEntity.ok(responseDto);
    }
}
