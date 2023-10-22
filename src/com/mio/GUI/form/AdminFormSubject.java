/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mio.GUI.form;

import com.mio.BLL.DepartmentBLL;
import com.mio.BLL.SubjectBLL;
import com.mio.DTO.Department;
import com.mio.DTO.Subject;
import com.mio.GUI.main.Main;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mio
 */
public class AdminFormSubject extends javax.swing.JPanel {

    /**
     * Creates new form AdminFormSubject
     */
    List<Subject> list;
    public AdminFormSubject() {
        initComponents();
        
        menuSplit1.setText("学部");
        menuSplit2.setText("科目");
        
        cbxDep.setModel(new DefaultComboBoxModel(DepartmentBLL.getInstance().getDepartmentList().toArray()));
        
        table.fixTable(scroll);
        table.setModel(new MyModel());
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    Subject s = list.get(table.getSelectedRow());
                    tfName.setText(s.getName());
                    spnCredit.setValue(s.getCredit());
                    rdbtnIsLab.setSelected(s.isRequireLab());
                }
            }
        });
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
        cbxDep = new com.mio.GUI.swing.ComboBox();
        btnShow = new com.mio.GUI.swing.Button();
        menuSplit2 = new com.mio.GUI.swing.MenuSplit();
        label1 = new com.mio.GUI.swing.Label();
        tfName = new com.mio.GUI.swing.TextField();
        btnAdd = new com.mio.GUI.swing.Button();
        btnEdit = new com.mio.GUI.swing.Button();
        btnDel = new com.mio.GUI.swing.Button();
        rdbtnIsLab = new com.mio.GUI.swing.RadioButton();
        scroll = new javax.swing.JScrollPane();
        table = new com.mio.GUI.swing.MyTable();
        spnCredit = new com.mio.GUI.swing.spinner.Spinner();
        label2 = new com.mio.GUI.swing.Label();

        setOpaque(false);

        btnShow.setText("一覧");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        label1.setText("科目名");

        btnAdd.setText("追加");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("編集");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setText("削除");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        rdbtnIsLab.setText("コンピュータ有り");

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

        label2.setText("時間");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuSplit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuSplit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(spnCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rdbtnIsLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(menuSplit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtnIsLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int currentDep = -1;
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        if(cbxDep.getSelectedIndex() != -1) {
            int selectedDepId = ((Department)cbxDep.getSelectedItem()).getId();
            if(selectedDepId != currentDep) {
                currentDep = selectedDepId;
                list = SubjectBLL.getInstance().getSubjectListByDepId(currentDep);
                ((MyModel)table.getModel()).setList(list);
            }
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if(currentDep != -1) {
            Subject s = new Subject(-1, tfName.getText(), currentDep, rdbtnIsLab.isSelected(), (int)spnCredit.getValue());
            SubjectBLL.getInstance().addSubject(s);
            if(s.getId() != -1) {
                list.add(s);
                ((AbstractTableModel)table.getModel()).fireTableRowsInserted(list.size() - 1, list.size() - 1);
            } else {
                Main.getInstance().showNotification(Main.NotificationType.ADD_FAILED);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int r = table.getSelectedRow();
        if(r != -1) {
            Subject s = new Subject(list.get(r).getId(), tfName.getText(), currentDep, rdbtnIsLab.isSelected(), (int)spnCredit.getValue());
            if(SubjectBLL.getInstance().updateSubject(s)) {
                list.get(r).copy(s);
                ((AbstractTableModel)table.getModel()).fireTableRowsUpdated(r, r);
            } else {
                Main.getInstance().showNotification(Main.NotificationType.UPDATE_FAILED);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int r = table.getSelectedRow();
        if(r != -1) {
            if(SubjectBLL.getInstance().delSubject(list.get(r).getId())) {
                list.remove(r);
                ((AbstractTableModel)table.getModel()).fireTableRowsDeleted(r, r);
            } else {
                Main.getInstance().showNotification(Main.NotificationType.DELETE_FAILED);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private class MyModel extends AbstractTableModel {
        List<Subject> list;
        MyModel() {
            this.list = new ArrayList<>();
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0 -> {
                    return "ID";
                }
                case 1 -> {
                    return "科目名";
                }
                case 2 -> {
                    return "コンピューター";
                }
                default -> {
                    return "時間";
                }
            }
        }
        
        
        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public int getRowCount() {
            return list.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Subject s = list.get(rowIndex);
            switch(columnIndex) {
                case 0 -> {
                    return s.getId();
                }
                case 1 -> {
                    return s.getName();
                }
                case 2 -> {
                    return s.isRequireLab() ? "有り" : "無し";
                }
                default -> {
                    return s.getCredit();
                }
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
        
        public void setList(List<Subject> list) {
            this.list = list;
            fireTableDataChanged();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mio.GUI.swing.Button btnAdd;
    private com.mio.GUI.swing.Button btnDel;
    private com.mio.GUI.swing.Button btnEdit;
    private com.mio.GUI.swing.Button btnShow;
    private com.mio.GUI.swing.ComboBox cbxDep;
    private com.mio.GUI.swing.Label label1;
    private com.mio.GUI.swing.Label label2;
    private com.mio.GUI.swing.MenuSplit menuSplit1;
    private com.mio.GUI.swing.MenuSplit menuSplit2;
    private com.mio.GUI.swing.RadioButton rdbtnIsLab;
    private javax.swing.JScrollPane scroll;
    private com.mio.GUI.swing.spinner.Spinner spnCredit;
    private com.mio.GUI.swing.MyTable table;
    private com.mio.GUI.swing.TextField tfName;
    // End of variables declaration//GEN-END:variables
}