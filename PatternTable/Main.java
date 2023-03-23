public class Main {
  public static void main(String[] args) {
    PatternTable test = new TreeMapPatternTable();

    String[] words = "According to all known laws of aviation, there is no way that a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway because bees don't care what humans think is impossible. We know that you, as a bee, have worked your whole life to get to the point where you can work for your whole life. Honey begins when our valiant Pollen Jocks bring the nectar to the hive. Our top-secret formula is automatically color-corrected, scent-adjusted and bubble-contoured into this soothing sweet syrup with its distinctive golden glow you know as..."
        .split(" ");
    System.out.println(words.length);

    for (int i = 0; i < words.length; i++) {
      test.addWord(words[i]);
    }

    System.out.println("same pattern as ABB: " + test.wordsWithSamePatternAs("ABB"));
    System.out.println("same pattern as BEE: " + test.wordsWithSamePatternAs("BEE"));
    System.out.println("same pattern as YELLOW: " + test.wordsWithSamePatternAs("YELLOW"));
    System.out.println("same pattern as RWHERILUN#@IUGBUE: " + test.wordsWithSamePatternAs("RWHERILUN#@IUGBUE"));
    System.out.println("same pattern as ACCORDING: " + test.wordsWithSamePatternAs("ACCORDING"));
    System.out.println("same pattern as AVIATION,: " + test.wordsWithSamePatternAs("aviation,"));
  }
}
