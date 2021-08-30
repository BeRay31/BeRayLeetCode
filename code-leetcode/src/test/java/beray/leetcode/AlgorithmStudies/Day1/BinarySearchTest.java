package beray.leetcode.AlgorithmStudies.Day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
  private static int[] tc = new int[]{-1,0,3,5,9,12};
  private static BinarySearch bin = new BinarySearch();

  @Test
  public void ShouldFindTargetNumber() {
    Assertions.assertEquals(4, bin.recursiveSolution(tc, 9));
    Assertions.assertEquals(4, bin.sequentialBinarySearch(tc, 9));
  }

  @Test
  public void ShouldNotFindTargetNumber() {
    Assertions.assertEquals(-1, bin.recursiveSolution(tc, 55));
    Assertions.assertEquals(-1, bin.sequentialBinarySearch(tc, 55));
  }

}
