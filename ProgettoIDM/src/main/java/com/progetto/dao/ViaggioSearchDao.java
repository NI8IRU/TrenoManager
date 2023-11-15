package com.progetto.dao;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;

import com.progetto.model.Treno;
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

    //questo metodo cerca in base a 4 filtri i viaggi presenti nel db. Permette all'utente di poter lasciare 
    //i campi dei filtri che non gli interessano vuoti; ma se aggiunge due o più filtri, verranno restituiti
    //solo i viaggi che rispettano tutte le condizioni inserite
    public List<Viaggio> findAllByCriteria(ViaggioSearchRequest request) {
        // Apri una nuova sessione Hibernate
        Session session = factory.openSession();

        // Crea un oggetto CriteriaBuilder per costruire i criteri di query
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Crea un oggetto CriteriaQuery specificando il tipo di risultato atteso (Viaggio.class)
        CriteriaQuery<Viaggio> criteriaQuery = criteriaBuilder.createQuery(Viaggio.class);

        // Lista di predicati che verranno utilizzati nella clausola WHERE della query
        List<Predicate> predicates = new ArrayList<>();

        // Ottieni il root della query, che rappresenta l'entità principale (Viaggio)
        Root<Viaggio> viaggioRoot = criteriaQuery.from(Viaggio.class);

        // Effettua una join con l'entità Treno usando il campo di join "treno"
        Join<Viaggio, Treno> trenoJoin = viaggioRoot.join("treno");

        // Aggiungi predicati per filtrare i risultati in base ai criteri di ricerca forniti
        if (request.getStazionePartenza() != null && !request.getStazionePartenza().trim().isEmpty()) {
            // Aggiungi un predicato per la stazione di partenza
            Predicate stazionePartenzaPredicate = criteriaBuilder
                    .like(viaggioRoot.get("stazionePartenza"), "%" + request.getStazionePartenza() + "%");
            predicates.add(stazionePartenzaPredicate);
        }

        if (request.getStazioneDestinazione() != null && !request.getStazioneDestinazione().trim().isEmpty()) {
            // Aggiungi un predicato per la stazione di destinazione
            Predicate stazioneDestinazionePredicate = criteriaBuilder
                    .like(viaggioRoot.get("stazioneDestinazione"), "%" + request.getStazioneDestinazione() + "%");
            predicates.add(stazioneDestinazionePredicate);
        }

        if (request.getMarca() != null && !request.getMarca().trim().isEmpty()) {
            // Aggiungi un predicato per la marca del treno
            Predicate marcaTrenoPredicate = criteriaBuilder
                    .like(trenoJoin.get("marca"), "%" + request.getMarca() + "%");
            predicates.add(marcaTrenoPredicate);
        }

        if (request.getDataPartenza() != null) {
            // Filtraggio per data di partenza
            LocalDate inizioGiornoDataPartenza = request.getDataPartenza();
            LocalDate fineGiornoDataPartenza = inizioGiornoDataPartenza.plusDays(1);

            // Crea predicati per le date di partenza
            Predicate dataPartenzaPredicate = criteriaBuilder
                    .greaterThanOrEqualTo(viaggioRoot.get("dataPartenza"), inizioGiornoDataPartenza.atStartOfDay());

            Predicate dataPartenzaEndPredicate = criteriaBuilder
                    .lessThan(viaggioRoot.get("dataPartenza"), fineGiornoDataPartenza.atStartOfDay());

            // Combina i due predicati usando un AND
            Predicate finalDataPartenzaPredicate = criteriaBuilder.and(dataPartenzaPredicate, dataPartenzaEndPredicate);

            predicates.add(finalDataPartenzaPredicate);
        }

        // Combina tutti i predicati usando un AND e imposta la clausola WHERE nella query
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        // Crea la query utilizzando il CriteriaQuery configurato
        Query<Viaggio> query = session.createQuery(criteriaQuery);

        // Esegue la query e restituisce la lista dei risultati
        return query.getResultList();
    }
}

