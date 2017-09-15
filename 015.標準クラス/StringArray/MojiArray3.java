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
public class MojiArray3 {
    public static void main(String[]args){
        //課題の文字列strを作成
        String str1="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        //strをそのまま表示
        System.out.println(str1);
        //replaceでフィルターに通して表示
        String str2=str1.replace("I","い");
        String str3=str2.replace("U","う");       
        System.out.println(str3);
    }
}
