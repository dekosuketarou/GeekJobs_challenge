/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateFolder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author guest1Day
 */
public class ManipulateFile1 {
    public static void main(String[]args) throws IOException{
        //Fileインスタンスを作成
        File file=new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\DateProject\\src\\java\\DateFolder\\textFile.txt");
        FileWriter fw=new FileWriter(file,false);
        fw.write("私の名前は玉城裕也です");
        fw.close();
    }
}
