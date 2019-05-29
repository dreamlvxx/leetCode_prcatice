@file:JvmName("MyKotlinCompanyObject") //这个可以修改顶级函数生成文件的文件名
import com.sun.istack.internal.NotNull
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.properties.Delegates
import JK06Code1 as jj //导包可以自己命名

/**
 * 类型别名--------------------------------------------------------------------------------------------------------
 * 只能定义在顶层
 */
typealias NetNode = MyFirstKotlin.Network.Node
typealias NodeSet = Set<MyFirstKotlin.Network.Node>

/**
 * 以下的几个顶级函数 变量，main 都会编辑成一个新的java文件  这个名字可以通过 @file:JvmName("MyKotlinCompanyObject") 修改
 */
fun main() {
    MyFirstKotlin :: class.java //类引用
    val sad : String? = null
    val l = sad?.length?: 9
    val ample : Examplex? = null
    val aa = ample?.arr?.size?: 88
    println(aa)
    //内联函数可以直接return
    go{ if (it == 1)return}
}
class Examplex{
    val arr : Array<String>? = null
}

/**
 * 内联函数 inline标记---------------------------------------------------------------------------------------
 * 通过替换函数调用出，把调用直接换成真实代码，减少入栈出栈的开销
 * 发生在编译器，不是运行时
 */
inline fun inlineFUnction(){

}

inline fun go(s : (a : Int) -> Unit){
    var i = 0
    while (i ++ < 3){
        s(i)
    }
}

//应用 一般在集合遍历返回
var carr = intArrayOf(1,2,3)
fun  yyy(){
    carr.forEach { if (it == 2)return }
    println("end")//此时当i == 2的时候  直接返回了  这句就不会执行了
}

/**
 * 委托-------------------------------------------------------------------------------------------
 * 这种方式重写的成员不会在委托对象的成员中调用 ，
 * 委托对象的成员只能访问其自身对接口成员实现
 * 就是说下面这个继承关系， 父亲属性不会受儿子影响
 */
interface Base {
    val message: String
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(message) }
}

class Derived(b: Base) : Base by b {
    // 在 b 的 `print` 实现中不会访问到这个属性
    override val message = "Message of Derived"
}

/**
 * 顶级函数 变量---------------------------------------------------------------------------
 */

//用const声明的为静态变量
const val ttt = "sad"

val topStringX : String = "lvxingxing"
fun topFunction(){
    println("this is top function")
}


//--------------------------------------------------------------------------------------
class MyFirstKotlin {

    /**
     * 操作符--------------------------------------------------------------------------------------------------------------------
     * == 比较的是结构  相当于a.equals(b)
     * === 比较是否是相同引用
     * is !is  相当于instanceof
     * ?  判断是不是空  空就返回null   bob?.department?.head?.name 任何一个环节为空  就返回null
     * val l = b?.length ?: -1 可以有选择的返回一个东西
     */



    /**
     * 解构声明----------------------------------------------------------------------------------------------------------------
     */

    // for ((a, b) in collection) { …… }
    // { a //-> …… } // 一个参数
    // { a, b //-> …… } // 两个参数
    // { (a, b) //-> …… } // 一个解构对
    // { (a, b), c //-> …… } // 一个解构对以及其他参数
    //map.mapValues { (_, value): Map.Entry<Int, String> -> "$value!" }
    //map.mapValues { (_, value: String) -> "$value!" }

    /**
     * 伴生对象-相当于java中的static-------------------------------------------------------------------------------------
     */

    companion object{
        //const声明的为静态
        const val aaaa = "staticSteing2"
        @JvmStatic
        val staticString :String = "staticString"
        var staticString11 : String = "stsaticString11"
        @JvmStatic  //这个标记的作用是在java中可以直接类名调用。不加标记的话 只能通过Companion.XXX()来调用
        fun invokeStaticFunction(){
            println("this is static functon")
        }

        fun invokeStaticFunction1(){
            println("sadasd")
        }
    }

    /**
     * 幕后字段 field-----------------------------------------------------------------------------------------------------
     */
    var lvxingxing : String  = ""
    get() = field
    set(value) {
        field =value
    }

    val canNotChange = 1 //val是只读变量 kotlin自动添加了 getter()
    var canChange = 2 //var是可读可写变量 kotlin自动添加了getter() setter()

    fun getMessage(): String {
        println("asdasda")
        return "asd"
    }

    fun sum(a: Int, b: Int): Int = a + b

    fun judge(obj: Any) { //kotlin里面的所有默认超类是Any  而不是Object  Object表示了另外一个含义->伴生对象
        val a: jj = jj() //kotlin没有new关键字
        if (obj is String) println("is String") //is 类似于java中的instanceof
    }

    fun hasDefaultParams(a: Int = 0) { //方法参数可以有default值
        println(a)
    }

    /**
     * 集合-------------------------------------------------------------------------------------------------------------------
     */
    fun collectionC(): List<Int> {//方法可以嵌套方法
        val lista = arrayListOf<String>()//空list
        val mutiallist = mutableListOf<String>()//空list
        var listt = arrayOf(1, 2, 3) //kotlin提供一系列的集合生成库
        val listtt = arrayOf(2,3,4)
        var list1 = listOf(1, 2, 2)
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        //copy集合
        val copyListaa = listt.toList()//copy只读list
        val copylistaaa = mutiallist.toMutableList()//copy可读写list

        //迭代器
        val iteratorll = listt.iterator()
        while (iteratorll.hasNext()){
            println(iteratorll.next())
        }

        //for 遍历list
        for (i in listt){
            println("$i")
        }
        //foreach 遍历list
        listt.forEach {
            println(it)//it是隐式指向变量
        }

        //for 遍历 map
        for ((k, v) in map) { //这种方式循环map比较方便
            println("$k -> $v") //这其中的$用作字面量  也就是可以访问相关的属性  相当于引用
        }


        //区间 in
        for (i in 10 downTo 1) { //in关键字  用来表示是否存在于取值范围内
            println(i)
        }
        for (i in 10 downTo 1 step 3) println(i) //step用来跳步循环


        //集合的一些操作
        listt.filter { it < 2 }//过滤条件值
        listt.map { it * 2 }//转换为条件值
        val mergeList = listt zip listtt


        val a = hashMapOf<String, String>()
        a.put("a", "22")
        a.put("b", "55")
        a.put("c", "55")

        a.entries.forEach {
            println(it.key + ":---" + it.value) //使用forEach语法循环集合，it隐式代表要访问的值
        }

        fun getNum(): String { //这个方法存在于collectionC之中 ，就是说方法可以嵌套方法  但是这个方法得作用域在它的声明之下，之前是不可以调用的。
            return "sa"
        }

        fun getM(a: String): String {
            val result = if (a.equals("ss")) {//if语句可以作为返回值
                print("sad")
                "sad"
            } else {
                print("sad")
                "sadas"
            }

            loop@ for (i in 1..100) { //使用@loop这种标签可以让循环跳到指定处
                for (j in 2..100) {
                    if (j == 2) break@loop
                }
            }

            return when (a) { //when语句相当于switch  它比较强大的是，一个分支可以写做个条件，而且条件可以是方法返回值形式
                getNum(), "s", "sad" -> "s"
                "2" -> {
                    print("sad")
                    "s"
                }
                else -> {//其他所有情况
                    print("sad")
                    "ss"
                }
            }
        }
        println(listt.filter { x -> x > 1 })

        return list1
    }

    /**
     * 集合的一些操作
     */
     fun optionList(){
        var listt = arrayOf(1, 2, 3,4,5) //kotlin提供一系列的集合生成库
        val listtt = arrayOf(7,8,9)
        //集合的一些操作
        listt.filter { it < 2 }//过滤条件值
        listt.map { it * 2 }//转换为条件值
        val mergeList = listt zip listtt//合并俩集合
        println(mergeList)

        val mmmap = listOf(1 to "1",2 to "2")
        println(mmmap)
        println(mmmap.unzip())

        val numbers = listOf("one", "two", "three", "four","three")

        // plus minus操作符   相当于add remove
        val plusList = numbers + "five"
        val minusList = numbers - listOf("three", "four")
        println(plusList)
        println(minusList)

        //groupBy操作符  可以根据一定的条件  对集合中的元素进行分组
        val numbers22 = listOf("one","osss", "two", "three", "four", "five")
        val number33 = listOf(1,2,3,4,5)
        println(numbers22.groupBy { it.first().toUpperCase() })//分组条件
        println(numbers22.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))//keySelector是分组条件，valueTransform是对元素的操作
        println(numbers22.groupingBy { it.first() }.eachCount())//eachCount可以计算出匹配条件值的元素个数
        println(numbers22.slice(1..3))//slice取一定区间的元素
        println("take " + numbers22.take(2))//take 去从开头往后的n个元素
        println("takelast" +numbers22.takeLast(2))//从后往前取n个元素
        println("takeWhile" + numbers22.takeWhile { it.startsWith("o") })//取特定条件的元素,如果第一个元素不匹配，就返回空
        println("takeLastWhile" + numbers22.takeLastWhile { it.startsWith("f") })//去特性条件的元素，如果最后一个不匹配，返回空
        println("drpo" + numbers22.drop(2))//取除去前n个元素的后面部分
        println("dropWhile" + numbers22.dropWhile { it.startsWith("u") })//取除了特定条件的元素,如果第一个元素不匹配，全返回
        println("dropLast" +numbers22.dropLast(2))//取除去后n个元素的前面部分
        println("dropLastWhile" + numbers22.dropLastWhile { it.startsWith("u") })//取除了特定条件的元素，如果最后一个不匹配，全返回
        println("chunk" + numbers22.chunked(3))//n个分为一个组
        println("chunk with condition" +number33.chunked(3){it.sum()})//n个一组，并对这一组数据进行操作
        println("windowed" + number33.windowed(3))//滑动窗口为3，往后一个一个移动
        println("windowed with step" + number33.windowed(size = 3,partialWindows = false,step = 2))//step是跳步数,partialWindows决定不够滑动窗口大小的时候是否舍弃
        println("elementAt" + number33.elementAt(2))//相当于get 和 []
        println("first" + number33.first())//取第一个
        println("last" + number33.last())//取最后一个
        println("empty" + number33.isEmpty() + "not empty" + number33.isNotEmpty())//判空
        println("contain" + number33.contains(2))//判断有没有
        println("in" +  (7 in number33))//判断有没有

    }

    /**
     * 序列
     * 使用与数据量大的情况下
     */
    fun sequ(){

    }


    class Person private constructor(a: String) { //一个类如果有主构造器，声明在头部
        constructor(name: String, sex: String, ss: String) : this(name) {//这个属于次构造器 、必须实现主构造器 ,并且主构造器的参数，必须就地初始化
            println("")
        }

        constructor(tt: String = "", bb: String = "", ww: String = "", aa: String) : this(tt) {
            println("sad")
        }
    }

    open class Base constructor(a: String) {
        //open关键字表示可以被继承
        open val message: String = "s"//属性如果可以被继承 用open

        open fun nv() {} //尽管类是open的   如果方法要被继承 也需要open

        init {// 构造函数执行的执行代码放在init()中
            println("init Base----------")
        }
    }

    open class Drive constructor(a: String, b: String, c: String) : Base(b.capitalize().also { println("${it.length} base con------") }) {
        override var message = "s"//属性继承同样适用override
        final override fun nv() {} //继承的方法可以关闭继承

        init {
            println("init drive------$c--$a")
        }
    }

    open class Foo {
        lateinit var iop: String
        open fun f() {
            println("Foo.f()")
        }

        open val x: Int get() = 1
    }

    abstract class Too : Foo() { //抽象类可以继承非抽象类
        abstract override fun f()
    }

    interface Hoo {
        open fun f() {
            print("Hoo.f()")
        }
    }

    class Bar : Foo(), Hoo {
        //实现多个超类
        override fun f() {}

        override var x: Int = 0
            get() = 0

        inner class Baz {
            fun g() {
                super<Foo>@Bar.f() //1，如果想调用超类的放法，就用super   2， 在调用超类实现的方法时  如果超类中有重名的函数方法名，必须尖括号指明是哪个超类
                println(super@Bar.x)
            }
        }
    }

    //---------------------------标签 属性与字段--------------------------------------------------------------------------------------------------------------------------
    //一个属性的完整声明方式 get set都重写
    var mmm: String
        get() = "sadasd"
        set(s) {
            s + "asdadasdasdas"
        }

    var setterVisiable = "sad"
        private set   //当你不需要定义访问器的实现，只需要进行注解或者可见性
        @NotNull get


    //幕后字段的作用-------------------------
    //反例 下面这个写法会造成set get进入了死循环 （可以编译成java代码自行查看）
//    var ty
//    get() = ty
//    set(value) {ty = value}

    var sss: String = "aaa"
        set(value) {
            if ("asd".equals(value)) field = value  //幕后字段field
        }

    object const

    val CON_STRING = "asd" //const声明一个编译器常量  它只能是顶层、object声明 或者是companion object的一个成员

    lateinit var lastString: String //laseinit可以使属性延迟赋值 并且在初始化前访问一个lateinit属性会抛出一个特定异常，该异常明确标识该属性被访问及它没有初始化的事实。


    //----【属性委托】-----------------------
    /**
     * 【lazy】
     * 惰性初始化是一种常见的模式，直到第一次访问该属性的时候，
     * 才根据需要创建对象的一部分(只会执行一次)
     * 当初始化过程消耗大量资源并且在使用对象时并不总是需要数据时，这个非常有用。
     * by lazy只能用于val lazy属于
     * 是同步的
     * 如果想取消代理，在lazy的构造函数中传入 LazyThreadSafetyMode.PUBLICATION
     */
    val rName: String by lazy(LazyThreadSafetyMode.PUBLICATION) { "sss" }

    /**
     * 【Delegates.observable】
     *  prop代表代理的属性名称
     *  old 是旧值
     *  new 是新值
     *  执行函数为监听器，但是一定会赋值操作
     */
    var deleGateName: String by Delegates.observable("初始值") { prop, old, new ->
        println("属性:$prop 旧值:$old --- 新值:$new")
    }

    /**
     * 【Delegates.vetoable】
     * 执行函数有返回值，里面的处理逻辑返回true的时候才会赋值
     */
    var votoableName: String by Delegates.vetoable("初始值") { prop, old, new ->
        if (new.contains("ss")) false
        else true
    }

    /**
     * map映射
     * 属性值与map中key对应
     * val 对应Map
     * var 对应MutableMap
     */
    class User(val map: Map<String, Any>) {
        val name: String by map
        val sex: String by map
    }

    val user = User(mapOf("name" to "hehe", "sex" to "sadad"))

    class Patient(var map: MutableMap<String, Any>) {
        var name: String by map
        var sex: String by map
    }

    var patient = Patient(mutableMapOf("name" to "sad", "sex" to "sad"))


    //------------------【接口】-------------------------------
    interface Myinterface {
        fun method1()
        fun method2() {//可以有默认实现
            println("sad")
        }
    }

    /**
     * -----------------【可见性修饰符】-----------------------
     *  如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；
     *  如果你声明为 private，它只会在声明它的文件内可见；
     *  如果你声明为 internal，它会在相同模块内随处可见；
     *  protected 不适用于顶层声明。
     */


    /**
     * 扩展函数
     */
    fun String.kuozhan() {
        println("扩展函数啊~~")
    }

    fun test() {
        var s = "asd"
        s.kuozhan()
    }

    //扩展函数也可以扩展同样名字但是签名不同的函数
    class C {
        fun foo() {
            println("sad")
        }
    }

    fun C.foo(a: Int) {
        println("$a ==")
    }

    //扩展属性--给一个对象增加属性
    var <T> List<T>.lastSecondIndex: Int
        get() = this.size - 2
        set(value) {
            println("nothing to do")
        }

    val list = listOf("asd", "sad")
    fun ss() {
        println(list.lastSecondIndex)
    }

    //伴生对象也可以扩展
    class D {
        companion object {
            val a = ""
        }
    }

    fun D.Companion.foo() {}

    //扩展声明为成员  在一个类内部可以为另一个类声明扩展
    class G {
        fun asd() {}
    }

    class EE {
        fun ddd() {}
        fun G.ttt() {
            ddd()
            asd()
        }

        fun caller(g: G) {
            g.ttt()
        }
    }


    /**
     * ----------------【数据类】------------------------------
     * 会相应生成toString()、 equals()、 hashCode() 以及 copy()这几个方法
     */
    data class Doctor(var name: String, var sex: String) {
        var addr: String = "sad"  //在类体中的属性 不会被应用到上面自动生成的方法中  ，上述方法只会用主构造函数中的属性,其他会被视为相等
    }

    //copy函数的作用，就是同样一个对象，改变部分属性
    //解构声明
    fun test1() {
        val doc1 = Doctor("s", "x")
        var doc2 = doc1.copy(sex = "sad")
        var doc3 = doc1.copy(sex = "sad", name = "sss")
        val (namename, sexsex) = doc1
        println("$namename ---- $sexsex")
    }

    /**
     * -----------------【密封类】-------------------
     * 枚举类的
     */

    sealed class State {
        class Night : State()
        class Day : State()
    }

    fun sealeFuntion(dd: State) {
        when (dd) {
            is State.Night -> println("night")
            is State.Day -> println("day")
        }
    }

    /**
     * 比较复杂***待看
     * 泛型-----------------------------------------------------------------------------------------------------
     */


    /**
     * 嵌套类与内部类
     */

    //---------------------嵌套类
    class Outer() {
        private val ss = "a"

        class Nested {
            fun foo() = 2
        }
    }

    fun test2() {
        val a = Outer.Nested().foo()
    }

    //----------------------内部类
    class Outer1 {
        private val s = "ss"

        inner class Innner {
            fun foo() = s
        }
    }

    fun test3() {
        val s = Outer1().Innner().foo() //这个与嵌套类的用法差异不同  嵌套类是Outer.Nested()  而内部类需要外部实例是Outer().Innner()
    }

    //-------------------匿名内部类
    open class getMe {
        open fun hah() {
            println("sad")
        }
    }

    class GetAnnoy {
        fun addListener(me: getMe) {
            //do something
        }
    }

    fun test4() {
        val getannoy = GetAnnoy()
        getannoy.addListener(object : getMe() {
            override fun hah() {
                println("something ----")
            }
        })
    }

    /**
     * 枚举类------------------------------------------------------------------------------------------
     *
     */

    enum class MyEnumClazz {
        LOADING, NORMAL, ERROR
    }

    enum class MyEnumClazz1(msg: String) {
        RED("RED"), BULE("BLUE")
    }

    //枚举类可以有自己的内部类  可以有成员
    enum class MyEnumClazz2(msg: String) {

        RED("red") {
            val a = "sad"
            override fun getValue() = a
        },
        BLUE("BLUE") {
            override fun getValue() = "BLUE"
        };

        abstract fun getValue(): String
    }

    fun getEnum() {
        MyEnumClazz2.RED.getValue()
    }

    //枚举类可以实现接口，但是不可以继承类
    //而且可以为每一个单独实现，也可以统一实现一个
    interface enumminterfaaa {
        fun getMes()
    }

    interface enumone {
        fun one()
    }

    enum class MyEnumCLazz4 : enumminterfaaa, enumone {
        RED {
            override fun getMes() {
                println("sad")
            }
        },

        BLUE {
            override fun getMes() {
                println("blue")
            }
        };

        override fun one() {
            println("统一输出")


        }
    }

    fun test34() {
        val a: MyEnumCLazz4 = MyEnumCLazz4.valueOf("RED")
        val aa = MyEnumCLazz4.values()
        for (i in aa) {
            println(i.getMes())
        }
//        println(a.getMes())
    }

    /**
     * lambda表达式------------------------------------------------
     */
    val lambdaString = "lambda"
    val length: (a: Int,b:Int) -> Int = { a,b ->lambdaString.length + a + b }
    //lambda 表达式总是括在花括号中， 完整语法形式的参数声明放在花括号内，
    // 并有可选的类型标注， 函数体跟在一个 -> 符号之后。
    // 如果推断出的该 lambda 的返回类型不是 Unit，
    // 那么该 lambda 主体中的最后一个（或可能是单个）表达式会视为返回值。
    val sum = {x: Int,y: Int ->
        println("ad")
        x + y}

    //方法作为参数传递
    fun functionWithfunc(a : String ,ss : (Int,Int) -> Int){

    }

    fun uu(){
        //lambda作为参数传入
        functionWithfunc("asd",sum)
        //调用lambda
        sum(1,2)
    }

    /**
     * 协程-------------------------------------------------------------------------------------------
     */
        fun cc(){
            GlobalScope.launch { // 在后台启动一个新的协程并继续
                delay(1000L) // 【非阻塞】   的等待 1 秒钟（默认时间单位是毫秒）
                println("World!") // 在延迟后打印输出
            }
            println("Hello,") // 协程已在等待时主线程还在继续
            Thread.sleep(2000L) // 【阻塞】主线程 2 秒钟来保证 JVM 存活
            runBlocking { //调用runblock的线程会阻塞直到里面的执行完
                delay(1000L)
            }
        }

         fun cc2() = runBlocking{
            //使用job 等待后台执行
            val job = GlobalScope.launch {
                delay(1000L)
                println("finsh")
            }
            println("start")
            job.join()
        }

        //上面的简化写法
        fun cc3() = runBlocking {
            launch {
                delay(1000L)
                println("start")
            }
            println("as")
        }


    class Network{
        inner class Node
    }

}
