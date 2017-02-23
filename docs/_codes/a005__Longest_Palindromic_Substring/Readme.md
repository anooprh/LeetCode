---
layout: post
title: Longest Palindromic Substring
---
#[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

### Problem Statement

Given a string `s`, find the longest palindromic substring in `s`. You may assume that the maximum length of `s` is 1000.


### Observation

A palindromic string (or substring) is the one which reads the same when we read forward or backward, such as `"abcddcba"` or `"bb"`. We should keep in mind that the string is case sensitive and white space sensitive. So some examples which seem like palindromes are not really palindromes under this problem solution. ex : `"Aibophobia"` or "`Never Odd Or Even`" i.e we should treat every character as it is.
  
Also a string can have two or more longest palindromic substrings. In that case either of the answers will be accepted(as seen from the examples given).

Example given 

````
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
````

````
Input: "cbbd"

Output: "bb"
````

### Solution

One way in which this problem can be solved is by visiting all the possible mid points of the string and expanding around in both left and right directions till the palindromic property is violated. 
  
We can have odd and even length palindromes. For odd length palindromes, the mirror is on a central character, and for even length palindromes, the mirror is on an imaginary wall between 2 characters. 

For example , if have `s = babad` .

we have generate an array of 
```
odd = [{max palindrome length centered at b},
       {max palindrome length centered at a},
       {max palindrome length centered at b},
       {max palindrome length centered at a},
       {max palindrome length centered at d}]
```
In this case it will be `odd = [1,3,3,1,1]`

```
even = [{max palindrome length centered between b & a},
        {max palindrome length centered between a & b},
        {max palindrome length centered between a & b},
        {max palindrome length centered between b & a},
        {max palindrome length centered between a & d}]
```
In this case it will be `even = [0,0,0,0]`

We use helper methods `expand_odd()` and `expand_even()` to determine these values by expanding on both sides of the center. 

We keep track of the the longest palindromic substring length and the midpoint point of that substring , using which we can extract out the substring from `s`

```Java
    public String longestPalindrome(String s) {
        int l = s.length();
        int[] odd = new int[l];
        int[] even = new int[l - 1];
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < l; ++i) {
            odd[i] = expand_odd(s, i);
            if(odd[i] > maxLen){

                maxLen = odd[i];
                ans = s.substring(i-odd[i]/2, i+odd[i]/2+1);
            }
        }
        for (int i = 0; i < l - 1; ++i) {
            even[i] = expand_even(s, i);
            if(even[i] > maxLen){
                maxLen = even[i];
                ans = s.substring(i-even[i]/2+1, i+even[i]/2+1);
            }
        }

        return ans;
    }

    private int expand_even(String s, int pos) {
        int i = 0;
        while (pos - i >= 0 && pos + 1 + i < s.length() && s.charAt(pos - i) == s.charAt(pos + 1 + i)) i++;
        return i*2;
    }

    private int expand_odd(String s, int pos) {
        int i = 0;
        while (pos - i >= 0 && pos + i < s.length() && s.charAt(pos - i) == s.charAt(pos + i)) i++;
        return i*2 - 1;
    }
```

### Analysis

We visit each element twice , once for odd length palindromic string expansion and once for even palindromic string expansion. i.e `2n` times. In each of these `2n` times we could iterate on all the elements of the string i.e `n` times, resulting in the time complexity of O(2n * n) ==> __O(n<sup>2</sup>)__. We use `odd[]` and `even[]` here resulting in space complexity of __O(n)__, however they can removed by computing the results on the fly.
  
There is a better algorithm for implementing this solution i.e [Manacher's Algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher.27s_algorithm). This reduces the time complexity to __O(n)__. However the O(n<sup>2</sup>) is also acceptable by LeetCode judge