import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatternTableEfficiencyTester {
  private static final String[] LETTER_BANK = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()<>;_+-=".split("");

  public static String randomWord() {
    int length = (int) (Math.random() * 8 + 1);
    String word = "";

    for (int i = 0; i < length; i++) {
      word += LETTER_BANK[(int) (LETTER_BANK.length * Math.random())];
    }

    return word;
  }

  public static WordList tonsOfWords(int n) {
    WordList wl = new WordList();

    for (int i = 0; i < n; i++) {
      String word = randomWord();

      while (wl.getList().contains(word)) {
        word = randomWord();
      }

      wl.insertWord(word);
    }

    return wl;
  }

  public static void evaluateTableEfficiency(PatternTable table) {
    WordList words = tonsOfWords(200000);

    ArrayList<Long> time1 = new ArrayList<>();
    ArrayList<Long> time2 = new ArrayList<>();
    ArrayList<Long> time3 = new ArrayList<>();
    ArrayList<Long> total = new ArrayList<>();

    // PatternTable tm = new TreeMapPatternTable();
    for (int i = 0; i < 1000; i++) {
      // TODO: CHANGE
      table = new HashMapPatternTable();
      long base = System.currentTimeMillis();

      for (int n = 0; n < 100000; n++) {
        table.addWord(words.nthWord(n));
      }

      time1.add(System.currentTimeMillis() - base);

      base = System.currentTimeMillis();

      for (int n = 0; n < 100000; n++) {
        table.wordsWithSamePatternAs(words.nthWord(n));
      }

      time2.add(System.currentTimeMillis() - base);

      base = System.currentTimeMillis();

      for (int n = 100000; n < 200000; n++) {
        table.wordsWithSamePatternAs(words.nthWord(n));
      }

      time3.add(System.currentTimeMillis() - base);

      total.add(time1.get(i) + time2.get(i) + time3.get(i));
    }

    try (
        FileWriter writer = new FileWriter("runtimes.csv");
        BufferedWriter csv = new BufferedWriter(writer)) {
      csv.append(
          "\"Insertion time\",\"Successful retrieval time\",\"Unsuccessful retrieval time\",\"Total time\"\n");
      for (int i = 0; i < 1000; i++) {
        csv.append(String.valueOf(time1.get(i))).append(",");
        csv.append(String.valueOf(time2.get(i))).append(",");
        csv.append(String.valueOf(time3.get(i))).append(",");
        csv.append(String.valueOf(total.get(i)));
        csv.append("\n");
      }

      double avg1 = 0;
      double avg2 = 0;
      double avg3 = 0;
      double avgTotal = 0;

      for (long i : time1) {
        avg1 += i;
      }

      avg1 = avg1 / 1000;

      for (long i : time2) {
        avg2 += i;
      }

      avg2 = avg2 / 1000;

      for (long i : time3) {
        avg3 += i;
      }

      avg3 = avg3 / 1000;

      for (long i : total) {
        avgTotal += i;
      }

      avgTotal = avgTotal / 1000;

      csv.append(String.valueOf(avg1)).append(",");
      csv.append(String.valueOf(avg2)).append(",");
      csv.append(String.valueOf(avg3)).append(",");
      csv.append(String.valueOf(avgTotal));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // TODO: CHANGE
    evaluateTableEfficiency(new HashMapPatternTable());
  }
}