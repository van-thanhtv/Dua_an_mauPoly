/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.khoaHocInterface;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.khoaHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class khoaHocDao implements khoaHocInterface{
    //đọc 1 đối tượng khoa học từ 1 bản ghi (1 ResultSet)
    //Trả về 1 đối tượng khóa học
    private khoaHoc readFromResultSet(ResultSet rs) throws SQLException{
        khoaHoc model=new khoaHoc();
         model.setMaKH(rs.getInt("MaKH"));
         model.setHocPhi(rs.getDouble("HocPhi"));
         model.setThoiLuong(rs.getInt("ThoiLuong"));
         model.setNgayKG(rs.getDate("NgayKG"));
         model.setGhiChu(rs.getString("GhiChu"));
         model.setMaNV(rs.getString("MaNV"));
         model.setNgayTao(rs.getDate("NgayTao"));
         model.setMaCD(rs.getString("MaCD"));
         return model;
    }
    //Thực hiện truy vấn lấy về 1 tập ResultSet rồi add nó vào list
    private ArrayList<khoaHoc> select(String sql,Object...args){
        ArrayList<khoaHoc> listKH = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {                    
                    listKH.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();//Đóng kết nối
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
      /**
     * Thêm mới khóa học vào CSDL
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void insert(khoaHoc entity) {
        String sql="INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV()
        );
    }
      /**
     * Cập nhập khóa học vào CSDL
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void update(khoaHoc entity) {
        String sql="UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
        jdbcHelper.executeUpdate(sql,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV(),
                entity.getMaKH()
        );
    }
      /**
     * Xóa khóa học khỏi CSDL
     * @param maKH là mã khóa học cần xóa
     */
    @Override
    public void delete(String maKH) {
        String sql="DELETE FROM KhoaHoc WHERE MaKH=?";
        jdbcHelper.executeUpdate(sql, maKH);
    }
    //Truy vấn tất cả các khóa học
    //Return về list khóa học
    @Override
    public ArrayList<khoaHoc> select() {
        String sql="SELECT * FROM KhoaHoc";
        return this.select(sql);
    }
    //Truy vấn khóa học theo mãKH
    //@param maKH là mã khóa học cần tìm
    //Return về khóa học tương ứng
    @Override
    public khoaHoc findById(String maKH) {
        String sql="SELECT * FROM KhoaHoc WHERE MaKH=?";
        return this.select(sql, maKH).size()>0 ? this.select(sql, maKH).get(0) : null;
    }
    
}
