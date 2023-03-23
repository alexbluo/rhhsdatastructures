#include "WordMaker.h"
#include <iostream>

int main()
{
  WordMaker wm;

  wm.reset();

  wm.FeedCharsOneAtATime("One two THREE me.");

  wm.FeedCharsOneAtATime("Four, five \"six,\" sev\' \'tis  he\'s!");

  wm.reset();

  wm.FeedCharsOneAtATime("*&^>have a * nice/ /da");

  wm.reset();

  wm.FeedCharsOneAtATime("y.");

  return 0;
}