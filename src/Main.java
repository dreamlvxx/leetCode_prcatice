import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> da = new ArrayList<>();
        da.add("123");
        da.add("123");
        da.add("2354");
        da.add("sdf");
        da.add("jhkhj");
        da.add("123");

        for (String s : da
        ) {
            if (s.equals("123")){
                da.remove(s);
            }
        }
        System.out.println(da);

//        Iterator iterator = da.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().equals("123")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(da);
    }
}

