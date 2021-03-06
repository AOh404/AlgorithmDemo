package avarice;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canBePlantedCount = 0;
        int prevIndex = -1;
        int flowerbedSize = flowerbed.length;

        for (int index = 0; index < flowerbedSize; index++) {
            if (flowerbed[index] == 0) continue;

            if (prevIndex < 0) {
                // 计算整个花坛第一朵花之前可种植的最大数量；
                canBePlantedCount += index / 2;
            } else {
                // 计算两朵花之间可种植的最大数量
                int betweenSize = index - prevIndex - 1;
                canBePlantedCount += Math.abs(betweenSize - 1) / 2;
            }

            // 不需要计算最多种植量，所以达到条件可以退出；
            if (canBePlantedCount >= n) {
                return true;
            }

            prevIndex = index;
        }

        if (prevIndex < 0) {
            // 整个花坛都未种花，因此计算整个花坛可种植的最大数量
            canBePlantedCount += (flowerbedSize + 1) / 2;
        } else {
            // 计算整个花坛最后一朵花之后可种植的最大数量；
            canBePlantedCount += (flowerbedSize - 1 - prevIndex) / 2;
        }
        return canBePlantedCount >= n;
    }
}
