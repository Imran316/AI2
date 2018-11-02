/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttdesign;

import FireData.Firedata;
import FireData.UploadTImetable;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author imran
 */
public class ShowTimetable extends javax.swing.JFrame {
    DefaultTableModel model, model1, model2, model_batch, model1_batch, model2_batch;
    Firedata firedata;
    ArrayList<UploadTImetable> seTimetable, teTimetable, beTimetable;

    /**
     * Creates new form ShowTimetable
     */
    public ShowTimetable() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            firedata = new Firedata();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        seTimetable = new ArrayList<>();
        teTimetable = new ArrayList<>();
        beTimetable = new ArrayList<>();

        model=(DefaultTableModel)jTableSE_COMP.getModel();
        model1=(DefaultTableModel)jTableTE_COMP.getModel();
        model2=(DefaultTableModel)jTableBE_COMP.getModel();
        model_batch=(DefaultTableModel)jTableSE_BATCH.getModel();
        model1_batch=(DefaultTableModel)jTableTE_BATCH.getModel();
        model2_batch=(DefaultTableModel)jTableBE_BATCH.getModel();
        ((DefaultTableCellRenderer)jTableBE_COMP.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        ((DefaultTableCellRenderer)jTableSE_COMP.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        ((DefaultTableCellRenderer)jTableSE_BATCH.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        ((DefaultTableCellRenderer)jTableTE_BATCH.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        ((DefaultTableCellRenderer)jTableBE_BATCH.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        try {
            seTimetable = firedata.retriveSE_Timetable();
            teTimetable = firedata.retriveTE_Timetable();
            beTimetable = firedata.retriveBE_Timetable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        for(int i=0; i<seTimetable.size(); i++){
            model.insertRow(model.getRowCount(), new String[]{
                    seTimetable.get(i).getTime().get(0),
                    seTimetable.get(i).getTime().get(1),
                    seTimetable.get(i).getTime().get(2),
                    seTimetable.get(i).getTime().get(3),
                    seTimetable.get(i).getTime().get(4),
                    seTimetable.get(i).getTime().get(5),
                    seTimetable.get(i).getTime().get(6),
                    seTimetable.get(i).getTime().get(7)
            });

            model_batch.insertRow(model_batch.getRowCount(), new String[]{
                    seTimetable.get(i).getPraTime().get(0),
                    seTimetable.get(i).getPraTime().get(1),
                    seTimetable.get(i).getPraTime().get(2),
                    seTimetable.get(i).getPraTime().get(3)
            });

            model1.insertRow(model1.getRowCount(), new String[]{
                    teTimetable.get(i).getTime().get(0),
                    teTimetable.get(i).getTime().get(1),
                    teTimetable.get(i).getTime().get(2),
                    teTimetable.get(i).getTime().get(3),
                    teTimetable.get(i).getTime().get(4),
                    teTimetable.get(i).getTime().get(5),
                    teTimetable.get(i).getTime().get(6),
                    teTimetable.get(i).getTime().get(7)
            });

            model1_batch.insertRow(model1_batch.getRowCount(), new String[]{
                    teTimetable.get(i).getPraTime().get(0),
                    teTimetable.get(i).getPraTime().get(1),
                    teTimetable.get(i).getPraTime().get(2),
                    teTimetable.get(i).getPraTime().get(3)
            });

            model2.insertRow(model2.getRowCount(), new String[]{
                    beTimetable.get(i).getTime().get(0),
                    beTimetable.get(i).getTime().get(1),
                    beTimetable.get(i).getTime().get(2),
                    beTimetable.get(i).getTime().get(3),
                    beTimetable.get(i).getTime().get(4),
                    beTimetable.get(i).getTime().get(5),
                    beTimetable.get(i).getTime().get(6),
                    beTimetable.get(i).getTime().get(7)
            });
            model2_batch.insertRow(model2_batch.getRowCount(), new String[]{
                    beTimetable.get(i).getPraTime().get(0),
                    beTimetable.get(i).getPraTime().get(1),
                    beTimetable.get(i).getPraTime().get(2),
                    beTimetable.get(i).getPraTime().get(3)
            });
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSE_COMP = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTE_COMP = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBE_COMP = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTE_BATCH = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableBE_BATCH = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableSE_BATCH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabelClose.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("x");
        jLabelClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TIMETABLE");
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelMin.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMin.setText("-");
        jLabelMin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jButtonBack.setBackground(new java.awt.Color(34, 167, 240));
        jButtonBack.setText("<-");
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelClose)
                                        .addComponent(jLabelMin))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 250));

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SE COMP:");

        jTableSE_COMP.setBackground(new java.awt.Color(44, 62, 80));
        jTableSE_COMP.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableSE_COMP.setForeground(new java.awt.Color(236, 240, 241));
        jTableSE_COMP.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        " 10.15 - 11.15", "11.15 - 12.15", "12.15 - 1.15", "BREAK", "1.45 - 2.45", "2.45 - 3.45", "3.45 - 4.45", "4.45 - 5.45"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSE_COMP.setRowHeight(25);
        jTableSE_COMP.setRowMargin(3);
        jTableSE_COMP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSE_COMPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSE_COMP);

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("TE COMP:");

        jTableTE_COMP.setBackground(new java.awt.Color(44, 62, 80));
        jTableTE_COMP.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableTE_COMP.setForeground(new java.awt.Color(236, 240, 241));
        jTableTE_COMP.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "10.15 - 11.15", "11.15 - 12.15", "12.15 - 1.15", "BREAK", "1.45 - 2.45", "2.45 - 3.45", "3.45 - 4.45", "4.45 - 5.45"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTE_COMP.setRowHeight(25);
        jTableTE_COMP.setRowMargin(3);
        jScrollPane2.setViewportView(jTableTE_COMP);

        jLabel6.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("BE COMP:");

        jTableBE_COMP.setBackground(new java.awt.Color(44, 62, 80));
        jTableBE_COMP.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableBE_COMP.setForeground(new java.awt.Color(236, 240, 241));
        jTableBE_COMP.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "10.15 - 11.15", "11.15 - 12.15", "12.15 - 1.15", "BREAK", "1.45 - 2.45", "2.45 - 3.45", "3.45 - 4.45", "4.45 - 5.45"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBE_COMP.setRowHeight(25);
        jTableBE_COMP.setRowMargin(3);
        jScrollPane3.setViewportView(jTableBE_COMP);

        jTableTE_BATCH.setBackground(new java.awt.Color(44, 62, 80));
        jTableTE_BATCH.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableTE_BATCH.setForeground(new java.awt.Color(236, 240, 241));
        jTableTE_BATCH.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "T1", "T2", "T3", "T4"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTE_BATCH.setRowHeight(25);
        jTableTE_BATCH.setRowMargin(3);
        jTableTE_BATCH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTE_BATCHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTE_BATCH);

        jTableBE_BATCH.setBackground(new java.awt.Color(44, 62, 80));
        jTableBE_BATCH.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableBE_BATCH.setForeground(new java.awt.Color(236, 240, 241));
        jTableBE_BATCH.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "B1", "B2", "B3", "B4"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBE_BATCH.setRowHeight(25);
        jTableBE_BATCH.setRowMargin(3);
        jTableBE_BATCH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBE_BATCHMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableBE_BATCH);

        jTableSE_BATCH.setBackground(new java.awt.Color(44, 62, 80));
        jTableSE_BATCH.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTableSE_BATCH.setForeground(new java.awt.Color(236, 240, 241));
        jTableSE_BATCH.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "S1", "S2", "S3", "S4"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSE_BATCH.setRowHeight(25);
        jTableSE_BATCH.setRowMargin(3);
        jTableSE_BATCH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSE_BATCHMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableSE_BATCH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(31, 31, 31)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel6))))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(60, 60, 60)
                                                        .addComponent(jLabel4))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1429, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {
        this.setState(JFrame.ICONIFIED);
    }

    private void jTableSE_COMPMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jTableTE_BATCHMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jTableBE_BATCHMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jTableSE_BATCHMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {
        Home loginForm  =  new Home();
        loginForm.setVisible(true);
        loginForm.pack();
        loginForm.setLocationRelativeTo(null);
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(ShowTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowTimetable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableBE_BATCH;
    private javax.swing.JTable jTableBE_COMP;
    private javax.swing.JTable jTableSE_BATCH;
    private javax.swing.JTable jTableSE_COMP;
    private javax.swing.JTable jTableTE_BATCH;
    private javax.swing.JTable jTableTE_COMP;
    // End of variables declaration
}
