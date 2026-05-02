package com.example.pagination_demo.project.repository;

import com.example.pagination_demo.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
