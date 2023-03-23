class Test {
  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();

    System.out.println("Description \t\t\t Expected \t\t Output");
    System.out.println("----------- \t\t\t -------- \t\t ------");

    print("empty size", "0", "size is " + wd.Size());

    wd.AddWord("");
    print("add empty String", "0", "size is " + wd.Size());

    print("empty String NextWord", "", wd.NextWord());

    print("size after adding empty String", "0",
        Integer.toString(wd.Size()));

    wd.AddWord("test");
    print("add test and NextWord", "test", wd.NextWord());

    print("NextWord when nextNode is null (at end)", "", wd.NextWord());

    wd.AddWord("TeST");
    wd.Reset();
    print("add TeST and Reset and NextWord", "test", wd.NextWord());

    wd.Reset();
    print("Reset with one item and NextWord", "test", wd.NextWord());

    wd.AddWord("a");
    print("add a then size", "2", Integer.toString(wd.Size()));
    wd.Reset();
    String temp1 = wd.NextWord();
    print("Reset and NextWord", "NextWord is a or test",
        (temp1 == "a" || temp1 == "test")
            ? "NextWord is a or test"
            : "NextWord is not a or test");

    String temp2 = wd.NextWord();
    print("NextWord again", "NextWord is a or test",
        (temp2 == "a" || temp2 == "test")
            ? "NextWord is a or test"
            : "NextWord is not a or test");

    wd.AddWord("A");
    wd.Reset();
    String temp3 = wd.NextWord();
    print("add A then NextWord", "NextWord is a or test",
        (temp3 == "a" || temp3 == "test")
            ? "NextWord is a or test"
            : "NextWord is not a or test");

    String temp4 = wd.NextWord();
    print("NextWord again", "NextWord is a or test",
        (temp4 == "a" || temp4 == "test")
            ? "NextWord is a or test"
            : "NextWord is not a or test");

    wd.AddWord("m");
    print("add m then IsInDictionary m", "false",
        wd.IsInDictionary("m") ? "true" : "false");

    print("IsInDictionary test", "true",
        wd.IsInDictionary("test") ? "true" : "false");

    print("IsInDictionary TeST", "true",
        wd.IsInDictionary("TeST") ? "true" : "false");

    print("IsInDictionary i aint here", "false",
        wd.IsInDictionary("i aint here") ? "true" : "false");

    for (int i = 10; i < 1000; i++) {
      wd.AddWord(Integer.toString(i));
    }

    print("size after adding 990 items", "992", wd.Size());
  }

  private static <D, E, O> void print(D description, E expected, O output) {
    System.out.println(description + " \t\t\t " + "expected " + expected + "\t\t" + "outputted " + output);
  }
}