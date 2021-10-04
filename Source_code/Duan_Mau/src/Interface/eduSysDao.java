/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;

/**
 *
 * @author Tran Van Thanh
 */
abstract public class eduSysDao<EntityType, KenType> {
    abstract public void insert(EntityType entity);//Thêm mới đối tượng vào CSDL
    abstract public void update(EntityType entity);//Cập nhập đối tượng vào CSDL    
    abstract public void delete(KenType id);//Xóa đối tượng trong CSDL
    abstract public ArrayList<EntityType> selectAll();//Truy vấn danh sách đối tượng
    abstract public EntityType selectByid(KenType id);//Truy vấn theo ID trả về đối tượng chứa thông tin bản ghi
    abstract protected ArrayList<EntityType> selectBySql(String sql, Object... args);//thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
}
