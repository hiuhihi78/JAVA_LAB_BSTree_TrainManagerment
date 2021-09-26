/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class NodeBooking {
    Booking info;
    NodeBooking next;

    public NodeBooking() {
    }
     
    public NodeBooking(Booking info){
        this.info = info;
        this.next = null;
    }

    public NodeBooking(Booking info, NodeBooking next) {
        this.info = info;
        this.next = next;
    }

    public Booking getInfo() {
        return info;
    }

    public void setInfo(Booking info) {
        this.info = info;
    }

    public NodeBooking getNext() {
        return next;
    }

    public void setNext(NodeBooking next) {
        this.next = next;
    }
    
    
    
}
