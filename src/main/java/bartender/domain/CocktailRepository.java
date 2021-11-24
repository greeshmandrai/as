package bartender.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CocktailRepository extends JpaRepository<Cocktail, Long>, JpaSpecificationExecutor<Cocktail> {

}
