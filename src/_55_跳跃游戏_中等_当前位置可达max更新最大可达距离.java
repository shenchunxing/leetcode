/**
 * https://leetcode.cn/problems/jump-game/
 */
public class _55_跳跃游戏_中等_当前位置可达max更新最大可达距离 {
    /**
     * 贪心：每遍历到一个位置i，如果位置可达，记录最大的可达位置i + nums[i]
     * O(n) O(1)
     * [2, 3, 1, 1, 4]
     * 一开始更新位置在0，跳跃长度2，更新rightmost = 2
     *
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;//最远可达位置
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) { //首先必须保证当前位置i是可达的，如果i + nums[i] > y,说明y也可达
                rightmost = Math.max(rightmost , i + nums[i]); //更新最远可达位置
                if (rightmost >= n - 1) return true; //最远可达距离>=最后的位置
            }
        }
        //遍历结束了，无法可达
        return false;
    }
}
