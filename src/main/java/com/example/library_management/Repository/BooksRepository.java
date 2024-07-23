package com.example.library_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library_management.Model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{
    
}
