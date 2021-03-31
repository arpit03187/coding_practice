package patterns.slidingWindow;

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    Map<Character, Integer> characterFreq = new HashMap<>();
    int windowStart = 0;
    int maxLength = Integer.MIN_VALUE;
    int windowLength = 0;

    for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      characterFreq.put(rightChar, characterFreq.getOrDefault(rightChar,0) + 1);
      
      while(characterFreq.size() > k) {
        char leftChar = str.charAt(windowStart);
        characterFreq.put(leftChar, characterFreq.get(leftChar) - 1);
        if (characterFreq.get(leftChar) == 0) {
          characterFreq.remove(leftChar);
        }
        windowStart++;
      }
      windowLength = windowEnd - windowStart + 1;
      maxLength = Math.max(maxLength, windowLength);
    }


    return maxLength;
  }
}