import com.sun.istack.internal.NotNull
import kotlin.properties.Delegates
import JK06Code1 as jj //导包可以自己命名

class MyFirstKotlin {
    //kotlin不需要写  ;  分号结尾

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

    fun collectionC(): List<Int> {//方法可以嵌套方法
        var list = arrayOf(1, 2, 3) //kotlin提供一系列的集合生成库
        var list1 = listOf(1, 2, 2)
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        for ((k, v) in map) { //这种方式循环map比较方便
            println("$k -> $v") //这其中的$用作字面量  也就是可以访问相关的属性  相当于引用
        }

        for (i in 10 downTo 1) { //in关键字  用来表示是否存在于取值范围内
            println(i)
        }

        for (i in 10 downTo 1 step 3) println(i) //step用来跳步循环

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

        val asds = "s"
        when (asds) {
            is String -> {
                print("sad")
            }
            else -> false
        }
        println(list.filter { x -> x > 1 })
        return list1
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


    //lambda表达式
    val lambdaString = "lambda"
    val length: (a: Int,b:Int) -> Int = { a,b ->lambdaString.length + a + b }
    //完整的lambda表达式
    val sum = {x: Int,y: Int -> x + y}
    //lambda 表达式总是括在花括号中， 完整语法形式的参数声明放在花括号内，
    // 并有可选的类型标注， 函数体跟在一个 -> 符号之后。
    // 如果推断出的该 lambda 的返回类型不是 Unit，
    // 那么该 lambda 主体中的最后一个（或可能是单个）表达式会视为返回值。
    val sum1: (Int, Int) -> Int = {x, y -> x+y }//这里x + y相当于return x + y
    fun sum3(x: Int, y: Int ): Int = x + y

}