package com.lostfound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lostfound.lostfound.model.Item;
import com.lostfound.lostfound.repository.ItemRepository;

@Service
public class ItemService {
  @Autowired
  private  ItemRepository itemRepository;

  public  List<Item> getAllItems(){
    return itemRepository.findAll();

  }

  public Optional<Item> getItemById(String  id ){
    return itemRepository.findById(id);
  }

   public Item updateItem( String id , Item updatedItem) {
        return itemRepository.findById(id)
            .map( item -> {
                item.setName(id);
                item.setDescription(id);
                item.setLocationFound(id);
                item.setPhotoUrl(id);
                item.setClaimed(false);
                return itemRepository.save(item);
            })
            .orElseThrow(()-> new RuntimeException("Item not found with id" + id));
    }

    public void deleteItem(String id){
        itemRepository.deleteById(id);
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }
  
  

}



