/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import model.khoaHoc;

/**
 *
 * @author Tran Van Thanh
 */
public interface khoaHocInterface {
        public void insert(khoaHoc entity);//Thêm mới khoa học vào CSDL
        public void update(khoaHoc entity);//Cập nhật khoa học vào CSDL    
        public void delete(String maKH);//Xóa khoa học trong CSDL
        public ArrayList<khoaHoc> select();//Truy vấn danh sách khoa học
        public khoaHoc findById(String maKH);//Truy vấn theo mãKH trả về đối tượng chứa thông tin bản ghi
}
