/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entidades.Vendedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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
import static utility.AutoComplete.autocompletar;
import servicios.AnuncioService;
import servicios.UsuarioService;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import utility.AutoComplete;

/**
 *
 * @author martin
 */
public class UIAltaAnuncio extends javax.swing.JFrame {

    /**
     * Usuario y contrasenia "murai", "megustaelcafe"
     */
    String usuario = "murai";
    String contrasenia = "megustaelcafe";

    ImageIcon flecharriba = new ImageIcon(getClass().getClassLoader().getResource("resources/flechaArriba.jpg"));
    ImageIcon flechabajo = this.rotateIcon(flecharriba);//new ImageIcon(getClass().getClassLoader().getResource("resources/flechaAbajo.jpg"));
    ImageIcon searchIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/search.png"));
    Vendedor vendedor = new Vendedor();
    Double precio;
    Float preciof;
    String llenar;
    ArrayList<String> arregloUsuarios = new ArrayList<>();
    Vector<String> listaResultadoUsuarios = new Vector<>();
    Vector<String> listaPermitidos = new Vector();
    Vector<String> listaBloqueados = new Vector();
    AnuncioService anuncioservice = new AnuncioService();
    UsuarioService usuarioservice = new UsuarioService();
    int parcheCartel = 4;
    List<String> listaUsuariosCompleta = usuarioservice.getCompradores();
    /* javax.swing.JComboBox jComboBoxExtend = new JComboBox(new DefaultComboBoxModel(listaUsuarios.toArray())) {
     public Dimension getPreferredSize() {
     return new Dimension(super.getPreferredSize().width, 0);
     }
     };*/
    JFileChooser chooser = new JFileChooser();
    DateFormat formatofecha = new SimpleDateFormat("yyyy-mm-dd");
    Calendar cal = Calendar.getInstance();
    boolean cargaimagen = false;
    int enterSegundo = 0;

    private List<String> cargaCombo(List<String> categorias, String texto) {
        //new DefaultComboBoxModel(anuncioservice.categorias().toArray())
        List<String> retorno = new ArrayList<>();
        retorno.add(texto);
        for (Iterator<String> it = categorias.iterator(); it.hasNext();) {
            retorno.add(it.next());
        }
        return retorno;
    }

    private double redondearn(double numero) {
        return Math.rint(numero * 100) / 100;
    }

    private void actualizarLista(JTable jTable, Vector lista, String titulo) {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };

        modelo.addColumn(titulo, lista);

        jTable.setModel(modelo);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    private void abajo(String seleccion, List<String> listaQuitar, Vector listaAgregar) {
        listaQuitar.remove(seleccion);
        listaAgregar.add(seleccion);
    }

    private void arriba(String seleccion, List<String> listaAgregar, Vector listaQuitar) {
        listaAgregar.add(seleccion);
        listaQuitar.remove(seleccion);
    }

    private void buscar(String texto) {
        listaResultadoUsuarios = new Vector<>();
        for (Iterator<String> it = listaUsuariosCompleta.iterator(); it.hasNext();) {
            String temporal = it.next();
            if (temporal.contains(texto)) {
                listaResultadoUsuarios.add(temporal);
            }
        }
    }

    public final ImageIcon achicar(ImageIcon icon, int alto, int ancho) {
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        return newIcon;
    }

    private ImageIcon rotateIcon(ImageIcon icon) {
        JLabel label = new JLabel();
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int type = BufferedImage.TYPE_INT_RGB;  // other options, see api
        BufferedImage image = new BufferedImage(h, w, type);
        Graphics2D g2 = image.createGraphics();
        double x = (h - w) / 2.0;
        double y = (w - h) / 2.0;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(180), w / 2.0, h / 2.0);
        g2.drawImage(icon.getImage(), at, label);
        g2.dispose();
        return new ImageIcon(image);
    }

    /**
     * Creates new form UIAltaAnuncio
     */
    public UIAltaAnuncio() {

        cal.setTime(new Date());
        vendedor = usuarioservice.obtenerVendedor(usuarioservice.validar(usuario, contrasenia));
        initComponents();
        jTextField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    enterSegundo+=1;
                    if (jTextField1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Escribe algo en el buscador");
                    } else {
                        if(enterSegundo==2){
                        buscar(jTextField3.getText());
                        actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
                        enterSegundo=0;}
                    }

                }
            }
            /*
             public void keyTyped(KeyEvent e) {
             public void keyPressed(KeyEvent e) {
             }*/
        });
        jSpinner1.setVisible(false);
        jLabel6.setVisible(false);
        /**
         * Seteo de los íconos en los botones
         */
        jButton4.setIcon(this.achicar(searchIcon, 30, 30));
        jButton7.setIcon(this.achicar(flechabajo, 30, 30));
        jButton8.setIcon(this.achicar(flecharriba, 30, 30));
        jButton9.setIcon(this.achicar(flechabajo, 30, 30));
        jButton10.setIcon(this.achicar(flecharriba, 30, 30));

        for (Iterator<String> it = listaUsuariosCompleta.iterator(); it.hasNext();) {
            String temporal = it.next();
            arregloUsuarios.add(temporal);
        }
        AutoComplete.autocompletar(jTextField3, arregloUsuarios);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        jLabel1.setText("Seleccione tipo de anuncio:");

        jComboBox1.setModel(new DefaultComboBoxModel(anuncioservice.tipoanuncios().toArray()));
        jComboBox1.setSelectedIndex(4);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiaLabel(evt);
            }
        });

        jTextField1.setText("Título");
        jTextField1.setToolTipText("Ingrese el el nombre de lo que va a publicar");
        jTextField1.setName(""); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaTitulo(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Descripción");
        jTextArea1.setToolTipText("Agregue una descripción para convencer de que compren su producto");
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaDescripcion(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Duración:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3 días", "5 días", "7 días", "10 días" }));

        jLabel3.setText("Precio $:");

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                redondeo(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialogoConfirmarAlta(evt);
            }
        });

        jLabel4.setText("Categoría:");

        jComboBox3.setModel(new DefaultComboBoxModel(this.cargaCombo(anuncioservice.categorias(), "Seleccione una categoría").toArray()));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambioopcion(evt);
            }
        });

        jLabel5.setText("Subcategoría:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoría" }));

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

        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarUsuario(evt);
            }
        });

        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueaBoton(evt);
            }
        });

        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desbloqueaBoton(evt);
            }
        });

        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permiteBoton(evt);
            }
        });

        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                despermiteBoton(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bloqueados"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Permitidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable4);

        jTextField3.setText("Búsqueda de usuario...");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickeaRestringir(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        jLabel8.setText("Administración de público");

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        jLabel9.setText("Información");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambioopcion(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambioopcion
        //jComboBox4.setModel(new DefaultComboBoxModel(anuncioservice.subcategorias(jComboBox3.getSelectedIndex() + 1).toArray()));
        if (((String) jComboBox3.getSelectedItem()).equals("Seleccione una categoría")) {
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccione una categoría"}));
        } else {
            jComboBox4.setModel(new DefaultComboBoxModel(this.cargaCombo(anuncioservice.subcategorias(jComboBox3.getSelectedIndex()), "Seleccione una subcategoria").toArray()));
        }
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
        int resultado = chooser.showOpenDialog(jButton3);
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

    private void dialogoConfirmarAlta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dialogoConfirmarAlta

        if (jTextField1.getText().isEmpty() || jTextField1.getText().equals("Título")
                || jTextArea1.getText().isEmpty() || jTextArea1.getText().equals("Descripción")
                || jTextField2.getText().isEmpty() || jComboBox3.getSelectedItem().toString().equals("Seleccione una categoría")
                || jComboBox4.getSelectedItem().toString().equals("Seleccione una subcategoria")) {
            JOptionPane.showMessageDialog(this, "Falta llenar alguno de estos campos: Título, Descripción, Precio, Categoría o Subcategoría");
        } else {
            try {
                preciof = Float.parseFloat(jTextField2.getText());
                if (preciof < 0) {
                    throw new NumberFormatException();
                }
                DefaultTableModel modelo = new DefaultTableModel() {
                    public boolean isCellEditable(int rowIndex, int vColIndex) {
                        return false;
                    }
                };
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
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el precio.");
            }
        }
    }//GEN-LAST:event_dialogoConfirmarAlta

    private void cambiaLabel(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiaLabel
        if (jComboBox1.getSelectedIndex() == 0) {
            parcheCartel = 0;
            jLabel3.setText("Precio de salida $:");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 2) {
            parcheCartel = 2;
            jLabel3.setText("Precio de salida $:");
            SpinnerNumberModel modelito = new SpinnerNumberModel();
            jSpinner1.setModel(modelito);
            modelito.setValue(2);
            modelito.setMinimum(2);
            jSpinner1.setVisible(true);
            jLabel6.setVisible(true);
        }
        if (jComboBox1.getSelectedIndex() == 1) {
            parcheCartel = 1;
            jLabel3.setText("Precio mínimo a vender $");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 4) {
            parcheCartel = 4;
            jLabel3.setText("Precio $");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);
        }
        if (jComboBox1.getSelectedIndex() == 3) {
            if (parcheCartel != 3) {
                JOptionPane.showMessageDialog(this, "Los compradores seran anónimos");
            }
            parcheCartel = 3;
            jLabel3.setText("Precio de salida $:");
            jSpinner1.setVisible(false);
            jLabel6.setVisible(false);

        }

    }//GEN-LAST:event_cambiaLabel

    private void agregarAnuncio(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarAnuncio

        cal.add(Calendar.DATE, Integer.parseInt(jComboBox2.getSelectedItem().toString().replace(" días", "")));
        boolean nuevo = true;
        if (buttonGroup2.getSelection() == jRadioButton4) {
            nuevo = false;
        }
        switch (jComboBox1.getSelectedIndex()) {

            case 1:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), 0, Float.parseFloat(jTextField2.getText()), cal.getTime(), nuevo, 1);
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), 0, Float.parseFloat(jTextField2.getText()), cal.getTime(), nuevo, 1, chooser.getSelectedFiles());
                }
                break;
            case 2:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, (int) jSpinner1.getValue());
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, (int) jSpinner1.getValue(), chooser.getSelectedFiles());
                }
                break;
            default:
                if (!cargaimagen) {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, 1);
                } else {
                    anuncioservice.agregar(jComboBox3.getSelectedIndex(), (String) jComboBox4.getSelectedItem(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0, cal.getTime(), nuevo, 1, chooser.getSelectedFiles());
                }
                break;
        }
        cal.setTime(new Date());
        jDialog2.dispose();
        JOptionPane.showMessageDialog(this, "Gracias por publicar en Compumundohipermegared");

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

    private void clickeaRestringir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickeaRestringir
        jTextField3.setText("");
    }//GEN-LAST:event_clickeaRestringir

    private void bloqueaBoton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloqueaBoton
        if (jTable2.isColumnSelected(0)) {
            int selectedRowIndex = jTable2.getSelectedRow();
            //int selectedColumnIndex = jTable2.getSelectedColumn();
            String selectedObject = (String) jTable2.getModel().getValueAt(selectedRowIndex, 0);
            this.abajo(selectedObject, listaUsuariosCompleta, listaBloqueados);
            actualizarLista(jTable3, listaBloqueados, "Bloqueados");
            listaResultadoUsuarios.remove(selectedObject);
            actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
        }
    }//GEN-LAST:event_bloqueaBoton

    private void buscarUsuario(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarUsuario
        listaResultadoUsuarios= new Vector<>();
        this.buscar(jTextField3.getText());
        actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
    }//GEN-LAST:event_buscarUsuario

    private void desbloqueaBoton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desbloqueaBoton
        if (jTable3.isColumnSelected(0)) {
            int selectedRowIndex = jTable3.getSelectedRow();
            //int selectedColumnIndex = jTable2.getSelectedColumn();
            String selectedObject = (String) jTable3.getModel().getValueAt(selectedRowIndex, 0);
            this.arriba(selectedObject, listaUsuariosCompleta, listaBloqueados);
            actualizarLista(jTable3, listaBloqueados, "Bloqueados");
            listaResultadoUsuarios.add(selectedObject);
            actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
        }
    }//GEN-LAST:event_desbloqueaBoton

    private void permiteBoton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permiteBoton
        if (jTable2.isColumnSelected(0)) {
            int selectedRowIndex = jTable2.getSelectedRow();
            //int selectedColumnIndex = jTable2.getSelectedColumn();
            String selectedObject = (String) jTable2.getModel().getValueAt(selectedRowIndex, 0);
            this.abajo(selectedObject, listaUsuariosCompleta, listaPermitidos);
            actualizarLista(jTable4, listaPermitidos, "Permitidos");
            listaResultadoUsuarios.remove(selectedObject);
            actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
        }
    }//GEN-LAST:event_permiteBoton

    private void despermiteBoton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_despermiteBoton
        if (jTable4.isColumnSelected(0)) {
            int selectedRowIndex = jTable4.getSelectedRow();
            //int selectedColumnIndex = jTable2.getSelectedColumn();
            String selectedObject = (String) jTable4.getModel().getValueAt(selectedRowIndex, 0);
            this.arriba(selectedObject, listaUsuariosCompleta, listaPermitidos);
            actualizarLista(jTable4, listaPermitidos, "Permitidos");
            listaResultadoUsuarios.add(selectedObject);
            actualizarLista(jTable2, listaResultadoUsuarios, "Usuarios");
        }
    }//GEN-LAST:event_despermiteBoton

    private void redondeo(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_redondeo
        precio = Double.parseDouble(jTextField2.getText().replace(",", "."));
        llenar = String.valueOf(redondearn(precio));
        jTextField2.setText(llenar);
    }//GEN-LAST:event_redondeo

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
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
