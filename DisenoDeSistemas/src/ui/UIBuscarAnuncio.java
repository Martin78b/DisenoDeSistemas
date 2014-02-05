/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entidades.Anuncio;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import servicios.AnuncioService;
import servicios.UsuarioService;
import utility.DetectorDeSO;

/**
 *
 * @author martin
 */
public class UIBuscarAnuncio extends javax.swing.JFrame {

    ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource("resources/noimage.jpg"));
    ImageIcon search = new ImageIcon(getClass().getClassLoader().getResource("resources/search.png"));
    AnuncioService anuncioService = new AnuncioService();
    UsuarioService usuarioService = new UsuarioService();
    ArrayList<String> listaSugerencias = anuncioService.listarTitulos();
    javax.swing.JComboBox jComboBoxExtend = new JComboBox(new DefaultComboBoxModel(listaSugerencias.toArray())) {
        public Dimension getPreferredSize() {
            return new Dimension(super.getPreferredSize().width, 0);
        }
    };
    Vector imagenes;
    Vector titulos;
    Vector categorias;
    Vector tipos;
    DefaultTableModel modelo = new DefaultTableModel();
    Vector categoriasTexto = new Vector();

    private List<String> cargaCombo(List<String> categorias) {
        //new DefaultComboBoxModel(anuncioservice.categorias().toArray())
        List<String> retorno = new ArrayList<>();
        retorno.add("Todas");
        for (Iterator<String> it = categorias.iterator(); it.hasNext();) {
            retorno.add(it.next());
        }
        return retorno;
    }

    public final ImageIcon achicar(ImageIcon icon, int alto, int ancho) {
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        return newIcon;
    }

    private void fixWidth(final JTable table, final int columnIndex, final int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setMinWidth(width);
        column.setMaxWidth(width);
        column.setPreferredWidth(width);
    }

    private final void mostrarTabla(JTable jTable, Vector imagenes, Vector titulos,
            Vector categorias, Vector tipos) {
        modelo.addColumn(
                "Imagen", imagenes);
        modelo.addColumn("Anuncio", titulos);
        modelo.addColumn("Categoria", categorias);
        modelo.addColumn("Tipo anuncio", tipos);
        jTable1.setModel(modelo);
        this.fixWidth(jTable1, 0, 100);
        this.fixWidth(jTable1, 1, 150);
        this.fixWidth(jTable1, 2, 80);
    }

    private void buscar(String texto) {
        imagenes = new Vector();
        titulos = new Vector();
        categorias = new Vector();
        tipos = new Vector();
        List<Anuncio> lista = anuncioService.buscar(texto);
        modelo = new DefaultTableModel();
        this.cargar(lista, imagenes, titulos, categorias, tipos);
        this.mostrarTabla(jTable1, imagenes, titulos, categorias, tipos);
    }

    private void cargar(List<Anuncio> listaCompleta, Vector imagenes,
            Vector titulos, Vector categorias, Vector tipos) {
        for (Iterator<Anuncio> it = listaCompleta.iterator(); it.hasNext();) {
            Anuncio temporal = it.next();
            if (anuncioService.tieneImagen(temporal.getNro())) {
                ImageIcon imagenTemp = new ImageIcon(anuncioService.getImagen(temporal));
                imagenes.add(achicar(imagenTemp, 100, 100));
            } else {
                imagenes.add(achicar(icono, 100, 100));
            }
            String estado;
            if (temporal.isEstado()) {
                estado = "Nuevo";
            } else {
                estado = "Usado";
            }
            //<html><b>Day Of<br>Week</b></html>
            titulos.add("<html><b>" + temporal.getTitulo() + "</b><br> [" + estado + "]<br>$" + temporal.getPrecioactual() + "</html>");
            categorias.add(anuncioService.categorias(temporal.getNro()));
            tipos.add(anuncioService.tipoanucio(temporal));
        }
    }

    /**
     * Creates new form UIBuscarAnuncio
     */
    public UIBuscarAnuncio() {
        initComponents();
        jButton1.setIcon(this.achicar(search, 30, 30));
        DetectorDeSO.autocompletar(jTextField1, listaSugerencias);
        imagenes = new Vector();
        titulos = new Vector();
        categorias = new Vector();
        tipos = new Vector();
        List<Anuncio> listaCompleta = anuncioService.novedades(1);
        this.cargar(listaCompleta, imagenes, titulos, categorias, tipos);
        this.mostrarTabla(jTable1, imagenes, titulos, categorias, tipos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new JTable(modelo)
        {
            public Class getColumnClass(int col) {
                if (col == 0) {
                    return ImageIcon.class;
                } else {
                    return String.class;
                }
            }
        };

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscar(evt);
            }
        });

        jLabel1.setText("Categorias");

        jLabel2.setText("Estado");

        jRadioButton1.setText("Nuevo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Usado");

        jLabel3.setText("Rango de precios");

        jTextField2.setText("min");

        jTextField3.setText("max");

        jLabel4.setText("Ubicacion");

        jComboBox1.setModel(new DefaultComboBoxModel(this.cargaCombo(usuarioService.getProvincias()).toArray()));

        jLabel5.setText("Tipo de venta");

        jComboBox2.setModel(new DefaultComboBoxModel((this.cargaCombo(anuncioService.tipoanuncios())).toArray()));

        jButton3.setText("Filtrar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrar(evt);
            }
        });

        jComboBox3.setModel(new DefaultComboBoxModel(this.cargaCombo(anuncioService.categorias()).toArray()));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiaCategoria(evt);
            }
        });

        jLabel6.setText("Subcategorias");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(100);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, 0, 144, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void buscar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscar
        this.buscar(jTextField1.getText());
    }//GEN-LAST:event_buscar

    private void filtrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrar
        imagenes = new Vector();
        titulos = new Vector();
        categorias = new Vector();
        tipos = new Vector();
        List<Anuncio> lista = anuncioService.buscar(jTextField1.getText());
        modelo = new DefaultTableModel();
        List<Anuncio> filtrada = new ArrayList<>();
        Iterator itera;
        if (jComboBox3.getSelectedItem() != "Todas" && jComboBox4.getSelectedItem() == "Todas") {
            itera = lista.iterator();
            for (Iterator<Anuncio> it = lista.iterator(); it.hasNext();) {
                Anuncio temporal = it.next();
                if (anuncioService.categorias(temporal.getNro()).contains(jComboBox3.getSelectedItem().toString())) {
                    filtrada.add(temporal);
                }
            }
        }
        if (jComboBox4.getSelectedItem() != "Todas") {
            itera = lista.iterator();
            for (Iterator<Anuncio> it = lista.iterator(); it.hasNext();) {
                Anuncio temporal = it.next();
                if (!anuncioService.categorias(temporal.getNro()).contains(jComboBox4.getSelectedItem().toString())) {
                    lista.remove(temporal);
                }
            }

        }
        for (Iterator<Anuncio> it = filtrada.iterator(); it.hasNext();) {
            Anuncio temporal = it.next();
            if (anuncioService.tieneImagen(temporal.getNro())) {
                ImageIcon imagenTemp = new ImageIcon(anuncioService.getImagen(temporal));
                imagenes.add(achicar(imagenTemp, 100, 100));
            } else {
                imagenes.add(achicar(icono, 100, 100));
            }
            String estado;
            if (temporal.isEstado()) {
                estado = "Nuevo";
            } else {
                estado = "Usado";
            }
            //<html><b>Day Of<br>Week</b></html>
            titulos.add("<html><b>" + temporal.getTitulo() + "</b><br> [" + estado + "]<br>$" + temporal.getPrecioactual() + "</html>");
            categorias.add(anuncioService.categorias(temporal.getNro()));
            tipos.add(anuncioService.tipoanucio(temporal));
        }
        this.mostrarTabla(jTable1, imagenes, titulos, categorias, tipos);
    }//GEN-LAST:event_filtrar

    private void cambiaCategoria(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiaCategoria
        if (((String) jComboBox3.getSelectedItem()).equals("Todas")) {
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Todas"}));
        } else {
            jComboBox4.setModel(new DefaultComboBoxModel(this.cargaCombo(anuncioService.subcategorias(jComboBox3.getSelectedIndex())).toArray()));
        }
    }//GEN-LAST:event_cambiaCategoria

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
            java.util.logging.Logger.getLogger(UIBuscarAnuncio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIBuscarAnuncio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIBuscarAnuncio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIBuscarAnuncio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIBuscarAnuncio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
