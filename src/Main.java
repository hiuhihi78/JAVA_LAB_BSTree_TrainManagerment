/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManagerTrain managerTrain = new ManagerTrain();
        ManagerCustormer managerCustormer = new ManagerCustormer();
        ManagerBooking managerBooking = new ManagerBooking();
        BSTreeTrain treeTrain = new BSTreeTrain();
        MyListCustormer listCustormer = new MyListCustormer();
        MyListBooking listBooking = new MyListBooking();
        Validation validation = new Validation();
        String choice = null;
        while (true) {
            managerTrain.menu();
            managerCustormer.menu();
            managerBooking.menu();
            choice = validation.getInputString("your choice");
            switch (choice) {
                case "1.1":
                    managerTrain.loadFile(treeTrain);
                    break;
                case "1.2":
                    managerTrain.insert(treeTrain);
                    break;
                case "1.3":
                    managerTrain.inOrder(treeTrain);
                    break;
                case "1.4":
                    managerTrain.breadthFirst(treeTrain);
                    break;
                case "1.5":
                    managerTrain.inOrderToFile(treeTrain);
                    break;
                case "1.6":
                    managerTrain.searchByTcode(treeTrain);
                    break;
                case "1.7":
                    managerTrain.deleteBycopying(treeTrain);
                    break;
                case "1.8":
                    managerTrain.simplyBalancing(treeTrain);
                    break;
                case "1.9":
                    managerTrain.countNumberOfTrain(treeTrain);
                    break;
                case "2.1":
                    managerCustormer.LoadFile(listCustormer);
                    break;
                case "2.2":
                    managerCustormer.addToTheEnd(listCustormer);
                    break;
                case "2.3":
                    managerCustormer.display(listCustormer);
                    break;
                case "2.4":
                    managerCustormer.SaveFile(listCustormer);
                    break;
                case "2.5":
                    managerCustormer.SearchByCcode(listCustormer);
                    break;
                case "2.6":
                    managerCustormer.DeleteByCcode(listCustormer);
                    break;
                case "3.1":
                    managerBooking.inputData(treeTrain, listCustormer, listBooking);
                    break;
                case "3.2":
                    managerBooking.displayData(listBooking, treeTrain);
                    break;
                case "3.3":
                    managerBooking.sortTcodeCcode(listBooking);
                    break;
                case "0":
                    treeTrain.in_Oder_TreeToArrayList(treeTrain.root);
                    System.out.println(treeTrain.in_oder_tree.size());
                //System.exit(0);
                default:
                    System.out.println("Invalid of choice!\n");
                    break;
            }
        }
    }

}
