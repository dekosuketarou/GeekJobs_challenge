/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateFolder;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author guest1Day
 */
public class ManipulateFile2 {
    public static void main(String[]args) throws IOException{
        //Fileインスタンスを作成
        File file=new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\DateProject\\src\\java\\DateFolder\\textFile.txt");
        //FIleReaderインスタンスを作成して読み出しを可能に
        FileReader fr=new FileReader(file);
        //BufferedReaderインスタンスを経由して効率的に読み出す
        BufferedReader br=new BufferedReader(fr);
        //readLineで一行読み出し
        System.out.print(br.readLine());
    }
}
