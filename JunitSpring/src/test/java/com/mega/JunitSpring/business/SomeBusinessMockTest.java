/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.business;

import com.mega.JunitSpring.data.SomeDataService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
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
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;
    
    @Mock
    SomeDataService someDataServiceMock;

    @BeforeEach
    public void before() {
        business.setSomeDataService(someDataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, business.calculateUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, business.calculateUsingDataService());
    }

}
