#include "WordList.cpp"

using namespace std;

int main()
{
  WordList wl;

  wl.insertWord("1");
  cout << wl.nthWord(1) << endl;
  assert(wl.nthWord(1) == "1");

  for (int i = 2; i < 1000; i++) {
    wl.insertWord(to_string(i));
  }

  cout << wl.nthWord(999) << endl;
  assert(wl.nthWord(999) == "999");

  cout << wl.size() << endl;
  assert(wl.size() == 999);

  try {
    wl.nthWord(1000);
  } catch (const out_of_range& e) {
    cout << "out of range" << endl;
  }



  return 0;
}