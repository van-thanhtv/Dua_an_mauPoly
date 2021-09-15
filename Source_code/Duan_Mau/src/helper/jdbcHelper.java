/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tran Van Thanh
 * Tiện ích này hỗ trợ về Jdbc Database  
 */
public class jdbcHelper {
    public static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Polypro";
    public static String username = "sa";
    public static String password = "thanhk52a2";
    
    //nạp truyền giá trị đối số vào prepareStatement
    //có thể statment không có đối số
    //prepareStatement có thể là prepareStatement hoặc CallableStatements
    /*
    @param sql câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
    return pstmt là PrepareStatement đã được truyền đối số
    */
    public static PreparedStatement preparedStatement(String sql,Object...args) throws SQLException{
        Connection conn = DriverManager.getConnection(dburl,username, password);
        PreparedStatement ps = null;
        if (sql.startsWith("{")) {
            ps=conn.prepareCall(sql);//có thể gán biến kiểu PreparedStatement là prepareCall (CallableStatement)
        }else{
            ps=conn.prepareStatement(sql);
        }
        //Set cho ?
        for (int i = 0; i <args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        return ps;
    }
    //thao tác (INSERT, UPDATE, DELETE)
    //thực thi prepareStatement (đã được truyền đối số ở hàm trên)
    //khi làm chỉ cần gọi hàm này, từ trong hàm này nó sẽ gọi ra hàm preparedStatement ở trên
    /*
    @param sql (String) câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
    */
    public static void executeUpdate(String sql,Object...args){
        try {
            PreparedStatement ps = preparedStatement(sql, args);
            try{
                ps.executeUpdate();
            }finally{
                ps.getConnection().close();//Đóng Connection từ PreparedStatement
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //thao tác truy vấn (SELECT)
    //thực thi prepareStatement (đã được truyền đối số ở hàm trên)
    //khi làm chỉ cần gọi hàm này, từ trong hàm này nó sẽ gọi ra hàm preparedStatement ở trên
    /*
    @param sql (String) câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
    */
    public static ResultSet executeQuery(String sql,Object...args){
        try {
            PreparedStatement ps = preparedStatement(sql, args);
            try{
                return ps.executeQuery();
            }finally{
//                ps.getConnection().close(); Đóng chỗ này thì sẽ bị lỗi
            }
        } catch (Exception e) {
            throw new RuntimeException(e);         //throw các lỗi khi chạy CT, VD không có return khi try bị lỗi Thay thế retun null ở cuối
        }        
    }
}
