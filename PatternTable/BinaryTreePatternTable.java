public class BinaryTreePatternTable extends PatternTable {
  private TreeNode root;

  BinaryTreePatternTable() {
    root = null;
  }

  public WordList wordsWithSamePatternAs(String word) {
    String pat = PatternMaker.makePattern(word);
    WordList ans = findPatternInTree(pat, root);

    return ans;
  }

  private WordList findPatternInTree(String pat, TreeNode tree) {
    if (tree == null) {
      return new WordList();
    } else if (tree.getPattern().equals(pat)) {
      return tree.getList();
    } else if (tree.getPattern().compareTo(pat) < 0) {
      return findPatternInTree(pat, tree.getLeft());
    } else {
      return findPatternInTree(pat, tree.getRight());
    }
  }

  public void addWord(String word) {
    String pat = PatternMaker.makePattern(word);

    addWordToTree(word, pat, root);
  }

  private TreeNode addWordToTree(String word, String pat, TreeNode tree) {
    if (root == null) {
      root = new TreeNode(word, pat);
    } else {
      if (tree == null) {
        tree = new TreeNode(word, pat);
      } else if (tree.getPattern().equals(pat)) {
        // if (!tree.getList().getList().contains(word)) {
        tree.getList().insertWord(word);
        // }
      } else if (tree.getPattern().compareTo(pat) < 0) {
        tree.setLeft(addWordToTree(word, pat, tree.getLeft()));
      } else {
        tree.setRight(addWordToTree(word, pat, tree.getRight()));
      }
      return tree;
    }

    return null;
  }

  public String traversePreOrder(TreeNode root) {

    if (root == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(root.getPattern());

    String pointerRight = "└──";
    String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

    traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
    traverseNodes(sb, "", pointerRight, root.getRight(), false);

    return sb.toString();
  }

  public void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node, boolean hasRightSibling) {
    if (node != null) {
      sb.append("\n");
      sb.append(padding);
      sb.append(pointer);
      sb.append(node.getPattern());

      StringBuilder paddingBuilder = new StringBuilder(padding);
      if (hasRightSibling) {
        paddingBuilder.append("│  ");
      } else {
        paddingBuilder.append("   ");
      }

      String paddingForBoth = paddingBuilder.toString();
      String pointerRight = "└──";
      String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

      traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
      traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
    }
  }

}
