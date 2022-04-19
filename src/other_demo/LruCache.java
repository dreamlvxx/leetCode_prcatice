package other_demo;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(){

        }
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }


    class DoubleList {
        private Node head;
        private Node tail;
        public int length;

        public DoubleList(){
            head = new Node(-1,-1);
            tail = head;
            length = 0;
        }

        void add(Node teamNode){
            tail.next = teamNode;
            teamNode.pre = tail;
            tail = tail.next;
            length ++;
        }

        void removeFirst(){
            if (head.next == null)return;
            if (head.next == tail){
                tail = head;
            }
            head.next = head.next.next;
            if (head.next != null){
                head.next.pre = head;
            }
            length --;
        }

        void removeTargetNode(Node target){
            target.pre.next = target.next;
            if(target.next != null){
                target.next.pre = target.pre;
            }

            if(target == tail){
                tail = tail.pre;
            }


            target.pre = null;
            target.next = null;
            length --;
        }

    }

    Map<Integer,Node> map = new HashMap<>();
    DoubleList list;
    int capacity;

    public LruCache(int capacity){
        this.capacity = capacity;
        list = new DoubleList();
    }

    public int get(int key){
        int res = -1;
        if(!map.containsKey(key)){
            return res;
        }
        Node target = map.get(key);
        list.removeTargetNode(target);
        list.add(target);
        res = target.value;
        return res;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node curr = map.get(key);
            list.removeTargetNode(curr);
        } else if(list.length == capacity){
            Node first = list.head.next;
            list.removeFirst();
            map.remove(first.key);
        }

        Node newNode = new Node(key,value);
        list.add(newNode);
    }



}
