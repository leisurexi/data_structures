package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * leetcode题号 26.删除排序数组中的重复项
 *
 * @author: leisurexi
 * @date: 2020-03-15 22:18
 * @since JDK 1.8
 */
@Slf4j
public class RemoveDuplicatesFromSortedArray {

    /**
     * 题目描述:
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *  
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int index = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > last) {
                nums[i] = last;
                nums[++index] = num;
                last = num;
            }
        }
        return index + 1;
    }

    /**
     * 方法：双指针法
     * 算法
     * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。
     * 只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
     * 当我们遇到 nums[j] \neq nums[i]nums[j]=nums[i] 时，跳过重复项的运行已经结束，
     * 因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。然后递增 ii，
     * 接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
     */
    public static int removeDuplicates_2(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
//        log.info(String.valueOf(removeDuplicates(nums)));
        log.info(String.valueOf(removeDuplicates_2(nums)));
        log.info(Arrays.toString(nums));
    }

}
