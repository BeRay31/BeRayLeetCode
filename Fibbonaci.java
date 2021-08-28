import java.util.*;

public class Fibbonaci {
  public static List<Integer> fibonacci(int n) {
    ArrayList<Integer> fibSeries = new ArrayList<>();
    fibSeries.add(0);
    if(n == 1) {
      return fibSeries;
    } 
    fibSeries.add(1);
    if(n == 2) {
      return fibSeries;
    }
    int currentIndex = 2;
    while(fibSeries.size() != n) {
      fibSeries.add(fibSeries.get(currentIndex - 1) + fibSeries.get(currentIndex - 2));
      currentIndex++;
    }
    System.out.println(fibSeries.toString());
    return fibSeries;
  }
  public static void main(String[] args) {
    fibonacci(10);
  }
}
