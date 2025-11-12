package com.lostfound.lostfound.repository;

import org.springframework.stereotype.Repository;

import com.lostfound.lostfound.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}


