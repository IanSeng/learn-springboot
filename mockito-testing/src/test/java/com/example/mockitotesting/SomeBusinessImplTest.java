package com.example.mockitotesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData() {
      SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
     int result =  businessImpl.findTheGreatestFromAllData();
     assertEquals(15,result);
    }
}

class DataServiceStub implements DataService{
  @Override
  public int[] retrieveAllData() {
    return new int[] {4,6,15};
  }
}
