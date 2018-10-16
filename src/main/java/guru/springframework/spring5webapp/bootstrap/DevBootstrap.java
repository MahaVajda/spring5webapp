package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{


	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Publisher rockStar = new Publisher();
		rockStar.setAddress("Juzna trieda 9");
		rockStar.setName("RockStar");
		
		publisherRepository.save(rockStar);
		
		Author adam = new Author("Adam", "Maly");
		Book adamKniha = new Book("Mala kniha","12345",  rockStar);
		
		adam.getBooks().add(adamKniha);
		adamKniha.getAuthorses().add(adam);
		
		authorRepository.save(adam);
		bookRepository.save(adamKniha);

		Author jozef = new Author("Jozef", "Mak");
		Book knihaJozko = new Book("Jozkova prva","789", rockStar);
		
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
