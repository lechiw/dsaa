import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;
/**
 * @Description: 单链表
 * @author: Liw
 * @date: 2018/12/2 11:51
 * <p>
 */
public class SinglyLinkedList {
    private Node head = null ;
    private Node findByValue(int data){
        Node p = head ;
        while (p != null && p.getData() != data){
            p = p.next ;
        }
        return p ;
    }

    /**
     * 将最新数据插入到第一个节点前
     * @param value
     */
    private void insertToHead(int value){
        Node node = new Node(value,null);
        insertToHead(node);
    }
    private void insertToHead(Node node){
        if(head == null){
            head = node ;
            return ;
        }
        node.next = head ;
        head = node ;
    }

    /**
     * 将数据插入到最后一个节点
     * @param data
     */
    private void insertToTail(int data){
        insertToTail(data);
    }
    private void insertToTail(Node node){
        Node p = node;
        if(head == null){
            head = p;
            return ;
        }
        Node tail = head ;
        while (tail.next != null){
            tail = tail.next ;
        }
        tail.next = p ;
    }

    /**
     * 将节点插入到目标节点前
     * @param data
     */
    private void insertBeforeNode(int data){
        Node node = new Node(data,null);
        insertBeforeNode(node);
    }
    private void insertBeforeNode(Node node){
        if(head == null){
            head = node ;
            return ;
        }
        Node p = head ;
        Node beforeNode = head ;
        while (p != null && p.data != node.data){
            beforeNode = p ;
            p = p.next ;
        }
        if(p == null){
            System.out.println("没有找到目标节点");
            return ;
        }
        beforeNode.next = node ;
        node.next = p ;
    }

    /**
     * 删除所有数据
     */
    private void deleteAll(){
        head = null ;
    }

    private void deleteByDate(int data){
        if(head == null) {
            return ;
        }
        Node p = head ;
        Node beforeNode = null ;
        while(p != null && p.data != data){
            beforeNode = p ;
            p = p.next ;
        }
        if(beforeNode == null){
            head = head.next ;
        }else{
            beforeNode.next = beforeNode.next.next ;
        }
    }

    private void deleteByNode(Node node){
        if(head == null || node == null) {
            return ;
        }
        Node beforeNode = null ;
        Node p = head ;
        while (p != null && p.getData() != node.getData()){
            beforeNode = p ;
            p = p.next ;
        }

        if(beforeNode == null){
            head = head.next ;
        }else{
            beforeNode.next = beforeNode.next.next;
        }


    }

    private void show(){
        Node p = head ;
        while (p != null){
            System.out.println(p.getData());
            p = p.next ;
        }
    }


    public static class Node{
        private int data ;
        private Node next ;
        public Node(int data,Node next){
            this.data = data ;
            this.next = next ;
        }
        public int getData(){
            return this.data ;
        }
    }

    public static void main(String args[]){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i=0;i<100;i++){
            singlyLinkedList.insertToHead(i*5);
        }
        singlyLinkedList.show();
        singlyLinkedList.insertBeforeNode(5);
        singlyLinkedList.insertBeforeNode(15);
        singlyLinkedList.insertBeforeNode(20);
        singlyLinkedList.show();
        System.out.println("删除所有数据");
        singlyLinkedList.deleteAll();
        singlyLinkedList.show();
        System.out.println("初始化数据");
        for (int i=0;i<20;i++){
            singlyLinkedList.insertToHead(i*5);
        }
        singlyLinkedList.show();
        System.out.println("打印删除后的数据");
        singlyLinkedList.deleteByDate(5);
        singlyLinkedList.deleteByDate(10);
        singlyLinkedList.show();
        singlyLinkedList.deleteByNode(new Node(15,null));
        System.out.println("打印删除Node后的数据");
        singlyLinkedList.show();
    }
}
