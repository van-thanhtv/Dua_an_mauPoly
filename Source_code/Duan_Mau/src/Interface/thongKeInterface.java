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
public interface thongKeInterface {
    public ArrayList<Object[]> getNguoHoc();//Thống kê số người học của trung tâm theo từng năm
    public ArrayList<Object[]> getBangDiem(Integer maKH);//Bảng điểm của các học viên trong khóa học
    public ArrayList<Object[]> getDiemTheoChuyenDe();//Tổng hợp điểm của học viên theo từng chuyên đề
    public ArrayList<Object[]> getDoanhThu(int nam);//Tổng hợp doanh thu từng chuyên đề (theo từng năm)
    public ArrayList<Integer> getNamKhaiGiang();//Tổng hợp lại năm khai giảng
}
