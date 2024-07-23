package com.example.library_management.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management.Model.Books;
import com.example.library_management.Repository.BooksRepository;

@Service
public class BooksServices {

    @Autowired
    BooksRepository booksRepository;
    
    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Books getBookById(Long id){
        return booksRepository.findById(id).orElse(null);
    }

    public Books saveBook(Books book){
        return booksRepository.save(book);
    }
    
    public void deleteBook(long id){
        booksRepository.deleteById(id);
    }
}
