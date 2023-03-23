#include <iostream>
#include <string>

using namespace std;

struct Node {
  Node* next;
  string value;
};

class WordDictionary {
public:
  WordDictionary();
  void addWord(string word);
  string nextWord();
  bool isInDictionary(Node* cur, string target);
  void reset();
  void print();
  void write(string fileName);
  void read(string fileName);
  void test();
  int length();
  bool testEverythingCopied();
  Node* getHead();

private:
  int size;
  Node* head;
  Node* nextNode;

  bool isInList(Node* node, string str);
  // Node* insertInListIfNecessary(Node* node, string str);
  void prettyPrintTest(string description, string expected, string actual);
  bool compareStringsCaseInsensitive(string s1, string s2);
};