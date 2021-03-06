package avarice;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int length = s.length();

        // 先统计每个字符最后出现的位置
        int[] lastCharIndex = new int[26];
        for (int index = 0; index < length; index++) {
            lastCharIndex[s.charAt(index) - 'a'] = index;
        }

        // 开始分片段
        List<Integer> labelsSizeList = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int index = 0; index < length; index++) {
            end = Math.max(lastCharIndex[s.charAt(index) - 'a'], end);
            if (index == end) {
                labelsSizeList.add(end - start + 1);
                start = end + 1;
            }
        }

        return labelsSizeList;
    }
}
