/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ManagerBooking {

    public ManagerBooking() {
    }

    Validation validation = new Validation();

    //menu
    public void menu() {
        System.out.println("Booking manager");
        System.out.println("----------------------");
        System.out.println("3.1.      Input data");
        System.out.println("3.2.      Display data width available seats");
        System.out.println("3.3.      Sort  by tcode + ccode");
    }

    //input data
    public void inputData(BSTreeTrain treeTrain, MyListCustormer listCustormer, MyListBooking listBooking) {
        String tCode = validation.getInputString("train code");
        String cCode = validation.getInputString("customer code");
        int seat = validation.getInputInt("number of seats to be booked");
        boolean tCodeExited = validation.checkTcodeExited(treeTrain, tCode);
        boolean cCodeExited = validation.checkCcodeExited(listCustormer, cCode);
        boolean tCodeAndCcodeDuplicate = validation.checkTcodeAndCcodeDuplicate(listBooking, tCode, cCode);
        boolean validBookingSeat = validation.checkValidBookingSeat(treeTrain, tCode, seat);
        if (tCodeAndCcodeDuplicate == true) {
            System.out.println("This info was exited in system!\n");
            return;
        }
        if (tCodeExited == false || cCodeExited == false) {
            System.out.println("tcode or ccode not contain in system!\n");
            return;
        }
        if (validBookingSeat == false) {
            return;
        }
        listBooking.addLast(new Booking(tCode, cCode, seat));
        System.out.println("Successfully!\n");
        NodeTrainBST nodeTrain = treeTrain.search(treeTrain.root, tCode);
        nodeTrain.info.setBooked(nodeTrain.info.getBooked() + seat); // adding booking seat in tree train
    }

    public void displayData(MyListBooking listBooking, BSTreeTrain listTrain) {
        NodeBooking p = listBooking.head;
        if (listBooking.size() == 0) {
            System.out.println("List is empty!\n");
            return;
        }
        while (p != null) {
            // search obj in train list to get avalible seat 
            String tcode = p.info.getTcode();
            int avalibleSeat = validation.getAvalibleSeatByTcode(listTrain, tcode);
            System.out.println(p.info + "|" + avalibleSeat);
            p = p.next;
        }
        System.out.println("");
    }

    public void sortTcodeCcode(MyListBooking listBooking) {
        listBooking.sortByTcodeCcode();
        System.out.println("Successfully!\n");
    }

}
