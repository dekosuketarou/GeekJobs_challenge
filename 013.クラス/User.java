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
       for(int i :card){
           this.myCards.add(i);
           
       }
       for(int i=0;i<checkCards.size();){
           checkCards.remove(i);
       //    System.out.println(checkCards.size()+"一時乱数要素数");
       }
       for(int i=0;i<myCards.size();i++){
       //    System.out.println(myCards.get(i)+"　　　　user履歴削除後myCardsチェックsetCards");
       }
   }
    @Override 
    public boolean checkSum(){
        int sum=0;
        int sum2=0;
        boolean bl=false;
        for(int i:myCards){
            int plus=cards.get(i);
            //    System.out.println(i+"　　　　usercheckSumの乱数チェック");
            //    System.out.println(plus+"　　　　usercheckSumのチェック");
            
            if(plus>10){
                plus=10;
            //    System.out.println(i+"　　　　usercheckSumの乱数チェック");
            //    System.out.println(plus+"　　　　usercheckSumのチェック3");
            }
            if(plus==1){
                plus=11;
                bl=true;
            //    System.out.println(i+"　　　　usercheckSumの乱数チェック");
            //    System.out.println(plus+"　　　　usercheckSumのチェック2");
            }
            sum+=plus;
        }
       
        if(bl==true&&sum>21){
            for(int i:myCards){
            int plus=cards.get(i);
            if(plus>10){
                plus=10;
            }
            sum2+=plus;
            }
            
        }
        
        //System.out.println(sum+"　　　　usersumのチェック");
        //System.out.println(sum2+"　　　　usersum2のチェック");
        
        /*
        if(sum==21){
            hitbl= false;
            
        }else if(sum2==21){
            hitbl= false;
            
        }else if(sum<21){
            hitbl= true;
        }else if(sum2<21){
            hitbl= true;
        }else if(sum>21 && sum2>21){
        //    System.out.println("userバーストしました");
            hitbl= false;
        }
        */
        hitbl=true;

        return hitbl;
    }
    @Override
    public int open(){
        int result=0;
        int sum=0;
        int sum2=0;
        boolean bl=false;
        for(int i:myCards){
            int plus=cards.get(i);
            
            if(plus>10){
                plus=10;
            }
            if(plus==1){
                plus=11;
                bl=true;
            }
            sum+=plus;
        }
        
        if(bl==true&&sum>21){
            for(int i:myCards){
            int plus=cards.get(i);
            if(plus>10){
                plus=10;
            }
            sum2+=plus;
            }
        }
        
        if(sum==21){
            result=sum;
        }else if(sum2==21){
            result=sum2;
        }else if(sum>21 && bl==true && sum2<21){
            result=sum2;
        }else if(sum<21 && sum2>21){
            result=sum;
        }else if(sum>sum2){
            result=sum;
        }else{
            result=sum;
        }
        
        return result;
    }
    
    
}