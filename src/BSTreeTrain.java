/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Admin
 */
public class BSTreeTrain {

    NodeTrainBST root;

    public BSTreeTrain() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void visit(NodeTrainBST nodeTrain) {
        System.out.println(nodeTrain.info);
    }

    public NodeTrainBST search(NodeTrainBST nodeTrain, String tcode) {
        if (nodeTrain == null) { // nodeTrain == position node of tree to start searching
            return null;
        }
        if (nodeTrain.info.getTcode().equalsIgnoreCase(tcode)) {
            return nodeTrain;
        }
        if (nodeTrain.info.getTcode().compareToIgnoreCase(tcode) < 0) {
            return search(nodeTrain.left, tcode);
        } else {
            return search(nodeTrain.right, tcode);
        }
    }

    public void insert(Train train) {
        // key nodeTrain.getTcode();
        String tcode = train.getTcode();
        if (root == null) {
            root = new NodeTrainBST(train);
            return;
        }
        NodeTrainBST f, p;
        f = null;
        p = root;
        while (p != null) {
            String xCodeT = p.info.getTcode();
            if (xCodeT.equalsIgnoreCase(tcode)) {
                System.out.println("The key " + tcode + " already exists, no insertion");
                return;
            }
            f = p;
            if (xCodeT.compareToIgnoreCase(tcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (tcode.compareToIgnoreCase(f.info.getTcode()) > 0) {
            f.left = new NodeTrainBST(train);
        } else {
            f.right = new NodeTrainBST(train);
        }
    }

    public void breadth_first(NodeTrainBST nodeTrain) {
        if (nodeTrain == null) {
            System.out.println("System is empty!");
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(nodeTrain);
        NodeTrainBST r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            System.out.println(r.info);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void pre_Order(NodeTrainBST nodeTrain) {
        if (nodeTrain == null) {
            return;
        }
        visit(nodeTrain);
        pre_Order(nodeTrain.left);
        pre_Order(nodeTrain.right);
    }

    public void in_Order(NodeTrainBST nodeTrain) {
        if (nodeTrain == null) {
            return;
        }
        in_Order(nodeTrain.left);
        visit(nodeTrain);
        in_Order(nodeTrain.right);
    }

    public void post_Order(NodeTrainBST nodeTrain) {
        if (nodeTrain == null) {
            return;
        }
        post_Order(nodeTrain.left);
        post_Order(nodeTrain.right);
        visit(nodeTrain);
    }

    

//    // in order to make array list from smallest tcode to greater tcode
//    public void in_Order_ForBalanceTree(ArrayList<Train> t, NodeTrainBST p) {
//        if (p == null) {
//            return;
//        }
//        in_Order_ForBalanceTree(t, p.left);
//        t.add(p.info);
//        in_Order_ForBalanceTree(t, p.right);
//    }
//
//    // get positon of node by tcode
//    public int positionNodeForIn_Order(String tcode) {
//        int length = in_oder_tree.size();
//        for (int i = 0; i < length; i++) {
//            if (in_oder_tree.get(i).getTcode().equalsIgnoreCase(tcode)) {
//                return i;
//            }
//        }
//        return -1; //if cannot find in tree
//    }
//
//    public void balace(ArrayList<Train> t, String tcode_1, String tcode_2) {
//        int i = positionNodeForIn_Order(tcode_1);
//        int j = positionNodeForIn_Order(tcode_2);
//        if (i > j) {
//            return;
//        }
//        int k = (i + j) / 2;
//        Train train = in_oder_tree.get(k);
//        //System.out.println(train);
//        insert(train); // insert
//        if(k - 1 < 0 || k + 1 > in_oder_tree.size() - 1){
//            return;
//        }
//        String tcode_1_next = in_oder_tree.get(k - 1).getTcode();
//        String tcode_2_next = in_oder_tree.get(k + 1).getTcode();
//        balace(t, tcode_1, tcode_1_next);
//        balace(t, tcode_2, tcode_2_next);
//    }
//
//    public void simpleBalance() {
//        ArrayList<Train> t = new ArrayList<>();
//        in_Oder_TreeToArrayList(root); // get node into array list to get tcode or position
//        in_Order_ForBalanceTree(t, root);
//        clear();
//        int size = t.size();
//        String tcodeFirstNode = in_oder_tree.get(0).getTcode();
//        String tcodeLastNode = in_oder_tree.get(size - 1).getTcode();
//        balace(t, tcodeLastNode, tcodeLastNode);
//        in_oder_tree = null;
//    }
    void inOrder(ArrayList<Train> t, NodeTrainBST p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Train> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Train x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void simpleBalance() {
        ArrayList<Train> t = new ArrayList<Train>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }
    
    // get elemment node of tree to array list for count node
    ArrayList<Train> in_oder_tree = new ArrayList<>();
    public void in_Oder_TreeToArrayList(NodeTrainBST nodeTrain) {
        if (nodeTrain == null) {
            return;
        }
        in_Oder_TreeToArrayList(nodeTrain.left);
        in_oder_tree.add(nodeTrain.info);
        in_Oder_TreeToArrayList(nodeTrain.right);
    }

    public int totalNode() {
        in_Oder_TreeToArrayList(root);
        int total = in_oder_tree.size();
        in_oder_tree = null;
        return total;
    }

    //delete by copying
    public void deleteByCopying(String tcode) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        NodeTrainBST f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.getTcode().equalsIgnoreCase(tcode)) {
                break;//Found key x
            }
            if (tcode.compareToIgnoreCase(p.info.getTcode()) > 0) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + tcode + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) { // p is a leaf node
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            System.out.println("Successfully!\n");
            return;
        }
        if (p.left != null && p.right == null) { // p has only left child
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) { // p has only right child
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            System.out.println("Successfully!\n");
            return;
        }
        if (p.left != null && p.right != null) { // p has both left and right children
            NodeTrainBST q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p 
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
            System.out.println("Successfully!\n");
        }
    }
}
