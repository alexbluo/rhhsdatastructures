import java.util.AbstractMap;

public class MapPatternTable extends PatternTable {
  protected AbstractMap<String, WordList> map;

  public void addWord(String word) {
    String pat = PatternMaker.makePattern(word);

    map.putIfAbsent(pat, new WordList());
    map.get(pat).insertWord(word);
  }

  public WordList wordsWithSamePatternAs(String word) {
    String pat = PatternMaker.makePattern(word);

    return map.getOrDefault(pat, new WordList());
  }
}