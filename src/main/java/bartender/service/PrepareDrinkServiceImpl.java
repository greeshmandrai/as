package bartender.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import bartender.domain.Cocktail;
import bartender.exception.DomainRuleException;

@Service
public class PrepareDrinkServiceImpl implements PrepareDrinkService{

	public int availabilityToMakeDrink = 4;

	@Override
	public void makeDrink(Cocktail cocktail) {
		if (isBarTenderAvailble(cocktail.getDrinkType())) {
			throw new DomainRuleException("err.msg.currently.we.are.full", "We sre full, sorry");
		}
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(new MakeDrinkProcess(), 2, TimeUnit.SECONDS);
	}
	
	private boolean isBarTenderAvailble(String drinkType) {
		String type = drinkType.toLowerCase();
		int requiredTime = 0;
		if(type.equals("beer")) {
			requiredTime = 2;
		} else {
			requiredTime = 4;
		}
		/*switch (type) {
		case "beer":
			requiredTime = 2;
			break;
		case "drink":
			requiredTime = 4;
			break;
		default:
			requiredTime = 2;
			break;
		}*/
		availabilityToMakeDrink = availabilityToMakeDrink - requiredTime;
		if (availabilityToMakeDrink > 0) {
			return true;
		}
		return false;
	}

	 private class MakeDrinkProcess implements Runnable {

	        @Override
	        public void run() {
	            System.out.println("Success");
	        }
	    }
	
}
