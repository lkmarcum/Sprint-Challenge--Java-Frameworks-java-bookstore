package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.ErrorDetail;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.services.AuthorService;
import com.lambdaschool.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController
{

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorrepos;

    @ApiOperation(value = "Update an existing book", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Updated", response = void.class),
            @ApiResponse(code = 404, message = "Book not found", response = ErrorDetail.class)
    })
    @PutMapping(value = "/books/{bookid}")
    public ResponseEntity<?> updateBook(
            @RequestBody
                    Book updateBook,
            @PathVariable
                    long bookid)
    {
        bookService.update(updateBook, bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Assign a book to an author", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Assigned", response = void.class),
            @ApiResponse(code = 404, message = "Book not found", response = ErrorDetail.class),
            @ApiResponse(code = 404, message = "Author not found", response = ErrorDetail.class)
    })
    @PostMapping(value = "/books/{bookid}/authors/{authorid}", produces = {"application/json"})
    public ResponseEntity<?> assignBookToAuthor(@PathVariable long bookid, @PathVariable long authorid)
    {
        authorrepos.insertIntoBookAuthors(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an existing book", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Deleted", response = void.class),
            @ApiResponse(code = 404, message = "Book not found", response = ErrorDetail.class)
    })
    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<?> deleteBookById(
            @PathVariable
                    long bookid)
    {
        bookService.delete(bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
