package com.example.mockitotesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockAnnotationsTest {
  @Mock
  DataService dataServiceMock;

  @InjectMocks
  SomeBusinessImpl businessImpl;

  @Test
  void testFindTheGreatestFromAllData() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 100, 15, 3 });
    assertEquals(100, businessImpl.findTheGreatestFromAllData());
  }



}
