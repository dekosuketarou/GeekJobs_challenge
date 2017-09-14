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
        Dealer dealer=new Dealer();
        User user =new User();
        
        user.setCard(dealer.deal());
        dealer.setCard(dealer.deal());
        
        for(int i=0;i<100;i++){
            System.out.println("貴方の手札");
            
            for(int cards:user.myCards){
                System.out.println("カード："+cards);
            }
            System.out.println("\n貴方の手札合計:"+user.open());
            
            user.checkSum();
            
            System.out.println("カードを引きますか？");
            Scanner scan=new Scanner(System.in);
            int select=scan.nextInt();
            switch(select){
                case 1:
                    
                    user.setCard(dealer.hit());
                    
                    if(dealer.checkSum()){
                        dealer.setCard(dealer.hit());
                    }
                    
                    break;
                case 3:   
                    while(dealer.checkSum()){
                        dealer.setCard(dealer.hit());
                    }                   
                    i+=100;
                    break;
            }
            //手札が21以下でディーラーより合計値が大きいとき
            if(user.open()<=21 && user.open()>dealer.open()){
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("やった！ディーラーに勝ったぞ！");
            //ユーザーの手札とディーラーの手札の合計が同じとき    
            }else if(user.open()==dealer.open()){
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("手札合計が同じだった・・・、あなたの負けだ");
            //ユーザーの手札の合計がディーラーの手札の合計を下回るとき    
            }else{
                System.out.println("\n貴方の手札合計:"+user.open());
                System.out.println("\nディーラーの手札合計"+dealer.open());
                System.out.println("一目瞭然！あなたの負けだ");
                
            }
            
            
            
        }
    }
}
