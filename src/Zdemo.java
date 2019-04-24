public class Zdemo {
    public void demo() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break;
                }
                System.out.println("----------" + j);
            }
        }
    }
}
