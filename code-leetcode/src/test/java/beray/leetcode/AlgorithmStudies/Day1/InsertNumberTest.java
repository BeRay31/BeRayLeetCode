package beray.leetcode.AlgorithmStudies.Day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertNumberTest {
  public static InsertNumber insertor = new InsertNumber();
  @Test
  public void ShouldInsertInTheMiddleOfTheArray() {
    int[] tc = new int[]{4,5,7,7,8,9,11};
    Assertions.assertEquals(2, insertor.binaryInsert(tc, 6));
    Assertions.assertEquals(2, insertor.sequentialInsert(tc, 6));
  }
}
