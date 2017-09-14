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

//抽象クラスHuman
//抽象クラスはDealerクラス、Userクラスに継承する
public abstract class Human {
    //手持ちカードInteger配列myCardsを作成
    ArrayList<Integer>myCards=new ArrayList<Integer>();
    //抽象メソッドopenを作成
    public abstract int open();
    //抽象メソッドsetCardを作成
    public abstract void setCard(ArrayList<Integer> card);
    //抽象メソッドcheckSumを作成
    public abstract boolean checkSum();
}
