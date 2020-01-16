package sidou.springprojects.spting5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sidou.springprojects.spting5webapp.model.Author;
import sidou.springprojects.spting5webapp.model.Book;
import sidou.springprojects.spting5webapp.model.Publisher;
import sidou.springprojects.spting5webapp.repositories.AuthorRepository;
import sidou.springprojects.spting5webapp.repositories.BookRepository;
import sidou.springprojects.spting5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    /*public DevBootstrap (AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }*/

    private void initData(){
        // object 1
        Author sidaAli = new Author("Sid Ali", "MAHMOUDI");
        Publisher publisher1  = new Publisher("Ahmed", "England");
        Book java = new Book("Java Design Patterns", "753219", publisher1);
        sidaAli.getBooks().add(java);
        java.getAuthors().add(sidaAli);

        authorRepository.save(sidaAli);
        publisherRepository.save(publisher1);
        bookRepository.save(java);

        // object 2
        Author oussama = new Author("Oussama", "H.");
        Publisher publisher2 = new Publisher("Eyrolles", "Canada");
        Book d = new Book("Be on data", "853219", publisher2);
        oussama.getBooks().add(d);
        d.getAuthors().add(oussama);

        authorRepository.save(oussama);
        publisherRepository.save(publisher2);
        bookRepository.save(d);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
