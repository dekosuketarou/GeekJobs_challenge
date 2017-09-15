/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateFolder;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author guest1Day
 */
public class MojiArray1 {
    public static void main(String[]args) throws UnsupportedEncodingException{
        String name = "たまきゆうや";
        //getBytesにて文字のByte数を取得して出力
        //今回はShift-JIS、UTF-8を比べてみる
        System.out.println("私の名前のバイト数は\"Shift-JIS\"では"+name.getBytes("Shift-JIS").length);
        System.out.println("私の名前のバイト数は\"UTF-8\"では"+name.getBytes("UTF-8").length+"です");
        //lengthで文字の長さを取得し出力
        System.out.println("私の名前の長さは"+name.length()+"です");

    }   
}
