package jz_offer_studp_project

class JZ_cn_075 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray? {
        val hash = IntArray(1001)
        for (n in arr1) {
            hash[n]++
        }
        var index = 0
        for (n in arr2) {
            while (hash[n] > 0) {
                arr1[index++] = n
                hash[n]--
            }
        }
        for (i in 0..1000) {
            while (hash[i] > 0) {
                arr1[index++] = i
                hash[i]--
            }
        }
        return arr1
    }
}