/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateFolder;

/**
 *
 * @author guest1Day
 */
public class MojiArray2 {
    public static void main(String[]args){
        //メールアドレス
        String mailAdress="honyarara.honnnyara@gmail.com";
        //indexOfで@の座標を取得しそれ以降を表示するために
        //1を足した材表をsubstringに引数として渡す
        System.out.println(mailAdress.substring(mailAdress.indexOf("@")+1));
        
    }
}
