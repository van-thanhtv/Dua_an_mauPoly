/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.nhanVienInterface;
import helper.dialogHelper;
import helper.hashPassHelper;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import model.nhanVien;

/**
 *
 * @author Tran Van Thanh
 */
public class nhanVienDao implements nhanVienInterface{
    private String pass="thanhit";//Mật khẩu để mã hóa
    //đọc 1 nhân viên từ 1 bản ghi (1 ResultSet)
    //Retum 1 nhân viên Được đọc từ CSDL
    public nhanVien readFromResultSet(ResultSet rs) throws SQLException{
        nhanVien model = new nhanVien();
        model.setHoTen(rs.getString("HoTen"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setMaNV(rs.getString("MaNV"));
        model.setGmail(rs.getString("Gmail"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    //Return list nhân viên được truy vấn từ câu lệnh sql và bởi tham số đối chiếu là args
    public ArrayList<nhanVien> select(String sql,Object...args){
        ArrayList<nhanVien> listNV=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {                    
                    listNV.add(readFromResultSet(rs));
                }
            } finally{
                rs.getStatement().getConnection().close();//Đóng kết nối bằng RS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    /*
     * Thêm mới Nhân Viên vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    @Override
    public void insert(nhanVien entity) {
        String sql ="INSERT INTO NhanVien (MaNV, MatKhau, HoTen,Gmail, VaiTro,IsDeleted) VALUES (?, ?, ?, ?,?,?)";
        try {
            jdbcHelper.executeUpdate(sql,
                entity.getMaNV(),
                //Nếu vai trò là nhân viên thì thực hiên băm pas 2 chiều còn không thì 1 chiều
                entity.isVaiTro() ? hashPassHelper.encrypt(entity.getMatKhau()):hashPassHelper.Myencrypt(entity.getMatKhau().getBytes("UTF-8")),//Nếu vai trò là quản lý thì thực hên băm pass theo "MD5" nếu là nhân viên thì băm pass theo kiểu "AES";
                entity.getHoTen(),
                entity.getGmail(),
                entity.isVaiTro(),0
                );
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null, "Lỗi hệ thống !");
        }        
    }
    /**
     * Cập nhật Nhân viên vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    @Override
    public void update(nhanVien entity) {
        String sql="UPDATE NhanVien SET  HoTen=?,Gmail=?, VaiTro=? WHERE MaNV=?";
        try {
            jdbcHelper.executeUpdate(sql,                
                //Nếu vai trò là nhân viên thì thực hiên băm pas 2 chiều còn không thì 1 chiều                
                entity.getHoTen(),
                entity.getGmail(),
                entity.isVaiTro(),
                entity.getMaNV()
                );
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null, "Cập nhập thất bại !");
        }
    }
    /**
     * Xóa Nhân viên khỏi CSDL
     * @param maNV là mã của bản ghi cần xóa
     */
    @Override
    public void delete(String maNV) {
        String sql="UPDATE NhanVien SET IsDeleted = 1  WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, maNV);
    }
     /**
     * Truy vấn tất cả các các Nhân viên
     * @return danh sách các Nhân viên
     */
    @Override
    public ArrayList<nhanVien> select() {
        String sql="SELECT * FROM NhanVien WHERE IsDeleted = 0";
        return this.select(sql);//trong 1 class có thể có 2 method trùng tên (nhưng param khác nhau)
    }
    //Truy vấn nhân viên theo mã nhân viên
    //Return nhân viên chứa thôn tin bản ghi
    @Override
    public nhanVien findById(String id) {
        String sql="SELECT * FROM NhanVien WHERE MaNV=? and IsDeleted =0";
        ArrayList<nhanVien> listNV = this.select(sql,id);
        return listNV.size()>0 ? listNV.get(0):null;//Nếu như không có nhân viên nào trùng id thì trả về null
    }

    @Override
    public void resetMK(nhanVien entity,JPasswordField txt) {
        String sql="UPDATE NhanVien SET MatKhau=? WHERE MaNV=? AND Gmail=?";
         try {
            jdbcHelper.executeUpdate(sql,                
                //Nếu vai trò là nhân viên thì thực hiên băm pas 2 chiều còn không thì 1 chiều
                entity.isVaiTro() ? hashPassHelper.encrypt(txt.getText()):hashPassHelper.Myencrypt(txt.getText().getBytes("UTF-8")),//Nếu vai trò là quản lý thì thực hên băm pass theo "MD5" nếu là nhân viên thì băm pass theo kiểu "AES";
                entity.getMaNV(),
                entity.getGmail()                                
                );
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null,"Lỗi hệ thống!");
        }        
    }
    
}
