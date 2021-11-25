package bartender.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartender.dao.CocktailDao;
import bartender.domain.Cocktail;

@Service
public class CocktailService {

	private final CocktailDao cocktailDao;
	private final PrepareDrinkService prepareDrinkService;

	@Autowired
	public CocktailService(final CocktailDao cocktailRepository, final PrepareDrinkService prepareDrinkService) {
		this.cocktailDao = cocktailRepository;
		this.prepareDrinkService = prepareDrinkService;
	}

	@Transactional
	public String createCocktail(Cocktail cocktail) {
		this.prepareDrinkService.makeDrink(cocktail);
		this.cocktailDao.save(cocktail);
		return "Your order for" + cocktail.getDrinkType() + "is placed successfully";
	}

	@Transactional
	public List<Cocktail> getAllCocktails() {
		return cocktailDao.getAllCocktails();
	}
}
