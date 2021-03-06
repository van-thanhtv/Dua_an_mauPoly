/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Polypro;

import Interface.khoaHocInterface;
import Interface.thongKeInterface;
import dao.khoaHocDao;
import dao.thongKeDao;
import helper.ExportFileHelper;
import helper.dialogHelper;
import helper.shareHelper;
import java.awt.CardLayout;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.khoaHoc;

/**
 *
 * @author Tran Van Thanh
 */
public class QLthong_ke_JInternalFrame extends javax.swing.JInternalFrame {

    private thongKeInterface TKDao;
    private khoaHocInterface KHDao;

    /**
     * Creates new form QLthong_ke_JInternalFrame
     */
    public QLthong_ke_JInternalFrame(int index) {
        initComponents();
        tabs.setSelectedIndex(index);
        this.init();
        this.TKDao = new thongKeDao();
        this.KHDao = new khoaHocDao();
    }

    private void init() {
        setFrameIcon(shareHelper.APP_ICON1);
        CardLayout card = (CardLayout) pnlDoanhThu.getLayout();
        if (shareHelper.USER.isVaiTro()) {
            card.show(pnlDoanhThu, "card1");
        } else {
            card.show(pnlDoanhThu, "card2");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlNguoiHoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        pnlBangDiem = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        pnlKhoaHoc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();
        pnlDoanhThu = new javax.swing.JPanel();
        pnlTruongPhong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_export = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Qu???n L?? Th???ng K??");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T???NG H???P TH???NG K??");

        pnlNguoiHoc.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlNguoiHocAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlNguoiHoc.setLayout(new java.awt.BorderLayout());

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N??M", "S??? NG?????I H???C", "?????U TI??N", "SAU C??NG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoiHoc.setRowHeight(25);
        jScrollPane1.setViewportView(tblNguoiHoc);

        pnlNguoiHoc.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabs.addTab("NG?????I H???C", new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png")), pnlNguoiHoc, "NG?????I H???C"); // NOI18N

        pnlBangDiem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlBangDiemAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlBangDiem.setLayout(new java.awt.BorderLayout());

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "M?? NH", "H??? V?? T??N", "??I???M", "X???P LO???I"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangDiem.setRowHeight(25);
        jScrollPane2.setViewportView(tblBangDiem);

        pnlBangDiem.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Card file.png"))); // NOI18N
        jLabel2.setText("KH??A H???C: ");
        jPanel2.add(jLabel2, java.awt.BorderLayout.LINE_START);

        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });
        jPanel2.add(cboKhoaHoc, java.awt.BorderLayout.CENTER);

        pnlBangDiem.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("B???NG ??I???M", new javax.swing.ImageIcon(getClass().getResource("/icon/Numbered list.png")), pnlBangDiem, "B???NG ??I???M"); // NOI18N

        pnlKhoaHoc.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlKhoaHocAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlKhoaHoc.setLayout(new java.awt.BorderLayout());

        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CHUY??N ?????", "T???NG S??? HV", "CAO NH???T", "TH???P NH???T", "??I???M TRUNG B??NH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhoaHoc.setRowHeight(25);
        jScrollPane3.setViewportView(tblKhoaHoc);

        pnlKhoaHoc.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        tabs.addTab("T???NG H???P ??I???M", new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png")), pnlKhoaHoc, "T???NG H???P ??I???M"); // NOI18N

        pnlDoanhThu.setLayout(new java.awt.CardLayout());

        pnlTruongPhong.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Date.png"))); // NOI18N
        jLabel3.setText("N??M: ");
        jPanel1.add(jLabel3, java.awt.BorderLayout.LINE_START);

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });
        jPanel1.add(cboNam, java.awt.BorderLayout.CENTER);

        pnlTruongPhong.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CHUY??N ?????", "S??? KH??A", "S??? HV", "DOANH THU", "HP CAO NH???T", "HP TH???P NH???T", "HP TRUNG B??NH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setRowHeight(25);
        tblDoanhThu.setRowMargin(0);
        tblDoanhThu.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tblDoanhThu);

        pnlTruongPhong.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pnlDoanhThu.add(pnlTruongPhong, "card1");

        pnlNhanVien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlNhanVienAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlNhanVien.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Secure.png"))); // NOI18N
        jLabel4.setToolTipText("c???n th???n b??? tr??? l????ng");
        pnlNhanVien.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CH??? TR?????NG PH??NG M???I ???????C XEM DOANH THU");
        jLabel5.setToolTipText("c???n th???n b??? tr??? l????ng");
        pnlNhanVien.add(jLabel5, java.awt.BorderLayout.CENTER);

        pnlDoanhThu.add(pnlNhanVien, "card2");

        tabs.addTab("DOANH THU", new javax.swing.ImageIcon(getClass().getResource("/icon/Coins.png")), pnlDoanhThu, "DOANH THU"); // NOI18N

        btn_export.setBackground(new java.awt.Color(24, 98, 151));
        btn_export.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_export.setForeground(new java.awt.Color(255, 255, 255));
        btn_export.setText("Xu???t EXCEL");
        btn_export.setBorder(null);
        btn_export.setBorderPainted(false);
        btn_export.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        // TODO add your handling code here:
        fillTableBangDiem();                     //ActionPerformed
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        fillTableDoanhThu();                   //ActionPerformed
    }//GEN-LAST:event_cboNamActionPerformed
    /*
    khi m??? JInternalFrame:
    ??i???n d??? li???u v??o cboKhoaHoc v?? cboNam
    ??i???n d??? li???u v??o c??c b???ng
     */
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        fillComboBoxkhoaHoc();
        fillTableBangDiem();
        fillTableNguoiHoc();
        fillTablekhoaHoc();
        fillComboBoxNam();
        fillTableDoanhThu();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        try {
            JFileChooser chonChoLuu = new JFileChooser();
            //chonChoLuu.setCurrentDirectory(new File(System.getProperty("user.dir")));
            chonChoLuu.setSelectedFile(new File("unname.xlsx"));
            int reponse = chonChoLuu.showSaveDialog(null);
            if (reponse == JFileChooser.APPROVE_OPTION) {
                String savePath = chonChoLuu.getSelectedFile().getAbsolutePath();
                if (chonChoLuu.getSelectedFile().getName().length() > 5) {
                    if (!savePath.substring(savePath.length() - 5).equals(".xlsx")) {
                        savePath = savePath + ".xlsx";
                    }
                } else {
                    savePath = savePath + ".xlsx";
                }
                if (new File(savePath).exists()) {
                    if (dialogHelper.confirm(this, "???? t???n t???i file n??y, b???n c?? mu???n ghi ?????")) {
                        switch (this.tabs.getSelectedIndex()) {
                            case 0:
                                ExportFileHelper.writeToExcell(this.tblNguoiHoc, Paths.get(savePath));
                                dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                                break;
                            case 1:
                                ExportFileHelper.writeToExcell(this.tblBangDiem, Paths.get(savePath));
                                dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                                break;
                            case 2:
                                ExportFileHelper.writeToExcell(this.tblKhoaHoc, Paths.get(savePath));
                                dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                                break;
                            case 3:
                                ExportFileHelper.writeToExcell(this.tblDoanhThu, Paths.get(savePath));
                                dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                                break;
                        }
                    }
                } else {
                    switch (this.tabs.getSelectedIndex()) {
                        case 0:
                            ExportFileHelper.writeToExcell(this.tblNguoiHoc, Paths.get(savePath));
                            dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                            break;
                        case 1:
                            ExportFileHelper.writeToExcell(this.tblBangDiem, Paths.get(savePath));
                            dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                            break;
                        case 2:
                            ExportFileHelper.writeToExcell(this.tblKhoaHoc, Paths.get(savePath));
                            dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                            break;
                        case 3:
                            ExportFileHelper.writeToExcell(this.tblDoanhThu, Paths.get(savePath));
                            dialogHelper.alert(this, "Xu???t File th??nh c??ng !");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Xu???t file th???t b???i!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_exportActionPerformed

    private void pnlNhanVienAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlNhanVienAncestorAdded
        // TODO add your handling code here:
        this.btn_export.setVisible(false);
    }//GEN-LAST:event_pnlNhanVienAncestorAdded

    private void pnlNguoiHocAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlNguoiHocAncestorAdded
        // TODO add your handling code here:
        this.btn_export.setVisible(true);
    }//GEN-LAST:event_pnlNguoiHocAncestorAdded

    private void pnlBangDiemAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlBangDiemAncestorAdded
        // TODO add your handling code here:
        this.btn_export.setVisible(true);
    }//GEN-LAST:event_pnlBangDiemAncestorAdded

    private void pnlKhoaHocAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlKhoaHocAncestorAdded
        // TODO add your handling code here:
        this.btn_export.setVisible(true);
    }//GEN-LAST:event_pnlKhoaHocAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export;
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlBangDiem;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlKhoaHoc;
    private javax.swing.JPanel pnlNguoiHoc;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblKhoaHoc;
    private javax.swing.JTable tblNguoiHoc;
    // End of variables declaration//GEN-END:variables
    //x??a b???ng ??i???m, ??i???n d??? li???u v??o b???ng ??i???m theo MaKH
    private void fillTableBangDiem() {
        khoaHoc kh = (khoaHoc) this.cboKhoaHoc.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> list = this.TKDao.getBangDiem(kh.getMaKH());
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    //x??a b???ng doanh thu, ??i???n d??? li???u v??o b???ng doanh thu theo n??m t????ng ???ng
    private void fillTableDoanhThu() {
        int nam = Integer.parseInt(cboNam.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> list = this.TKDao.getDoanhThu(nam);//l???y doanh thu theo n??m
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    //x??a cbo, l???y t???t c??? ??t khoaHoc t??? CSDL th??m m???i v??o cbo
    //ch???n s???n Item th??? nh???t
    private void fillComboBoxkhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoaHoc.getModel(); //k???t n???i cbo v???i model
        model.removeAllElements(); //x??a t???t c??? item
        ArrayList<khoaHoc> list = this.KHDao.select();
        for (khoaHoc kh : list) {
            model.addElement(kh);
        }
        cboKhoaHoc.setSelectedIndex(0);
    }

    //x??a b???ng ng?????i h???c, ??i??m d??? li???u v??o b???ng ng?????i h???c
    private void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> list = this.TKDao.getNguoHoc();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    //x??a b???ng t???ng h???p ??i???m, ??i???n d??? li???u v??o b???ng t???ng h???p ??i???m
    private void fillTablekhoaHoc() {
        DefaultTableModel model = (DefaultTableModel) tblKhoaHoc.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> list = this.TKDao.getDiemTheoChuyenDe();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    //l???y t???t c??? n??m c???a kh??a h???c (int) ??i???n v??o cbo (??i???n ??t int), ko ??i???n tr??ng
    //ch???n s???n Item th??? nh???t
    private void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        ArrayList<Integer> list = this.TKDao.getNamKhaiGiang();//L???y list n??m khai gi???ng
        for (Integer nam : list) {
            model.addElement(nam);
        }
        this.cboNam.setSelectedIndex(0);
    }
}
