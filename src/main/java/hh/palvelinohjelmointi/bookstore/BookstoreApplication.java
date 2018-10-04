package hh.palvelinohjelmointi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.bookstore.model.Book;
import hh.palvelinohjelmointi.bookstore.model.BookRepository;
import hh.palvelinohjelmointi.bookstore.model.Gategory;
import hh.palvelinohjelmointi.bookstore.model.GategoryRepository;
import hh.palvelinohjelmointi.bookstore.model.User;
import hh.palvelinohjelmointi.bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, GategoryRepository gategoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Save a couple of books :)");
			gategoryRepository.save(new Gategory("Tietokirjat"));
			gategoryRepository.save(new Gategory("Keittokirjat"));
			gategoryRepository.save(new Gategory("Kaunokirjat"));
			
			bookRepository.save(new Book("Tiedon ABC", "Jussi Pekka", 2017, "978-3-43-23432-0", 20.99, gategoryRepository.findByName("Tietokirjat").get(0)));
			bookRepository.save(new Book("Keitto Opas", "Perttu Pehmo", 2012, "978-2-12-14554-0", 12.34, gategoryRepository.findByName("Keittokirjat").get(0)));
			bookRepository.save(new Book("Santerin seikkailut", "Keijo Kelaperä", 1997, "978-2-14-14434-0", 19.99, gategoryRepository.findByName("Kaunokirjat").get(0)));
			
			User user1 = new User("user", "$2a$10$SvpCwzfI4kWO4PDrtVGntOFp9fjK9PudHNHe.WT7HN7XB0HRrIYzi","user@bookstore.com", "USER");
			User user2 = new User("admin", "$2a$10$koYgEIHUhmd1DrUY4KqD3uUHFQyG2MzdklR98Tpuv7XkYYGbRBXJe","admin@bookstore.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all books:");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
