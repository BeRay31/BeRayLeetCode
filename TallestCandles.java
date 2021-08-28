import java.util.List;

public class TallestCandles {
  public int solution(List<Integer> candles) {
    int tallest = candles.get(0);
    int tall = 0;
    for(int candle : candles) {
      if(tallest == candle) {
        tall+=1;
      }
      if(tallest < candle) {
        tallest = candle;
        tall = 1;
      }
    }
    return tall;
  }
}
