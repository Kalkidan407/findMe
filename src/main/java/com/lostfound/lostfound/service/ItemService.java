package com.lostfound.lostfound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.lostfound.lostfound.model.Item;
import com.lostfound.lostfound.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> getItemById(Long id) {
    return itemRepository.findById(id);
}


    public void deleteItemById(Long id){
      itemRepository.deleteById(id);
    }


}
