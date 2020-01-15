package sidou.springprojects.spting5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sidou.springprojects.spting5webapp.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
