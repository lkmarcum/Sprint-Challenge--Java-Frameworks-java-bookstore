package com.lambdaschool.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String title;

    private String isbn;

    @Column(nullable = true)
    private int copy;

    public Book()
    {
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return title;
    }

    public void setBooktitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }
}
