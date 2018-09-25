package hh.palvelinohjelmointi.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gategoryid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gategory")
	private List<Book> books;

	public Gategory() {
	}

	public Gategory(String name) {
		super();
		this.name = name;
	}

	public long getGategoryid() {
		return gategoryid;
	}

	public void setGategoryid(long gategoryid) {
		this.gategoryid = gategoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Gategory [gategoryid=" + gategoryid + ", name=" + name + "]";
	}

}
