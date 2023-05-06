package org.example.relationships.many_to_many.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="book")
public class BookBi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @ManyToMany(fetch = FetchType.LAZY,
                 cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="book_reader",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name="reader_id")
    )
    private List<ReaderBi> readerBis;

    public BookBi() {
    }

    public BookBi(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<ReaderBi> getReaders() {
        return readerBis;
    }

    public void setReaders(List<ReaderBi> readerBis) {
        this.readerBis = readerBis;
    }

    @Override
    public String toString() {
        return "BookBi{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author +
                '}';
    }
}
