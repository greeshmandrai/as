package bartender.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailRepositoryWrapper {

	@Autowired
	private CocktailRepository repository;

	public CocktailRepositoryWrapper(final CocktailRepository repository) {
		this.repository = repository;
	}

	public void save(final Cocktail cocktail) {
		this.repository.save(cocktail);
	}
}
