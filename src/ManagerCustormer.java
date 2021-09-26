/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hiuhihi78
 */
public class ManagerCustormer {

    Validation validation = new Validation();

    public ManagerCustormer() {
    }
   
    // menu
    public void menu(){
        System.out.println("Customer Manager");
        System.out.println("------------------------------");
        System.out.println("2.1.      Load data from file");
        System.out.println("2.2.      Input & add to the end");
        System.out.println("2.3.      Display data");
        System.out.println("2.4.      Save customer list to file");
        System.out.println("2.5.      Search by ccode");
        System.out.println("2.6.      Delete by ccode");
    }

    // load file
    public void LoadFile(MyListCustormer list) {
        String fname = null;
        while (true) {
            try {
                fname = validation.getInputString("file name");
                Load_File(list, fname);
                System.out.println("Successfully!\n");
                return;
            } catch (Exception e) {
                System.out.println("This file is not contain in system!\n");
                break;
            }
        }
    }

    public void Load_File(MyListCustormer list, String fname) throws IOException {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] arr;
        String ID, Name;
        int Phone;
        while (true) {
            s = br.readLine();
            if (s == null || s.length() < 3) {
                break;
            }
            arr = s.split("\\|");
            ID = arr[0].trim();
            Name = arr[1].trim();
            Phone = Integer.parseInt(arr[2].trim());
            list.addLast(new Custormer(ID, Name, Phone));
        }
        fr.close();
        br.close();
    }

    // add to end
    public void addToTheEnd(MyListCustormer list) {
        String ID = validation.getID(list);
        String Name = validation.getInputString("name");
        int Phone = validation.getInputInt("phone");
        list.addLast(new Custormer(ID, Name, Phone));
        System.out.println("Successfully!\n");
    }

    // display
    public void display(MyListCustormer list) {
        if (list.isEmpty()) {
            System.out.println("List empty!\n");
        }
        list.traverse();
    }

    // save file
    public void SaveFile(MyListCustormer list) {
        String fname = null;
        while (true) {
            try {
                fname = validation.getInputString("name file");
                Save_File(list, fname);
                System.out.println("Successfully!\n");
                return;
            } catch (Exception e) {
            }
        }
    }

    public void Save_File(MyListCustormer list, String fname) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeCustormer p = list.head;
        while (p != null) {
            pw.printf("%-10s | %-10s | %-10d \n",
                    p.info.getID(), p.info.getName(), p.info.getPhone());
            p = p.next;
        }
        pw.close();
        fw.close();
        System.out.println("Succsessfully!\n");
    }

    // search by ccode
    public void SearchByCcode(MyListCustormer list) {
        String code = validation.getInputString("code");
        NodeCustormer xNode = list.searchByCcode(code);
        if (xNode == null) {
            System.out.println("This code not contain in System!");
        } else {
            System.out.println(xNode.info);
        }
    }

    // delere by ccode
    public void DeleteByCcode(MyListCustormer list) {
        String code = validation.getInputString("code");
        NodeCustormer xNode = list.searchByCcode(code);
        if (xNode == null) {
            System.out.println("This code not contain in System!");
            return;
        }
        list.remove(xNode);
        System.out.println("Successfully!\n");
    }

}
