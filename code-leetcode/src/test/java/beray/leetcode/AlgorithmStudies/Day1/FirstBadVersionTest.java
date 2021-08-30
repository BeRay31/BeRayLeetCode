package beray.leetcode.AlgorithmStudies.Day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstBadVersionTest {
  public static int badVersion = 19;
  @Test
  public void ShouldFindFirstBadVersion() {
    FirstBadVersion finder = new FirstBadVersion(FirstBadVersionTest.badVersion);
    Assertions.assertEquals(19, finder.firstBad(50));
  }
}
