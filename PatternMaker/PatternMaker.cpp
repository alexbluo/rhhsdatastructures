#include <string>
#include <map>
#include <iostream>
#include <cassert>
#include "PatternMaker.h"

using namespace std;

string PatternMaker::MakePattern(string str)
{
  string ans = "";
  map<char, int> dict;
  int inc = 0;

  for (int i = 0; i < str.length(); i++)
  {
    char upper = toupper(str[i]);

    if (dict.find(upper) == dict.end())
    {
      dict[upper] = inc;
      inc++;
    }

    ans += static_cast<char>(65 + dict[upper]);
  }

  return ans;
}

bool PatternMaker::TestMakePattern(string str, string expected)
{
  PatternMaker pm;
  string res = pm.MakePattern(str);

  assert(res == expected);
  return false;
}