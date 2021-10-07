/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Polypro;

import Interface.hocVienInterface;
import Interface.nguoiHocInterface;
import dao.hocVienDao;
import dao.nguoiHocDao;
import helper.dialogHelper;
import helper.jdbcHelper;
import helper.shareHelper;
import helper.utilityHelper;
import static java.awt.Color.white;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.hocVien;
import model.khoaHoc;
import model.nguoiHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class hocVienJFrame extends javax.swing.JFrame {

//    private Integer maKH;
    private hocVienInterface HVDao;
    private nguoiHocInterface NHDao;
    private khoaHoc khoaHoc;

    /**
     * Creates new form hocVienJFrame
     */
    public hocVienJFrame(khoaHoc kh) {
        initComponents();
        setIconImage(shareHelper.APP_ICON);
        setLocationRelativeTo(null);
        this.HVDao = new hocVienDao();
        this.NHDao = new nguoiHocDao();
        this.khoaHoc = kh;
        this.lblname.setText("QUẢN LÝ HỌC VIÊN KHÓA HỌC :" + this.khoaHoc.getMaCD() + "(" + this.khoaHoc.getNgayKG() + ")");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlHVKhac = new javax.swing.JPanel();
        cboNguoiHoc = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        lblname = new javax.swing.JLabel();
        pnlHVKH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaNhap = new javax.swing.JRadioButton();
        rdoChuaNhap = new javax.swing.JRadioButton();
        btnCapNhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lý Học Viên");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlHVKhac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỌC VIÊN KHÁC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cboNguoiHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguoiHocActionPerformed(evt);
            }
        });

        txtDiem.setName("Điểm"); // NOI18N
        txtDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHVKhacLayout = new javax.swing.GroupLayout(pnlHVKhac);
        pnlHVKhac.setLayout(pnlHVKhacLayout);
        pnlHVKhacLayout.setHorizontalGroup(
            pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHVKhacLayout.setVerticalGroup(
            pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnThem))
        );

        lblname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblname.setForeground(new java.awt.Color(0, 0, 204));
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblname.setText("QUẢN LÝ HỌC VIÊN");

        pnlHVKH.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỌC VIÊN CỦA KHÓA HỌC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM (sửa đc)", "XÓA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGridView.setRowHeight(25);
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGridView);

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatCaMouseClicked(evt);
            }
        });
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaNhap);
        rdoDaNhap.setText("Đã nhập điểm");
        rdoDaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaNhapMouseClicked(evt);
            }
        });
        rdoDaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuaNhap);
        rdoChuaNhap.setText("Chưa nhập điểm");
        rdoChuaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChuaNhapMouseClicked(evt);
            }
        });
        rdoChuaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaNhapActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save as.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHVKHLayout = new javax.swing.GroupLayout(pnlHVKH);
        pnlHVKH.setLayout(pnlHVKHLayout);
        pnlHVKHLayout.setHorizontalGroup(
            pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHVKHLayout.createSequentialGroup()
                        .addComponent(rdoTatCa)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDaNhap)
                        .addGap(18, 18, 18)
                        .addComponent(rdoChuaNhap)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHVKHLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)))
                .addContainerGap())
        );
        pnlHVKHLayout.setVerticalGroup(
            pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoDaNhap)
                    .addComponent(rdoChuaNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHVKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHVKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHVKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHVKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguoiHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNguoiHocActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkDiem(txtDiem)) {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        // TODO add your handling code here:
//        vitri=tblGridView.getSelectedRow();
    }//GEN-LAST:event_tblGridViewMouseClicked

    private void rdoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatCaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTatCaMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // TODO add your handling code here:
        this.fillGridView();                   //ActionPerformed
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaNhapMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDaNhapMouseClicked

    private void rdoDaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaNhapActionPerformed
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_rdoDaNhapActionPerformed

    private void rdoChuaNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuaNhapMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChuaNhapMouseClicked

    private void rdoChuaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaNhapActionPerformed
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_rdoChuaNhapActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.fillComboBox();
        this.fillGridView();
    }//GEN-LAST:event_formWindowOpened

    private void txtDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(hocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(hocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(hocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(hocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new hocVienJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNguoiHoc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel pnlHVKH;
    private javax.swing.JPanel pnlHVKhac;
    private javax.swing.JRadioButton rdoChuaNhap;
    private javax.swing.JRadioButton rdoDaNhap;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtDiem;
    // End of variables declaration//GEN-END:variables
    /*
    thêm đt hocVien vào CSDL bảng hocVien
    load lại combobox, bảng
    MaHV là tự sinh từ 1 đến ... trong CSDL ko cần nhập
    mã tự sinh này là cố định không đổi kể cả khi bản ghi phía trước bị xóa làm stt thay đổi
     */
    private void insert() {
        nguoiHoc nh = (nguoiHoc) this.cboNguoiHoc.getSelectedItem();
        hocVien hv = new hocVien();
        hv.setMaKH(this.khoaHoc.getMaKH());
        hv.setMaNH(nh.getMaNH());
        if (!this.txtDiem.getText().equals("")) {
            hv.setDiem(Double.parseDouble(this.txtDiem.getText()));
        }
        System.out.println(""+hv.getDiem());
        try {
            this.HVDao.insert(hv);
            this.fillComboBox();
            this.fillGridView();
            this.txtDiem.setText("");
            dialogHelper.alert(this, "Thêm mới học viên :" + nh.getHoTen() + "\nVào khóa học :" + this.khoaHoc.getMaCD());
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(this, "Lỗi thêm học viên vào khóa học !");
        }
    }

    //lấy về MaHV, MaKH, MaNH, Diem, HoTen từ các bảng trong CSDL của các học viên thuộc khóa học (theo maKH)
    //điền các bản ghi tương ứng vào bảng theo: tất cả, chưa nhập điểm, đã nhập điểm
    private void fillGridView() {
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setRowCount(0);
        ResultSet rs = null;
        try {
            //lấy về MaHV, MaKH, MaNH, Diem, HoTen từ các bảng trong CSDL của các học viên thuộc 
            //khóa học (theo maKH)
            String sql = "SELECT hv.*, nh.HoTen FROM hocVien hv "
                    + " JOIN nguoiHoc nh ON nh.MaNH=hv.MaNH WHERE MaKH=?";
            rs = jdbcHelper.executeQuery(sql, this.khoaHoc.getMaKH());
            while (rs.next()) {
                double diem = rs.getDouble("Diem");
                Object[] row = {
                    rs.getInt("MaHV"), rs.getString("MaNH"),
                    rs.getString("HoTen"), diem <= 0 ? "" : diem, false
                };
                if (rdoTatCa.isSelected()) {  //tất cả thì add tất cả bản ghi vào 
                    model.addRow(row);
                } else if (rdoDaNhap.isSelected() && diem > 0) {//đã nhập thì chỉ add bản ghi điểm 0-10
                    model.addRow(row);
                } else if (rdoChuaNhap.isSelected() && diem <= 0) {//chưa nhập thì chỉ nhập bản ghi điểm -1
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            dialogHelper.alert(this, "Lỗi truy vấn học viên!");
        } finally {
            try {
                rs.getStatement().getConnection().close();
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
        }
    }

    //chỉ sửa điểm hocVien, xóa hocVien bị tích
    //cập nhật vào CSDL, load lại bảng, load lại cbo
    private void update() {
        txtDiem.setBackground(white);
        int a = 0, b = 0;//dùng để kiểm tra và đưa ra thong báo lỗi
        for (int i = 0; i < tblGridView.getRowCount(); i++) {//Dùng vòng For để cập nhập nhiều bản ghi
            String mahv = tblGridView.getValueAt(i, 0).toString();  //lấy maHV từ bảng(ko sửa đc)
            String manh = (String) tblGridView.getValueAt(i, 1);  //lấy maNH từ bảng(ko sửa đc)                       
            Double diem=0.0;
            if (!String.valueOf(tblGridView.getValueAt(i, 3)).equals("")) {
                 diem= Double.valueOf(String.valueOf(tblGridView.getValueAt(i, 3)));   //lấy điểm (sửa đc)
            }            
            Boolean isDelete = (Boolean) tblGridView.getValueAt(i, 4);
            if (isDelete) {
                a++;
            }
            if (isDelete && shareHelper.USER.isVaiTro()) {     //nếu có tích thì xóa bản ghi đó đi
                if (dialogHelper.confirm(this, "Bạn có chắc xóa Học viên : "+mahv+" này ?")) {
                    this.HVDao.delete(mahv);
                }
            } else {           //còn ko tích thì cập 
                if (shareHelper.USER.isVaiTro() == false) {
                    tblGridView.setValueAt(false, i, 3);
                }
                if (diem!=null&& (diem >= 0 && diem <= 10) || diem == -1) {
                    hocVien model = new hocVien();
                    model.setMaHV(Integer.valueOf(mahv));
                    model.setMaKH(this.khoaHoc.getMaKH());
                    model.setMaNH(manh);
                    model.setDiem(diem);
                    System.out.println("" + model.getMaHV());
                    this.HVDao.update(model);
                } else {
                    b++;
                }
            }
        }
        this.fillComboBox();
        this.fillGridView();
        if (a > 0 && shareHelper.USER.isVaiTro() == false) {
            dialogHelper.alert(this, "Chỉ trưởng phòng mới được xóa học viên\nbạn chỉ được thêm học viên và điểm");
            return;
        }
        if (b > 0) {
            dialogHelper.alert(this, "Điểm phải là số thực từ 0-10 hoặc chưa nhập (-1)");
            return;
        }
        dialogHelper.alert(this, "Cập nhật thành công!");
    }

    //lấy tất cả đối tượng nguoiHoc không thuộc khoaHoc từ CSDL (theo maKH)
    //rồi thêm vào combobox
    private void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNguoiHoc.getModel(); //kết nối cbo với model
        model.removeAllElements(); //xóa toàn bộ item
        try {
            //lấy tất cả đối tượng nguoiHoc không thuộc khoaHoc từ CSDL
            //rồi thêm vào combobox
            ArrayList<nguoiHoc> list = this.NHDao.selectByCourse(this.khoaHoc.getMaKH());
            for (nguoiHoc nh : list) {
                model.addElement(nh);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn học viên!");
        }
    }
}
