/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.controller;

import com.mega.JunitSpring.business.ItemBusinessService;
import com.mega.JunitSpring.model.Item;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Asus
 */
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    public ItemControllerTest() {
    }

    @Test
    public void helloWorld_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //assertEquals("Hello World", result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(itemBusinessService.retriveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{id:2,name:Item2,price:10}"))
                .andReturn();
    }

    @Test
    public void retriveAllItems_basic() throws Exception {

        when(itemBusinessService.retriveAllItems())
                .thenReturn(
                        Arrays.asList(
                                new Item(2, "Item2", 10, 10),
                                new Item(3, "Item3", 20, 20))
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-item-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{id:2,name:Item2,price:10},{id:3,name:Item3,price:20}]"))
                .andReturn();
    }

}
