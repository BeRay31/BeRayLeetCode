package beray.leetcode.AlgorithmStudies.Day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
  private int[] tc = new int[]{-1,0,3,5,9,12};
  @Test
  public void ShouldFindTargetNumberWithRecursiveMethod() {
    BinarySearch bin = new BinarySearch();
    Assertions.assertEquals(4, bin.recursiveSolution(tc, 9));
  }

  @Test
  public void ShouldNotFindTargetNumberWithRecursiveMethod() {
    BinarySearch bin = new BinarySearch();
    Assertions.assertEquals(-1, bin.recursiveSolution(tc, 55));
  }

  @Test
  public void ShouldFindTargetNumberWithSequentialMethod() {
    BinarySearch bin = new BinarySearch();
    Assertions.assertEquals(4, bin.sequentialBinarySearch(tc, 9));
  }

  @Test
  public void ShouldNotFindTargetNumberWithSequentialMethod() {
    BinarySearch bin = new BinarySearch();
    Assertions.assertEquals(-1, bin.sequentialBinarySearch(tc, 55));
  }

}
