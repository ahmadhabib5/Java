/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.controllerPelanggan;
import dataBase.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class viewPelangganInternal extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewPelangganInternal
     */
    
    private controllerPelanggan cP;
    private DefaultTableModel model;
    
    public viewPelangganInternal() {
        initComponents();
        cP = new controllerPelanggan(this);
        model = new DefaultTableModel();
        tabelPelanggan.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("Jk");
        model.addColumn("No.Hp");
        model.addColumn("Alamat");
        tampilDataPelanggan();
        cP.kontrolButton();
        
    }

    public JTextArea getAlamatPelangganView() {
        return alamatPelangganView;
    }

    public JTextField getNamaPelangganView() {
        return namaPelangganView;
    }

    public JTextField getNoHpPelangganView() {
        return noHpPelangganView;
    }

    public JTextField getUmurpelangganView() {
        return umurpelangganView;
    }

    public JRadioButton getWanitaView() {
        return wanitaView;
    }

    public JRadioButton getPriaView() {
        return priaView;
    }

    public JTextField getIdPelangganView() {
        return idPelangganView;
    }

    public JButton getTombolBatalView() {
        return tombolBatalView;
    }

    public JButton getTombolHapusView() {
        return tombolHapusView;
    }

    public JButton getTombolSimpanView() {
        return tombolSimpanView;
    }

    public JButton getTombolUbahView() {
        return tombolUbahView;
    }
    
    

    private void tampilDataPelanggan(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String sql = ("SELECT * FROM pelanggan");
        try {
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6];
                hasil[0] = res.getString("idPelanggan");
                hasil[1] = res.getString("namaPelanggan");
                hasil[2] = res.getString("noHp");
                hasil[3] = res.getString("jenisKelamin");
                hasil[4] = res.getString("umur");
                hasil[5] = res.getString("alamat");
                model.addRow(hasil);
            }
        } catch (Exception e) {
            
        }
        
    }
    
    private void ambilDataTabel(){
        int index = tabelPelanggan.getSelectedRow();
        String id = String.valueOf(tabelPelanggan.getValueAt(index, 0));
        String nama = String.valueOf(tabelPelanggan.getValueAt(index, 1));
        String tlp = String.valueOf(tabelPelanggan.getValueAt(index, 2));
        String jk = String.valueOf(tabelPelanggan.getValueAt(index, 3));
        String umur = String.valueOf(tabelPelanggan.getValueAt(index, 4));
        String alamat = String.valueOf(tabelPelanggan.getValueAt(index, 5));
        
        idPelangganView.setText(id);
        namaPelangganView.setText(nama);
        umurpelangganView.setText(umur);
        noHpPelangganView.setText(tlp);
        if (jk.equals("Pria")){
            priaView.setSelected(true);
        }else if (jk.equals("wanita")){
            wanitaView.setSelected(true);
        }
        
        alamatPelangganView.setText(alamat);
        cP.kontrolButtonDua();
    } 
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelaminPelangganView = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaPelangganView = new javax.swing.JTextField();
        umurpelangganView = new javax.swing.JTextField();
        noHpPelangganView = new javax.swing.JTextField();
        priaView = new javax.swing.JRadioButton();
        wanitaView = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatPelangganView = new javax.swing.JTextArea();
        tombolSimpanView = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        idPelangganView = new javax.swing.JTextField();
        tombolUbahView = new javax.swing.JButton();
        tombolHapusView = new javax.swing.JButton();
        tombolBatalView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modul Pelanggan");

        jLabel1.setText("Nama");

        jLabel4.setText("Umur");

        jLabel3.setText("No. Hp");

        jLabel2.setText("Jenis Kelamin");

        jLabel5.setText("Alamat");

        namaPelangganView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPelangganViewActionPerformed(evt);
            }
        });

        umurpelangganView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umurpelangganViewActionPerformed(evt);
            }
        });

        noHpPelangganView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHpPelangganViewActionPerformed(evt);
            }
        });

        priaView.setText("Pria");
        priaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priaViewActionPerformed(evt);
            }
        });

        wanitaView.setText("wanita");
        wanitaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wanitaViewActionPerformed(evt);
            }
        });

        alamatPelangganView.setColumns(20);
        alamatPelangganView.setRows(5);
        jScrollPane1.setViewportView(alamatPelangganView);

        tombolSimpanView.setText("Simpan");
        tombolSimpanView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanViewActionPerformed(evt);
            }
        });

        jLabel6.setText("ID Pelanggan");

        idPelangganView.setEnabled(false);
        idPelangganView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPelangganViewActionPerformed(evt);
            }
        });

        tombolUbahView.setText("Ubah");
        tombolUbahView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahViewActionPerformed(evt);
            }
        });

        tombolHapusView.setText("Hapus");
        tombolHapusView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusViewActionPerformed(evt);
            }
        });

        tombolBatalView.setText("Batal");
        tombolBatalView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalViewActionPerformed(evt);
            }
        });

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tombolBatalView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolHapusView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolUbahView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolSimpanView))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(noHpPelangganView)
                        .addComponent(umurpelangganView, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(priaView)
                            .addGap(49, 49, 49)
                            .addComponent(wanitaView))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                    .addComponent(namaPelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idPelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namaPelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(umurpelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(noHpPelangganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(priaView)
                            .addComponent(wanitaView))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolSimpanView)
                            .addComponent(tombolUbahView)
                            .addComponent(tombolHapusView)
                            .addComponent(tombolBatalView))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaPelangganViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPelangganViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPelangganViewActionPerformed

    private void umurpelangganViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umurpelangganViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_umurpelangganViewActionPerformed

    private void noHpPelangganViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHpPelangganViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noHpPelangganViewActionPerformed

    private void priaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priaViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priaViewActionPerformed

    private void wanitaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wanitaViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wanitaViewActionPerformed

    private void tombolSimpanViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanViewActionPerformed
        // TODO add your handling code here:
        cP.simpan();
        tampilDataPelanggan();
    }//GEN-LAST:event_tombolSimpanViewActionPerformed

    private void idPelangganViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPelangganViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPelangganViewActionPerformed

    private void tombolUbahViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahViewActionPerformed
        // TODO add your handling code here:
        cP.ubah();
        tampilDataPelanggan();
    }//GEN-LAST:event_tombolUbahViewActionPerformed

    private void tombolHapusViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusViewActionPerformed
        // TODO add your handling code here:
        cP.hapus();
        tampilDataPelanggan();
    }//GEN-LAST:event_tombolHapusViewActionPerformed

    private void tombolBatalViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalViewActionPerformed
        // TODO add your handling code here:
        cP.kontrolButton();
        cP.bersihkan();
        tampilDataPelanggan();
    }//GEN-LAST:event_tombolBatalViewActionPerformed

    private void tabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPelangganMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelPelangganMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatPelangganView;
    private javax.swing.JTextField idPelangganView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup jenisKelaminPelangganView;
    private javax.swing.JTextField namaPelangganView;
    private javax.swing.JTextField noHpPelangganView;
    private javax.swing.JRadioButton priaView;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JButton tombolBatalView;
    private javax.swing.JButton tombolHapusView;
    private javax.swing.JButton tombolSimpanView;
    private javax.swing.JButton tombolUbahView;
    private javax.swing.JTextField umurpelangganView;
    private javax.swing.JRadioButton wanitaView;
    // End of variables declaration//GEN-END:variables
}
