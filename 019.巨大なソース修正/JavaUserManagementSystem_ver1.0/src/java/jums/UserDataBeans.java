/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DEKO
 */
//JavaBeansの要素
//隠匿されたフィールドを持つ
//フィールドにgetter,setterを機能させる
//Serializableを継承しておりデータによる受け渡しが可能である
//引数なしのコンストラクタを持つ
public class UserDataBeans implements Serializable {

    //privateフィールド
    private String name = "";   //名前
    private String year = "";   //生まれた年
    private String month = "";  //生まれた月
    private String day = "";    //生まれた日
    private String type = "";   //種別
    private String tell = "";   //電話番号
    private String comment = "";//自己紹介文

    public UserDataBeans() {
        //コンストラクタ
    }

    //privateフィールドに対応するsetter
    //form情報を受け取りそこから対応する情報を取得する
    public void setName(HttpServletRequest request) {
        if (!request.getParameter("name").equals("")) {
            this.name = request.getParameter("name").trim();
        }
    }

    public void setYear(HttpServletRequest request) {
        if (!request.getParameter("year").equals("")) {
            this.year = request.getParameter("year").trim();
        }
    }

    public void setMonth(HttpServletRequest request) {
        if (!request.getParameter("month").equals("")) {
            this.month = request.getParameter("month").trim();
        }
    }

    public void setDay(HttpServletRequest request) {
        if (!request.getParameter("day").equals("")) {
            this.day = request.getParameter("day").trim();
        }
    }

    public void setType(HttpServletRequest request) {
        if (request.getParameter("type")!=null) {
            this.type = request.getParameter("type").trim();
        }
    }

    public void setTell(HttpServletRequest request) {
        if (!request.getParameter("tell").equals("")) {
            this.tell = request.getParameter("tell").trim();
        }
    }

    public void setComment(HttpServletRequest request) {
        if (!request.getParameter("comment").equals("")) {
            this.comment = request.getParameter("comment").trim();
        }
    }

    //privateフィールドに対応するgetter
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

    public String getTell() {
        return tell;
    }

    public String getComment() {
        return comment;
    }
}
