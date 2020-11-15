package com.games.gamelog.games;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User, String> {

    User findById(ObjectId id);
    User findByFirstName(String firstName);


}
