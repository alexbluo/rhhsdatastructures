import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordDictionary {
  private int max = 11;
  private int size = 0;
  private int cur = 0;
  private String[] table = new String[max];
  private ArrayList<String> next = new ArrayList<>();

  public void addWord(String word) {
    if (word.trim().length() == 0 || (word.length() == 1 && !word.equals("a") && !word.equals("i") &&
        !word.equals("A") && !word.equals("I"))) {
      return;
    }

    if (isInDictionary(word)) {
      return;

    }

    table[rehash(word, 0, table)] = word;

    size += 1;

    if ((double) size / max > .5) {
      resize();
    }
  }

  public int size() {
    return size;
  }

  private void resize() {
    max = max * 2;
    String[] newTable = new String[max];

    for (String word : table) {
      if (word != null) {
        newTable[rehash(word, 0, newTable)] = word;
      }
    }

    table = newTable;
  }

  private int rehash(String word, int i, String[] table) {
    int pos = (Math.abs(word.toLowerCase().hashCode()) + (int) Math.pow(i, 2)) % max;

    if (table[pos] == null) {
      return pos;
    } else {
      return rehash(word, i + 1, table);
    }
  }

  public String nextWord() {
    for (int i = 0; i < max; i++) {
      if (!next.contains(table[i]) && table[i] != null) {
        next.add(table[i]);
      }
    }
    if (cur >= size)
      return null;

    String ans = next.get(cur);

    cur++;

    return ans;
  }

  public void reset() {
    cur = 0;
  }

  public void write(String filename) {
    try (
        FileWriter writer = new FileWriter(filename);
        BufferedWriter csv = new BufferedWriter(writer)) {
      for (int i = 0; i < max; i++) {
        if (table[i] != null) {
          csv.append(table[i]).append("\n");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean isInDictionary(String word) {
    int pos = Math.abs(word.toLowerCase().hashCode()) % max;

    int i = 1;
    while (table[pos] != null) {
      if (table[pos].equalsIgnoreCase(word))
        return true;

      pos = ((Math.abs(word.toLowerCase().hashCode()) + (int) Math.pow(i, 2))) % max;
      i++;
    }

    return false;
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    // System.out.println("Description \t\t\t Expected \t\t Output");
    // System.out.println("----------- \t\t\t -------- \t\t ------");

    // print("empty size", "0", "size is " + wd.size());

    // wd.addWord("");
    // print("add empty String", "0", "size is " + wd.size());

    // print("empty String nextWord", "", wd.nextWord());

    // print("size after adding empty String", "0",
    // Integer.toString(wd.size()));

    // wd.addWord("test");
    // print("add test and nextWord", "test", wd.nextWord());

    // print("nextWord when nextNode is null (at end)", "", wd.nextWord());

    // wd.addWord("TeST");
    // wd.reset();
    // print("add TeST and reset and nextWord", "test", wd.nextWord());

    // wd.reset();
    // print("reset with one item and nextWord", "test", wd.nextWord());

    // wd.addWord("a");
    // print("add a then size", "2", Integer.toString(wd.size()));
    // wd.reset();
    // String temp1 = wd.nextWord();
    // print("reset and nextWord", "nextWord is a or test",
    // (temp1 == "a" || temp1 == "test")
    // ? "nextWord is a or test"
    // : "nextWord is not a or test");

    // String temp2 = wd.nextWord();
    // print("nextWord again", "nextWord is a or test",
    // (temp2 == "a" || temp2 == "test")
    // ? "nextWord is a or test"
    // : "nextWord is not a or test");

    // wd.addWord("A");
    // wd.reset();
    // String temp3 = wd.nextWord();
    // print("add A then nextWord", "nextWord is a or test",
    // (temp3 == "a" || temp3 == "test")
    // ? "nextWord is a or test"
    // : "nextWord is not a or test");

    // String temp4 = wd.nextWord();
    // print("nextWord again", "nextWord is a or test",
    // (temp4 == "a" || temp4 == "test")
    // ? "nextWord is a or test"
    // : "nextWord is not a or test");

    // wd.addWord("m");
    // print("add m then IsInDictionary m", "false",
    // wd.isInDictionary("m") ? "true" : "false");

    // print("IsInDictionary test", "true",
    // wd.isInDictionary("test") ? "true" : "false");

    // print("IsInDictionary TeST", "true",
    // wd.isInDictionary("TeST") ? "true" : "false");

    // print("IsInDictionary i aint here", "false",
    // wd.isInDictionary("i aint here") ? "true" : "false");

    // for (int i = 10; i < 1000; i++) {
    // wd.addWord(Integer.toString(i));
    // }

    // print("size after adding 990 items", "992", wd.size());
    for (int i = 0; i < 50010; i++) {
      wd.addWord(Integer.toString(i));
    }
    System.out.println(wd.size());

    wd.write("WordDictionary.csv");
  }

  private static <D, E, O> void print(D description, E expected, O output) {
    System.out.println(description + " \t\t\t " + "expected " + expected + "\t\t" + "outputted " + output);
  }
}
