/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Polypro;

import Interface.chuyenDeInterface;
import Interface.hocVienInterface;
import Interface.khoaHocInterface;
import Interface.nguoiHocInterface;
import dao.chuyenDeDao;
import dao.hocVienDao;
import dao.khoaHocDao;
import dao.nguoiHocDao;
import helper.dialogHelper;
import helper.jdbcHelper;
import helper.shareHelper;
import helper.utilityHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.chuyenDe;
import model.hocVien;
import model.khoaHoc;
import model.nguoiHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class HocVienJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form HocVienJInternalFrame
     */
    private hocVienInterface HVDao;
    private nguoiHocInterface NHDao;
    private khoaHocInterface KHDao;
    private chuyenDeInterface CDDao;

    public HocVienJInternalFrame() {
        initComponents();
        init();
    }

    private void init() {
        setFrameIcon(shareHelper.APP_ICON1);//Set icon cho JInternalFrame        
        this.HVDao = new hocVienDao();
        this.NHDao = new nguoiHocDao();
        this.CDDao = new chuyenDeDao();
        this.KHDao = new khoaHocDao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbbChuyenDe = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbbKhoaHoc = new javax.swing.JComboBox<>();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVIen = new javax.swing.JTable();
        btnDELETE = new javax.swing.JButton();
        btnUPDETE = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        lblname = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quản lý học viên");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chuyên Đề"));

        cbbChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbbChuyenDe, 0, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cbbChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Khóa học"));

        cbbKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblHocVIen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "Mã HV", "Mã NH", "Họ Tên", "Điểm"
            }
        ));
        jScrollPane1.setViewportView(tblHocVIen);

        btnDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnDELETE.setText("Xóa Khỏi Khóa Học");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        btnUPDETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/but.png"))); // NOI18N
        btnUPDETE.setText("Cập Nhập Điểm");
        btnUPDETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUPDETE, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDELETE)
                    .addComponent(btnUPDETE))
                .addGap(15, 15, 15))
        );

        tabs.addTab("Học Viên", new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png")), jPanel3); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NH", "Họ Và Tên", "Giới Tính", "Ngày Sinh", "Điện Thoại", "Email"
            }
        ));
        jScrollPane2.setViewportView(tblNguoiHoc);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        btnThem.setText("Thêm vào khóa học");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabs.addTab("Người Học Khác", new javax.swing.ImageIcon(getClass().getResource("/icon/Numbered list.png")), jPanel4); // NOI18N

        lblname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblname.setForeground(new java.awt.Color(0, 0, 204));
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblname.setText("QUẢN LÝ HỌC VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        // TODO add your handling code here:
        removeHocVien();
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnUPDETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDETEActionPerformed
        // TODO add your handling code here:
        updateDiem();
    }//GEN-LAST:event_btnUPDETEActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        fillComboBoxChuyenDe();
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbbChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChuyenDeActionPerformed
        // TODO add your handling code here:
        fillComboBoxKhoaHoc();
    }//GEN-LAST:event_cbbChuyenDeActionPerformed

    private void cbbKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaHocActionPerformed
        // TODO add your handling code here:
        fillTableHocVien();
    }//GEN-LAST:event_cbbKhoaHocActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        fillTableNguoiHoc();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:       
        insert();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUPDETE;
    private javax.swing.JComboBox<String> cbbChuyenDe;
    private javax.swing.JComboBox<String> cbbKhoaHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblname;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHocVIen;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbKhoaHoc.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo
        try {
            chuyenDe cd = (chuyenDe) this.cbbChuyenDe.getSelectedItem();
            if (cd != null) {
                ArrayList<khoaHoc> list = this.KHDao.selectByCD(cd.getMaCD());
                for (khoaHoc kh : list) {
                    model.addElement(kh);    //thêm đối tượng (Object) vào model                
                    //chỉ thêm đc đối tượng đối với model, cbo chỉ được cbo.addItem(String);
                    //lấy đối tượng thì từ cbo cũng được: cbo.getSelectedItem();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }

    }

    private void removeHocVien() {
        if (!shareHelper.USER.isVaiTro()) {
            dialogHelper.alert(this, "Bạn không thể xóa học viên!");
        } else {
            if (dialogHelper.confirm(this, "Bạn muốn xóa các học viên được chọn ?")) {
                for (int row : this.tblHocVIen.getSelectedRows()) {
                    String mahv = (String) this.tblHocVIen.getValueAt(row, 1);
                    HVDao.delete(mahv);
                }
                this.fillTableHocVien();
            }
        }
    }

    private void updateDiem() {
        int b = 0;
        for (int i = 0; i < this.tblHocVIen.getRowCount(); i++) {
            Double diem = 0.0;
            int mahv = (Integer) this.tblHocVIen.getValueAt(i, 1);
            if (!String.valueOf(this.tblHocVIen.getValueAt(i, 4)).equals("")) {
                diem = Double.parseDouble(this.tblHocVIen.getValueAt(i, 4).toString());
            }
            if (diem != null && (diem >= 0 && diem <= 10) || diem == 0.0) {
                hocVien model = this.HVDao.findById(String.valueOf(mahv));
//                    model.setMaHV(Integer.valueOf((Integer)this.tblHocVIen.getValueAt(i, 1)));
                model.setDiem(diem);
                this.HVDao.update(model);
            } else {
                b++;
            }
//            int mahv= (Integer)this.tblHocVIen.getValueAt(i, 1);
//            hocVien hv = this.HVDao.findById(String.valueOf(mahv));
//            hv.setDiem(diem);
//            this.HVDao.update(hv);
        }
        if (b > 0) {
            dialogHelper.alert(this, "Điểm phải là số thực từ 0-10 hoặc chưa nhập (-1)");
            return;
        }else
        dialogHelper.alert(this, "Cập nhập điểm thành công!");

    }

    private void fillComboBoxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbChuyenDe.getModel(); //kết nối model với cbo
        model.removeAllElements();   //xóa toàn bộ item của cbo

        try {
            ArrayList<chuyenDe> list = this.CDDao.select();
            for (chuyenDe cd : list) {
                model.addElement(cd);    //thêm đối tượng (Object) vào model                
                //chỉ thêm đc đối tượng đối với model, cbo chỉ được cbo.addItem(String);
                //lấy đối tượng thì từ cbo cũng được: cbo.getSelectedItem();
            }
            this.fillComboBoxKhoaHoc();
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblHocVIen.getModel();
        model.setRowCount(0);
        ResultSet rs = null;
        try {
            //lấy về MaHV, MaKH, MaNH, Diem, HoTen từ các bảng trong CSDL của các học viên thuộc 
            //khóa học (theo maKH)
            String sql = "SELECT hv.*, nh.HoTen FROM hocVien hv "
                    + " JOIN nguoiHoc nh ON nh.MaNH=hv.MaNH WHERE MaKH=?";
            khoaHoc kh = (khoaHoc) this.cbbKhoaHoc.getSelectedItem();
            if (kh != null) {
                rs = jdbcHelper.executeQuery(sql, kh.getMaKH());
                while (rs.next()) {
                    double diem = rs.getDouble("Diem");
                    Object[] row = {
                        rs.getRow(),
                        rs.getInt("MaHV"), rs.getString("MaNH"),
                        rs.getString("HoTen"), diem <= 0 ? "" : diem, false
                    };
                    model.addRow(row);
                }
                this.fillTableNguoiHoc();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            dialogHelper.alert(this, "Lỗi truy vấn học viên!");
        }
    }

    private void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        khoaHoc kh = (khoaHoc) this.cbbKhoaHoc.getSelectedItem();
        String keyword = this.txtTimKiem.getText();
        ArrayList<nguoiHoc> list = this.NHDao.selectByCourse(kh.getMaKH(), keyword);
        for (nguoiHoc hoc : list) {
            model.addRow(new Object[]{
                hoc.getMaNH(), hoc.getHoTen(), hoc.isGioiTinh() ? "Nam" : "Nữ", hoc.getNgaySinh(), hoc.getDienThoai(), hoc.getEmail()
            });
        }

    }

    private void insert() {
        khoaHoc kh = (khoaHoc) this.cbbKhoaHoc.getSelectedItem();
        for (int row : this.tblNguoiHoc.getSelectedRows()) {
            hocVien hv = new hocVien();
            hv.setMaKH(kh.getMaKH());
            hv.setDiem(0.0);
            hv.setMaNH((String) this.tblNguoiHoc.getValueAt(row, 0));
            HVDao.insert(hv);
        }
        this.fillTableHocVien();
        this.tabs.setSelectedIndex(0);
    }
}
