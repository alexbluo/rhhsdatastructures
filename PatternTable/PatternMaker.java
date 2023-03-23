import java.util.HashMap;

public class PatternMaker {
  public static String makePattern(String str) {
    String ans = "";
    HashMap<Character, Integer> dict = new HashMap<>();
    int inc = 0;

    for (int i = 0; i < str.length(); i++) {
      char upper = str.substring(i, i + 1).toUpperCase().charAt(0);

      if (!dict.containsKey(upper)) {
        dict.put(upper, inc);
        inc++;
      }

      ans += (char) (65 + dict.get(upper));
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(makePattern("CAT"));
    System.out.println(makePattern("moOn"));
    System.out.println(makePattern("Mississippi"));
  }
}
