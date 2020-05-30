package com.example.mockitotesting;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SomeBusinessImplMockTest {

    @Test
    void findTheGreatestFromAllData() {
      DataService dataServiceMock = mock(DataService.class);
      when(dataServiceMock.retrieveAllData()).thenReturn((new int[] {30, 10, 2}));

      SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
      int result =  businessImpl.findTheGreatestFromAllData();
      assertEquals(30,result);
    }
}
