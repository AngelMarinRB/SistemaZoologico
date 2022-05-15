package pantallas;

import entidades.Animal;
import entidades.CargoEspecie;
import entidades.Cuidador;
import entidades.Especie;
import entidades.Habitat;
import entidades.Zona;
import interfaces.INegocio;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import pantallas.util.JButtonCellEditor;
import pantallas.util.JButtonRenderer;

/**
 * Pantalla de Registro par Especies y Animales en el sistema.
 * 
 * @author Marin
 */
public class FrmEspecies extends javax.swing.JPanel {

    private static final String ACTUALIZACION = "UPDATE";
    private static final String NUEVOREGISTRO = "NEWENTRY";
    
    private INegocio negocio;
    private List<Habitat> habitats;
    private List<Cuidador> cuidadores;
    private List<Zona> zonas;
    private List<Animal> animales;
    
    private DefaultComboBoxModel listaHabitats;
    private DefaultComboBoxModel listaCuidadores;
    private DefaultComboBoxModel listaZonas;
    
    private JFrame parent;
    
    private Especie especie = null;
    
    //Especifica el Estatus del formulario
    //Modo UPDATE : Todos los animales agregados y eliminados se reflejan al instante en la base de datos.
    //Modo NEWENTRY : Todos los animales pre-registrados se registran hasta que se guarde la especie.
    private String status = null;
    
    /**
     * Crea e inicializa los objetos dentro del formulario Especies.
     * @param negocio Objeto Negocio para el acceso a datos.
     */
    public FrmEspecies(INegocio negocio, JFrame parent) {
        this.negocio = negocio;
        
        this.parent = parent;
        
        animales = new ArrayList();
        
        cargarRecursos();
        
        mostrarRecursos();
        
        initComponents();
        
        tblAnimales.getTableHeader().setReorderingAllowed(false);
        
        desactivarFormulario();
    }

    /**
     * Consulta las entidades que requiere el formulario para registra Especies.
     * Busca todos los registros de:
     * - Habitats
     * - Cuidadores
     * - Zonas
     */
    public void cargarRecursos(){
        habitats = negocio.consultarHabitats();
        cuidadores = negocio.consultarCuidadores();
        zonas = negocio.consultarZonas();
        mostrarRecursos();
    }
    
    /**
     * Busca todos los animales registrados con la misma especie, la especie
     * a buscar se obtiene una vez que el usuario intenta registrar una especie existente.
     * Este método solo debería utilizarse en el STATUS : UPDATE.
     */
    private void cargarAnimales(){
        animales = negocio.consultarAnimalesEspecie(especie);
    }
    
    /**
     * Muestra todas las entidades cargadas en el formulario dentro de comboBoxes
     * para que puedan ser utilizados.
     */
    private void mostrarRecursos(){
        llenarCBoxHabitats(habitats);
        llenarCBoxCuidadores(cuidadores);
        llenarCBoxZonas(zonas);
    }
    
    /**
     * Actualiza la tabla de Animales registrados, mostrando los últimos cambios hechos.
     * Método para llamarse de manera interna.
     */
    private void actualizarTablaAnimales(){
        llenarTablaAnimales(animales);
        initBotonesAnimales();
    }
    
    /**
     * Activa todos las secciones y campos del formulario para poder registrar una nueva especie.
     */
    private void activarFormulario(){
        pnlAnimales.setVisible(true);
        pnlDatos.setVisible(true);
        txtNombreEspecie.setEditable(false);
        txtNombreEspaniol.setText(txtNombreEspecie.getText());
        txtNombreCientifico.setEnabled(true);
        txtDescripcion.setEnabled(true);
        cboxCuidadores.setEnabled(true);
        cboxHabitats.setEnabled(true);
        cboxZonas.setEnabled(true);
        pnlAnimales.setVisible(true);
    }
    
    /**
     * Activa todas las secciones del formulario, pero no permite la interacción
     * con ninguno de los campos de registro, excepto con la edición de Animales.
     * Este método se debe de utilizar en STATUS : UPDATE.
     */
    private void activarFormularioActualizacion(){
        pnlAnimales.setVisible(true);
        pnlDatos.setVisible(true);
        txtNombreEspecie.setEditable(true);
        txtNombreEspaniol.setText(txtNombreEspecie.getText());
        txtNombreCientifico.setEnabled(false);
        txtDescripcion.setEnabled(false);
        cboxCuidadores.setEnabled(false);
        cboxHabitats.setEnabled(false);
        cboxZonas.setEnabled(false);
        btnGuardar.setEnabled(false);
        pnlAnimales.setVisible(true);
    }
    
    /**
     * Llena el formulario con los datos de la Especie dada como parámetro, además
     * consulta y muestra dentro de la tabla de Animales, los animales que se encuentren
     * registrados bajo esta especie.
     * @param especie 
     */
    private void llenarFormulario(Especie especie){

        txtNombreCientifico.setText(especie.getNombreCientifico());
        txtNombreEspaniol.setText(especie.getNombreVulgar());
        txtDescripcion.setText(especie.getDescripcion());
        Cuidador cuidador = buscarCuidador(especie);
        cboxCuidadores.setSelectedItem(cuidador);
        cboxHabitats.setSelectedItem(especie.getHabitat());
        cboxZonas.setSelectedItem(especie.getZona());
        animales = negocio.consultarAnimalesEspecie(especie);
        actualizarTablaAnimales();
        this.especie = especie;
        activarFormularioActualizacion();
        
    }
    
    /**
     * Busca dentro de los cuidadores registrados en el sistema, el cuidador que está
     * a cargo de la Especie dada como parámetro.
     * @param especie Especie a buscar.
     * @return Cuidador a cargo de la Especie.
     */
    private Cuidador buscarCuidador(Especie especie){
    
        for(int i = 0 ; i < cuidadores.size(); i++){

            List<CargoEspecie> especiesCargo = cuidadores.get(i).getEspeciesCargo();
            
            for(int j = 0 ; j < especiesCargo.size() ; j++){
                if(especiesCargo.get(j).getEspecie() == especie);
                    return cuidadores.get(i);
            }
        }
        return null;
    }
    
    /**
     * Llena la comboBox de hábitats con la lista de hábitats dada como parámetro.
     * @param habitats Lista de habitats.
     */
    private void llenarCBoxHabitats(List<Habitat> habitats){
        if (listaHabitats == null) {
            listaHabitats = new DefaultComboBoxModel();
        }
        
        listaHabitats.removeAllElements();
        
        
        for(int i = 0 ; i < habitats.size() ; i++){
            listaHabitats.addElement(habitats.get(i));
        }
        
        listaHabitats.setSelectedItem(null);
    }
    
    /**
     * Llena la comboBox de cuidadores con la lista de cuidadores dada como parámetro.
     * @param cuidadores Lista de cuidadores.
     */
    private void llenarCBoxCuidadores(List<Cuidador> cuidadores){
        if (listaCuidadores == null) {
            listaCuidadores = new DefaultComboBoxModel();
        }
        
        listaCuidadores.removeAllElements();
        
        
        for(int i = 0 ; i < cuidadores.size() ; i++){
            listaCuidadores.addElement(cuidadores.get(i));
        }
        
        listaCuidadores.setSelectedItem(null);
    }
    
    /**
     * Llena la comboBox de zonas con la lista de zonas dada como parámetro.
     * @param zonas Lista de zonas.
     */
    private void llenarCBoxZonas(List<Zona> zonas){
        if (listaZonas == null) {
            listaZonas = new DefaultComboBoxModel();
        }
        
        listaZonas.removeAllElements();

        
        for(int i = 0 ; i < zonas.size() ; i++){
            listaZonas.addElement(zonas.get(i));
        }
        
        listaZonas.setSelectedItem(null);
    }
    
    /**
     * Desactiva todas las secciones y campos del formulario además de limpiar cada
     * una de ellas de cualquier dato que puedan contener.
     */
    private void desactivarFormulario(){
        txtNombreEspecie.setEditable(true);
        pnlAnimales.setVisible(false);
        pnlDatos.setVisible(false);
        cboxCuidadores.setEnabled(false);
        cboxHabitats.setEnabled(false);
        cboxZonas.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtNombreCientifico.setEnabled(false);
        txtNombreEspaniol.setEnabled(false);
        btnValidarEspecie.setEnabled(true);
        limpiarFormulario();
    }
    
    /**
     * Vacía cada uno de los campos del formulario.
     */
    private void limpiarFormulario(){
        
        txtNombreEspecie.setText("");
        txtDescripcion.setText("");
        txtEdadAnimal.setText("");
        txtNombreAnimal.setText("");
        txtNombreCientifico.setText("");
        txtNombreEspaniol.setText("");
    }
    
    /**
     * Verifica que el formulario de Especies esté válido.
     * 
     * El formulario es válido si contiene
     * - Nombre científico
     * - Descripción
     * - Seleccionó un cuidador
     * - Seleccionó un hábitat
     * - Seleccionó una zona
     * 
     * @return True si es válido, False en caso contrario.
     */
    private boolean verificarFormulario(){
        
        if(txtNombreCientifico.getText().isEmpty())
            return false;
            
        if(txtDescripcion.getText().isEmpty())
            return false;
        
        if(cboxCuidadores.getSelectedItem() == null)
            return false;
            
        if(cboxHabitats.getSelectedItem() == null)
            return false;
        
        if(cboxZonas.getSelectedItem() == null)
            return false;
        
        return true;
    }
    
    /**
     * Vacía los campos del formulario de animales.
     */
    private void limpiarFormularioAnimales(){
        txtNombreAnimal.setText("");
        txtEdadAnimal.setText("");
        rBtnHembra.setSelected(false);
        rBtnMacho.setSelected(false);
    }
    
    /**
     * Verifica que el formulario de animales sea válido.
     * 
     * El formulario es válido si:
     * - Contiene un nombre
     * - La edad del animal se encuentra entre 0 a 128
     * - Se haya seleccionado un sexo
     * @return True en caso de ser válido, False en caso contrario.
     */
    private boolean verificarFormularioAnimal(){
        
        if(txtNombreAnimal.getText().isEmpty())
            return false;
        
        if(txtEdadAnimal.getText().isEmpty())
            return false;
        
        int edadAnimal = -1;
        
        try{
            edadAnimal = Integer.parseInt(txtEdadAnimal.getText());
        }catch(Exception e){
            return false;
        }

        if(edadAnimal < 1 || edadAnimal > 150)
            return false;
        
        if(!rBtnHembra.isSelected() && !rBtnMacho.isSelected())
            return false;

        return true;
    }
    
    /**
     * Crea una ficha de cargo de especie al cuidador dado como parámetro.
     * Este método se debe de llamar después de registrar una Especie, siempre y cuando
     * el registro se haya completado con éxito.
     * @param cuidador Cuidador a crear ficha de cargo.
     * @return True si fue creada y guardada exitosamente, False en caso contrario.
     */
    private boolean crearFichaCargoEspecie(Cuidador cuidador){
        
        Especie especie = negocio.verificarEspecieNombre(txtNombreEspaniol.getText());
        
        Date fecha = new Date();
        
        CargoEspecie fichaCargo = new CargoEspecie(especie, fecha, cuidador.getId());
        
        return negocio.agregarFichaCargoCuidador(cuidador, fichaCargo);
    }
    
    /**
     * Guarda cada uno de los animales que se encuentran dentro de la tabla de animales
     * Este método se debe usar únicamente cuando se están registrando animales junto
     * con una nueva especie.
     * @param especie 
     */
    private void guardarAnimales(Especie especie){
        
        for(int i = 0 ; i < animales.size() ; i++){
            Animal animal = animales.get(i);
            animal.setEspecie(especie);
            negocio.guardarAnimal(animal);
        }
    }
    
    /**
     * Llena la tabla de animales con la lista de animales dada como parámetro.
     * @param animales Lista de animales.
     */
    private void llenarTablaAnimales(List<Animal> animales) {

        List<Animal> listaAnimales = animales;

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAnimales.getModel();

        modeloTabla.setRowCount(0);

        listaAnimales.forEach(animal -> {
            Object[] fila = new Object[4];
            fila[0] = animal;
            fila[1] = animal.getEdad();
            fila[2] = animal.getSexo();
            fila[3] = "Eliminar";
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * Inicializa los botones de "Eliminar" dentro de la tabla de animales.
     */
    private void initBotonesAnimales(){
        ActionListener onEditarClickListener = new ActionListener() {
            
            /**
             * Elimina de la tabla el animal que se encuentre en el renglón donde el botón fue presionado.
             * 
             * El método elimina de la tabla el animal si el formulario se encuentra en Status : NUEVOREGISTRO
             * El método elimina de la aplicación el animal si el formulario se enceuntra en Status : UPDATE
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int fila = tblAnimales.getSelectedRow();
                Animal animal = (Animal) tblAnimales.getValueAt(fila, 0);
                
                DefaultTableModel modeloTabla = (DefaultTableModel) tblAnimales.getModel();
                
                List<Animal> animales = new ArrayList<>();
                
                for(int i = 0 ; i < modeloTabla.getRowCount() ; i++){
                    
                    Animal animalTabla = (Animal) modeloTabla.getValueAt(i,0);
                    
                    if(!(animal.getId() == animalTabla.getId()) || !(animal.getNombre().equalsIgnoreCase(animalTabla.getNombre()))){
                        animales.add(animalTabla);
                    }else{
                        eliminarAnimal(animalTabla);
                    }
                }
                
                setAnimales(animales);
                actualizarTablaAnimales();
            }
        };        


        int indiceColumnaEditar = 3;
        
        TableColumnModel modeloColumnas = this.tblAnimales.getColumnModel();

        modeloColumnas = this.tblAnimales.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));
    }
    
    /**
     * Vacía la tabla de animales.
     */
    private void limpiarTablaAnimales(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tblAnimales.getModel();
        modeloTabla.setRowCount(0);
    }
    
    /**
     * Muestra un mensaje de error dentro un JOptionPane.
     * @param mensaje Mensaje a mostrar.
     */
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Elimina de la aplicación el animal dado como parámetro.
     * @param animal Animal a eliminar.
     */
    private void eliminarAnimal(Animal animal){
        negocio.eliminarAnimal(animal);
    }
    
    /**
     * Agrega al animal dado como parámetro, siempre y cuando no exista uno en la tabla con el mismo nombre.
     * 
     * Si el status del formulario es : NUEVORGISTRO, sólo se almacenará temporalmente en la tabla
     * y se guardará hasta que se guarda la Especie.
     * 
     * Si el status del formulario es : ACTUALIZACIÓN, se guardará automáticamente en la aplicación.
     * @param animal 
     */
    private void agregarAnimal(Animal animal){
        
            
        for (int i = 0; i < animales.size(); i++) {
            if (animales.get(i).getNombre().equalsIgnoreCase(animal.getNombre())) {
                mostrarError("Ya existe un animal con el mismo nombre");
                return;
            }
        }
        
        if(status == NUEVOREGISTRO)
            animales.add(animal);
        
        
        if (status == ACTUALIZACION) 
            negocio.guardarAnimal(animal);

    }
    
    /**
     * Establece la lista de animales al atributo de animales del formulario.
     * Este funciona como almacenamiento temporal para las consutlas de animales.
     * @param animales 
     */
    private void setAnimales(List<Animal> animales){
        this.animales = animales;
    }
    
    /**
     * Actualiza el status del formulario al dado como parámetro.
     * Sólo son validos : NUEVORGISTRO y ACTUALIZACION
     * @param status 
     */
    private void cambiarStatus(String status){
        this.status = status;
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
        txtNombreEspecie = new javax.swing.JTextField();
        lblNombreEspecie = new javax.swing.JLabel();
        btnValidarEspecie = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pnlAnimales = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimales = new javax.swing.JTable();
        lblAnimales = new javax.swing.JLabel();
        btnEditarAnimales = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        pnlRegistroEspecie = new javax.swing.JPanel();
        lblHabitat = new javax.swing.JLabel();
        lblCuidador = new javax.swing.JLabel();
        cboxCuidadores = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblNombreCientifico = new javax.swing.JLabel();
        txtNombreCientifico = new javax.swing.JTextField();
        txtNombreEspaniol = new javax.swing.JTextField();
        lblNombreEspaniol = new javax.swing.JLabel();
        cboxHabitats = new javax.swing.JComboBox<>();
        lblRegistro = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblZona = new javax.swing.JLabel();
        cboxZonas = new javax.swing.JComboBox<>();
        pnlRegistroAnimales = new javax.swing.JPanel();
        lblRegistroAnimal = new javax.swing.JLabel();
        lblNombreAnimal = new javax.swing.JLabel();
        txtNombreAnimal = new javax.swing.JTextField();
        lblEdadAnimal = new javax.swing.JLabel();
        txtEdadAnimal = new javax.swing.JTextField();
        rBtnMacho = new javax.swing.JRadioButton();
        rBtnHembra = new javax.swing.JRadioButton();
        lblSexoAnimal = new javax.swing.JLabel();
        btnConfirmacionAnimal = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        pnlEncabezado.setBackground(new java.awt.Color(33, 47, 69));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 204, 204));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de Especies");

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

        lblNombreEspecie.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreEspecie.setText("Nombre de la Especie");

        btnValidarEspecie.setText("Verificar");
        btnValidarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnValidarEspecie(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Sexo", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimales);

        lblAnimales.setText("Animales Registrados");

        btnEditarAnimales.setText("Editar Animales");
        btnEditarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnEditarAnimales(evt);
            }
        });

        javax.swing.GroupLayout pnlAnimalesLayout = new javax.swing.GroupLayout(pnlAnimales);
        pnlAnimales.setLayout(pnlAnimalesLayout);
        pnlAnimalesLayout.setHorizontalGroup(
            pnlAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnimalesLayout.createSequentialGroup()
                .addGroup(pnlAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAnimalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(pnlAnimalesLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblAnimales)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlAnimalesLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnEditarAnimales)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        pnlAnimalesLayout.setVerticalGroup(
            pnlAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnimalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnimales)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarAnimales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatos.setLayout(new java.awt.CardLayout());

        lblHabitat.setText("Hábitat");

        lblCuidador.setText("Cuidador");

        cboxCuidadores.setModel(listaCuidadores);

        lblDescripcion.setText("Descripción");

        lblNombreCientifico.setText("Nombre Científico");

        txtNombreEspaniol.setEditable(false);

        lblNombreEspaniol.setText("Nombre en Español");

        cboxHabitats.setModel(listaHabitats);

        lblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegistro.setText("Registro");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnGuardar(evt);
            }
        });

        lblZona.setText("Zona");

        cboxZonas.setModel(listaZonas);

        javax.swing.GroupLayout pnlRegistroEspecieLayout = new javax.swing.GroupLayout(pnlRegistroEspecie);
        pnlRegistroEspecie.setLayout(pnlRegistroEspecieLayout);
        pnlRegistroEspecieLayout.setHorizontalGroup(
            pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroEspecieLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(276, 276, 276))
            .addGroup(pnlRegistroEspecieLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroEspecieLayout.createSequentialGroup()
                        .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreCientifico)
                            .addComponent(lblNombreEspaniol)
                            .addComponent(lblDescripcion)
                            .addComponent(lblCuidador)
                            .addComponent(lblHabitat)
                            .addComponent(lblZona))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreCientifico)
                            .addComponent(txtDescripcion)
                            .addComponent(cboxCuidadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreEspaniol, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRegistroEspecieLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(lblRegistro)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        pnlRegistroEspecieLayout.setVerticalGroup(
            pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroEspecieLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRegistro)
                .addGap(36, 36, 36)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreEspaniol)
                    .addComponent(txtNombreEspaniol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCientifico)
                    .addComponent(txtNombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuidador)
                    .addComponent(cboxCuidadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitat)
                    .addComponent(cboxHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroEspecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZona)
                    .addComponent(cboxZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnGuardar)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pnlDatos.add(pnlRegistroEspecie, "Especie");

        lblRegistroAnimal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegistroAnimal.setText("Registro de Animal");

        lblNombreAnimal.setText("Nombre");

        lblEdadAnimal.setText("Edad");

        rBtnMacho.setText("Macho");
        rBtnMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnMachoSelected(evt);
            }
        });

        rBtnHembra.setText("Hembra");
        rBtnHembra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnHembraSelected(evt);
            }
        });

        lblSexoAnimal.setText("Sexo:");

        btnConfirmacionAnimal.setText("Agregar");
        btnConfirmacionAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnAgregarAnimal(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnRegresar(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroAnimalesLayout = new javax.swing.GroupLayout(pnlRegistroAnimales);
        pnlRegistroAnimales.setLayout(pnlRegistroAnimalesLayout);
        pnlRegistroAnimalesLayout.setHorizontalGroup(
            pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreAnimal)
                            .addComponent(lblEdadAnimal)
                            .addComponent(lblSexoAnimal))
                        .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdadAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(rBtnMacho)
                                .addGap(56, 56, 56)
                                .addComponent(rBtnHembra))))
                    .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(lblRegistroAnimal))
                    .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar)
                            .addComponent(btnConfirmacionAnimal))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        pnlRegistroAnimalesLayout.setVerticalGroup(
            pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroAnimalesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRegistroAnimal)
                .addGap(44, 44, 44)
                .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreAnimal)
                    .addComponent(txtNombreAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdadAnimal)
                    .addComponent(txtEdadAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pnlRegistroAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtnMacho)
                    .addComponent(rBtnHembra)
                    .addComponent(lblSexoAnimal))
                .addGap(55, 55, 55)
                .addComponent(btnConfirmacionAnimal)
                .addGap(75, 75, 75)
                .addComponent(btnRegresar)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pnlDatos.add(pnlRegistroAnimales, "Animales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(txtNombreEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnValidarEspecie))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(lblNombreEspecie)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreEspecie)
                                .addGap(33, 33, 33)
                                .addComponent(txtNombreEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnValidarEspecie)
                                .addGap(44, 44, 44)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAnimales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Desactiva el formulario y regresa la aplicación al menú principal
     * @param evt Botón "Menú" seleccionado
     */
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        desactivarFormulario();
        
        this.status = null;
        this.especie = null;
        this.animales = new ArrayList<>();
        limpiarTablaAnimales();

        Container frame = this.getParent().getParent().getParent();

        CardLayout cl = (CardLayout)(frame.getLayout());
        cl.show(frame, "Menu");
        
        parent.setTitle("Zoológico");
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * Verifica si ya fue registrada una Especie con el nombre dado.
     * 
     * Si ya se encuentra una especie, despliega sus datos y permite agregar o eliminar animales de la especie.
     * Si no se encuentra una sepecie, activa los campos necesarios para su registro y permite agregar animales
     * junto con el registro.
     * @param evt Botón "Validar" seleccionado
     */
    private void clickBtnValidarEspecie(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnValidarEspecie
        String nombreEspecie = txtNombreEspecie.getText();
        
        if(nombreEspecie.isEmpty()){
            mostrarError("Ingrese un nombre de la especie");
            return;
        }
        
        Especie especie = negocio.verificarEspecieNombre(nombreEspecie);
        this.especie = especie;
        
        if(especie != null){
            mostrarError("Ya existe una especie con ese nombre.");
            llenarFormulario(especie);
            cambiarStatus(ACTUALIZACION);
        }else{
            activarFormulario();
            btnValidarEspecie.setEnabled(false);
            cambiarStatus(NUEVOREGISTRO);
        }
        
    }//GEN-LAST:event_clickBtnValidarEspecie

    /**
     * Guarda dentro de la aplicación la Especie con todos los datos dados en el formulario,
     * adicionalmente guarda todos los animales que se encuentren en la tabla de animales.
     * @param evt Botón "Guardar" seleccionado
     */
    private void clickBtnGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnGuardar
        
        if(!verificarFormulario()){
            mostrarError("Debe llenar todos los campos.");
            return;
        }
        
        if(negocio.verificarEspecieNombreCientifico(txtNombreCientifico.getText()) != null){
            mostrarError("Ya existe una especie registrada con el mismo nombre científico");
            return;
        }
        
        String nombreVulgar = txtNombreEspaniol.getText();
        String nombreCientifico = txtNombreCientifico.getText();
        String descripcion = txtDescripcion.getText();
        Cuidador cuidador = (Cuidador) cboxCuidadores.getSelectedItem();
        Habitat habitat = (Habitat) cboxHabitats.getSelectedItem();
        Zona zona = (Zona) cboxZonas.getSelectedItem();
        
        Especie especie = new Especie(nombreVulgar, nombreCientifico, descripcion, habitat, zona);
        especie.generarId();
        
        boolean registroGuardado = negocio.guardarEspecie(especie);
        
        if(!registroGuardado){
            mostrarError("La especie no pudo ser guardada");
        }
        
        if(!crearFichaCargoEspecie(cuidador))
            mostrarError("Error al actualizar el cuidador");
        
        
        guardarAnimales(especie);
        
        JOptionPane.showMessageDialog(this, "Se ha registrado la especie exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        desactivarFormulario();
        
        this.status = null;
        this.especie = null;
        this.animales = new ArrayList<>();
        limpiarTablaAnimales();
    }//GEN-LAST:event_clickBtnGuardar

    /**
     * Muestra el formulario de registro para Animales.
     * @param evt Botón "Editar Animales" seleccionado.
     */
    private void clickBtnEditarAnimales(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnEditarAnimales
        CardLayout cl = (CardLayout) (pnlDatos.getLayout());
        cl.show(pnlDatos, "Animales");
        
        limpiarFormularioAnimales();

    }//GEN-LAST:event_clickBtnEditarAnimales

    /**
     * Vuelve a mostrar el formulario de Especies.
     * @param evt Botón "Regresar" seleccionado.
     */
    private void clickBtnRegresar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnRegresar
        CardLayout cl = (CardLayout) (pnlDatos.getLayout());
        cl.show(pnlDatos, "Especie");
    }//GEN-LAST:event_clickBtnRegresar

    /**
     * Verifica si el botón de "Macho" fue seleccionado, si lo fue, desactiva la
     * selección del botón hembra, si estaba seleccionado.
     * @param evt Botón "Macho" seleccionado.
     */
    private void rBtnMachoSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnMachoSelected
        rBtnHembra.setSelected(false);
    }//GEN-LAST:event_rBtnMachoSelected

    /**
     * Verifica si el botón "Hembra" fue seleccionado, si lo fue, desactiva la
     * la selección del botón "Macho", si estaba seleccionado.
     * @param evt Botón "Hembra" seleccionado.
     */
    private void rBtnHembraSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnHembraSelected
        rBtnMacho.setSelected(false);
    }//GEN-LAST:event_rBtnHembraSelected

    /**
     * Guarda un animal con los datos del formulario.
     * 
     * Si el status es NUEVOREGISTRO, el animal será almacenado temporalmente en la tabla hasta que se guarde la Especie.
     * Sie lstatus es ACTUALIACIÓN, el animal será almacenado en la aplicación inmediatamente.
     * @param evt Botón "Agregar" seleccionado.
     */
    private void clickBtnAgregarAnimal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnAgregarAnimal

        if (!verificarFormularioAnimal()) {
            mostrarError("Formulario incompleto y/o edad negativa o mayora 150");
            return;
        }

        String nombreAnimal = txtNombreAnimal.getText();
        int edadAnimal = Integer.parseInt(txtEdadAnimal.getText());
        String sexoAnimal = null;
        
        if(rBtnHembra.isSelected())
            sexoAnimal = "Hembra";
        
        if(rBtnMacho.isSelected())
            sexoAnimal = "Macho";
        
        Animal animal = new Animal(nombreAnimal, edadAnimal, sexoAnimal);
        
        if (status == NUEVOREGISTRO) {
            agregarAnimal(animal);
            actualizarTablaAnimales();
        }else if (status == ACTUALIZACION){
            animal.setEspecie(especie);
            agregarAnimal(animal);
            cargarAnimales();
            actualizarTablaAnimales();
        }
        
        limpiarFormularioAnimales();
        
    }//GEN-LAST:event_clickBtnAgregarAnimal


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmacionAnimal;
    private javax.swing.JButton btnEditarAnimales;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnValidarEspecie;
    private javax.swing.JComboBox<String> cboxCuidadores;
    private javax.swing.JComboBox<String> cboxHabitats;
    private javax.swing.JComboBox<String> cboxZonas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAnimales;
    private javax.swing.JLabel lblCuidador;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEdadAnimal;
    private javax.swing.JLabel lblHabitat;
    private javax.swing.JLabel lblNombreAnimal;
    private javax.swing.JLabel lblNombreCientifico;
    private javax.swing.JLabel lblNombreEspaniol;
    private javax.swing.JLabel lblNombreEspecie;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistroAnimal;
    private javax.swing.JLabel lblSexoAnimal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblZona;
    private javax.swing.JPanel pnlAnimales;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlRegistroAnimales;
    private javax.swing.JPanel pnlRegistroEspecie;
    private javax.swing.JRadioButton rBtnHembra;
    private javax.swing.JRadioButton rBtnMacho;
    private javax.swing.JTable tblAnimales;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEdadAnimal;
    private javax.swing.JTextField txtNombreAnimal;
    private javax.swing.JTextField txtNombreCientifico;
    private javax.swing.JTextField txtNombreEspaniol;
    private javax.swing.JTextField txtNombreEspecie;
    // End of variables declaration//GEN-END:variables
}
