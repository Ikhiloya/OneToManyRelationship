package com.loya.onetomanybidirectionaldemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Book")
public class Book  implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    @NotBlank(message = "Enter a title ")
    private String title;

    @Column(name = "Genre")
    @NotBlank(message = "Enter a genre ")
    private String genre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;


    public Book() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //getter method to retrieve the AuthorId
    public Long getAuthor_id(){
        return author.getId();
    }

    //getter Method to get the author's full name
    public String getAuthorName(){
        return author.getFirstName() + " " + author.getLastName();
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    @JsonIgnore
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
