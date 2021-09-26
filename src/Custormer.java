/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hiuhihi78
 */
public class Custormer {
    
    private String ID;
    private String Name;
    private int Phone;

    public Custormer() {
    }

    public Custormer(String ID, String Name, int Phone) {
        this.ID = ID;
        this.Name = Name;
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    
    
    @Override
    public String toString() {
        String s = String.format("%-10s | %-10s | %-10d", ID,Name,Phone);
        return s;
    }
    
    
}
