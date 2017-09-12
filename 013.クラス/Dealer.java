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



    //コンストラクタ
    //Dealerがインスタンス化されたとき、1~13を4種類、計52枚のカードを作り出す
    public Dealer(){
        for(int i = 1 ; i<=4 ; i++){
            for(int j = 1 ; j <= 13 ; j ++){
                cards.add(j);
            }
        }
    }
    
    //最初の二枚のカードを配るメソッド
    public ArrayList<Integer> deal(){
        //Randomをインスタンス化して乱数を取得する
        Random random=new Random();
        if(myCards.size()==0){
            //カードを二枚取得する
            for(int i=0;i<2;i++){
                //一枚目のカードを取得する
                if(checkCards.size()==0){
                    
                    //1~52枚目のカードを引く
                    int c=random.nextInt(52);
                    
                //    System.out.println(c+"　　　　deal乱数チェック1番目");
                
                    //取得したカードの情報をそれぞれに登録
                    checkCards.add(c);
                    pickCards.add(c);
                //二枚目のカードを取得する    
                }else if(checkCards.size()==1){
                    //上記同様
                    int c=random.nextInt(52);
                    
                //    System.out.println(c+"　　　　deal乱数チェック2番目");
                
                    //今まで取得したカードと今引いたカードの数値が同値の時
                    //改めてカードを引き直す処理をする
                    for(int j=0;j<pickCards.size();j++){
                        if(pickCards.get(j)==c){
                            deal();
                            break;
                        }

                    }
                    //異なるカードの乱数を取得した場合、乱数を登録する    
                    checkCards.add(c);
                    pickCards.add(c);                  
                }
            }
        }
        
        return checkCards;
    }
    
    //ランダムで一枚のカードを引くメソッド
    public ArrayList<Integer>hit(){       
        Random random=new Random();
        //乱数の重複回避のためにbooleanを宣言
        boolean bl=false;
        
        //Humanクラスに設定したhitを行うかどうかの判定
        //hitblはcheckSumで判定する
        if(hitbl==true){
            //hit判定をtrueならば以降の処理を行う
            int c=random.nextInt(52);
            
            //System.out.println(c+"　　　　hitチェック");
            
            //今まで取得したカードと今引いたカードの数値が同値の時
            //改めてカードを引き直す処理をする
                   //pickCardsは今まで引いたカードの乱数を保持している
                   //pickCardsの配列数分、今引いた乱数cと照らし合わせる
                   //もし一致した場合はblがtrueになり、hitメソッドを改めて起動する。
            for(int i=0;i<pickCards.size();i++){
                if(pickCards.get(i)==c){
                   bl=true;           
                }                                   
            }
            if(bl==true){
                hit();
            //新しい乱数の場合はその乱数を処理する    
            }else if(bl==false){

            //異なるカードの乱数を取得した場合、乱数を登録する    
            checkCards.add(c);
            //System.out.println(checkCards.size()+"　　　　hitチェック");
            pickCards.add(c);
            }
            //System.out.println(checkCards.size()+"　　　　hitチェックラスト");
        }
        //checkCardsは一時的に保持した乱数
        //setCardsでcheckCardsに保持されている情報はすべて消去される
        return checkCards;
    }
    
    
    @Override
    public void  setCard(ArrayList<Integer> card){
        //手に入れた配列情報をmyCardsに加える
        for(int i :card){
           this.myCards.add(i);
           
       }
       /*
       for(int i=0;i<myCards.size();i++){
           System.out.println(myCards.get(i)+"       myCardsチェックsetCards");
       }
        */
       //保持している一時ファイルを削除する
       for(int i=0;i<checkCards.size();){
           checkCards.remove(i);
           
       //    System.out.println(checkCards.size()+"ディーラー一時乱数要素数");
       
       }
       for(int i=0;i<myCards.size();i++){
       //    System.out.println(myCards.get(i)+"　　　　履歴削除後myCardsチェックsetCards");
       }
   }
    @Override 
    public boolean checkSum(){
        //hit判定の条件変数
        int hit=17;
        int sum=0;
        int sum2=0;
        boolean bl=false;
        for(int i:myCards){
            int plus=cards.get(i);
            //    System.out.println(i+"　　　　checkSumの乱数チェック");
            //      System.out.println(plus+"　　　　ディーラーcheckSumのチェック");
            
            if(plus>10){
                plus=10;
            //    System.out.println(i+"　　　　checkSumの乱数チェック");
            //        System.out.println(plus+"　　　　ディーラーcheckSumのチェック");
            }
            if(plus==1){
                plus=11;
                bl=true;
            //    System.out.println(i+"　　　　checkSumの乱数チェック");
            //      System.out.println(plus+"　　　　ディーラーcheckSumのチェック");
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
        
        //System.out.println(sum+"　　　　sumのチェック");
        //System.out.println(sum2+"　　　　sum2のチェック");
        if(sum==21){
            hitbl=false;
         
            
        }else if(sum2==21){
            hitbl=false;
          
            
        }else if(sum<21 && sum>hit || bl==true &&sum2<21 && sum2>hit){
            hitbl=false;
           
        }else if(sum<hit && bl==true && sum2<hit){
            hitbl= true;
        }else if(sum>21 && sum2>21){
        
            hitbl= false;
        }
        
    

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
            if(plus==1){
                plus=11;
                bl=true;
            }
            if(plus>10){
                plus=10;
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
        }else if(bl==true&&sum2==21){
            result=sum2;
        }else if(sum>21 && bl==true && sum2<21){
            result=sum2;
        }else if(sum<21){
            result=sum;
        }else if(sum>sum2 &&bl==true){
            result=sum;
        }else{
            result=sum;
        }
        
        return result;
    }
}
