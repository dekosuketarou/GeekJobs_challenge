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
public class User extends Human{
    
    
    @Override
    public void  setCard(ArrayList<Integer> card){
        for(int i:card){
            myCards.add(i);
        }
   }
    
    //myCardsの合計値を取得しバーストしていないかをチェック
    @Override 
    public boolean checkSum(){
        int sum=0;
        boolean checker=true;
        for(int check:myCards){
            if(check>10){
                check=10;
            }
            sum +=check;
        }
        
        if(sum>21){
            System.out.println("貴方の手札はバーストしました");
            System.exit(0);
        }else if(sum<21){
            System.out.println("まだカードを引くことができます");
            checker=true;
        }else if(sum==21){
            System.out.println("手札の合計が21だ、勝負にでましょう");
            checker=false;
        }
        
        return checker;
    }
    @Override
    public int open(){
        int sum=0;
     
        for(int check:myCards){
            if(check>10){
                check=10;
            }
            sum +=check;
        }
        return sum;
    }  
}