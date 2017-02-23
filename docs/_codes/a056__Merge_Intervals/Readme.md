---
layout: post
title: Merge Intervals
---
#[Merge Intervals](https://leetcode.com/problems/merge-intervals/)

### Problem Statement

Given a collection of intervals, merge all overlapping intervals.


### Observation

A Collection of intervals is a list of intervals. In the example given, intervals 1 & 2 overlap, so they should be merged. The other intervals don't overlap so they should be returned as it is. 

Example given 

````
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]

````


### Solution

Before we proceed to solve the question, we should dispense the base cases for this problem
1. When input list is `null` ==> return `null`
2. When input list is empty ==> return an empty list

Once we handle these two cases, we are guaranteed that we have at least 1 element in our list before we start our solution. We then sort the list (any `n*log(n)` sort) by their starting indices. 

We record the starting index `s` and end ending index `e` of the first interval. We then iterate over the remaining elements in this list. On reaching every element in the list, we check if its start falls before the previously recorded `e`. If it falls before, then there should be a merge. But we are not sure if this is that last element in the merge or not, so we simply update `e` with `max(e , this_interval.end)` and defer the decision to add the interval till we are sure that a discontinuity emerges(or loop terminates). 
   
If there is no overlap i.e `e < this_interval.start` we add an interval with previously recorded `s` and `e` and we reset `s` and `e` with the `start` and `end` of this interval. After we get out of the iteration, we have to add one more interval to the result with remaining `s` and `e` to cover the complete ranges. 


```Java
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null)return null;
        if(intervals.isEmpty())return new ArrayList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        ArrayList<Interval> result = new ArrayList<>();
        for(int i = 1; i < intervals.size(); ++i){
            Interval interval = intervals.get(i);
            if(interval.start <= e){
                e = Math.max(interval.end, e);
            } else {
                result.add(new Interval(s, e));
                s = interval.start;
                e = interval.end;
            }
        }
        result.add(new Interval(s,e));

        return result;
    }

```

### Analysis

Here we sort the input list by their start indices. We end up spending __O(n*log(n))__ in this step of the algorithm. Hence the time complexity is __O(n*log(n))__. However, if we are given a condition that the input list is sorted (either by their start or end indices), then we can eliminate the sort step and the rest of the algorithm can be completed in linear time as we loop over the list only once. i.e If we know the input list is sorted the time complexity reduces to __O(n)__

We are generating new Intervals for the result here, so auxiliary space complexity is __O(n)__. We can try to improve it reuse the input list but we will (1) Lose the input list (2) Worst case space complexity still remains __O(n)__