#include <iostream>
#include "PatternMaker.h"

using namespace std;

int main()
{
  PatternMaker pm;

  pm.TestMakePattern("baboon", "ABACCD");
  pm.TestMakePattern("cat", "ABC");
  pm.TestMakePattern("where", "ABCDC");
  pm.TestMakePattern("moon", "ABBC");
  pm.TestMakePattern("qwertyuiopasdfghjklzxcvbnm", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
  pm.TestMakePattern("ddaaddabbdda", "AABBAABCCAAB");
  pm.TestMakePattern("oPpOsItioN", "ABBACDEDAF");
  pm.TestMakePattern("llama", "AABCB");
  pm.TestMakePattern("dddd", "AAAA");

  return 0;
}
