---
layout: post
title: Two Sum
---
#[Two Sum](https://leetcode.com/problems/two-sum/)

### Problem Statement

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Observation

The assumptions make the solution/input cases easier to handle.

Example given 

````
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
````

### Solution

We can solve this problem by keeping a HashMap with `key : number_in_array` and `value : index_in_array` while looping through the array. For every number in the array, we try to look for it's complementary number in the array. If we find such a number, we return the indices of these two numbers, which we have saved in the hashmap. 
  
```Java
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
```

### Analysis

Since we are looping through the array only once, __    Time Complexiy : O(n)__ and HashMap can save upto 'n' elements, __Auxillary Space complexity : O(n)__