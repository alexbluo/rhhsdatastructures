#include "WordDictionary.h"
#include <cassert>
#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

WordDictionary::WordDictionary() {
  head = NULL;
  nextNode = NULL;
  size = 0;
}

Node* WordDictionary::getHead() { return head; }

bool WordDictionary::compareStringsCaseInsensitive(string s1, string s2) {
  if (s1.length() != s2.length()) {
    return false;
  }

  for (int i = 0; i < s1.length(); i++) {
    if (tolower(s1.at(i)) != tolower(s2.at(i))) {
      return false;
    }
  }

  return true;
}

bool WordDictionary::isInList(Node* node, string str) {
  Node* cur = node;
  while (cur != NULL) {
    if (compareStringsCaseInsensitive(cur->value, str)) {
      return true;
    }
    cur = cur->next;
  }
  return false;
}

void WordDictionary::addWord(string word) {
  if (word.length() == 0 || (word.length() == 1 && word != "a" && word != "i" &&
                             word != "A" && word != "I")) {
    return;
  }

  if (isInDictionary(head, word)) {
    return;
  }

  Node* node = new Node();
  node->value = word;

  if (head == NULL) {
    head = node;
  } else {
    node->next = head;
    head = node;
  }

  if (nextNode == NULL)
    nextNode = node;

  size++;
}

int WordDictionary::length() { return size; }

string WordDictionary::nextWord() {
  if (nextNode == NULL) {
    return "";
  }

  string res = nextNode->value;
  nextNode = nextNode->next;

  return res;
}

bool WordDictionary::isInDictionary(Node* cur, string target) {
  if (cur == NULL) {
    return false;
  }
  if (compareStringsCaseInsensitive(cur->value, target)) {
    return true;
  } 

  return isInDictionary(cur->next, target);
}

void WordDictionary::reset() { nextNode = head; }

void WordDictionary::print() {
  Node* cur = head;
  while (cur != NULL) {
    cout << cur->value << endl;
    cur = cur->next;
  }
}

void WordDictionary::write(string fileName) {
  ofstream file;
  file.open(fileName);

  Node* cur = head;
  while (cur != NULL) {
    file << cur->value << endl;
    cur = cur->next;
  }
}

void WordDictionary::read(string fileName) {
  ifstream file;
  file.open(fileName, ios::in);
  string temp;

  vector<string> stack;
  while (getline(file, temp)) {
    stack.push_back(temp);
  }

  for (int i = stack.size() - 1; i >= 0; i--) {
    this->addWord(stack.at(i));
  }
}

void WordDictionary::prettyPrintTest(string description, string expected,
                                     string actual) {
  const char separator = ' ';
  cout << description << setw(30) << setfill(separator) << expected << setw(20)
       << setfill(separator) << actual << setw(20) << setfill(separator)
       << endl;
}

bool WordDictionary::testEverythingCopied() {
  for (int i = 10; i < 1000; i++) {
    if (!this->isInDictionary(head, to_string(i))) {
      return false;
    }
  }

  if (!this->isInDictionary(head, "a") || !this->isInDictionary(head, "test")) {
    return false;
  }

  return true;
}

void WordDictionary::test() {
  WordDictionary wd;
  prettyPrintTest("Description", "Expected", "Actual");

  prettyPrintTest("empty size", "0", to_string(wd.length()));

  wd.addWord("");
  prettyPrintTest("add empty string", "", wd.nextWord());

  prettyPrintTest("size after adding empty string", "0",
                  to_string(wd.length()));

  wd.addWord("test");
  prettyPrintTest("add test and nextWord", "test", wd.nextWord());

  prettyPrintTest("nextWord when nextNode is null (at end)", "", wd.nextWord());

  wd.addWord("TeST");
  wd.reset();
  prettyPrintTest("add TeST and reset and nextWord", "test", wd.nextWord());

  wd.reset();
  prettyPrintTest("reset with one item and nextWord", "test", wd.nextWord());

  wd.addWord("a");
  prettyPrintTest("add a then size", "2", to_string(wd.length()));
  wd.reset();
  string temp1 = wd.nextWord();
  prettyPrintTest("reset and nextWord", "nextWord is a or test",
                  (temp1 == "a" || temp1 == "test")
                      ? "nextWord is a or test"
                      : "nextWord is not a or test");

  string temp2 = wd.nextWord();
  prettyPrintTest("nextWord again", "nextWord is a or test",
                  (temp2 == "a" || temp2 == "test")
                      ? "nextWord is a or test"
                      : "nextWord is not a or test");

  wd.addWord("A");
  wd.reset();
  string temp3 = wd.nextWord();
  prettyPrintTest("add A then nextWord", "nextWord is a or test",
                  (temp3 == "a" || temp3 == "test")
                      ? "nextWord is a or test"
                      : "nextWord is not a or test");

  string temp4 = wd.nextWord();
  prettyPrintTest("nextWord again", "nextWord is a or test",
                  (temp4 == "a" || temp4 == "test")
                      ? "nextWord is a or test"
                      : "nextWord is not a or test");

  wd.addWord("m");
  prettyPrintTest("add m then isInDictionary m", "false",
                  wd.isInDictionary(wd.getHead(), "m") ? "true" : "false");

  prettyPrintTest("isInDictionary test", "true",
                  wd.isInDictionary(wd.getHead(), "test") ? "true" : "false");

  prettyPrintTest("isInDictionary TeST", "true",
                  wd.isInDictionary(wd.getHead(), "TeST") ? "true" : "false");

  prettyPrintTest("isInDictionary i aint here", "false",
                  wd.isInDictionary(wd.getHead(), "i aint here") ? "true" : "false");

  for (int i = 10; i < 1000; i++) {
    wd.addWord(to_string(i));
  }

  prettyPrintTest("size after adding 990 items", "992", to_string(wd.length()));

  wd.write("input.txt");

  WordDictionary readWd;
  readWd.read("input.txt");
  readWd.reset();
  prettyPrintTest("write and read into new object", "992",
                  to_string(wd.length()));

  prettyPrintTest("everything is copied", "true",
                  readWd.testEverythingCopied() ? "true" : "false");
}