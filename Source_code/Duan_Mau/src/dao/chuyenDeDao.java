/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.chuyenDeInterface;
import Interface.eduSysDao;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.chuyenDe;

/**
 *
 * @author Tran Van Thanh
 */
public class chuyenDeDao extends eduSysDao<chuyenDe, String> implements chuyenDeInterface {

    //đọc 1 đối tượng chuyên đề từ 1 bản ghi (1 ResultSet)
    //Trả về 1 đối tượng chuyên đề
    private chuyenDe readFromResultSet(ResultSet rs) throws SQLException {
        chuyenDe model = new chuyenDe();
        model.setMaCD(rs.getString("MaCD"));
        model.setHinh(rs.getString("Hinh"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenCD(rs.getString("TenCD"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        return model;
    }

    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    private ArrayList<chuyenDe> select(String sql, Object... args) {
        ArrayList<chuyenDe> listCD = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    listCD.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return listCD;
    }

    /**
     * Thêm mới chuyên đề vào CSDL
     *
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void insert(chuyenDe entity) {
        String sql = "INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaCD(),
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa()
        );
    }

    /**
     * Cập nhập chuyên đề vào CSDL
     *
     * @param entity là đối tượng chứa thông tin bản ghi mới
     */
    @Override
    public void update(chuyenDe entity) {
        String sql = "UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinh(),
                entity.getMoTa(),
                entity.getMaCD()
        );
    }

    /**
     * Xóa chuyên đề khỏi CSDL
     *
     * @param maCD là mã chuyên đề cần xóa
     */
    @Override
    public void delete(String maCD) {
        String sql = "DELETE FROM ChuyenDe WHERE MaCD=?";
        jdbcHelper.executeUpdate(sql, maCD);
    }

    //Truy vấn tất cả các chuyên đề
    //Return về list chuyên đề
    @Override
    public ArrayList<chuyenDe> select() {
        String sql = "SELECT * FROM ChuyenDe";
        return select(sql);
    }

    //Truy vấn chuyên đề theo mãCD
    //@param maCD là mã chuyên đề cần tìm
    //Return về chuyên đề tương ứng
    @Override
    public chuyenDe findById(String maCD) {
        String sql = "SELECT * FROM ChuyenDe WHERE MaCD=?";
        return select(sql, maCD).size() > 0 ? select(sql, maCD).get(0) : null;
    }
    //-------------------------------------------Theo cms-----------------------------------
    @Override
    public ArrayList<chuyenDe> selectAll() {
        String sql = "SELECT * FROM ChuyenDe";
        return selectBySql(sql);
    }

    @Override
    public chuyenDe selectByid(String id) {
        String sql = "SELECT * FROM ChuyenDe WHERE MaCD=?";
        return selectBySql(sql, id).size() > 0 ? selectBySql(sql, id).get(0) : null;
    }

    @Override
    protected ArrayList<chuyenDe> selectBySql(String sql, Object... args) {
        ArrayList<chuyenDe> listCD = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    listCD.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return listCD;
    }

}
