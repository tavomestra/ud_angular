/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author Asus
 */
public class JsonAssertTest {
    
    
    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    
    @Test
    public void jsonAssert() throws JSONException{
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
    
     @Test
    public void jsonAssertWhitoutEscapeCharanters() throws JSONException{
        String expectedResponse = "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    
}
