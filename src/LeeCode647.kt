fun main() {
    val a = LeeCode647()
    a.countSubstrings("abc")
}

class LeeCode647 {
    var number = 0
    fun countSubstrings(s: String): Int {
        for(i in 0 until s.length){
            countNumber(s,i,i)  //这里并不需要担心这两行会出现重复的回文串，因为一个是奇数长度，一个是偶数长度，肯定不同
            countNumber(s,i,i + 1)
        }
        return number
    }

    fun countNumber(s: String,j : Int ,k : Int){
        var jj = j
        var kk = k
        while(jj >=0 && kk < s.length && s[jj] == s[kk]){ //以一个几点向两头扩散，相等继续扩散
            number ++
            jj --
            kk++
        }
    }

}