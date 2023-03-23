import java.util.ArrayList;

public class WordList {
  ArrayList<String> list = new ArrayList<>();

  public void insertWord(String str) {
    list.add(str);
  }

  public String nthWord(int n) {
    return list.get(n);
  }

  public int size() {
    return list.size();
  }

  ArrayList<String> getList() {
    return list;
  };

  public String toString() {
    String ans = "";

    for (String word : list) {
      ans += word + "\n";
    }

    return ans;
  }
}