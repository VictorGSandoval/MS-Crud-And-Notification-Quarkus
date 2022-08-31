package org.vallegrande.repository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import org.vallegrande.entity.Institute;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstituteRepository implements ReactivePanacheMongoRepository<Institute> {
}
