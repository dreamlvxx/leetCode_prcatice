public class JK08Code01 {
    private String[] items;
    private int capacity;
    private int currentHas = 0;
    //初始化
    private JK08Code01(int capacity){
        this.capacity = capacity;
        items = new String[capacity];
    }

    private void push(String s){
        if (currentHas >= items.length){
            System.out.println("已经满了");
            return;
        }
        items[++currentHas] = s;

    }

    private String pop(){
        if (currentHas <= 0){
            System.out.println("没有");
            return "";
        }
        String result = items[currentHas];
        currentHas--;
        return result;
    }

}
