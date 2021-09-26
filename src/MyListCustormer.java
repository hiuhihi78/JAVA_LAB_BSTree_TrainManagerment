/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class MyListCustormer {
    NodeCustormer head,tail;
    public MyListCustormer() {
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addLast(Custormer xCustormer){
        NodeCustormer q = new NodeCustormer(xCustormer);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    
    void visit(NodeCustormer p) {
        if (p != null) {
            System.out.print(p.info + "\n");
        }
    }

    void traverse() {
        NodeCustormer p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }
    
    
    NodeCustormer searchByCcode(String code) {
        NodeCustormer p = head;
        while (p != null) {
            if (p.info.getID().equalsIgnoreCase(code)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    
//    public NodeCustormer SearchByCcode(String xCode) {
//        NodeCustormer p = head;
//        while (p != null) {
//            if (p.info.getID().equalsIgnoreCase(xCode)) {
//                return (p);
//            }
//            p = p.next;
//        }
//        return null;
//    }
    
    void removeFrist() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void remove(NodeCustormer q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFrist();
            return;
        }
        NodeCustormer f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; // q is not found in the list
        } else {
            NodeCustormer q1 = q.next;
            f.next = q1;
            if (q == tail) {
                tail = f;
            }
        }

    }
}
