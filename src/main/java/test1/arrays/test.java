package test1.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {

        arrays_Solution a_sol = new arrays_Solution();
    }
}

class arrays_Solution{
    /**
     * 基础算法 1: 删除排序数组中的重复项
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 基础算法 2: 买卖股票的最佳时机 II
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rightpart, 0, nums, 0, k);
    }

    /**
     * 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        boolean res = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res = true;
            }
        }

        return res;
    }

    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        if (nums.length == 1) {
            res = nums[0];
        } else if (nums[0] != nums[1] && nums[1] == nums[2]) {
            res = nums[0];
        } else if (nums[nums.length - 1] != nums[nums.length - 2] && nums[nums.length - 2] == nums[nums.length - 3]) {
            res = nums[nums.length - 1];
        } else {
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    res = nums[i];
                }
            }
        }

        return res;
    }

    /**
     * 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> res_list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res_list.add(nums1[i]);
                ++i;
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            }
        }

        //把list转化为数组
        int[] res = new int[res_list.size()];
        for (int k = 0; k < res_list.size(); k++) {
            res[k] = res_list.get(k);
        }
        return res;
    }

    /**
     * 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int end = ++digits[n - 1];

        if (new Integer(end).toString().length() > 1) {
            digits[n - 1] = 0;
            if (n != 1) {
                for (int k = n - 2; k >= 0; k--) {
                    int res = ++digits[k];
                    if (k != 0) {
                        if (new Integer(res).toString().length() > 1) {
                            digits[k] = 0;
                        } else {
                            digits[k] = res;
                            break;
                        }
                    } else {
                        if (new Integer(res).toString().length() > 1) {
                            int[] res_arr = new int[n + 1];
                            res_arr[0] = 1;
                            res_arr[1] = 0;

                            System.arraycopy(digits, 1, res_arr, 2, n - 2);

                            digits = res_arr;
                        }
                    }
                }
            } else {
                int[] res_arr = new int[n + 1];
                res_arr[0] = 1;
                res_arr[1] = 0;
                digits = res_arr;
            }
        }

        return digits;
    }

    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        //一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res_int = new int[2];
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (nums[j] + nums[i] == target) {
                    res_int[0] = i;
                    res_int[1] = j;
                    break;
                } else {
                    ++j;
                }
            }
            ++i;
        }
        return res_int;
    }

    /**
     * 有效的数独
     * <p>
     * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;

                }
                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }

        return true;
    }

    /**
     * 旋转图像
     * <p>
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] res = new int[length][length];

        int x = 0;
        while (x < length) {
            int y = 0;
            while (y < length) {
                res[y][length - 1 - x] = matrix[x][y];
                ++y;
            }
            ++x;
        }
        int i = 0;
        while (i < length) {
            int j = 0;
            while (j < length) {
                matrix[i][j] = res[i][j];
                ++j;
            }
            ++i;
        }
    }
}



