/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;

import java.util.ArrayList;
/**
 *
 * @author DEKO
 */
public abstract class Human {
    
    ArrayList<Integer>myCards=new ArrayList<Integer>();
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> card);
    public abstract boolean checkSum();
}
