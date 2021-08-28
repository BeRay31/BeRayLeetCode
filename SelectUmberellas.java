import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectUmberellas {
  public static int getUmbrellas(int requirement, List<Integer> sizes) {
    // Write your code here
    if(sizes.contains(requirement)) {
      return 1;
    }
    Collections.sort(sizes, Collections.reverseOrder());
    ArrayList<Integer> usedUmberellas = new ArrayList<>();
    int uncoveredPeople = requirement;
    int index = 0;
    int numUmberella = sizes.size();
    while(uncoveredPeople > 0 && index < numUmberella) {
      if(uncoveredPeople-sizes.get(index) < 0) {
        index++;
      } else {
        
      }
    }
  }
}
