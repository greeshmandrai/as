package bartender.dao;

import java.util.List;

import bartender.domain.Cocktail;

public interface CocktailDao {

	public List<Cocktail> getAllCocktails() ;
	
	public void save(Cocktail cocktail);
}
