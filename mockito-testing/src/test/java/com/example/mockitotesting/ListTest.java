package com.example.mockitotesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ListTest {

  @Test
  public void test() {
    List listMock = mock(List.class);
    when(listMock.size()).thenReturn(10);
    assertEquals(10, listMock.size());
  }

  @Test
  public void test_multipleReturns() {
    List listMock = mock(List.class);
    when(listMock.size()).thenReturn(10).thenReturn(20);
    assertEquals(10, listMock.size());
    assertEquals(20, listMock.size());
    assertEquals(20, listMock.size());
  }

  @Test
  public void test_get() {
    List listMock = mock(List.class);
    when(listMock.get(0)).thenReturn("SomeString");
    assertEquals("SomeString", listMock.get(0));
    assertEquals(null, listMock.get(1));
  }

  @Test
  public void test_getGenericParameter() {
    List listMock = mock(List.class);
    when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
    assertEquals("SomeString", listMock.get(0));
    assertEquals("SomeString", listMock.get(1));
  }
}
