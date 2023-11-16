/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlbv;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import qlsv.IO.IO;
import qlsv.ultis.Ve;
import qlsv.ultis.VEDAO;

/**
 *
 * @author hoanl
 */
public class QLBANVEMAYBAY extends javax.swing.JFrame {
    private NonEdit tblModel = new NonEdit();
    private VEDAO dao = new VEDAO();
    private boolean isSort = true;
    /**
     * Creates new form QLSVview
     */
    public QLBANVEMAYBAY() {
        initComponents();
        init();
    }
    
    class NonEdit extends DefaultTableModel{
        public boolean isCellEditable(int row,int column){
            return false;
        }
    }
    
    void init(){
        this.setLocationRelativeTo(null);
        
        tblModel.setColumnIdentifiers(new Object[]{"Mã Vé","Số Ghế","Họ tên","Tổng tiền","Tổng"});
        tblSinhVien.setModel(tblModel);
        // tang size
        JTableHeader header = tblSinhVien.getTableHeader();
        Font headerFont = new Font("Segoe UI",Font.BOLD,13);
        header.setFont(headerFont);
        ///
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        //
        dao.addToArray(new Ve("A1","Hoan",2.0,120.000,600.000));
        dao.addToArray(new Ve("A2","thien",3.0,130.000,240.000));
        dao.addToArray(new Ve("A4","liem",2.0,140.000,360.000));
        dao.addToArray(new Ve("A5","liem",2.0,150.000,360.000));
        fillToTable();
    }
    
    public void fillToTable(){
        tblModel.setRowCount(0);
        for(Ve sv : dao.getList()){
            tblModel.addRow(new Object[]{sv.getId(),sv.getName(),sv.getSGhe(),sv.getGiaphong(),sv.getTongtien()});
        }
    }
    
    Ve check(){
        String id = txtID.getText();
        String name = txtName.getText();
//        String giaphong = txtgiaphong.getText();
        String SGhe = txtSGhe.getText();
        
        if(id.equals("")||name.equals("")||SGhe.equals("")){
            JOptionPane.showMessageDialog(this, "Không được bỏ trống ô nhập");
            return null;
        }
        
        Double giaphongb = null;
//        Double SGhea = null;
//
//            if(SGhea<0){
//                JOptionPane.showMessageDialog(this, "Số ngày ở phải lớn hơn 0");
//                return null;
//            }
//
//        
  
                Double SGhea = null;
       

            SGhea = Double.parseDouble(txtSGhe.getText());

            if(SGhea <0){
                JOptionPane.showMessageDialog(this, "Số ghế phải lớn hơn 0");
               
            }
        
        
       
        Double Tongtien = null;
         if( SGhea!=null && rdoPhothong.isSelected()){
            Tongtien = (SGhea)*8000000 ;
        }else if(  SGhea!=null && rdoThuonggia.isSelected()){
            Tongtien = ( SGhea )* 17000000;
//        }else if(Giaphongb!=null && SNgayOb!=null && rdoxedua.isSelected()){
//            Tongtien = (Giaphongb * SNgayOb )+ 200000;
        }
//           Double thanhtien = null;
//           if(SGhea!=null){
//                thanhtien = (SGhea)*8000000;
//        }else{
//               thanhtien = (SGhea)*17000000;
//           }
              
       
        

       
       
        
        Ve svMoi = new Ve();
        svMoi.setTongtien(Tongtien);
        svMoi.setId(id);
        svMoi.setSGhe(SGhea);
        svMoi.setName(name);
        svMoi.setGiaphong(giaphongb);
        
        return svMoi;
        
    }
    
    void reset(){
        txtID.setText("");
        txtName.setText("");
//        txtgiaphong.setText("");
        txtSGhe.setText("");
        txtthanhtien.setText("");
        btnAdd.setEnabled(true);
        txtID.setEditable(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        tblSinhVien.clearSelection();
        buttonGroup1.clearSelection();
        
    }
    
    void fillToForm(Ve sv){
        txtID.setText(sv.getId());
        txtName.setText(sv.getName());
        txtSGhe.setText(sv.getSGhe()+"");
//        txtgiaphong.setText(sv.getGiaphong()+"");
        txtthanhtien.setText(sv.getTongtien()+"");
        txtID.setEditable(false);
                btnAdd.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
    }
    
    public void readFile(){
        try{
            dao = (VEDAO) IO.readObject("src\\FinalTest\\QuanLy_BanVe.txt");
            fillToTable();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void writeFile(){
        try{
            IO.writeObject("src\\FinalTest\\QuanLy_BanVe.txt", dao);
            JOptionPane.showMessageDialog(this, "da luu thanh cong");
        }
        catch(Exception e){
            System.out.println(e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSGhe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        btnAVG = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        rdoPhothong = new javax.swing.JRadioButton();
        rdoThuonggia = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QLSV");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("QUẢN LÝ VÉ MÁY BAY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Vé");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên khách hàng");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số Hiệu Ghế");

        txtSGhe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giá tiền");

        txtthanhtien.setEditable(false);
        txtthanhtien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAVG.setText("In gia tiền");
        btnAVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAVGActionPerformed(evt);
            }
        });

        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Create.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnSort.setText("Sắp xếp");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnRead.setText("Đọc file");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu file");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        rdoPhothong.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoPhothong);
        rdoPhothong.setText("Phổ Thông");

        rdoThuonggia.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoThuonggia);
        rdoThuonggia.setText("Thương Gia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnAVG, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(rdoPhothong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(rdoThuonggia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRead))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFind))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSort)))
                        .addGap(157, 157, 157))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(39, 39, 39)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoPhothong)
                            .addComponent(rdoThuonggia))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAVG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnFind))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnSort))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnRead))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnSave))))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Ve svMoi = check();
        if(svMoi!=null){
            dao.addToArray(svMoi);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công.");
            fillToTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAVGActionPerformed

        Double SGhe = null;
        try{

            SGhe = Double.parseDouble(txtSGhe.getText());

            if(SGhe <0){
                JOptionPane.showMessageDialog(this, "Số ghế phải lớn hơn 0");
                return;
            }
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(this, "Số Ghế phải lớn hơn 0");
                return ;
        }
        
        Double Tongtien = null;
         if( SGhe!=null && rdoPhothong.isSelected()){
            Tongtien = (SGhe)*8000000 ;
        }else if(  SGhe!=null && rdoThuonggia.isSelected()){
            Tongtien = ( SGhe )* 17000000;
//        }else if(Giaphongb!=null && SNgayOb!=null && rdoxedua.isSelected()){
//            Tongtien = (Giaphongb * SNgayOb )+ 200000;
        }else{
            Tongtien = null;
        }
             txtthanhtien.setText(Tongtien+"");
//         String giatui = rdogiatui.getActionCommand();
//         String hoboi = rdohoboi.getActionCommand();
//         String xedua = rdoxedua.getActionCommand();
//        if(giatui.equals("")){
//            
//        }else{
//           Tongtien = (Giaphongb * SNgayOb + 100000);
//         
//        }
//        if(hoboi.equals("")){
//            
//        }else{
//           Tongtien = (Giaphongb * SNgayOb + 150000);
//          
//        }
//        if(xedua.equals("")){
//            
//        }else{
//           Tongtien = (Giaphongb * SNgayOb + 200000);
//          
//        }
        
     
    }//GEN-LAST:event_btnAVGActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        int rowSelected = tblSinhVien.getSelectedRow();
        if(rowSelected >=0){
            String id = (String) tblModel.getValueAt(rowSelected, 0);
            Ve sv = dao.findByID(id);
            if(sv!=null){
                fillToForm(sv);

            }
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(!txtID.getText().isBlank()){
            Ve sv = check();
            if(sv!=null){
                if(dao.edit(sv)){
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    fillToTable();
                    reset();
                    return;
                }
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        if(!id.equals("")){
            if(!dao.deleteByID(id)){
                JOptionPane.showMessageDialog(this, "Xóa thất bại hoặc số phòng không tồn tại");
                return;
            }
            else{
                reset();
                fillToTable();
            }
        }
        else{
                JOptionPane.showMessageDialog(this, "Không được để trống ô sô phòng");
                return;
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        if(!id.equals("")){
            Ve sv = dao.findByID(id);
            if(sv!=null){
                fillToForm(sv);
                tblSinhVien.setRowSelectionInterval(dao.indexOfsv(sv), dao.indexOfsv(sv));
            }
            else{
                JOptionPane.showMessageDialog(this, "Không tìm thấy số phòng");
                return;
            }
        }
        else{
                JOptionPane.showMessageDialog(this, "Số phòng cần tìm không được trống");
                return;
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:'
        if(isSort){
          dao.sort(isSort);
          isSort = !isSort;
        }
        else{
          dao.sort(isSort);
          isSort = !isSort;
        }
        fillToTable();
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // TODO add your handling code here:
        this.readFile();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.writeFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLBANVEMAYBAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLBANVEMAYBAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLBANVEMAYBAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLBANVEMAYBAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLBANVEMAYBAY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAVG;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoPhothong;
    private javax.swing.JRadioButton rdoThuonggia;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSGhe;
    private javax.swing.JTextField txtthanhtien;
    // End of variables declaration//GEN-END:variables
}
