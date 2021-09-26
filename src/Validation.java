
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Validation {

    public Validation() {
    }

    private Scanner scanner = new Scanner(System.in);

    // get input String
    public String getInputString(String parameter) {
        String result;
        while (true) {
            System.out.print("Enter " + parameter + ": ");
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Invalid! " + parameter + " is not empty!");
                continue;
            } else {
                return result;
            }
        }
    }

    //get input int
    public int getInputInt(String paramater) {
        int result;
        while (true) {
            try {
                String temp = getInputString(paramater);
                result = Integer.parseInt(temp);
                if (result < 0) {
                    System.err.println(paramater + " must be positive interger!");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Invalid of " + paramater + ", " + paramater + " must be a number!");
            }
        }
    }

    //get input y/n
    public String getInputYesNo() {
        System.out.println("You wants to keep the existing data or not?(Y/N)");
        while (true) {
            String choice = getInputString("your choice");
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                return choice;
            } else {
                System.err.println("Invaild of choice!");
            }
        }
    }

    // get booked
    public int getBooked(int seat) {
        int result = 0;
        while (true) {
            result = getInputInt("booked");
            if (result > seat) {
                System.err.println("Booked seat must less than " + seat + "!");
            } else {
                return result;
            }
        }
    }

    public double getDepartTime() {
        double result = 0;
        while (true) {
            try {
                String temp = getInputString("depart time");
                result = Double.parseDouble(temp);
                if(result < 0){
                    System.err.println("Depart time must be geater or equal 0!");
                }else{
                    return result;
                }
            } catch (Exception e) {
                System.out.println("Depart time must be a number!");
            }
        }
    }
    
    public String getID(MyListCustormer list) {
        String ID = null;
        while (true) {
            ID = getInputString("ID");
            if (list.searchByCcode(ID)== null) {
                return ID;
            } else {
                System.out.println("This ID was exited in system!");
            }
        }
    }
    
    public String getInputNumber(String paramater) {
        String input = null;
        while (true) {
            try {
                input = getInputString("number");
                int temp = Integer.parseInt(input); //check is number
                if (input != null) {
                    return input;
                } else {
                    System.out.println("Invaild of " + paramater + "!");
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean checkTcodeExited(BSTreeTrain treeTrain, String tCode) {
        NodeTrainBST train = treeTrain.search(treeTrain.root, tCode);
        if(train == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkCcodeExited(MyListCustormer listCustormer, String cCode) {
        NodeCustormer custormer = listCustormer.searchByCcode(cCode);
        if(custormer == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkTcodeAndCcodeDuplicate(MyListBooking listBooking, String tCode, String cCode) {
        NodeBooking booking = listBooking.searchByTcodeAndCcode(tCode, cCode);
        if(booking == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkValidBookingSeat(BSTreeTrain treeTrain, String tCode, int seat) {
        NodeTrainBST nodeTrain = treeTrain.search(treeTrain.root, tCode);
        if(nodeTrain == null){
            return false;
        }
        Train train = nodeTrain.info;
        if(train == null){
            return false;
        }
        int available_seat = train.getSeat() - train.getBooked();
        if (available_seat == 0) {
            System.out.println("Train is  exhausted.");
            return false;
        }
        if (seat > available_seat) {
            System.out.println("Train not have enough seat!");
            return false;
        } else {
            return true;
        }
    }

    public int getAvalibleSeatByTcode(BSTreeTrain treeTrain, String tCode) {
        NodeTrainBST nodeTrain = treeTrain.search(treeTrain.root, tCode);
        Train train = nodeTrain.info;
        int seat = train.getSeat();
        int booked = train.getBooked();
        int avalibleSeat = seat - booked;
        return avalibleSeat;
    }
}
