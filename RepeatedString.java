public class RepeatedString {
  public static long solution(String s, long n) {
    long numA = 0;
    long sLength = s.length();
    long numPerfectRepeated = n/sLength;
    long stringLeft = n - (numPerfectRepeated*sLength);
    long subNumA = 0;
    for(int i = 0; i < sLength; i++) {
      if(s.charAt(i) == 'a') {
        numA++;
      }
      if(i == stringLeft - 1) {
        subNumA = numA;
      }
    }
    return numA*numPerfectRepeated + subNumA;
  }
  public static void main(String[] args) {
    System.out.println(solution("a", 1000000000));
  }
}
