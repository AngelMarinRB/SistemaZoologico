package pantallas;

import entidades.Clima;
import entidades.Continente;
import entidades.Habitat;
import entidades.Vegetacion;
import interfaces.INegocio;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.util.JButtonCellEditor;
import pantallas.util.JButtonRenderer;

/**
 * Pantalla de registro de Hábitats para el sistema.
 * 
 * @author Marin
 */
public class FrmHabitats extends javax.swing.JPanel {

    private INegocio negocio;
    private List<Clima> climas;
    private List<Vegetacion> vegetaciones;
    private List<Continente> continentes;
    private JFrame parent;
    
    /**
     * Crea e inicializa los objetos dentro del formulario de Hábitats.
     * @param negocio Objeto Negocio para el acceso a datos.
     */
    public FrmHabitats(INegocio negocio, JFrame parent) {
        this.parent = parent;
        initComponents();
        
        this.negocio = negocio;
        
        // Prevenir que las tablas sean re-organizadas
        tblClimas.getTableHeader().setReorderingAllowed(false);
        tblContinentesLista.getTableHeader().setReorderingAllowed(false);
        tblContinentesSeleccionados.getTableHeader().setReorderingAllowed(false);
        tblVegetaciones.getTableHeader().setReorderingAllowed(false);
        
        desactivarFormulario();
        
        cargarRecursos();
    }
    
    /**
     * Consulta las entidades que requiere el formulario para registrar Hábitats.
     * Búsca todos los registros de:
     * - Climas
     * - Vegetaciones
     * - Continentes
     */
    public void cargarRecursos(){
        
        climas = negocio.consultarClimas();
        vegetaciones = negocio.consultarVegetaciones();
        continentes = negocio.consultarContinentes();
    }
    
    /**
     * Muestra las listas de entidades dadas como parámetros dentro de las tablas
     * correspondientes a cada entidad y habilita los botones correspondientes a
     * agregar y eliminar de las tablas de continentes.
     * 
     * @param climas Lista de Climas.
     * @param vegetaciones Lista de Vegetaciones.
     * @param continentes Lista de continentes.
     */
    private void mostrarRecursos(List<Clima> climas , List<Vegetacion> vegetaciones , List<Continente> continentes){
        
        llenarTablaClimas(climas);
        llenarTablaVegetacion(vegetaciones);
        
        llenarTablaContinentes(continentes);
        initBotonesContinentesLista();
        initBotonesContinentesSeleccionados();
    }
    
    /**
     * Activa todos los campos del formulario para el registro de Hábitats.
     * (El apartado de verificación de nombre no se contempla en este método)
     */
    private void activarFormulario(){
        cargarRecursos();
        mostrarRecursos(climas, vegetaciones , continentes);
        pnlClimas.setVisible(true);
        pnlContinentes.setVisible(true);
        pnlVegetaciones.setVisible(true);
        btnGuardar.setVisible(true);
        txtNombre.setEnabled(false);
        limpiarFormulario();
        txtNombreDatos.setText(txtNombre.getText());
        jSeparator3.setVisible(true);
        jSeparator4.setVisible(true);
    }
    
    /**
     * Desactiva todos los campos del formulario a excepción del apartado de verificación
     * del nombre de un hábitat.
     */
    private void desactivarFormulario(){
        pnlClimas.setVisible(false);
        pnlContinentes.setVisible(false);
        pnlVegetaciones.setVisible(false);
        btnGuardar.setVisible(false);
        txtNombre.setEnabled(true);
        jSeparator3.setVisible(false);
        jSeparator4.setVisible(false);
        limpiarFormulario();
        txtNombre.setText("");
    }
    
    /**
     * Limpia todos los campos y las selecciones de las tablas del formulario.
     */
    private void limpiarFormulario(){
        txtClimaDatos.setText("");
        txtContinentesDatos.setText("");
        txtNombreDatos.setText("");
        txtVegetacionDatos.setText("");
        DefaultTableModel tablaContinentesSeleccionados = (DefaultTableModel) this.tblContinentesSeleccionados.getModel();
        tablaContinentesSeleccionados.setRowCount(0);
    }
    
    /**
     * Valida que todo el formulario sea válido (Se toma como válido si todos los campos tienen información).
     * @return True en caso de ser válido, False en caso contrario.
     */
    private boolean verificarFormulario(){        
        return !(txtClimaDatos.getText().isEmpty()|| txtContinentesDatos.getText().isEmpty() || txtVegetacionDatos.getText().isEmpty());
    }
    
    /**
     * Llena la tabla de climas con la lista de climas dada como parámetro.
     * @param climas Lista de Climas.
     */
    private void llenarTablaClimas(List<Clima> climas) {

        List<Clima> listaClimas = climas;

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClimas.getModel();

        modeloTabla.setRowCount(0);

        listaClimas.forEach(clima -> {
            Object[] fila = new Object[1];
            fila[0] = clima;
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * Llena la tabla de vegetacion con la lista de vegetaciones dada como parámetro.
     * @param vegetaciones Lista de Vegetaciones.
     */
    private void llenarTablaVegetacion(List<Vegetacion> vegetaciones) {

        List<Vegetacion> listaVegetaciones = vegetaciones;

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblVegetaciones.getModel();

        modeloTabla.setRowCount(0);

        listaVegetaciones.forEach(vegetacion -> {
            Object[] fila = new Object[1];
            fila[0] = vegetacion;
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * Llena la tabla de continentes disponibles con la lista de continentes dada como parámetro.
     * @param continentes Lista de continentes.
     */
    private void llenarTablaContinentes(List<Continente> continentes) {

        List<Continente> listaContinentes = continentes;

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblContinentesLista.getModel();

        modeloTabla.setRowCount(0);
        
        listaContinentes.forEach(continente -> {
            Object[] fila = new Object[2];
            fila[0] = continente;
            fila[1] = "Agregar";
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * Llena la tabla de continentes seleccionados con la lista de continentes dada como parámetro.
     * Todos los continentes que se encuentren en esta tabla serán utilizados para registrar el hábitat.
     * @param continentes Lista de continenets.
     */
    private void llenarTablaContinentesSeleccionados(List<Continente> continentes) {
        
        List<Continente> listaContinentes = continentes;

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblContinentesSeleccionados.getModel();

        modeloTabla.setRowCount(0);

        listaContinentes.forEach(continente -> {
            Object[] fila = new Object[2];
            fila[0] = continente;
            fila[1] = "Eliminar";
            modeloTabla.addRow(fila);
        });
        
        actualizarTextoContinentes(continentes);
    }
    
    /**
     * Actualiza el texto dentro del campo de texto "Continentes" de la interáz a
     * el nombre de todos los continentes dados como parámetro.
     * @param continentes Lista de Continentes a mostrar.
     */
    private void actualizarTextoContinentes(List<Continente> continentes){
        if(continentes.size() != 0){
            txtContinentesDatos.setText(Arrays.toString(continentes.toArray()));
        }else{
            txtContinentesDatos.setText("");
        }
    }
    
    /**
     * Inicializa los botones de "Agregar" de la tabla "Continentes Disponibles"
     * de la interfáz.
     */
    private void initBotonesContinentesLista(){
        ActionListener onEditarClickListener = new ActionListener() {
            
            /**
             * Elimina de la tabla "Continentes Disponibles" el continente que
             * se encuentra en el renglón donde el botón fue presionado y pasa
             * este mismo continente a la tabla de "Continentes Seleccionados"
             * @param e Click al botón "Agregar" de la tabla.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int fila = tblContinentesLista.getSelectedRow();
                Continente continente = (Continente) tblContinentesLista.getValueAt(fila, 0);
                
                DefaultTableModel modeloTabla = (DefaultTableModel) tblContinentesLista.getModel();
                
                List<Continente> continentes = new ArrayList<>();
                
                for(int i = 0 ; i < modeloTabla.getRowCount() ; i++){
                    
                    Continente continenteTabla = (Continente) modeloTabla.getValueAt(i,0);
                    
                    if(!continente.equals(continenteTabla)){
                        continentes.add(continenteTabla);
                    }
                }
                
                llenarTablaContinentes(continentes);
                agregar(continente);
            }
            
            /**
             * Agrega a la tabla de "Continentes Seleccionados" el continente
             * dado como parámetro.
             */
            public void agregar(Continente continente){

                List<Continente> continentes = obtenerContinentesSeleccionados();
                continentes.add(continente);
                
                llenarTablaContinentesSeleccionados(continentes);
            }
        };        


        int indiceColumnaEditar = 1;
        
        TableColumnModel modeloColumnas = this.tblContinentesLista.getColumnModel();

        modeloColumnas = this.tblContinentesLista.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Agregar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));
    }
    
    /**
     * Inicializa los botones de "Eliminar" de la tabla "Continentes Seleccionados"
     * de la interfáz.
     */
    private void initBotonesContinentesSeleccionados(){
        ActionListener onEditarClickListener = new ActionListener() {
            
            /**
             * Elimina de la tabla "Continentes Seleccionados" el continente que
             * se encuentra en el renglón donde el botón fue presionado y pasa
             * este mismo continente a la tabla de "Continentes Disponibles"
             * @param e Click al botón "Eliminar" de la tabla.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int fila = tblContinentesSeleccionados.getSelectedRow();
                Continente continente = (Continente) tblContinentesSeleccionados.getValueAt(fila, 0);
                
                DefaultTableModel modeloTabla = (DefaultTableModel) tblContinentesSeleccionados.getModel();
                
                List<Continente> continentes = new ArrayList<>();
                
                for(int i = 0 ; i < modeloTabla.getRowCount() ; i++){
                    
                    Continente continenteTabla = (Continente) modeloTabla.getValueAt(i,0);
                    
                    if(!continente.equals(continenteTabla)){
                        continentes.add(continenteTabla);
                    }
                }
                
                llenarTablaContinentesSeleccionados(continentes);
                agregar(continente);
            }
            
            /**
             * Agrega a la tabla de "Continentes Disponibles" el continente
             * dado como parámetro.
             */
            public void agregar(Continente continente){
                DefaultTableModel modeloTabla = (DefaultTableModel) tblContinentesLista.getModel();
                
                List<Continente> continentes = new ArrayList<>();
                continentes.add(continente);
                
                for(int i = 0 ; i < modeloTabla.getRowCount() ; i++){
                    
                    Continente continenteTabla = (Continente) modeloTabla.getValueAt(i,0);
                    
                    continentes.add(continenteTabla);
                }
                
                llenarTablaContinentes(continentes);
            }
        };        


        int indiceColumnaEditar = 1;
        
        TableColumnModel modeloColumnas = this.tblContinentesSeleccionados.getColumnModel();

        modeloColumnas = this.tblContinentesSeleccionados.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));
    }
    
    /**
     * Despliega a manera de error dentro de un JOptionPane el mensaje dado
     * como parámetro.
     * @param mensaje Mensjae a mostrar.
     */
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Llena todo el formulario con los datos del Hábitat dado como parámetro.
     * @param habitat Habitat a utilizar.
     */
    private void llenarFormulario(Habitat habitat){
        
        txtNombreDatos.setText(habitat.getNombre());
        txtClimaDatos.setText(habitat.getClima().getTipo());
        txtVegetacionDatos.setText(habitat.getVegetacion().getTipo());
        txtContinentesDatos.setText(Arrays.toString(habitat.getContinentes().toArray()));
    }
    
    /**
     * Obtiene de la tabla "Continentes Seleccionados" todos los continentes que
     * se encuentren dentro de la misma.
     * @return Lista de Continentes.
     */
    private List<Continente> obtenerContinentesSeleccionados(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tblContinentesSeleccionados.getModel();

        List<Continente> continentes = new ArrayList<>();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {

            Continente continenteTabla = (Continente) modeloTabla.getValueAt(i, 0);

            continentes.add(continenteTabla);
        }

        return continentes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnVerificarHabitat = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lblDatos = new javax.swing.JLabel();
        lblNombreDatos = new javax.swing.JLabel();
        lblClimaDatos = new javax.swing.JLabel();
        lblVegetacionDatos = new javax.swing.JLabel();
        lblContinentesDatos = new javax.swing.JLabel();
        txtNombreDatos = new javax.swing.JTextField();
        txtClimaDatos = new javax.swing.JTextField();
        txtVegetacionDatos = new javax.swing.JTextField();
        txtContinentesDatos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        pnlClimas = new javax.swing.JPanel();
        spnlClimas = new javax.swing.JScrollPane();
        tblClimas = new javax.swing.JTable();
        lblClimas = new javax.swing.JLabel();
        pnlVegetaciones = new javax.swing.JPanel();
        spnlVegetaciones = new javax.swing.JScrollPane();
        tblVegetaciones = new javax.swing.JTable();
        lblVegetaciones = new javax.swing.JLabel();
        pnlContinentes = new javax.swing.JPanel();
        spnlVegetaciones2 = new javax.swing.JScrollPane();
        tblContinentesLista = new javax.swing.JTable();
        spnlVegetaciones1 = new javax.swing.JScrollPane();
        tblContinentesSeleccionados = new javax.swing.JTable();
        lblContinentesSeleccionados = new javax.swing.JLabel();
        lblListaContinentes = new javax.swing.JLabel();
        lblContinentes = new javax.swing.JLabel();

        pnlEncabezado.setBackground(new java.awt.Color(33, 47, 69));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 204, 204));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de Hábitats");

        btnMenu.setText("MENÚ");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre del Hábitat");

        btnVerificarHabitat.setText("Verificar");
        btnVerificarHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnVerificarHabitat(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblDatos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDatos.setText("Datos");

        lblNombreDatos.setText("Nombre");

        lblClimaDatos.setText("Clima");

        lblVegetacionDatos.setText("Vegetación");

        lblContinentesDatos.setText("Continentes");

        txtNombreDatos.setEditable(false);
        txtNombreDatos.setToolTipText("");
        txtNombreDatos.setMaximumSize(new java.awt.Dimension(600, 22));

        txtClimaDatos.setEditable(false);
        txtClimaDatos.setMaximumSize(new java.awt.Dimension(600, 22));

        txtVegetacionDatos.setEditable(false);
        txtVegetacionDatos.setMaximumSize(new java.awt.Dimension(600, 22));

        txtContinentesDatos.setEditable(false);
        txtContinentesDatos.setMaximumSize(new java.awt.Dimension(600, 22));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarclickBtnVerificarHabitat(evt);
            }
        });

        tblClimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClimas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClimasMouseClicked(evt);
            }
        });
        spnlClimas.setViewportView(tblClimas);

        lblClimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblClimas.setText("Climas");

        javax.swing.GroupLayout pnlClimasLayout = new javax.swing.GroupLayout(pnlClimas);
        pnlClimas.setLayout(pnlClimasLayout);
        pnlClimasLayout.setHorizontalGroup(
            pnlClimasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClimasLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(lblClimas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(spnlClimas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlClimasLayout.setVerticalGroup(
            pnlClimasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClimasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClimas)
                .addGap(18, 18, 18)
                .addComponent(spnlClimas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblVegetaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vegetación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVegetaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVegetacionesMouseClicked(evt);
            }
        });
        spnlVegetaciones.setViewportView(tblVegetaciones);

        lblVegetaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVegetaciones.setText("Vegetaciones");

        javax.swing.GroupLayout pnlVegetacionesLayout = new javax.swing.GroupLayout(pnlVegetaciones);
        pnlVegetaciones.setLayout(pnlVegetacionesLayout);
        pnlVegetacionesLayout.setHorizontalGroup(
            pnlVegetacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVegetacionesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblVegetaciones)
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(spnlVegetaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlVegetacionesLayout.setVerticalGroup(
            pnlVegetacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVegetacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVegetaciones)
                .addGap(18, 18, 18)
                .addComponent(spnlVegetaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblContinentesLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Continentes", "Agregar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spnlVegetaciones2.setViewportView(tblContinentesLista);

        tblContinentesSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Continentes", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spnlVegetaciones1.setViewportView(tblContinentesSeleccionados);

        lblContinentesSeleccionados.setText("Seleccionados");

        lblListaContinentes.setText("Disponibles");

        lblContinentes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContinentes.setText("Continentes");

        javax.swing.GroupLayout pnlContinentesLayout = new javax.swing.GroupLayout(pnlContinentes);
        pnlContinentes.setLayout(pnlContinentesLayout);
        pnlContinentesLayout.setHorizontalGroup(
            pnlContinentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContinentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContinentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContinentesLayout.createSequentialGroup()
                        .addComponent(spnlVegetaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(spnlVegetaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlContinentesLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblListaContinentes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addComponent(lblContinentesSeleccionados)
                        .addGap(102, 102, 102))))
            .addGroup(pnlContinentesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblContinentes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContinentesLayout.setVerticalGroup(
            pnlContinentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContinentesLayout.createSequentialGroup()
                .addComponent(lblContinentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContinentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblListaContinentes)
                    .addComponent(lblContinentesSeleccionados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContinentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnlVegetaciones1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(spnlVegetaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnVerificarHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(177, 177, 177)))))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContinentesDatos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContinentesDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblClimaDatos)
                                    .addComponent(lblNombreDatos)
                                    .addComponent(lblVegetacionDatos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtClimaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVegetacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatos))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlClimas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlVegetaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlContinentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDatos)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombreDatos)
                                    .addComponent(txtNombreDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblClimaDatos)
                                    .addComponent(txtClimaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVegetacionDatos)
                                    .addComponent(txtVegetacionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContinentesDatos)
                                    .addComponent(txtContinentesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnVerificarHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlVegetaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator4)
                                .addGap(8, 8, 8)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlContinentes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlClimas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Verifica que el nombr del Hábitat dado sea válido y no se encuentre registrado.
     * 
     * En caso de que el Hábitat no se encuentre registrado, activa el formulario para su registro.
     * En caso de que el Hábitat ya se encuentre registrado, la interfáz mostrará sus datos.
     * En caso de que no ingrese un nombre, se mostrará un mensaje advirtiendo de ello.
     * @param evt Botón "Verificar" seleccionado.
     */
    private void clickBtnVerificarHabitat(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnVerificarHabitat
        
        String nombreHabitat = txtNombre.getText();
        
        if(nombreHabitat.isEmpty()){
            mostrarError("Ingrese un nombre para registrar el hábitat");
            return;
        }
        
        Habitat habitat = negocio.verificarExistenciaHabitat(nombreHabitat);
        
        if(habitat != null){
            mostrarError("Ya existe un hábitat con ese nombre.");
            llenarFormulario(habitat);
        } else {
            activarFormulario();
        }
    }//GEN-LAST:event_clickBtnVerificarHabitat

    /**
     * Guarda un Hábitat dentro de la aplicación con los datos que se encuentren
     * en el formulario, en caso de haber un error se mostrará y no se hará ninguna
     * acción.
     * @param evt Botón "Guardar" seleccionado. 
     */
    private void btnGuardarclickBtnVerificarHabitat(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarclickBtnVerificarHabitat
        boolean formValido = verificarFormulario();
        
        if(!formValido){
            mostrarError("Debe llenar todos los datos.");
            return;
        }
        
        String nombre = txtNombreDatos.getText();
        Clima clima = (Clima) tblClimas.getValueAt(tblClimas.getSelectedRow(), 0);
        Vegetacion vegetacion = (Vegetacion) tblVegetaciones.getValueAt(tblClimas.getSelectedRow(), 0);
        List<Continente> continentes = obtenerContinentesSeleccionados();
        
        Habitat habitat = new Habitat(nombre, clima, vegetacion, continentes);
        
        boolean guardado = negocio.guardarHabitat(habitat);
        
        if(guardado){
            JOptionPane.showMessageDialog(this, "Hábitat registrado de manera correcta" , "Información", JOptionPane.INFORMATION_MESSAGE);
        }else{
            mostrarError("Error al guardar el hábitat.");
        }
        
        desactivarFormulario();
    }//GEN-LAST:event_btnGuardarclickBtnVerificarHabitat

    /**
     * Verifica que elemento dentro de la tabla de climas fue seleccionado y muestra
     * sus datos dentro del formulario de registro en el campo de Clima.
     * @param evt Click a un elemento de la tabla Climas.
     */
    private void tblClimasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClimasMouseClicked
        
        Clima clima = (Clima) tblClimas.getValueAt(tblClimas.getSelectedRow(), 0);
        txtClimaDatos.setText(clima.getTipo());
    }//GEN-LAST:event_tblClimasMouseClicked

    /**
     * Verifica que elemento dentro de la tabla de vegetaciones fue seleccionado y muestra
     * sus datos dentro del formulario de registro en el campo de Vegetacion.
     * @param evt Click en un elemento de la tabla Vegetaciones.
     */
    private void tblVegetacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVegetacionesMouseClicked
        Vegetacion vegetacion = (Vegetacion) tblVegetaciones.getValueAt(tblVegetaciones.getSelectedRow(), 0);
        txtVegetacionDatos.setText(vegetacion.getTipo());
    }//GEN-LAST:event_tblVegetacionesMouseClicked

    /**
     * Desactiva el formulario y devuelve la aplicación al menú principal.
     * @param evt Click al botón "Menú"
     */
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        desactivarFormulario();
        
        Container frame = this.getParent().getParent().getParent();
        
        CardLayout cl = (CardLayout)(frame.getLayout());
        cl.show(frame, "Menu");
        parent.setTitle("Zoológico");
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnVerificarHabitat;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblClimaDatos;
    private javax.swing.JLabel lblClimas;
    private javax.swing.JLabel lblContinentes;
    private javax.swing.JLabel lblContinentesDatos;
    private javax.swing.JLabel lblContinentesSeleccionados;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblListaContinentes;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreDatos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVegetacionDatos;
    private javax.swing.JLabel lblVegetaciones;
    private javax.swing.JPanel pnlClimas;
    private javax.swing.JPanel pnlContinentes;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlVegetaciones;
    private javax.swing.JScrollPane spnlClimas;
    private javax.swing.JScrollPane spnlVegetaciones;
    private javax.swing.JScrollPane spnlVegetaciones1;
    private javax.swing.JScrollPane spnlVegetaciones2;
    private javax.swing.JTable tblClimas;
    private javax.swing.JTable tblContinentesLista;
    private javax.swing.JTable tblContinentesSeleccionados;
    private javax.swing.JTable tblVegetaciones;
    private javax.swing.JTextField txtClimaDatos;
    private javax.swing.JTextField txtContinentesDatos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreDatos;
    private javax.swing.JTextField txtVegetacionDatos;
    // End of variables declaration//GEN-END:variables
}
