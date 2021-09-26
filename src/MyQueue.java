
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class MyQueue {

    LinkedList<NodeTrainBST> list;

    public MyQueue() {
        list = new LinkedList<NodeTrainBST>();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(NodeTrainBST nodeTrain) {
        list.addLast(nodeTrain);
    }

    public NodeTrainBST dequeue() {
        if (isEmpty() == true) {
            return null;
        } else {
            return list.removeFirst();
        }
    }
    
    public NodeTrainBST font(NodeTrainBST nodeTrainBST){
        if(isEmpty() == true){
            return null;
        }else{
            return list.getFirst();
        }
    }

}
