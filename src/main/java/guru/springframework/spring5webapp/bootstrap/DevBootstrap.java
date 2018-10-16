package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	private void initData() {
		
		Author adam = new Author("Adam", "Maly");
		Book adamKniha = new Book("Mala kniha","12345", "RockStarPublisher");
		
		adam.getBooks().add(adamKniha);
		adamKniha.getAuthorses().add(adam);
		
		authorRepository.save(adam);
		bookRepository.save(adamKniha);
		
		Author jozef = new Author("Jozef", "Mak");
		Book knihaJozko = new Book("Jozkova prva","789","ActivisionPublisher");
		
		jozef.getBooks().add(knihaJozko);
		
		authorRepository.save(jozef);
		bookRepository.save(knihaJozko);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

}
