package a056__Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
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
}
