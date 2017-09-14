/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author DEKO
 */
public class Test {
    public static void main(String[]args){
        //ユーザーとディーラーのインスタンスを作成
        User user =new User();
        Dealer dealer=new Dealer();
        
        //双方の初めのカードを取得
        user.setCard(dealer.deal());
        dealer.setCard(dealer.deal());
        
        for(int i=0;i<100;i++){
            System.out.println("貴方の手札");
            //現在取得しているカードを表示
            for(int cards:user.myCards){
                System.out.println("カード："+cards);
            }
            //現在取得しているカードの合計数を表示
            System.out.println("\n貴方の手札合計:"+user.open());
            //バーストしているかの判定を表示
            //バーストしている場合はその場でプログラムを終了する
            user.checkSum();
            
            System.out.println("カードを引きますか？");
            System.out.println("引く場合は\"1\"を、引かない場合は\"3\"を入力してください");
            
            //Scannerクラスで入力受付
            Scanner scan=new Scanner(System.in);
            //入力した数値をselectへ代入
            int select=scan.nextInt();
            //取得した数値で分岐
            switch(select){
                case 1:
                    //引くを選んだ場合 1
                    //hitメソッドを使いカードを1枚取得する
                    user.setCard(dealer.hit());
                    //checkSumでtrueの時、dealerもhitメソッドを使いカードを一枚取得する
                    if(dealer.checkSum()){
                        dealer.setCard(dealer.hit());
                    }
                    
                    break;
                case 3:   
                    //引かないを選んだ場合
                    //dealerが引かない選択をするまでhitメソッドを繰り返す
                    //条件はcheckSumの変数stopの数値を変更
                    while(dealer.checkSum()){
                        dealer.setCard(dealer.hit());
                    }                   
                    i+=100;
                    break;
            }
            //手札が21以下でディーラーより合計値が大きいとき
            //または手札が21以下でディーラーがバーストしてしまったとき
            if(user.open()<=21 && user.open()>dealer.open()||user.open()<=21 && dealer.open()>21){
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("\nやった！ディーラーに勝ったぞ！");
            //ユーザーの手札とディーラーの手札の合計が同じとき    
            }else if(user.open()==dealer.open()){
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("\n手札合計が同じだった・・・、あなたの負けだ");
            //ユーザーの手札の合計がディーラーの手札の合計を下回るとき    
            }else{
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("\n一目瞭然！あなたの負けだ");
                
            }
            
            
            
        }
    }
}
