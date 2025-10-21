package com.lostfound.lostfound.controller;


import org.springframework.web.bind.annotation.*;

import com.lostfound.lostfound.model.Item;
import com.lostfound.lostfound.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id){
        return itemRepository.findById(id);
    }

   @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item updatedItem){
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

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
      public String deteteItem(@PathVariable String id){
           itemRepository.deleteById(id);
           return "Item with id" + id + "deleted successfully!";
      }
    
}
