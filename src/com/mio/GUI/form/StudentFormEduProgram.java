/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mio.GUI.form;

import com.mio.BLL.EduProgramBLL;
import com.mio.BLL.SubjectBLL;
import com.mio.DTO.EduProgramDetail;
import com.mio.DTO.Subject;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mio
 */
public class StudentFormEduProgram extends javax.swing.JPanel {

    /**
     * Creates new form StudentFormEduProgram
     */
    public StudentFormEduProgram(int eduId) {
        initComponents();
        
        menuSplit1.setText(EduProgramBLL.getInstance().getEduProgram(eduId).getName());
        List<EduProgramDetail> list = EduProgramBLL.getInstance().getEduProgDetail(eduId);
        HashMap<Integer, Subject> subjects  = new HashMap<>();
        Subject s;
        int maxSemester = 0, totalCredit = 0;
        for(EduProgramDetail e: list) {
            s = SubjectBLL.getInstance().getSubject(e.getSubjectId());
            subjects.put(s.getId(), s);
            if(maxSemester < e.getSemester())
                maxSemester = e.getSemester();
            totalCredit += s.getCredit();
        }
        lblTotalSemester.setText(lblTotalSemester.getText() + maxSemester);
        lblTotalCredit.setText(lblTotalCredit.getText() + totalCredit);
        table.fixTable(scroll);
        table.setModel(new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0 -> {
                        return "学期";
                    }
                    case 1 -> {
                        return "ID";
                    }
                    case 2 -> {
                        return "科目名";
                    }
                    case 3 -> {
                        return "コンピュータ";
                    }
                    default -> {
                        return "時間";
                    }
                }
            }
            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                EduProgramDetail e = list.get(rowIndex);
                Subject s = subjects.get(e.getSubjectId());
                switch(columnIndex) {
                    case 0 -> {
                        return e.getSemester();
                    }
                    case 1 -> {
                        return e.getSubjectId();
                    }
                    case 2 -> {
                        return s.getName();
                    }
                    case 3 -> {
                        return s.isRequireLab() ? "有り" : "無し";
                    }
                    default -> {
                        return s.getCredit();
                    }
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
        lblTotalSemester = new com.mio.GUI.swing.Label();
        lblTotalCredit = new com.mio.GUI.swing.Label();
        scroll = new javax.swing.JScrollPane();
        table = new com.mio.GUI.swing.MyTable();

        setOpaque(false);

        lblTotalSemester.setText("学期合計：");

        lblTotalCredit.setText("時間合計：");

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
                    .addComponent(lblTotalSemester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mio.GUI.swing.Label lblTotalCredit;
    private com.mio.GUI.swing.Label lblTotalSemester;
    private com.mio.GUI.swing.MenuSplit menuSplit1;
    private javax.swing.JScrollPane scroll;
    private com.mio.GUI.swing.MyTable table;
    // End of variables declaration//GEN-END:variables
}
