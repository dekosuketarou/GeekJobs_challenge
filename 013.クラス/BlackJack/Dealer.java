/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author DEKO
 */
public class Dealer extends Human{
   
    //全てのカードを保持する配列
    static ArrayList<Integer>cards=new ArrayList<Integer>();

    //コンストラクタ
    //Dealerがインスタンス化されたとき、1~13を4種類、計52枚のカードを作り出す
    public Dealer(){
        for(int i = 1 ; i<=4 ; i++){
            for(int j = 1 ; j <= 13 ; j ++){
                cards.add(j);
            }
        }
    }
    
    //まだ手札がないときトランプを2枚引く
    public ArrayList<Integer> deal(){
            
        ArrayList<Integer> drawCards=new ArrayList<>();
        //手札が有無を確認
        if(myCards.size()==0){
            //Randomインスタンスを作成
            Random random=new Random();
            //2枚のカードを引く
            for(int i=0;i<2;i++){
            //Integer配列cardsの配列要素数から乱数を取得しdrawに保存    
            int draw=random.nextInt(cards.size());
            //Integer配列cardsの配列番号にdrawを引数として渡し、Integer配列drawCardsに加える
            drawCards.add(cards.get(draw));
            //Integer配列cardsから上記で取得した配列番号をremoveで削除する
            //これで同じカードを引くことはなくなる
            cards.remove(draw);
            }
        //手札があったときは何も処理されない    
        }else{
            System.out.println("すでに初めの手札は引いています");
        }      
        return drawCards;
    }
    
    public ArrayList<Integer>hit(){       
        ArrayList<Integer>hitCard=new ArrayList<>();
        Random random=new Random();
        
        int draw=random.nextInt(cards.size());
        hitCard.add(cards.get(draw));
        cards.remove(draw);
        
        return hitCard;
    }
    
    
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
        int stop=18;
        boolean checker=true;
        for(int check:myCards){
            if(check>10){
                check=10;
            }
            sum +=check;
        }
        
        if(sum>=stop){
            checker=false;
        }else if(sum<stop){
            checker=true;
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
