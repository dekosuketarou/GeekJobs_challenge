/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateFolder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
/**
 *
 * @author guest1Day
 */
public class ManipulateFile3 {
    public static void main(String[]args) throws IOException{
        //標準クラスLinkedListの処理について処理をログファイルに残していく
        //
        
        //Fileインスタンスを作成
        File file=new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\DateProject\\src\\java\\DateFolder\\log.txt");
        //logファイルを読み出し可能に
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        //書き出し可能に
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        //Dateクラスで現在の日時を取得
        Date now=new Date();
        //SimpleDateFormatで時間表示形式を指定
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        
        //LinkedListのインスタンスを作成
        LinkedList<String> LL=new LinkedList<>();
        //LinkedListに文字列を登録
        bw.write(sdf.format(now)+"文字列「たぬき」を入力"+"を開始　");
        LL.add("たぬき");//[たぬき]
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"文字列「きつね」を入力"+"を開始　");
        LL.add("きつね");//[たぬき][きつね]
        bw.write(sdf.format(now)+"　終了\r\n");

        bw.write(sdf.format(now)+"文字列「ねこ」を最初に入力"+"を開始　");
        LL.addFirst("ねこ");//[ねこ][たぬき][きつね]
        bw.write(sdf.format(now)+"　終了\r\n");

        bw.write(sdf.format(now)+"文字列「たぬき」を最初に入力"+"を開始　");
        LL.addFirst("こぶた");//[こぶた][ねこ][たぬき][きつね]
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"文字列「ねこ」を最後に入力"+"を開始　");
        LL.addLast("ねこ");//[こぶた][ねこ][たぬき][きつね][ねこ]
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"LLの要素１を「こねこ」に置換"+"を開始　");
        LL.set(1,"こねこ");
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"最初の要素を取得し表示"+"を開始　");
        System.out.println(LL.getFirst());
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"最後の要素を取得し表示"+"を開始　");
        System.out.println(LL.getLast());
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"最前列から検索して「ねこ」のある位置を検索"+"を開始　");
        System.out.println(LL.indexOf("ねこ"));
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"最後尾から検索して「こねこ」のある位置を検索"+"を開始");
        System.out.println(LL.lastIndexOf("こねこ"));
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"LLに「ぶた」が登録されているか検索"+"を開始");
        System.out.println(LL.contains("ぶた"));
        bw.write(sdf.format(now)+"　終了\r\n");
        
        bw.write(sdf.format(now)+"LLに「ねこ」が登録されているか検索"+"を開始");
        System.out.println(LL.contains("ねこ"));
        bw.write(sdf.format(now)+"　終了\r\n");
        
        //書き込んだ後はクローズ
        bw.close();
        
        String str;
        while((str = br.readLine()) != null){
        System.out.println(str);
        }
       
     
    }
}
