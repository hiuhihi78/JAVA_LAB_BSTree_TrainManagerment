
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ManagerTrain {

    Validation validation = new Validation();

    public ManagerTrain() {
    }

    // menu
    public void menu() {
        System.out.println("Train Manager");
        System.out.println("-----------------------------");
        System.out.println("1.1.      Load data from file");
        System.out.println("1.2.      Input & insert data");
        System.out.println("1.3.      In-order traverse");
        System.out.println("1.4.      Breadth-first traverse");
        System.out.println("1.5.      In-order traverse to file");
        System.out.println("1.6.      Search by pcode");
        System.out.println("1.7.      Delete by pcode by copying");
        System.out.println("1.8.      Simply balancing");
        System.out.println("1.9.      Count number of trains");
    }

    //load data from file
    public void loadFile(BSTreeTrain tree) {
        String fname = null;
        try {
            fname = validation.getInputString("file name");
            Load_File(tree, fname);
        } catch (Exception e) {
            System.out.println("This file is not contain in system!\n");
        }
    }

    public void Load_File(BSTreeTrain treeTrain, String fname) throws IOException {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] arr;
        int seat, booked;
        String tcode, train_name, depart_place;
        double depart_time;
        //check list empty to loading
        if (!treeTrain.isEmpty()) {
            String getYesNo = validation.getInputYesNo();
            if (!getYesNo.equalsIgnoreCase("y")) {
                return;
            }
        }
        while (true) {
            s = br.readLine();
            if (s == null || s.length() < 6) {
                break;
            }
            arr = s.split("[|]");
            tcode = arr[0].trim();
            train_name = arr[1].trim();
            seat = Integer.parseInt(arr[2].trim());
            booked = Integer.parseInt(arr[3].trim());
            depart_time = Double.parseDouble(arr[4].trim());
            depart_place = arr[5].trim();
            treeTrain.insert(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
        }
        fr.close();
        br.close();
        System.out.println("Successfully!\n");
    }

    //insert node
    public void insert(BSTreeTrain treeTrain) {
        String tcode = validation.getInputString("tcode");
        String train_name = validation.getInputString("train name");
        int seat = validation.getInputInt("seat");
        int booked = validation.getBooked(seat);
        double depart_time = validation.getDepartTime();
        String depart_place = validation.getInputString("depart place");
        treeTrain.insert(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
        System.out.println("Successfully!\n");
    }

    // in order
    public void inOrder(BSTreeTrain treeTrain) {
        System.out.println("In-order traverse");
        System.out.println("------------------");
        treeTrain.in_Order(treeTrain.root);
        System.out.println("");
    }

    // breadth first search
    public void breadthFirst(BSTreeTrain treeTrain) {
        System.out.println("Breadth-first traverse");
        System.out.println("-----------------------");
        treeTrain.breadth_first(treeTrain.root);
        System.out.println("");
    }

    //in-order traverse to file
    public void inOrderToFile(BSTreeTrain treeTrain) {
        String fname = null;
        while (true) {
            try {
                fname = validation.getInputString("name file");
                saveFileInOder(fname , treeTrain);
                System.out.println("Successfully!\n");
                return;
            } catch (Exception e) {
            }
        }
    }

    public void saveFileInOder(String fname, BSTreeTrain treeTrain) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        treeTrain.in_Oder_TreeToArrayList(treeTrain.root); // 
        for(int i = 0; i < treeTrain.in_oder_tree.size(); i++){
            Train train = treeTrain.in_oder_tree.get(i);
            pw.printf("%-10s | %-10s | %-10d | %-10d | %-10f | %-10s\n",
                    train.getTcode(), train.getTrain_name(),
                    train.getSeat(), train.getBooked(),
                    train.getDepart_time(), train.getDepart_place());
        }
        pw.close();
        fw.close();
        System.out.println("Successfully!\n");
    }

    //search by tcode
    public void searchByTcode(BSTreeTrain treeTrain) {
        System.out.println("Search train by tcode");
        System.out.println("----------------------");
        String tcode = validation.getInputString("tcode");
        NodeTrainBST node = treeTrain.search(treeTrain.root, tcode);
        if (node == null) {
            System.err.println("This train with this tcode is not contain in system!\n");
        } else {
            System.out.println(node.info);
        }
    }

    //delete by copying
    public void deleteBycopying(BSTreeTrain treeTrain) {
        System.out.println("Delete train by tcode use delete by copying method");
        System.out.println("--------------------------------------------------");
        String tcode = validation.getInputString("tcode");
        NodeTrainBST train = treeTrain.search(treeTrain.root, tcode);
        if (train == null) {
            System.out.println("The train with this tcode is not contain in system!\n");
        }
        treeTrain.deleteByCopying(tcode.trim());
    }

    // simply balancing
    public void simplyBalancing(BSTreeTrain treeTrain) {
        treeTrain.simpleBalance();
        System.out.println("Successfully!\n");
    }

    //count number of train
    public void countNumberOfTrain(BSTreeTrain treeTrain) {
        int numberTrain = treeTrain.totalNode();
        System.out.println("Total information trains in system is: " + numberTrain + "\n");
    }

}
