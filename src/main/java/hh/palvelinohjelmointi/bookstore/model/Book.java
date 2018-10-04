package hh.palvelinohjelmointi.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "gategoryid")
	private Gategory gategory;

	public Book() {
	}

	public Book(String title, String author, int year, String isbn, double price, Gategory gategory) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.gategory = gategory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Gategory getGategory() {
		return gategory;
	}

	public void setGategory(Gategory gategory) {
		this.gategory = gategory;
	}

	@Override
	public String toString() {
		if (this.gategory != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + "," + " isbn="
					+ isbn + ", price=" + price + " gategory =" + this.getGategory() + "]";

		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + "," + " isbn="
					+ isbn + ", price=" + price + "]";
	}
}