package bartender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bartender.domain.Cocktail;
import bartender.service.CocktailService;

@RestController
@RequestMapping("/bar")
public class DrinkController {
	
    private final CocktailService cocktailService;

    @Autowired
    public DrinkController(final CocktailService cocktailService) {
    	//http://localhost:8080/bar/cocktails
        this.cocktailService = cocktailService;
    }

	@RequestMapping(value = "/drinkrequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createDrinkRequest(@RequestBody Cocktail cocktail) {
		return cocktailService.createCocktail(cocktail);
	}
	
	@RequestMapping(value = "/cocktails", method = RequestMethod.GET)
	public String goToHomePage() {
		return "redirect:/tasks";
	}

}
