/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;
import java.io.PrintWriter;
/**
 *
 * @author guest1Day
 */
public class JavaClass1 {
    //JavaClass1のフィールド
    String name="";
    int age=0;
    
    //setter
    public void setProfile(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void printProfile(PrintWriter out){
        out.print("名前は"+name+"<br>");
        out.print("歳は"+age+"です<br>");
    }
    
}
