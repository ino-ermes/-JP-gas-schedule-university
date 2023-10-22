/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mio.GUI.swing;

import com.mio.BLL.RoomBLL;
import com.mio.DTO.Room;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mio
 */
public class RoomChooser extends javax.swing.JPanel {

    /**
     * Creates new form RoomChooser
     */
    public RoomChooser() {
        initComponents();
        menuSplit1.setText("教室選択");
        
        table.fixTable(scroll);
        list = RoomBLL.getInstance().getRoomList();
        chosens = new boolean[list.size()];
        for(int i = 0; i != chosens.length; ++i) {
            chosens[i] = true;
        }
        table.setModel(new MyModel());
        
    }

    private List<Room> list;
    private boolean[] chosens;
    
    private class MyModel extends AbstractTableModel {
    MyModel() {
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "ID";
            }
            case 1 -> {
                return "教室名";
            }
            case 2 -> {
                return "収容人数";
            }
            case 3 -> {
                return "コンピュータ";
            }
            default -> {
                return "選択";
            }
        }
    }


    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room s = list.get(rowIndex);
        switch(columnIndex) {
            case 0 -> {
                return s.getId();
            }
            case 1 -> {
                return s.getName();
            }
            case 2 -> {
                return s.getSize();
            }
            case 3 -> {
                return s.isLab() ? "有り" : "無し";
            }
            default -> {
                return chosens[rowIndex] ? "〇" : "✕";
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
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

        menuSplit1 = new com.mio.GUI.swing.MenuSplit();
        btnChoose = new com.mio.GUI.swing.Button();
        btnChooseAll = new com.mio.GUI.swing.Button();
        btnUnChooseAll = new com.mio.GUI.swing.Button();
        scroll = new javax.swing.JScrollPane();
        table = new com.mio.GUI.swing.MyTable();

        setOpaque(false);

        btnChoose.setText("選択");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnChooseAll.setText("すべて（〇）");
        btnChooseAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseAllActionPerformed(evt);
            }
        });

        btnUnChooseAll.setText("すべて（✕）");
        btnUnChooseAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnChooseAllActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuSplit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChooseAll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUnChooseAll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnChooseAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        int r = table.getSelectedRow();
        if(r != -1) {
            chosens[r] = !chosens[r];
            ((MyModel)table.getModel()).fireTableRowsUpdated(r, r);
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnChooseAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseAllActionPerformed
        for(int i = 0; i != chosens.length; ++i) {
            chosens[i] = true;
        }
        ((MyModel)table.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_btnChooseAllActionPerformed

    private void btnUnChooseAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnChooseAllActionPerformed
        for(int i = 0; i != chosens.length; ++i) {
            chosens[i] = false;
        }
        ((MyModel)table.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_btnUnChooseAllActionPerformed

    public List<Room> getChosenRoom() {
        ArrayList<Room> rooms = new ArrayList<>();
        for(int i = 0; i != chosens.length; ++i) {
            if(chosens[i]) {
                rooms.add(list.get(i));
            }
        }
        return rooms;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mio.GUI.swing.Button btnChoose;
    private com.mio.GUI.swing.Button btnChooseAll;
    private com.mio.GUI.swing.Button btnUnChooseAll;
    private com.mio.GUI.swing.MenuSplit menuSplit1;
    private javax.swing.JScrollPane scroll;
    private com.mio.GUI.swing.MyTable table;
    // End of variables declaration//GEN-END:variables
}