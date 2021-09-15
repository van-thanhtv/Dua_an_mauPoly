/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import javax.swing.JPasswordField;
import model.nhanVien;

/**
 *
 * @author Tran Van Thanh
 */
public interface nhanVienInterface {
    public void insert(nhanVien entity);//Thêm mới nhân viên vào CSDL
    public void update(nhanVien entity);//Cập nhật nhân viên vào CSDL
    public void resetMK(nhanVien entity,JPasswordField txt);//Cập nhập mật khẩu cho nv quên MK
    public void delete(String maNV);//Xóa nhân viên trong CSDL
    public ArrayList<nhanVien> select();//Truy vấn danh sách nhân viên
    public nhanVien findById(String id);//Truy vấn theo mãNV trả về đối tượng chứa thông tin bản ghi
}
