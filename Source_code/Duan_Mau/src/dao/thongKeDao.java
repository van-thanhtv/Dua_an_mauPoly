/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.thongKeInterface;
import helper.jdbcHelper;
import helper.utilityHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tran Van Thanh
 */
public class thongKeDao implements thongKeInterface{
    
    /*
    thống kê số người học của trung tâm theo từng năm
    @return 1 <Object[]> list : Năm - số lượng - ngày người đầu tiên đk - ngày người cc đk
     */
    @Override
    public ArrayList<Object[]> getNguoHoc() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeNguoiHoc}";                
                rs=jdbcHelper.executeQuery(sql);
                while (rs.next()) {                    
                    Object[] row = new Object[]{
                        rs.getInt("Nam"),
                        rs.getInt("SoLuong"),
                        rs.getDate("DauTien"),
                        rs.getDate("CuoiCung")
                    };
                    list.add(row);
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }
    /*
    bảng điểm của các học viên trong khóa học
    @param makh mã khóa học
    @return <Object[]> list : mã NH - họ và tên - điểm - xếp loại
     */
    @Override
    public ArrayList<Object[]> getBangDiem(Integer maKH) {        
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_BangDiem (?)}";
                rs=jdbcHelper.executeQuery(sql,maKH);
                while (rs.next()) {                    
                    Object[] row = new Object[]{
                        rs.getString("MaNH"),
                        rs.getString("HoTen"),
                        rs.getDouble("Diem"),
                        utilityHelper.getRank(rs.getDouble("Diem"))
                    };
                    list.add(row);
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;        
    }
    /*
    tổng hợp điểm của theo từng chuyên đề
    @return <Object[]> list : tên chuyên đề - số HV - điểm thấp nhất - điểm cao nhất - điểm trung bình
     */
    @Override
    public ArrayList<Object[]> getDiemTheoChuyenDe() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
              String sql = "{call sp_ThongKeDiem}";
              rs=jdbcHelper.executeQuery(sql);
                while (rs.next()) {                    
                    Object[] row = new Object[]{
                        rs.getString("ChuyenDe"),
                        rs.getInt("SoHV"),
                        rs.getDouble("CaoNhat"),
                        rs.getDouble("ThapNhat"),
                        rs.getDouble("TrungBinh")                        
                    };
                    list.add(row);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }
    /*
    tổng hợp doanh thu từng chuyên đề (theo từng năm)
    @param int nam
    @return <Object[]> list : tên chuyên đề - số KH - số HV - doanh thu - HP cao nhất - HP thấp nhất - HP trung bình
     */
    @Override
    public ArrayList<Object[]> getDoanhThu(int nam) {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
              String sql = "{call sp_ThongKeDoanhThu (?)}";
              rs=jdbcHelper.executeQuery(sql,nam);
                while (rs.next()) {                    
                    Object[] row = new Object[]{
                        rs.getString("ChuyenDe"),
                        rs.getInt("SoKH"),
                        rs.getInt("SoHV"),
                        rs.getDouble("DoanhThu"),
                        rs.getDouble("ThapNhat"),
                        rs.getDouble("CaoNhat"),
                        rs.getDouble("TrungBinh")                   
                    };
                    list.add(row);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }
    //Tổng hợp năm khai giảng
    //Return năm khai giảng
    @Override
    public ArrayList<Integer> getNamKhaiGiang() {
        ArrayList<Integer> listNam = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
              String sql ="select distinct year(NgayKG) as nam from KhoaHoc order by year(NgayKG) desc";
              rs=jdbcHelper.executeQuery(sql);
                while (rs.next()) {                    
                    listNam.add(rs.getInt(1));
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return listNam;
    }
    
}
