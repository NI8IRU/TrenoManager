package com.progetto.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;
import com.progetto.model.Viaggio;

@Repository
public class ViaggioSearchDao {


    @Autowired
    SessionFactory factory;

    public List<Viaggio> findAllBySimpleQuery(String stazionePartenza, String stazioneDestinazione) {
    	Session session = factory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Viaggio> criteriaQuery = criteriaBuilder.createQuery(Viaggio.class);

        Root<Viaggio> root = criteriaQuery.from(Viaggio.class);

        Predicate stazionePartenzaPredicate = criteriaBuilder
                .like(root.get("stazionePartenza"), "%" + stazionePartenza + "%");

        Predicate stazioneDestinazionePredicate = criteriaBuilder
                .like(root.get("stazioneDestinazione"), "%" + stazioneDestinazione + "%");

        Predicate orPredicate = criteriaBuilder.or(stazionePartenzaPredicate, stazioneDestinazionePredicate);

        criteriaQuery.where(orPredicate);

        Query<Viaggio> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Viaggio> findAllByCriteria(ViaggioSearchRequest request) {
    	Session session = factory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Viaggio> criteriaQuery = criteriaBuilder.createQuery(Viaggio.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Viaggio> root = criteriaQuery.from(Viaggio.class);

        if (request.getStazionePartenza() != null && !request.getStazionePartenza().trim().isEmpty()) {
            Predicate stazionePartenzaPredicate = criteriaBuilder
                    .like(root.get("stazionePartenza"), "%" + request.getStazionePartenza() + "%");
            predicates.add(stazionePartenzaPredicate);
        }

        if (request.getStazioneDestinazione()!= null && !request.getStazioneDestinazione().trim().isEmpty()) {
            Predicate stazioneDestinazionePredicate = criteriaBuilder
                    .like(root.get("stazioneDestinazione"), "%" + request.getStazioneDestinazione() + "%");
            predicates.add(stazioneDestinazionePredicate);
        }
        
        if (request.getDataPartenza() != null) {
            // Tronca la data all'inizio del giorno
            LocalDateTime inizioGiornoDataPartenza = request.getDataPartenza().truncatedTo(ChronoUnit.DAYS);

            // Tronca la data alla fine del giorno
            LocalDateTime fineGiornoDataPartenza = inizioGiornoDataPartenza.plusDays(1);

            // Crea il predicato per il giorno specifico
            Predicate dataPartenzaPredicate = criteriaBuilder
                    .greaterThanOrEqualTo(root.get("dataPartenza"), inizioGiornoDataPartenza);

            Predicate dataPartenzaEndPredicate = criteriaBuilder
                    .lessThan(root.get("dataPartenza"), fineGiornoDataPartenza);

            // Combina i due predicati usando un AND
            Predicate finalDataPartenzaPredicate = criteriaBuilder.and(dataPartenzaPredicate, dataPartenzaEndPredicate);

            predicates.add(finalDataPartenzaPredicate);
        }



        if (request.getDataArrivo() != null) {
            // Tronca la data alla precisione del giorno
        	LocalDateTime truncatedDataArrivo = request.getDataArrivo().truncatedTo(ChronoUnit.DAYS);

            // Crea il predicato per data di arrivo
            Predicate dataArrivoPredicate = criteriaBuilder
                    .lessThanOrEqualTo(root.get("dataArrivo"), truncatedDataArrivo);

            predicates.add(dataArrivoPredicate);
        }

        
        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));

        Query<Viaggio> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}

//@Repository
//public class ViaggioSearchDao {
//	
//	private final EntityManager em; 
//	
//
//	
//	@Autowired
//	public ViaggioSearchDao(EntityManager em) {
//	    this.em = em;
//	}
//
//	public List<Viaggio> findAllBySimpleQuery(String stazionePartenza, String stazioneDestinazione){
//		
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		CriteriaQuery<Viaggio> criteriaQuery = criteriaBuilder.createQuery(Viaggio.class);
//		
//		//select * from Viaggio
//		Root<Viaggio> root = criteriaQuery.from(Viaggio.class);
//		
//		//creazione clausola WHERE:
//		//WHERE stazionePartenza like '%stringa%'
//		Predicate stazionePartenzaPredicate = criteriaBuilder
//				.like(root.get("stazionePartenza"), "%" + stazionePartenza + "%");
//		
//		Predicate stazioneDestinazionePredicate = criteriaBuilder
//				.like(root.get("stazioneDestinazione"), "%" + stazioneDestinazione + "%");
//		
////		Predicate dataPartenzaPredicate = criteriaBuilder
////				.like(root.get("dataPartenza"), "%" + dataPartenza + "%");
////		
////		Predicate dataArrivoPredicate = criteriaBuilder
////				.like(root.get("dataArrivo"), "%" + dataArrivo + "%");
//		
//		Predicate orPredicate = criteriaBuilder.or(stazionePartenzaPredicate, stazioneDestinazionePredicate);
//		
//		criteriaQuery.where(orPredicate);
//		
//		TypedQuery<Viaggio> query = em.createQuery(criteriaQuery);
//		
//		return query.getResultList();
//	}
//	
//	public List<Viaggio> findAllByCriteria(ViaggioSearchRequest request){
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		CriteriaQuery<Viaggio> criteriaQuery = criteriaBuilder.createQuery(Viaggio.class);
//		List<Predicate> predicates = new ArrayList<>();
//		
//		//select from Viaggio
//		Root<Viaggio> root = criteriaQuery.from(Viaggio.class);
//		
//		if(request.getStazionePartenza() != null) {
//			Predicate stazionePartenzaPredicate = criteriaBuilder
//					.like(root.get("stazionePartenza"), "%" + request.getStazionePartenza() + "%");
//			predicates.add(stazionePartenzaPredicate);
//		}
//		
//		if(request.getStazioneDestinazione() != null) {
//			Predicate stazioneDestinazionePredicate = criteriaBuilder
//					.like(root.get("stazioneDestinazione"), "%" + request.getStazioneDestinazione() + "%");
//			predicates.add(stazioneDestinazionePredicate);
//		}
//		
//		criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
//		
//		TypedQuery<Viaggio> query = em.createQuery(criteriaQuery);
//		return query.getResultList();
//	}
//}
