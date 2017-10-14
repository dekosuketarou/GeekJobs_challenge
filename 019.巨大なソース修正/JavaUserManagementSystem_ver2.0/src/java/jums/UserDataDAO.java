package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    //複数データ取得のために戻り値をUserDataDTOからArrayListに変更
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException {
        ArrayList<UserDataDTO> resultdata = new ArrayList<UserDataDTO>();

        Connection con = null;
        PreparedStatement st = null;
        try {

            con = DBManager.getConnection();

            //未入力箇所がある場合にも対応するには
            //パラメータ記述にもif条件で振り分ける必要がある
            //仕様変更
            String sql = "SELECT * FROM user_t";
            int i = 1;
            boolean flag = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }
            if (ud.getBirthday() != null) {
                if (!flag) {
                    sql += " WHERE birthday like ?";
                    flag = true;
                } else {
                    sql += " AND birthday like ?";
                }
            }
            if (ud.getType() != 0) {
                if (!flag) {
                    sql += " WHERE type like ?";
                } else {
                    sql += " AND type like ?";
                }
            }

            st = con.prepareStatement(sql);

            if (!ud.getName().equals("")) {
                st.setString(i, "%" + ud.getName() + "%");
                i++;
            }
            if (ud.getBirthday() != null) {
                st.setString(i, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                i++;
            }
            if (ud.getType() != 0) {
                st.setInt(i, ud.getType());
            }

//                st.setString(i, "%"+ud.getName()+"%");
//                st.setString(i, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
//                st.setInt(i, ud.getType());
            ResultSet rs = st.executeQuery();

            //複数の該当データがあった場合この処理では1件しか出力できない
//                rs.next();
//                UserDataDTO resultUd = new UserDataDTO();
//                resultUd.setUserID(rs.getInt(1));
//                resultUd.setName(rs.getString(2));
//                resultUd.setBirthday(rs.getDate(3));
//                resultUd.setTell(rs.getString(4));
//                resultUd.setType(rs.getInt(5));
//                resultUd.setComment(rs.getString(6));
//                resultUd.setNewDate(rs.getTimestamp(7));
//
//                System.out.println("search completed");
//                
//                return resultUd;
            //複数出力に対応する
            //仕様変更
            //検索結果を判定するためnext()メソッドを使用
            if (rs.next()) {
                //next()メソッドによりカーソルが進んでいるので最前列に設定
                rs.beforeFirst();
                //カーソルが最後のレコードに達するまでArrayList<UserDataDTO>にadd
                while (rs.next()) {
                    UserDataDTO resultUd = new UserDataDTO();
                    resultUd.setUserID(rs.getInt(1));
                    resultUd.setName(rs.getString(2));
                    resultUd.setBirthday(rs.getDate(3));
                    resultUd.setTell(rs.getString(4));
                    resultUd.setType(rs.getInt(5));
                    resultUd.setComment(rs.getString(6));
                    resultUd.setNewDate(rs.getTimestamp(7));
                    resultdata.add(resultUd);
                    System.out.println("search completed");
                }
                con.close();
                st.close();
                rs.close();
                return resultdata;
            } else {
                con.close();
                st.close();
                rs.close();
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());

            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));

            System.out.println("searchByID completed");

            return resultUd;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /*deleteコマンドの実行
    /
    /
     */
    public void deleteID(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("delete from user_t where userID=?");
            st.setInt(1, ud.getUserID());

            st.executeUpdate();
            System.out.println("delete completed");

        } catch (SQLException e) {

        }
    }

    public boolean updateID(UserDataDTO ud) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;
        try {

            con = DBManager.getConnection();

            int i = 1;
            //未入力箇所がある場合にも対応するには
            //パラメータ記述にもif条件で振り分ける必要がある
            String sql = "update user_t set";
            boolean flag = false;
            
            if (!ud.getName().equals("")) {
                sql += " name=?";
                flag = true;
            }
            if (ud.getBirthday() != null) {
                if (flag) {
                    sql += ", birthday=?";
                } else {
                    sql += " birthday=?";
                    flag = true;
                }
            }
            if (!ud.getTell().equals("")) {
                if (flag) {
                    sql += ", tell=?";
                } else {
                    sql += " tell=?";
                    flag = true;
                }
            }
            if (ud.getType() != 0) {
                if (flag) {
                    sql += ", type=?";
                } else {
                    sql += " type=?";
                    flag = true;
                }
            }
            if (!ud.getComment().equals("")) {
                if (flag) {
                    sql += ", comment=?";
                } else {
                    sql += " comment=?";
                    flag = true;
                }
            }
            sql += " where userID=?";
            st = con.prepareStatement(sql);
            int flag2=0;
            if (flag) {

                if (!ud.getName().equals("")) {
                    st.setString(i, ud.getName());
                    i++;
                }
                if (ud.getBirthday() != null) {
                    st.setDate(i, new java.sql.Date(ud.getBirthday().getTime()));
                    i++;
                }
                if (!ud.getTell().equals("")) {
                    st.setString(i, ud.getTell());
                    i++;
                }
                if (ud.getType() != 0) {
                    st.setInt(i, ud.getType());
                    i++;
                }
                if (!ud.getComment().equals("")) {
                    st.setString(i, ud.getComment());
                    i++;
                }
                st.setInt(i, ud.getUserID());
                //更新数を取得
                flag2=st.executeUpdate();
                //更新したものがあればtrueのまま
                if(flag2==0){
                    flag=false;
                }
            }
            con.close();
            st.close();
            return flag;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

}
