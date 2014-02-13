/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entidades.Vendedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import static utility.AutoComplete.setupAutoComplete;
import servicios.AnuncioService;
import servicios.UsuarioService;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class UIAltaAnuncio extends javax.swing.JFrame {

    Vendedor vendedor = new Vendedor();
    Float precio;
    AnuncioService anuncioservice = new AnuncioService();
    UsuarioService usuarioservice = new UsuarioService();
    List<String> listaUsuarios = usuarioservice.getCompradores();
    javax.swing.JComboBox jComboBoxExtend = new JComboBox(new DefaultComboBoxModel(listaUsuarios.toArray())) {
        public Dimension getPreferredSize() {
            return new Dimension(super.getPreferredSize().width, 0);
        }
    };
    JFileChooser chooser = new JFileChooser();
    DateFormat formatofecha = new SimpleDateFormat("yyyy-mm-dd");
    Calendar cal = Calendar.getInstance();
    boolean cargaimagen = false;

    /**
     * Creates new form UIAltaAnuncio
     */
    public UIAltaAnuncio() {

        cal.setTime(new Date());
        vendedor = usuarioservice.obtenerVendedor(usuarioservice.validar("murai", "megustaelcafe"));
        initComponents();
        jTextField3.setLayout(new BorderLayout());
        jTextField3.add(jComboBoxExtend, BorderLayout.SOUTH);
        jSpinner1.setVisible(false);
        jLabel6.setVisible(false);
        ArrayList<String> listaFinal;
        listaFinal = new ArrayList<>();
        for (Iterator<String> it = listaUsuarios.iterator(); it.hasNext();) {
            listaFinal.add(it.next());
        }
        setupAutoComplete(jTextField3, listaFinal);
        setupAutoComplete(jTextField4, listaFinal);
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
        jDialog2 = new javax.swing.JDialog();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);

        jButton5.setText("Confirmar y Publicar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarAnuncio(evt);
            }
        });

        jButton6.setText("Atrás");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atras(evt);
            }
        });

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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(167, 167, 167))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Anuncio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Seleccione tipo de anuncio");

        jComboBox1.setModel(new DefaultComboBoxModel(anuncioservice.tipoanuncios().toArray()));
        jComboBox1.setSelectedIndex(4);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiaLabel(evt);
            }
        });

        jTextField1.setText("Título");
        jTextField1.setToolTipText("Título");
        jTextField1.setName(""); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaTitulo(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Descripción");
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaDescripcion(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Duración:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "7", "10" }));

        jLabel3.setText("Precio $:");

        jTextField3.setText("usuario1; usuario2;....");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaRestringir(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apretaTecla(evt);
            }
        });

        jRadioButton1.setText("Restingir usuario:");

        jRadioButton2.setText("Compartir solo con:");

        jTextField4.setText("usuario1; usuario2; ...");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaCompartir(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialogoConfirmarAlta(evt);
            }
        });

        jLabel4.setText("Categoría:");

        jComboBox3.setModel(new DefaultComboBoxModel(anuncioservice.categorias().toArray()));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambioopcion(evt);
            }
        });

        jLabel5.setText("Subcategoría:");

        jComboBox4.setModel(new DefaultComboBoxModel(anuncioservice.subcategorias(jComboBox3.getSelectedIndex()+1).toArray()));

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar(evt);
            }
        });

        jButton3.setText("Agregar Imagen...");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarArchivo(evt);
            }
        });

        jLabel6.setText("Cantidad de artículos:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Nuevo");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Usado");

        jLabel7.setText("Url:");

        jTextField5.setText("Enlace");
        jTextField5.setToolTipText("Agregue un enlace relacionado con el artículo para sumar información");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickenlace(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5))
                            .addComponent(jScrollPane1)))
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jButton3)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambioopcion(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambioopcion
        jComboBox4.setModel(new DefaultComboBoxModel(anuncioservice.subcategorias(jComboBox3.getSelectedIndex() + 1).toArray()));
    }//GEN-LAST:event_cambioopcion

    private void clickeaDescripcion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickeaDescripcion
        jTextArea1.setText("");
    }//GEN-LAST:event_clickeaDescripcion

    private void clickeaTitulo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickeaTitulo
        jTextField1.setText("");
    }//GEN-LAST:event_clickeaTitulo

    private void buscarArchivo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarArchivo
        // TODO add your handling code here:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes", "jpg");
        chooser.setFileFilter(filtro);
        chooser.setMultiSelectionEnabled(true);
        int resultado= chooser.showOpenDialog(jButton3);
        if (chooser.getSelectedFiles().length > 0) {
            cargaimagen = true;
        } else {
            cargaimagen = false;
        }
        if (chooser.getSelectedFiles().length > 3) {
            JOptionPane.showMessageDialog(chooser, "No se pueden seleccionar más de 3 imágenes");
            chooser.showOpenDialog(jButton3);
        }
        if (resultado == JFileChooser.CANCEL_OPTION) {
            chooser = new JFileChooser();
        }


    }//GEN-LAST:event_buscarArchivo

    private void clickeaRestringir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickeaRestringir
        jTextField3.setText("");
    }//GEN-LAST:event_clickeaRestringir

    private void clickeaCompartir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickeaCompartir
        jTextField4.setText("");
    }//GEN-LAST:event_clickeaCompartir

    private void dialogoConfirmarAlta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dialogoConfirmarAlta

        if (jTextField1.getText().isEmpty() || jTextField1.getText().equals("Título")
                || jTextArea1.getText().isEmpty() || jTextArea1.getText().equals("Descripción")
                || jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta llenar alguno de estos campos: Título, Descripción o Precio");
        } else { 
            try{
                precio=Float.parseFloat(jTextField2.getText());
                if(precio<0) throw new NumberFormatException();
            DefaultTableModel modelo = new DefaultTableModel();
            jTable1.setModel(modelo);
            Vector vector = new Vector(4);
            vector.add("Precio por anunciar:");
            vector.add("Precio por imagenes adjuntas:");
            vector.add("Precio por cantidad de días:");
            vector.add("Total:");
            Vector vector2 = new Vector(4);
            vector2.add("$ " + 20);
            vector2.add("$ " + chooser.getSelectedFiles().length * 5);
            vector2.add("$ " + jComboBox2.getSelectedIndex() * 10);
            int suma = 20 + Array.getLength(chooser.getSelectedFiles()) * 5 + jComboBox2.getSelectedIndex() * 10;
            vector2.add("$ " + suma);
            modelo.addColumn("Ítem", vector);
            modelo.addColumn("Precio", vector2);
            jDialog2.setSize(400, 250);
            jDialog2.setVisible(true);
            System.out.println(chooser.getSelectedFiles().length);
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Error en el precio.");
            }
        }
    }//GEN-LAST:event_dialogoConfirmarAlta

    private void cambiaLabel(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiaLabel
        if (jComboBox1.getSelectedIndex() == 0) {
            jLabel3.setText("Precio de salida $:");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 2) {
            jLabel3.setText("Precio de salida $:");
            SpinnerNumberModel modelito = new SpinnerNumberModel();
            jSpinner1.setModel(modelito);
            modelito.setValue(1);
            modelito.setMinimum(1);
            jSpinner1.setVisible(true);
            jLabel6.setVisible(true);
        }
        if (jComboBox1.getSelectedIndex() == 1) {
            jLabel3.setText("Precio mínimo a vender $");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 4) {
            jLabel3.setText("Precio $");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 3) {
            jLabel3.setText("Precio de salida $:");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
            JOptionPane.showMessageDialog(this, "Los compradores seran anónimos");

        }

    }//GEN-LAST:event_cambiaLabel

    private void apretaTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apretaTecla
        // TODO add your handling code here:
    }//GEN-LAST:event_apretaTecla

    private void agregarAnuncio(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarAnuncio

        cal.add(Calendar.DATE, Integer.parseInt((String) jComboBox2.getSelectedItem()));
        boolean nuevo = true;
        if (buttonGroup2.getSelection() == jRadioButton4) {
            nuevo = false;
        }
        switch (jComboBox1.getSelectedIndex()) {

            case 1:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), 0, Float.parseFloat(jTextField2.getText()), cal.getTime(), nuevo, 1);
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), 0, Float.parseFloat(jTextField2.getText()), cal.getTime(), nuevo, 1, chooser.getSelectedFiles());
                }
                break;
            case 2:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, (int) jSpinner1.getValue());
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, (int) jSpinner1.getValue(), chooser.getSelectedFiles());
                }
                break;
            default:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, 1);
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex() + 1, (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, 1, chooser.getSelectedFiles());
                }
                break;
        }
        jDialog2.dispose();

    }//GEN-LAST:event_agregarAnuncio

    private void atras(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atras
        jDialog2.dispose();
    }//GEN-LAST:event_atras

    private void cancelar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar
        this.dispose();
    }//GEN-LAST:event_cancelar

    private void clickenlace(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickenlace
        jTextField5.setText("");
    }//GEN-LAST:event_clickenlace

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
            java.util.logging.Logger.getLogger(UIAltaAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIAltaAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIAltaAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIAltaAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAltaAnuncio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
