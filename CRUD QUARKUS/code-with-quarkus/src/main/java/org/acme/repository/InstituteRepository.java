package org.acme.repository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import org.acme.entity.Institute;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstituteRepository implements ReactivePanacheMongoRepository<Institute> {

}
