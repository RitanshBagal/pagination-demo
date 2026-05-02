package com.example.pagination_demo.project.service.impl;

import com.example.pagination_demo.project.dto.BookDto;
import com.example.pagination_demo.project.entity.Book;
import com.example.pagination_demo.project.repository.BookRepository;
import com.example.pagination_demo.project.response.PaginatedResponse;
import com.example.pagination_demo.project.service.BookService;
import com.example.pagination_demo.project.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public PaginatedResponse<BookDto> getAllBooks(Pageable pageable) {
        Page<Book> page = bookRepository.findAll(pageable);
        Page<BookDto> dtoPage = page.map(book -> modelMapper.map(book, BookDto.class));

        return PaginationUtil.buildResponse(dtoPage);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksById(Long id) {
        return List.of();
    }

}
