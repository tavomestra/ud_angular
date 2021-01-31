/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.business;

import com.mega.JunitSpring.data.ItemRepository;
import com.mega.JunitSpring.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retriveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retriveAllItems() {
         var items = repository.findAll();
        for (var item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

}
