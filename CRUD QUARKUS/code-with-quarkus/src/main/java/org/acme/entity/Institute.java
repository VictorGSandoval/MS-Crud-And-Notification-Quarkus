package org.acme.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(collection = "institute")
public class Institute extends ReactivePanacheMongoEntity {
    private ObjectId id;
    private String ruc;
    private String name;
    private String address;
    private String email;
}
