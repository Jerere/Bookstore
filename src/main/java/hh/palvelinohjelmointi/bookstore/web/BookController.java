package hh.palvelinohjelmointi.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("/index")
	public String bookStoreController() {
		return "view";
	}
}
