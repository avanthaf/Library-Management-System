package com.example.library_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management.Model.Book;
import com.example.library_management.Services.BooksServices;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BooksServices booksServices;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return booksServices.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return booksServices.getBookById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {        
        return booksServices.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        Book existingBook = booksServices.getBookById(id);

        if (existingBook != null){
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setCategory(book.getCategory());
            return booksServices.saveBook(existingBook);
        }else{
            return null;
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable long id){
        booksServices.deleteBook(id);
    }
    
}
