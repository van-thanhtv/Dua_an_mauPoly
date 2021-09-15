/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import model.hocVien;

/**
 *
 * @author Tran Van Thanh
 */
public interface hocVienInterface {
        public void insert(hocVien entity);//Thêm mới học viên vào CSDL
        public void update(hocVien entity);//Cập nhật học viên vào CSDL    
        public void delete(String maHV);//Xóa học viên trong CSDL
        public ArrayList<hocVien> select();//Truy vấn danh sách học Viên
        public hocVien findById(String maHV);//Truy vấn theo mãHV trả về đối tượng chứa thông tin bản ghi
}
