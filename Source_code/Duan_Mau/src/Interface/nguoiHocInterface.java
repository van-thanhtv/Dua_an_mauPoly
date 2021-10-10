/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import model.nguoiHoc;


/**
 *
 * @author Tran Van Thanh
 */
public interface nguoiHocInterface {
    public void insert(nguoiHoc entity);//Thêm mới người học vào CSDL
    public void update(nguoiHoc entity);//Cập nhật người học vào CSDL    
    public void delete(String maNH);//Xóa người học trong CSDL
    public ArrayList<nguoiHoc> select();//Truy vấn danh sách người học
    public ArrayList<nguoiHoc> selectByKeyword(String keyword);
    public ArrayList<nguoiHoc> selectByCourse(Integer makh,String...key);
    public nguoiHoc findById(String maNH);//Truy vấn theo mãNH trả về đối tượng chứa thông tin bản ghi
}
