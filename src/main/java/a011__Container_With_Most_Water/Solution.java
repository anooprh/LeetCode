package a011__Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int ans = 0, l = 0, r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[r], height[l]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}