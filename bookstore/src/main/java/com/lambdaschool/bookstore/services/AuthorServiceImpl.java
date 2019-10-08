package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private BookRepository bookrepos;

    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> list = new ArrayList<>();
        authorrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author findAuthorById(long id)
    {
        return authorrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }
}
