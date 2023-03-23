#include <string>

using namespace std;

class WordMaker
{
private:
  string word;
  bool complete;

public:

  void reset();

  void addChar(char newChar);

  bool wordReady();

  string getWord();

  void FeedCharsOneAtATime(string chars);
};