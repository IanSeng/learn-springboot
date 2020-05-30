import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    MyMath myMath = new MyMath();

    @BeforeEach
    public void before() {
      System.out.println("Before");
    }
    @Test
    void sum_with3numbers() {
      int result = myMath.sum(new int[] {1,2,3});

      assertEquals(6, result);
    }

  @Test
  void sum_with1number() {
    int result = myMath.sum(new int[] {3});

    assertEquals(3, result);
  }

  @AfterEach
  public void after() {
    System.out.println("After");
  }
}
