/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dataBase.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class viewListDataPelanggan extends javax.swing.JFrame {

    /**
     * Creates new form viewListDataPelanggan
     */
    
    private viewTransaksi vT;
    private DefaultTableModel model;
    
    
    public viewListDataPelanggan(viewTransaksi vT) {
        initComponents();
        
        this.vT = vT;
        
        model = new DefaultTableModel();
        viewListDataPelanggan.setModel(model);
        model.addColumn("Id Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Nomor Handphone");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Umur");
        model.addColumn("Alamat");
        tampilDataPelanggan(); //panggil di fungsi kontruktor maka fungsi ini 
        //akan dieksekusi
    }
    
    private void tampilDataPelanggan(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM pelanggan";
        
        try {
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                //mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[6];//karena ada 6 field ditabel pelanggan
                hasil[0] = res.getString("idPelanggan");
                hasil[1] = res.getString("namaPelanggan");
                hasil[2] = res.getString("noHp");
                hasil[3] = res.getString("jenisKelamin");
                hasil[4] = res.getString("umur");
                hasil[5] = res.getString("alamat");
                
                model.addRow(hasil);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewPelangganInternal.class.getName()).log(Level.SEVERE, null, ex);
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        viewListDataPelanggan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewListDataPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        viewListDataPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewListDataPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewListDataPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewListDataPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewListDataPelangganMouseClicked
        // TODO add your handling code here:
        int listX = viewListDataPelanggan.getSelectedRow();
        vT.getIdPelanggan().setText(viewListDataPelanggan.getValueAt(listX,0).toString());
        vT.getNamaPelanggan().setText(viewListDataPelanggan.getValueAt(listX,1).toString());
        vT.getNomorHp().setText(viewListDataPelanggan.getValueAt(listX,2).toString());
        vT.getJenisKelamin().setText(viewListDataPelanggan.getValueAt(listX,3).toString());
        vT.getAlamatPelanggan().setText(viewListDataPelanggan.getValueAt(listX,5).toString());
        
        //ketika tabel di klik, maka list pelanggan akan di close
        dispose();
    }//GEN-LAST:event_viewListDataPelangganMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable viewListDataPelanggan;
    // End of variables declaration//GEN-END:variables
}
