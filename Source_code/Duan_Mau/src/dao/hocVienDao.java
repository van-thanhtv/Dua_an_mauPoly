/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.eduSysDao;
import Interface.hocVienInterface;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.hocVien;

/**
 *
 * @author Tran Van Thanh
 */
public class hocVienDao extends eduSysDao<hocVien, String>implements hocVienInterface {

    //Các câu lệnh SQL
    private final String sqlINSERT = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    private final String sqlUPDATE = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    private final String sqlDELETE = "DELETE FROM HocVien WHERE MaHV=?";
    private final String sqlSELECT = "SELECT * FROM HocVien";
    private final String sqlSELECT1 = "SELECT * FROM HocVien WHERE MaHV=?";
    
    //đọc 1 đối tượng học viên từ 1 bản ghi (1 ResultSet)
    //Trả về 1 đối tượng học viên
    private hocVien readFromResultSet(ResultSet rs) throws SQLException {
        hocVien model = new hocVien();
        model.setMaHV(rs.getInt("MaHV"));
        model.setMaKH(rs.getInt("MaKH"));
        model.setMaNH(rs.getString("MaNH"));
        model.setDiem(rs.getDouble("Diem"));
        return model;
    }

    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    public ArrayList<hocVien> select(String sql, Object... args) {
        ArrayList<hocVien> listHV = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    listHV.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();      //đóng kết nối từ resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return listHV;
    }
      /**
     * Thêm mới học viên vào CSDL
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void insert(hocVien entity) {
        jdbcHelper.executeUpdate(sqlINSERT,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem()
                );
    }
      /**
     * Cập nhập học viên vào CSDL
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void update(hocVien entity) {
        jdbcHelper.executeUpdate(sqlUPDATE,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem(),
                entity.getMaHV()
                );
    }
      /**
     * Xóa học viên khỏi CSDL
     * @param maHV là mã học viên cần xóa
     */
    @Override
    public void delete(String maHV) {
        jdbcHelper.executeUpdate(sqlDELETE, maHV);
    }
    //Truy vấn tất cả các học viên
    //Return về list học viên
    @Override
    public ArrayList<hocVien> select() {
        return select(sqlSELECT);
    }
    //Truy vấn học viên theo mãHV
    //@param maHV là mã học viên cần tìm
    //Return về học viên tương ứng
    @Override
    public hocVien findById(String maHV) {
        return select(sqlSELECT1,maHV).size()>0?select(sqlSELECT1,maHV).get(0):null;
    }

    @Override
    public ArrayList<hocVien> selectAll() {
        return selectBySql(sqlSELECT);
    }

    @Override
    public hocVien selectByid(String id) {
        return selectBySql(sqlSELECT1, id).size()>0?selectBySql(sqlSELECT1, id).get(0):null;
    }

    @Override
    protected ArrayList<hocVien> selectBySql(String sql, Object... args) {
        ArrayList<hocVien> listHV = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    listHV.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();      //đóng kết nối từ resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return listHV;
    }
}
