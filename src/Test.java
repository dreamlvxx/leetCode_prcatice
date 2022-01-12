import javafx.collections.ListChangeListener;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        testList();
    }

    static void testList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        changeList(list);
        System.out.println(list);


    }

    public static void changeList(List<Integer> list){
        list.add(77);
    }

    public static void test() {
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


    class SuperC {

    }

    class SubC extends SuperC {

    }

    List<? super SuperC> s = new ArrayList<>();

    class Coll<T extends SuperC> {

    }

    public void asd() {
        s.add(new SubC());
        s.get(0);
    }

    public void testSub(Collection<? super SuperC> para) {
        para.add(new SuperC());

    }

    private final static ListChangeListener<Integer> selectedIndicesListener = c -> System.out.println("sasa");

    interface oncc {
        void onchange(String a);
    }

    private final static oncc a = a -> System.out.println("sasa");


}
