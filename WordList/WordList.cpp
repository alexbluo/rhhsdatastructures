#include <iostream>
#include <vector>
#include <string>

using namespace std;

class WordList
{
  vector<string> list;

public:
  void insertWord(string str)
  {
    list.push_back(str);
  };

  string nthWord(int n)
  {
    if ((n - 1) > list.size())
    {
      throw out_of_range("out of range");
    }

    return list.at(n - 1);
  };

  int size()
  {
    return list.size();
  };

  vector<string> getList() {
    return list;
  }
};