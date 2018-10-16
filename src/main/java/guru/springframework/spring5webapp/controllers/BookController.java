package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository BookRepository;
	
	
	public BookController(guru.springframework.spring5webapp.repositories.BookRepository bookRepository) {
		super();
		BookRepository = bookRepository;
	}



	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		
		model.addAttribute("books", BookRepository.findAll());
		
		return "books";
	}
	
}
