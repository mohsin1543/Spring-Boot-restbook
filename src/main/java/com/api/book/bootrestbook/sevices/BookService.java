package com.api.book.bootrestbook.sevices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// private static List<Book> list = new ArrayList<>();

	// static {
	// list.add(new Book(14, "Java Complete Reference", "XYZ"));
	// list.add(new Book(45, "Think for Java", "FORT"));
	// list.add(new Book(76, "Learn for java", "XCORT"));
	// list.add(new Book(7348, "Java for Learning", "ALO"));
	// list.add(new Book(536, "Language java", "CORT"));
	// }

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {

		Book book = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();

			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

	public void deleteBook(int bid) {
		// list = list.stream().filter(book -> book.getId() !=
		// bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);

	}

	public void updateBook(Book book, int bookId) {
		// list = list.stream().map(b -> {
		// if (b.getId() == bookId) {
		// b.setTitle(book.getTitle());
		// b.setAutor(book.getAutor());
		// }
		//
		// return b;
		// }).collect(Collectors.toList());

		book.setId(bookId);
		bookRepository.save(book);

	}

}
