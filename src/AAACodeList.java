import jk.*;
import leetcode.*;
import offer.*;
import dfs.*;
import leetcode_cn.*;
import dp_study_project.*;

/**
 * --------------------https://www.nowcoder.com/ta/coding-interviews----------------------------------------------
 * 【重新建立一个二叉树】+             {@link JZ7}
 * 【旋转数组的最小数字】+             {@link JZ11} [数组]
 * 【上楼梯问题】+                     {@link JZ69}
 * 【变态上楼梯】+                     {@link JZ71}
 * 【矩形覆盖】+                       {@link JZ70} [递归]
 * 【调整数组中的数字位置】+           {@link JZ21}
 * 【返回单链表中倒数第K个结点】+      {@link JZ54} [单链表]
 * 【合并两个有序单链表】+             {@link JZ25} [单链表]
 * 【树的子结构】                     {@link JZ26} [树]
 * 【二叉树的镜像】                   {@link Offer18} [树]
 * 【二叉搜索树的后序遍历序列】       {@link VerifySequenceIsBST}[二叉树]
 * 【栈的压入、弹出序列】             {@link StackPushAndPop} [栈]
 * 【二叉树中和为某一值的路径】       {@link FindPathSumTotarget}[二叉树]
 * 【数组中出现次数超过一半的数字】   {@link Vote} 摩尔投票算法
 * 【二叉搜索树与双向链表】           {@link ConvertTreeToSequenceTree} [二叉树] [递归]
 * 【复杂链表的复制】                 {@link CopyRandomTree} [链表]
 * 从尾到头打印一个链表           {@link Offer02}
 * 两个栈实现一个队列             {@link Offer05}
 * 斐波那契数列返回指定值         {@link Offer07}
 * 二进制数中1的个数              {@link Offer11} [二进制]
 * 一个数字的整次方               {@link Offer12}
 * 翻转单链表                     {@link Offer15} [单链表]
 * 顺时针打印矩阵                 {@link PrintMatrix} [数组]
 * 最小的K个数                    {@link MinusK} [数组]
 * 整数中1出现的次数（从1到n整数中1出现的次数）  {@link OnceShow} 未完成。。。
 * 把数组排成最小的数                {@link AddToMin}  未完成
 * 第一个只出现一次的字符              {@link FirstOnceNumber}
 * 数字在排序数组中出现的次数            {@link FindShowHowMany} 二分查找的妙用
 *
 *
 * -----------------------------------------极客时间----------------------------------------------------------
 * 【单链表反转】                     {@link JK06Code1}
 * 【插入 冒泡 选择 归并  快速 排序】 {@link JK11Code}
 * AC自动机                       {@link ACAutoMechine}
 * 判断链表环的一系列问题         {@link JK06Code02}
 * java实现基本的栈               {@link JK08Code01}
 * java实现基本的队列             {@link JK09Code1}
 * 循环队列实现                   {@link JK09Code02}
 * 上楼梯问题                     {@link JK10Code01}
 * 二分查找(最简单的，无重复元素) {@link JK15Code01}
 * 求解一个数的平方根             {@link JK15Code02}
 * 二分查找变形                   {@link JK16Code}
 * 跳表实现                       {@link JK17Code01}
 * 二叉查找树的操作               {@link JK24Code}
 * 计算一个数组的有序度           {@link JK38Code1}
 * 【八皇后问题】                     {@link JK39Code1} [回溯]
 * 背包算法--动态规划解法         {@link JK40Code01}
 * 背包问题 最大总价值            {@link JK40Code02}
 * 拓扑排序                       {@link JK43Code01}
 * KMP算法                        {@link KMP}
 *
 * ---------------------------------------------LeeCode----------------------------------------------------------------------
 * 【两个链表交汇结点】*               {@link LeeCode160} favorite amazing
 * 【树的非递归遍历】                {@link TreeNodeTravelByIterator}
 * 【最小乱序区域】                   {@link LeeCode581} favorite 最优解法 O(n)
 * 【最长不重复串】                   {@link LeeCode003} dp问题 双指针
 * 【在一个字符串中寻找最大回文串】   {@link LeeCode005} dp
 * 【约瑟夫环】                         {@link YueSeFuCircle}
 * 【Two Sum】                        {@link LeeCode001}
 * 两个数字相加                   {@link LeeCode002}
 * 承装最多水                     {@link LeeCode011}
 * 最大公共前缀子串               {@link LeeCode14}
 * 一堆数中寻找三个数字和为0      {@link LeeCode015}
 * 删除倒数第几个结点             {@link LeeCode19}
 * 括号匹配                       {@link LeeCode20}
 * 合并两个有序链表               {@link LeeCode21} favorite
 * 【Same Tree】                   {@link LeeCode100} dfs
 * 是否为对称二叉树               {@link LeeCode101} dfs favorite
 * Convert Sorted Array to Binary Search Tree  @{@link LeeCode108} dfs
 * Flatten Binary Tree to Linked List {@link LeeCode114} dfs favorite
 * Populating Next Right Pointers in Each Node  {@link LeeCode116} favorite
 * 蓄水池最大容量                 {@link MaxWater}
 * 找出单独的一个                 {@link LeeCode136} favorite
 * 摩尔投票算法                   {@link LeeCode169} favorite
 * 翻转一个链表                   {@link LeeCode206} favorite
 * 翻转一个二叉树                 {@link LeeCode226}
 * 判断一个链表是否回文           {@link LeeCode234} favorite cant {@link LeeCode206}
 * Binary Tree Paths            {@link LeeCode257} dfs
 * 将数组中的0移到末尾            {@link LeeCode283}
 * Counting Bits                  {@link LeeCode338} favorite 运算符的巧用
 * topKFrequent                   {@link LeeCode347}
 * 路径和等于给定数字             {@link LeeCode437} favorite  difficult 里面有一种类似计数排序原理的解法，比较难理解。记。{@link LeeCode560}关联。
 * 寻找特殊子串                   {@link LeeCode438} favorite 滑动窗口问题  一系列。重点。
 * 一个数组不存在的数             {@link LeeCode448}
 * 两个int值的二进制不同位的个数  {@link LeeCode461}
 * Convert BST to Greater Tree    {@link LeeCode538} favorite difficult
 * Diameter of Binary Tree        {@link LeeCode543}
 * 所有和等于给定值的子串         {@link LeeCode560}
 * LeeCode561匹配最小数           {@link LeeCode561}
 * N叉树前序遍历                  {@link LeeCode589}
 * 求解一个树的最大深度           {@link TreeMaxDepth}
 * N叉树后序遍历                  {@link LeeCode590}
 * 合并两颗二叉树                 {@link LeeCode617}
 * 寻找所有回文串                 {@link LeeCode647} cant 类似005
 * 可以自己除自己每位数           {@link LeeCode728}
 * Daily Temperatures             {@link LeeCode739} cant favorite 思路 **
 * 翻转对称                       {@link LeeCode832}
 * 数字中最大的（只有一个顶峰）   {@link LeeCode852}
 * 交换一个数组中的数组           {@link LeeCode867}
 * 找到链表中点                   {@link LeeCode876} dfs
 * 重新排序数组                   {@link LeeCode922}
 * 处理数组                       {@link LeeCode929}
 * 按照规则重拍数组               {@link LeeCode942}
 * minDeletionSize                {@link LeeCode944}
 * Generate Parentheses         {@link LeeCode22} [递归,回溯]
 * Product of Array Except Self  {@link LeeCode227} [数学规律]
 * Subsets                      {@link LeeCode78} {递归，回溯}
 * Maximum Depth of N-ary Tree
 *
 * ===================================================DFS===============================================
 * 【Leaf-Similar Trees】             {@link LeeCode872} 二叉树
 * Increasing Order Search Tree   {@link LeeCode897} 二叉树
 * Maximum Depth of N-ary Tree    {@link LeeCode559} 二叉树
 * Maximum Depth of Binary Tree   {@link LeeCode104}
 * Number of Islands              {@link LeeCode200}
 *
 * ==================================================DP===================================================
 *
 * 【Word Break】                  {@link LeeCode139} DP
 * 【买卖的最佳时机】               {@link LeeCode121} good
 * 【爬楼梯问题】                     {@link LeeCode70}
 * 【连续串最大和】                   {@link LeeCode53}
 * 【隔间偷】                         {@link LeeCode198}
 * 【杨辉三角】                       {@link LeetCode118}
 * 【买卖股票3】                      {@link LeetCode_123}
 *
 *
 * ==================================================
 * 【无序数组中位数】              {@link MediumNumber} 快排思想 + 二分查找
 *
 * ==================================================DP学习计划======================================
 * day1
 * 【斐波那契数】                  {@link LeetCode_cn_509}
 * 【第 N 个泰波那契数】             {@link LeetCode_cn_1137}
 * day2
 * 【爬楼梯】                    {@link LeetCode_cn_70}
 * 【使用最小花费爬楼梯】*          {@link LeetCode_cn_746}
 * day3
 * 【打家劫舍】                  {@link LeetCode_cn_198}
 * 【打家劫舍 II】                {@link LeetCode_cn_213}
 * 【删除并获得点数】*                {@link LeetCode_cn_740}
 * day4
 * 【跳跃游戏】                   {@link LeetCode_cn_55}
 * 【跳跃游戏 II】                {@link LeetCode_cn_45}
 * day5
 * 【最大子序和】                  {@link LeetCode_cn_53}
 *【环形子数组的最大和】           {@link LeetCode_cn_918}
 * day6
 * 【乘积最大子数组】                {@link LeetCode_cn_152}
 *【乘积为正数的最长子数组长度】     {@link LeetCode_cn_1567}
 * day7
 * 【买卖的最佳时机】                    {@link LeeCode121}
 * 【买卖股票的最佳时机 II】          {@link LeetCode_cn_122}
 * 【买卖股票的最佳时机 III】          {@link LeetCode_123}
 * 【买卖股票的最佳时机 IV】           {@link LeetCode_cn_188}
 * day8
 * 【最佳买卖股票时机含冷冻期】           {@link LeetCode_cn_309}
 * 【买卖股票的最佳时机含手续费】          {@link LeetCode_cn_714}
 *
 *
 */
public interface AAACodeList{

}


