package sidou.springprojects.spting5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sidou.springprojects.spting5webapp.model.Author;
import sidou.springprojects.spting5webapp.model.Book;
import sidou.springprojects.spting5webapp.repositories.AuthorRepository;
import sidou.springprojects.spting5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    /*public DevBootstrap (AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }*/

    private void initData(){
        // object 1
        Author sidaAli = new Author("Sid Ali", "MAHMOUDI");
        Book java = new Book("Java Design Patterns", "753219", "Oussama");
        sidaAli.getBooks().add(java);
        java.getAuthors().add(sidaAli);

        authorRepository.save(sidaAli);
        bookRepository.save(java);

        // object 2
        Author oussama = new Author("Oussama", "H.");
        Book d = new Book("Be on data", "853219", "Oussama");
        oussama.getBooks().add(d);
        d.getAuthors().add(oussama);

        authorRepository.save(oussama);
        bookRepository.save(d);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
