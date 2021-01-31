/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.controller;

import com.mega.JunitSpring.model.Item;
import com.mega.JunitSpring.business.ItemBusinessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retriveHardcodedItem();
    }

    @GetMapping("/all-item-from-database")
    public List<Item> retriveAllItems() {
        var items = itemBusinessService.retriveAllItems();        
        return items;
    }

}
