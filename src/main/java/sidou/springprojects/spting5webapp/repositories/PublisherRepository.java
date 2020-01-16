package sidou.springprojects.spting5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sidou.springprojects.spting5webapp.model.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
