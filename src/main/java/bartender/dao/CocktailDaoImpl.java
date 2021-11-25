package bartender.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bartender.domain.Cocktail;

@Repository
public class CocktailDaoImpl implements CocktailDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Cocktail> getAllCocktails() {
		Session session = this.sessionFactory.getCurrentSession();
		return (List<Cocktail>)session.createQuery("from cocktail").list();
	}
	
	public void save(Cocktail cocktail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(cocktail);
	}
}
