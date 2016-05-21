package thkr.jpa;
import java.util.List;

import thkr.model.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
public class THKRDBService {
	
	EntityManager entityManager;
	
	public THKRDBService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Lakas> getAllLakas(){
		TypedQuery<Lakas> query=entityManager.createQuery("SELECT * FROM LAKAS",Lakas.class);
		return query.getResultList();
	}

}
