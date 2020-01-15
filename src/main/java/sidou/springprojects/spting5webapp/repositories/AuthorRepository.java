package sidou.springprojects.spting5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sidou.springprojects.spting5webapp.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
