public class List {

    Node head;
    Node tail;

    class Node{
        int value;
        Node next;
        Node prev;
    }

    public void push(int value){
        Node node = new Node();
        node.value = value;
        if(tail == null){
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public void revert(){
        Node node = head;
        while (node != null){
            Node next = node.next;
            Node prev = node.prev;
            node.next = prev;
            node.prev = next;

            node = node.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

public static class Main{
    public static void main(String[] args) {
        List list = new List();
        for(int i = 1; i < 11; i++){
            list.push(i);
        }
        list.print();
        System.out.println();

        list.revert();
        list.print();
    }
}

}
