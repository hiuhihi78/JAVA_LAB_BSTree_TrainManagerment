/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class NodeCustormer {
    Custormer info;
    NodeCustormer next;

    public NodeCustormer() {
    }

    public NodeCustormer(Custormer info){
        this.info = info;
        this.next = null;
    }
    
    public NodeCustormer(Custormer info, NodeCustormer next) {
        this.info = info;
        this.next = next;
    }

    public Custormer getInfo() {
        return info;
    }
    
}
