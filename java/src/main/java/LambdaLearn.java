import java.util.Arrays;
import java.util.List;

interface A {
  void show();
}

class Xyz implements A {
  public void show() {
    System.out.println("Hello");
  }
}

public class LambdaLearn {
  public static void main(String args[]) {
    List<Integer> values = Arrays.asList(6, 7, 8, 9, 10);

    // simple lambda expression
    values.forEach(i -> System.out.println(i));

    // old way of creating a class to impletement interface
    A obj;
    obj = new Xyz();
    obj.show();

    // same method but with anonymous inner class
    A obj2;
    obj2 = new A() {  // this a anonymous inner class
      public void show(){
        System.out.println("hello2");
      }
    };
    obj2.show();

    // using lambda way
    A obj3 = () -> System.out.println("hello3");
    obj3.show();

  }
}
