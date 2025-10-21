package com.lostfound.lostfound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.lostfound.lostfound.model.Item;



public interface ItemRepository extends MongoRepository<Item, String> {
}


