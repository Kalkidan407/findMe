package com.lostfound.lostfound.controller;


import org.springframework.web.bind.annotation.*;

import com.lostfound.lostfound.model.Item;
import com.lostfound.lostfound.repository.ItemRepository;
import com.lostfound.service.ItemService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private  ItemRepository itemRepository;
    private  ItemService itemService;

    // public ItemController(ItemRepository itemRepository) {
    //     this.itemRepository = itemRepository;
    // }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable("id") String id){
        return itemService.getItemById(id);
    }

   @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item updatedItem){
        return itemService.updateItem(id, updatedItem);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/{id}")
      public String deleteItem(@PathVariable String id){
           itemService.deleteItem(id);
           return "Item with id" + id + "deleted successfully!";
      }
    
}
