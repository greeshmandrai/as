package bartender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartender.domain.Cocktail;
import bartender.domain.CocktailRepositoryWrapper;

@Service
public class CocktailService {
	
	 private final CocktailRepositoryWrapper cocktailRepository;

	    @Autowired
	    public CocktailService(final CocktailRepositoryWrapper cocktailRepository) {
	        this.cocktailRepository = cocktailRepository;
	    }


	public String createCocktail(Cocktail cocktail) {
		this.cocktailRepository.save(cocktail);
		return "success";
	}
	
	/*@Autowired
	TodoDao todoDao;

	@Transactional
	public List<Cocktail> getAllCocktails() {
		return todoDao.getAllCocktails();
	}*/
	

}
