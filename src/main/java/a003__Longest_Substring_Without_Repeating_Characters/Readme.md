#[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### Problem Statement

Given a string, find the length of the longest substring without repeating characters

### Observation

The question tells to find the longest substring(not subsequence) without repeating characters

Example given 

````
Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
````

### Solution

This problem can be solved by using a HashMap to keep track of the characters observed as we loop through the characters of the string. We save the __key : character__ and the __value : position of character__ in the hashmap. 

If we dont find the character in the string, we simply save it in the HashMap. If it is already found in the HashMap, we find the result till that point and update our best answer if it is beats any existing answer. 
 

````
// example, "abcabcbb"

set start of string(st) to 0 , best ans = 0
a  --> map contains 'a' ? : No --> Add {a,0}
b  --> map contains 'b' ? : No --> Add {b,1}
c  --> map contains 'c' ? : No --> Add {c,2}
a  --> map contains 'a' ? : Yes--> compute the answer till that point 
    => i - st -> 3 ("abc"), beats existing ans of 0, update ans
    => update start of string to next pos, update position of "a"
...
...
...
Till end of string. 

After loop, check for the case where the end of the string is one of the answer. 
````

```Java
    // Java Solution
    public int lengthOfLongestSubstring(String s) {
        int st = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                ans = Math.max(i - st, ans);

                st = Math.max(st, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            }
        }
        ans = Math.max(s.length() - st, ans);
        return ans;
    }
```

### Analysis

Since we are looping through the string only once, __Time Complexiy : O(n)__ and HashMap can save upto 'n' elements, __Auxillary Space complexity : O(n)__