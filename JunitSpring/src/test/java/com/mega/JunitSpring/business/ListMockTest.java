/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.business;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Asus
 */
public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {

        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("hola");
        assertEquals("hola", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("hola");
        assertEquals("hola", mock.get(0));
        assertEquals("hola", mock.get(1));
    }

    //Para verificar si se llamó a un método en un objeto Mockito.verify puede usar el método Mockito.verify :
    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt()); // call 2
        verify(mock, atLeast(2)).get(anyInt()); // min 3 calls
        verify(mock, atLeastOnce()).get(anyInt()); // same as Mockito.atLeast(1)
        verify(mock, atMost(2)).get(anyInt()); // max 3 calls
        verify(mock, never()).get(2); // same as Mockito.times(0)
    }

    @Test
    public void argumentCapturing() {
        mock.add("hola");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("hola", captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing() {

        mock.add("hola");
        mock.add("hola1");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("hola", allValues.get(0));
        assertEquals("hola1", allValues.get(1));

    }

    @Disabled
    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));// null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test0");
        System.out.println(arrayListSpy.get(0));// null
        System.out.println(arrayListSpy.size()); // 0
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size()); // 0
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
    }

}
