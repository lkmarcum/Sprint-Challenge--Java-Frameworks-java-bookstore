package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE from bookauthors where bookid = :bookid")
//    void deleteBookAuthorsByBookId(long bookid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO bookauthors (bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void insertIntoBookAuthors(long bookid, long authorid);
}
