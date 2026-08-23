import java.util.prefs.NodeChangeEvent;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void print(Node node){

        while(node != null){
            System.out.print("[" + node.val + ", " + node.random + ", " + node + "]" + " ----> ");
            node = node.next;
        }

        System.out.print("NULL");

    }

}