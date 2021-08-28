package FunChallenges;
import java.util.ArrayList;
import java.util.List;

public class SelectingStocks {
  public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
    // Write your code here
    // Knapsack problem
    ArrayList<Integer> income = new ArrayList<>();
    for(int i = 0; i < currentValue.size(); i++) {
      income.add(futureValue.get(i)-currentValue.get(i));
    }
    return selecStockKnapsackRecursive(saving, currentValue, income, currentValue.size());

  }
  public static int selecStockKnapsackRecursive(int weightMax, List<Integer> currentValue, List<Integer> income, int n) {
    if(n == 0 || weightMax == 0) {
      return 0; //base
    }
    if(currentValue.get(n-1) > weightMax) {
      return selecStockKnapsackRecursive(weightMax, currentValue, income, n-1);
    } else {
      return Math.max(
        income.get(n-1)+selecStockKnapsackRecursive(weightMax-currentValue.get(n-1), currentValue, income, n-1), 
        selecStockKnapsackRecursive(weightMax, currentValue, income, n-1)
      );
    }
  }
}
