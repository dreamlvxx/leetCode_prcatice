
import java.util.*

fun main() {
    val aa = arrayOf(intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1), intArrayOf(5, 0), intArrayOf(6, 1), intArrayOf(5, 2))
    val ll = LeeCode406()
    ll.reconstructQueue(aa)
}
class LeeCode406 {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list

        //以下sort，把最大的相同K组排序，而且，相同K之中，根据H排序
        //排序结果
        //7+0
        //7+1
        //6+1
        //5+0
        //5+2
        //4+4
        Arrays.sort(people) { o1, o2 -> if (o1[0] != o2[0]) -o1[0] + o2[0] else o1[1] - o2[1] }

        val res = LinkedList<IntArray>()
        //以下这个步骤就是根据K把当前数据往进插到K位置即可
        for (cur in people) {
            res.add(cur[1], cur)
        }
        return res.toTypedArray()
    }
}