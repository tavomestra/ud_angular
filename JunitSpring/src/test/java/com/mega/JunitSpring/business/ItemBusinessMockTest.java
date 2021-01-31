/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.business;

import com.mega.JunitSpring.data.ItemRepository;
import com.mega.JunitSpring.model.Item;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Asus
 */
@ExtendWith(MockitoExtension.class)
public class ItemBusinessMockTest {

    @InjectMocks
    private ItemBusinessService business;
    
    @Mock
    private ItemRepository itemRepository;

   

    @Test
    public void calculateSumUsingDataService_basic() {
        when(itemRepository.findAll()).thenReturn( Arrays.asList(
                                new Item(2, "Item2", 10, 10),
                                new Item(3, "Item3", 20, 20)));
        
        List<Item> items = business.retriveAllItems();
        
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }

}
