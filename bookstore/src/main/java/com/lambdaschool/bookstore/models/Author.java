package com.lambdaschool.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String firstname;

    private String lastname;

    public Author()
    {
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
}
