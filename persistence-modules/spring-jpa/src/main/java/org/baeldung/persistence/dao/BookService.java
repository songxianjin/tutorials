package org.baeldung.persistence.dao;

import static org.baeldung.persistence.dao.BookSpecifications.hasAuthor;
import static org.baeldung.persistence.dao.BookSpecifications.titleContains;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.baeldung.persistence.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> query(String author, String title) {
        return bookRepository.findAll(where(hasAuthor(author)).and(titleContains(title)));
    }

}
