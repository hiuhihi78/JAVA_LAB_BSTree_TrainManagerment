/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class MyListBooking {
    
    NodeBooking head;
    NodeBooking tail;

    public MyListBooking() {
        head = tail = null;
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    void clear(){
        head = tail = null;
    }
    
    void  visit(NodeBooking q){
        System.out.println(q.info);
    }
    
    void traverse(){
        NodeBooking p = head;
        while(p!=null){
            visit(p);
            p = p.next;
        }
    }
    
    void addLast(Booking x) {
        NodeBooking q = new NodeBooking(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
        
    }
    
    NodeBooking searchByTcodeAndCcode(String xTcode, String xCcode) {
        NodeBooking p = head;
        while (p != null) {
            if (p.info.getTcode().equalsIgnoreCase(xTcode) &&
                    p.info.getCcode().equalsIgnoreCase(xCcode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }
    
    int size(){
        NodeBooking p = head;
        int count = 0;
        while(p != null){
            count = count + 1;
            p = p.next;
        }
        return count;
    }
    
    void sortByTcodeCcode(){
        NodeBooking pi,pj;
        Booking temp;
        for(pi = head; pi != null; pi = pi.next){
            for(pj = pi.next; pj != null; pj = pj.next){
                String before = pi.info.getTcode() + pi.info.getCcode();
                String after = pj.info.getTcode() + pj.info.getCcode();
                if(before.compareTo(after) > 0){
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
    
    
    
    
    
    
    
}
