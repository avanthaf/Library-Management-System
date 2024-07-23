package com.example.library_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.Model.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{
    
}
