public class TreeNode {
  private String pattern;
  private WordList list;
  private TreeNode left;
  private TreeNode right;

  TreeNode(String word, String pat) {
    pattern = pat;
    list = new WordList();
    list.insertWord(word);
    left = null;
    right = null;
  }

  public String getPattern() {
    return pattern;
  }

  public WordList getList() {
    return list;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setPattern(String str) {
    pattern = str;
  }

  public void setList(WordList wl) {
    list = wl;
  }

  public void setLeft(TreeNode node) {
    left = node;
  }

  public void setRight(TreeNode node) {
    right = node;
  }
}
