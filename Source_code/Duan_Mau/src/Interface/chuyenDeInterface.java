/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import model.chuyenDe;

/**
 *
 * @author Tran Van Thanh
 */
public interface chuyenDeInterface {
        public void insert(chuyenDe entity);//Thêm mới chuyên đề vào CSDL
        public void update(chuyenDe entity);//Cập nhật chuyên đề vào CSDL    
        public void delete(String maCD);//Xóa chuyên đề trong CSDL
        public ArrayList<chuyenDe> select();//Truy vấn danh sách chuyên đề
        public chuyenDe findById(String maCD);//Truy vấn theo mãCD trả về đối tượng chứa thông tin bản ghi
}
