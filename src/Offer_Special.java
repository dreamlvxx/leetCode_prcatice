import jz_offer_studp_project.*;
import offer.JZ7;

public interface Offer_Special {
    /**
     * ===========================================================剑指OFFER专项突破-学习计划==============================================
     * --------------------------------------------------    https://leetcode-cn.com/problem-list/e8X3pBZi/    ------------------------------
     *
     * -------------------------------------------------2------------------------------------
     *
     *
     * -------------------------------------------------1------------------------------------
     * 【剑指 Offer II 001. 整数除法】                              {@link JZ_cn_001}
     * 【剑指 Offer II 002. 二进制加法】                             {@link JZ_cn_002}
     * 【剑指 Offer II 003. 前 n 个数字二进制中 1 的个数】             {@link JZ_cn_003}
     * 【剑指 Offer II 004. 只出现一次的数字】                          {@link JZ_cn_004}
     * 【剑指 Offer II 005. 单词长度的最大乘积】                       {@link JZ_cn_005}
     * 【剑指 Offer II 006. 排序数组中两个数字之和】                    {@link JZ_cn_006}
     * 【剑指 Offer II 007. 数组中和为 0 的三个数】                     {@link JZ_cn_007}
     * 【剑指 Offer II 008. 和大于等于 target 的最短子数组】*            {@link JZ_cn_008}
     * 【剑指 Offer II 009. 乘积小于 K 的子数组】                       {@link JZ_cn_009}
     * 【剑指 Offer II 010. 和为 k 的子数组】                          {@link JZ_cn_010}
     * 【剑指 Offer II 011. 0 和 1 个数相同的子数组】                    {@link JZ_cn_011}
     * 【剑指 Offer II 014. 字符串中的变位词】                          {@link JZ_cn_014}
     * 【剑指 Offer II 015. 字符串中的所有变位词】                        {@link JZ_cn_015}
     * 【剑指 Offer II 088. 爬楼梯的最少成本】                          {@link JZ_cn_088}
     * 【剑指 Offer II 012. 左右两边子数组的和相等】                       {@link JZ_cn_012}
     * 【剑指 Offer II 018. 有效的回文】                                 {@link JZ_cn_018}
     * 【剑指 Offer II 023. 两个链表的第一个重合节点】                      {@link JZ_cn_023}
     * 【剑指 Offer II 027. 回文链表】**                                  {@link JZ_cn_027}
     * 【剑指 Offer II 032. 有效的变位词】                                {@link JZ_cn_032}
     * 【剑指 Offer II 034. 外星语言是否排序】*                             {@link JZ_cn_034}
     * 【剑指 Offer II 101. 分割等和子集】*                               {@link JZ_cn_101}
     * 【剑指 Offer II 052. 展平二叉搜索树】*                               {@link JZ_cn_052}
     * 【剑指 Offer II 056. 二叉搜索树中两个节点之和】                      {@link JZ_cn_056}
     * 【剑指 Offer II 068. 查找插入位置】                                {@link JZ_cn_068}
     * 【剑指 Offer II 069. 山峰数组的顶部】                               {@link JZ_cn_069}
     * 【剑指 Offer II 072. 求平方根】                                      {@link JZ_cn_072}
     * 【剑指 Offer II 075. 数组相对排序】* 计数排序                             {@link JZ_cn_075}
     * 【剑指 Offer II 081. 允许重复选择元素的组合】*                           {@link JZ_cn_081}
     * 【剑指 Offer II 082. 含有重复元素集合的组合】                           {@link JZ_cn_082}
     * 【剑指 Offer II 083. 没有重复元素集合的全排列】**                         {@link JZ_cn_083}
     * 【剑指 Offer II 084. 含有重复元素集合的全排列 】*                         {@link JZ_cn_084}
     *
     *
     *
     *
     * --------------------     https://www.nowcoder.com/ta/coding-interviews    ----------------------------------------------
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
     */
}
