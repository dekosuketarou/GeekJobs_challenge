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
    //全てのカードを保持する配列
    static ArrayList<Integer>cards=new ArrayList<Integer>();
        //一時的な乱数を保持する配列
    static ArrayList<Integer>checkCards=new ArrayList<Integer>();
    //取得した乱数の保持をする配列
    static ArrayList<Integer>pickCards=new ArrayList<Integer>();
    //hit判定のboolean
    static boolean hitbl=true;
    
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> card);
    public abstract boolean checkSum();
}
