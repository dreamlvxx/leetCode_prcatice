import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Set<String> set = new HashSet<>();
        set.add("sdasd");
        set.add("dfgdgdf");
        set.add("hjhgj");
        set.add("oooo");
        set.add("trthrt");
        set.add("oplpolp");
        set.add("bdfbi");
        set.add("fngi");

        for (String a :
                set) {
            System.out.println(a);
        }

    }
}
