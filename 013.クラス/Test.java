/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;

import static human.Human.checkCards;
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
        //    System.out.println(dealer.cards.size());
        /*
        ArrayList<Integer>pool=dealer.deal();
        for(int i:pool){
            System.out.println(i);
        }
        */
        
        user.setCard(dealer.deal());
    
        dealer.setCard(dealer.deal());

            
        for(int i=0;i<10;i++){                
            System.out.println("新たにカードを引きますか？");
            for(int x:user.myCards){
                System.out.println("トランプ:"+Human.cards.get(x));
            }
            System.out.println("引く場合は\"1\"を");
            System.out.println("引かない場合は\"3\"を入力してください");
            int select=new Scanner(System.in).nextInt();
            if(select==1){
                
                user.checkSum(); 
                user.setCard(dealer.hit());
                
                dealer.checkSum();
                dealer.setCard(dealer.hit());

            }else if(select==3){
                for(int x=0;x<3;x++){
                    dealer.checkSum();
                    dealer.setCard(dealer.hit());
                }
                int flag=0;
                if(user.open()>dealer.open()&&user.open()<21){
                    flag=1;
                }else if(user.open()<dealer.open()&&dealer.open()<=21){
                    flag=2;
                }else if(user.open()==dealer.open()){
                    flag=3;
                }else if(user.open()>21){
                    flag=4;
                }
                
                if(flag==1){
                    System.out.println("あなたの勝ちだ！ディーラーの手札合計は"+dealer.open()+"だった");
                    System.out.println("カード合計"+user.open()+"で勝った");
                    System.exit(0);
                    
                }else if(flag==2){
                    System.out.println("ディーラーの手札のほうが強いようだ");
                    System.out.println("あなたは負けてしまった");
                    System.out.println("貴方の手札合計"+user.open()+"ディーラーの手札合計"+dealer.open());
                    System.exit(0);
                    
                }else if(flag==3){
                    System.out.println("ディーラーとカードの合計が同じだった");
                    System.out.println("あなたは負けてしまった");
                    System.out.println("貴方の手札合計"+user.open()+"ディーラーの手札合計"+dealer.open());
                    System.exit(0);
                    
                }else if(flag==4){
                    System.out.println("バーストしてしまいました");
                    System.out.println("あなたは負けてしまった");
                    System.out.println("貴方の手札合計"+user.open()+"ディーラーの手札合計"+dealer.open());
                    System.exit(0);                    
                    
                }
            
            
            }

           
            
        }
     

        
    }
}
