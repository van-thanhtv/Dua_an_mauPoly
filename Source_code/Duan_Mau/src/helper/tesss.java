/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import static helper.jdbcHelper.dburl;
import static helper.jdbcHelper.password;
import static helper.jdbcHelper.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.nguoiHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class tesss {

    public static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Polypro";
    public static String username = "sa";
    public static String password = "thanhk52a2";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, username, password);

        ArrayList<nguoiHoc> listNH = new ArrayList<>();
        ResultSet rs = null;
        Scanner s = new Scanner(System.in);
        String ke = s.nextLine();
        String ma = s.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM NguoiHoc WHERE HoTen LIKE ?  and MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)");
            ps.setObject(1,"%"+ke+"%");
            ps.setObject(2,ma);
            rs = ps.executeQuery();            
            while (rs.next()) {





                nguoiHoc learner = new nguoiHoc();
                learner.setMaNH(rs.getString("MaNH"));
                learner.setHoTen(rs.getString("HoTen"));
                learner.setNgaySinh(rs.getDate("NgaySinh"));
                learner.setGioiTinh(rs.getBoolean("GioiTinh"));
                learner.setDienThoai(rs.getString("DienThoai"));
                learner.setEmail(rs.getString("Email"));
                learner.setGhiChu(rs.getString("GhiChu"));
                learner.setMaNV(rs.getString("MaNV"));
                learner.setNgayDK(rs.getDate("NgayDK"));
                listNH.add(learner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(listNH.size());
    }
}
