/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NodeTrainBST {
    Train info;
    NodeTrainBST left;
    NodeTrainBST right;

    public NodeTrainBST() {
    }
    
    public  NodeTrainBST(Train xTrain){
        this.info = xTrain;
        this.left = null;
        this.right = null;
    }
    
}
