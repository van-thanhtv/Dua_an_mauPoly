/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.nguoiHocInterface;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.nguoiHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class nguoiHocDao implements nguoiHocInterface {

    //đọc 1 người học từ 1 bản ghi (1 ResultSet)
    //Retum 1 người học Được đọc từ CSDL
    private nguoiHoc readFromResultSet(ResultSet rs) throws SQLException {
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
        return learner;
    }

    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    //Return list nhân viên được truy vấn từ câu lệnh sql và bởi tham số đối chiếu là args
    private ArrayList<nguoiHoc> select(String sql, Object... args) {
        ArrayList<nguoiHoc> listNH = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    listNH.add(readFromResultSet(rs));
                }
                System.out.println("dao :"+listNH.size());
            } finally {
                rs.getStatement().getConnection().close();//Đóng kết nối bằng RS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNH;
    }

     /**
     * Thêm mới người học vào CSDL     
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    @Override
    public void insert(nguoiHoc entity) {
        String sql = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV,IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaNH(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.isGioiTinh(),
                entity.getDienThoai(),
                entity.getEmail(),
                entity.getGhiChu(),
                entity.getMaNV(),0);
    }
    /**
     * Cập nhập người học vào CSDL     
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    @Override
    public void update(nguoiHoc entity) {
        String sql="UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV=? WHERE MaNH=?";
        jdbcHelper.executeUpdate(sql,            
                 entity.getHoTen(),
                 entity.getNgaySinh(),
                 entity.isGioiTinh(),
                 entity.getDienThoai(),
                 entity.getEmail(),
                 entity.getGhiChu(),
                 entity.getMaNV(),
                 entity.getMaNH());
    }
      /**
     * Xóa người học khỏi CSDL     
     * @param maNH là mã người học cần xóa
     */
    @Override
    public void delete(String maNH) {
        String sql="UPDATE NguoiHoc SET IsDeleted = 1 WHERE MaNH=?";
        jdbcHelper.executeUpdate(sql, maNH);
    }
    /**
     * Truy vấn tất cả các các người học
     * @return list danh sách người học
     */
    @Override
    public ArrayList<nguoiHoc> select() {
        String sql="SELECT * FROM NguoiHoc";
        return select(sql);
    }
    //Truy vấn người học theo keyword
    @Override
    public ArrayList<nguoiHoc> selectByKeyword(String keyword) {
        String sql="SELECT * FROM NguoiHoc WHERE HoTen LIKE ? and IsDeleted = 0";
        return select(sql, "%"+keyword+"%");
    }
    //truy xuất tất cả người học không học khóa học maKH
    @Override
    public ArrayList<nguoiHoc> selectByCourse(Integer makh) {//để là Integer cho đúng kiểu Object Trong CSDL
               String sql = "SELECT * FROM NguoiHoc WHERE "                
                + "MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?) and IsDeleted =0";
        return this.select(sql,makh);
    }
    //truy xuất người học theo maNH
    @Override
    public nguoiHoc findById(String maNH) {
        String sql="SELECT * FROM NguoiHoc WHERE MaNH=? and IsDeleted =0";
        ArrayList<nguoiHoc> list = select(sql, maNH);
        return list.size() > 0 ? list.get(0) : null;
    }

}
