#include <string>
#include <iostream>
#include "WordMaker.h"

using namespace std;

void WordMaker::reset()
{
  word = "";
  complete = false;
}

void WordMaker::addChar(char newChar)
{
  if (newChar == '\'')
  {
    return;
  }
  else if (isalpha(newChar) && complete)
  {
    reset();
    word += newChar;
  }
  else if (isalpha(newChar))
  {
    word += newChar;
  }
  else
  {
    complete = true;
  }
}

bool WordMaker::wordReady()
{
  return complete;
}

string WordMaker::getWord()
{
  if (wordReady())
  {
    return word;
  }
  else
  {
    return "";
  }
}

void WordMaker::FeedCharsOneAtATime(string chars)
{
  for (int pos = 0; pos < chars.length(); pos++)
  {
    char cur = chars[pos];
    addChar(cur);
    if (wordReady())
    {
      cout << "getWord returns \'" + getWord() + "\'" << endl;
    }
    else
    {
      cout << "no word ready yet." << endl;
    }
  }
}