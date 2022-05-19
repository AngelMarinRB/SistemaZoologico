package pantallas;

import entidades.DiasHorario;
import entidades.Itinerario;
import entidades.Zona;
import interfaces.INegocio;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * frama para guardar un itinerario
 * @author ricardosn saavedra
 */
public class FrmItinerarios extends javax.swing.JPanel {
    /**
     * objetos de negocio
     */
    private INegocio negocio;
    /**
     * lista que guarda zonas que ya esten en el sistema
     */
    private List<Zona> zonas;
    /**
     * Lista que almacena las zonas seleccionadas para el itinerario
     */
    private List<String> zonatblSeleccionada;
    /**
     * lista de arreglos que almacena objetos diasHorario usados para la creacion
     * de itinerario
     */
    private ArrayList<DiasHorario> dhArray;
    
    private JFrame parent;
    
    /**
     * Crea e inicializa los objetos del formulario de Itinerarios.
     * @param negocio Objeto Negocio para el acceso a datos.
     */
    public FrmItinerarios(INegocio negocio , JFrame parent) {
        initComponents();
        this.pnlHorario.setVisible(false);
        this.pnlZonas.setVisible(false);
        this.pnlFormPrincipal.setVisible(false);
        this.btnGuardar.setVisible(false);
        this.txtHorarioAviso.setVisible(false);
        this.btnLimpiar.setVisible(false);
        this.lblFormatoHoras.setVisible(false);
        
        this.negocio = negocio;
        
        this.parent = parent;
        
        this.cargarRecursos();
        this.zonatblSeleccionada = new ArrayList<>();
    }
    
    /**
     * metodo que carga recursos a usar en el frm de la base de datos
     */
    public void cargarRecursos(){
        zonas= negocio.consultarZonas();
    }
    
     /**
      * metodo que busca el itinerario ingresado en la verificacion
      */
    public void buscarItinerario(){
      
        if(!this.txtVerificarNombre.getText().equalsIgnoreCase("")){
            Itinerario itinerario =  negocio.verificarExistenciaItinerario(this.txtVerificarNombre.getText());
            if(itinerario ==  null){
              this.continuarDatos();
              
            }else{
                this.mostrarError("Ya existe este itinerario");
                 
                this.reiniciarFrm();
            }
        }else{
            this.mostrarError("No se ha ingresado nada");
            this.reiniciarFrm();
        }
    }
    
    /**
     * metodo que verifica los valores de los campos de texto que se encuentran
     * en el panel de datos
     */
    public void registraDatosItinerario(){
        int i=0;
        if(this.txtDisponibilidad.getText().equalsIgnoreCase("")){
            this.mostrarError("Se ha dejado el campo de visitantes vacío");
           i=i+1;
        } 

        if( this.txtDuracion.getText().equalsIgnoreCase("")){
            this.mostrarError("Se ha dejado el campo de duración vacío");
            i=i+1;
        }
        
        if(this.txtLongitud.getText().equalsIgnoreCase("")){
            this.mostrarError("Se ha dejado el campo de longitud vacío");
            i=i+1;
        }
        
        if(diasSeleccionados()==false){
            this.mostrarError("No se selecciono ningun día");
            i=i+1;
        }
        
        if(i==0){
        this.activarCampos();
        }
    }
    
    
    /**
     * metodo que verifica si por lo menos un dia se encuentra seleccionado
     * @return true si es verdad que por lo menos uno lo esta, false de lo contrario
     */
    public boolean diasSeleccionados(){
        if(this.checkLunes.isSelected() ||
           this.checkMartes.isSelected() ||
           this.checkMiercoles.isSelected() ||
           this.checkJueves.isSelected() ||
           this.checkViernes.isSelected() ||
           this.checkSabado.isSelected() ||
           this.checkDomingo.isSelected())
        {
          return true;
        }
        return false;
    }
    
    /**
     * metodo que hace visible el panel de datos
     * si el nombre del itinerario no esta repetido
     */
    public void continuarDatos(){
        this.pnlFormPrincipal.setVisible(true);
        this.txtNombre.setText(this.txtVerificarNombre.getText());
        
    }
    
    /**
     * metodo que activa los campos una vez que estan
     * seleccionados los dias asi como activar los paneles
     * correspondientes asi como los de zona
     */
    public void activarCampos(){
        
        
        this.btnGuardar.setVisible(true);
        this.pnlHorario.setVisible(true);
        this.pnlZonas.setVisible(true);
        this.btnLimpiar.setVisible(true);
        
        if(!this.checkLunes.isSelected()){
            this.txtLunes.setEditable(false);
        }else{
            this.txtLunes.setEditable(true);
        }
        
        if(!this.checkMartes.isSelected()){
            this.txtMartes.setEditable(false);
        }else{
            this.txtMartes.setEditable(true);
        }
        
        if(!this.checkMiercoles.isSelected()){
            this.txtMiercoles.setEditable(false);
        }else{
            this.txtMiercoles.setEditable(true);
        }
        
        if(!this.checkJueves.isSelected()){
            this.txtJueves.setEditable(false);
        }else{
            this.txtJueves.setEditable(true);
        }
        
        if(!this.checkViernes.isSelected()){
            this.txtViernes.setEditable(false);
        }else{
            this.txtViernes.setEditable(true);
        }
        
        if(!this.checkSabado.isSelected()){
            this.txtSabado.setEditable(false);
        }else{
            this.txtSabado.setEditable(true);
        }
        
        if(!this.checkDomingo.isSelected()){
            this.txtDomingo.setEditable(false);
        }else{
            this.txtDomingo.setEditable(true);
        }
        
        this.btnContinuar.setEnabled(false);
        this.txtHorarioAviso.setVisible(true);
        this.llenarTablaZonas(zonas);
        
        this.checkLunes.setEnabled(false);
        this.checkMartes.setEnabled(false);
        this.checkMiercoles.setEnabled(false);
        this.checkJueves.setEnabled(false);
        this.checkSabado.setEnabled(false);
        this.checkViernes.setEnabled(false);
        this.checkDomingo.setEnabled(false);
        
        this.lblFormatoHoras.setVisible(true);
        
        

    }
    
    /**
     * metodo que obtiene el nombre de la zona seleccionada
     * en la tabla
     * @return nombre de la zona si es un valor valido de lo contrario null
     */
    private String getNombreZonaSeleccionado(){
        int indiceFilaSeleccionada = this.tblZonas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblZonas.getModel();
            int indiceColumnaNombre = 0;
            String nombreSeleccionado= (String) modeloTabla.getValueAt(indiceFilaSeleccionada, indiceColumnaNombre);
            return nombreSeleccionado;
        }
        else {
            return null;
        }       
    }
    
    /**
     * metodo que obtiene el nombre seleccionado de la tabla
     * de zonas seleccionadas para eliminarlo
     * @return el nombre si se encuentra, null de lo contrario
     */
     private String getNombreEliminarZonaSeleccionada(){
        int indiceFilaSeleccionada = this.tblZonasSeleccionadas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblZonasSeleccionadas.getModel();
            int indiceColumnaNombre = 0;
            String nombreSeleccionado= (String) modeloTabla.getValueAt(indiceFilaSeleccionada, indiceColumnaNombre);
            return nombreSeleccionado;
        }
        else {
            return null;
        }       
    }
     
    /**
     * metodo que obtiene el string del nombre de la zona y lo agrega a 
     * la lista de zonas seleccionadas si no se encuentra
     * @param nombre String con el nombre de la zona a agregar
     */
    public void agregarZonaSeleccionada(String nombre){
        for(String xx:zonatblSeleccionada){
            if(nombre.equalsIgnoreCase(xx)){
               return; 
            }
        }
      
        this.zonatblSeleccionada.add(nombre);
        
    }
      
    /**
     * metodo que llena la tabla de zonas seleccionadas 
     * con la lista de zonas seleccionadas
     */
    private void llenarTablaZonasSeleccionadas(){
        List<String> listaZonas = zonatblSeleccionada;
        
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblZonasSeleccionadas.getModel();

        modeloTabla.setRowCount(0);

        listaZonas.forEach(zona -> {
            Object[] fila = new Object[1];
            fila[0] = zona;
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * metodo que llena la tabla de zonas con
     * las zonas cargadas de la base de datos anteriormente
     * @param zonas lista de zonas 
     */
    private void llenarTablaZonas(List<Zona> zonas) {

        List<Zona> listaZonas = zonas;
        
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblZonas.getModel();

        modeloTabla.setRowCount(0);

        listaZonas.forEach(zona -> {
            Object[] fila = new Object[2];
            fila[0] = zona.getNombre();
            fila[1] = zona.getExtension();
            modeloTabla.addRow(fila);
        });
    }
    
    /**
     * metodo que muestra un error con el string enviado
     * @param mensaje mensaje a mostrar
     */
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * metodo que regresa todos los componentes del frm
     * a su estado inicial
     */
    private void reiniciarFrm(){
       this.pnlFormPrincipal.setVisible(false);
       this.pnlHorario.setVisible(false);
       this.pnlZonas.setVisible(false);
       
       this.txtViernes.setText("");
       this.txtDisponibilidad.setText("");
       this.txtDomingo.setText("");
       this.txtDuracion.setText("");
       this.txtLongitud.setText("");
       this.txtJueves.setText("");
       this.txtLunes.setText("");
       this.txtMartes.setText("");
       this.txtMiercoles.setText("");
       this.txtSabado.setText("");
       this.txtVerificarNombre.setText("");
       
       this.checkLunes.setSelected(false);
       this.checkMartes.setSelected(false);
       this.checkMiercoles.setSelected(false);
       this.checkJueves.setSelected(false);
       this.checkViernes.setSelected(false);
       this.checkSabado.setSelected(false);
       this.checkDomingo.setSelected(false);
       
       this.checkLunes.setEnabled(true);
       this.checkMartes.setEnabled(true);
       this.checkMiercoles.setEnabled(true);
       this.checkJueves.setEnabled(true);
       this.checkViernes.setEnabled(true);
       this.checkSabado.setEnabled(true);
       this.checkDomingo.setEnabled(true);
       
       this.txtHorarioAviso.setVisible(false);
       this.btnContinuar.setEnabled(true);
       this.btnGuardar.setVisible(false);
       this.btnLimpiar.setVisible(false);
         
       this.zonas.clear();
       this.zonatblSeleccionada.clear();
       
       this.llenarTablaZonas(zonas);
       this.llenarTablaZonasSeleccionadas();
       
       this.lblFormatoHoras.setVisible(false);
       this.cargarRecursos();
    }
    
    /**
     * metodo que verifica los datos ingresado en los campos
     * @return true si los datos son correctos, false de lo contrario
     */
    public boolean verificarDatos(){
        
        
        if(this.verificarHora() && !this.zonatblSeleccionada.isEmpty() &&
                this.verificarCamposDatos()){
            return true;
        }
        
        if(this.zonatblSeleccionada.isEmpty()){
        this.mostrarError("lista de zonas vacía");
        }
        
        return false;
    }
    
    /**
     * metodo que verifica los campos del panel de datos
     * @return true si son correctos, false de lo contrario
     */
    public boolean verificarCamposDatos(){
        int longitud,visitantes,duracion;
        int i=0;
        
        try{
        
        Float.valueOf(this.txtLongitud.getText());
        
        }catch(Exception e){
            this.mostrarError("Campo de longitud incorrecto, ingrese dato numérico valido");
            i=i+1;
        }
        
        try{
            Integer.valueOf(this.txtDisponibilidad.getText());
        }catch(Exception e){
            this.mostrarError("Campo de visitantes incorrecto, ingrese dato numérico valido");
            i=i+1;
        }
        
        try{
            Integer.valueOf(this.txtDuracion.getText());
        }catch(Exception e){
            this.mostrarError("Campo de duración incorrecto, ingrese dato numérico valido");
            i=i+1;
        }
        
        if(i==0){
        return true;
        }else{
            return false;
        }
    }
        
    /**
     * metodo que construye un objeto itinerario
     * y lo guarda en la base de datos
     */
    public void guardarItinerario(){
        Itinerario itinerario = new Itinerario();
        itinerario.setNombre(this.txtNombre.getText());
        itinerario.setDuracion(Integer.valueOf(this.txtDuracion.getText()));
        itinerario.setDiasHorario(this.dhArray);
        itinerario.setLongitud(Float.valueOf(this.txtDisponibilidad.getText()));
        itinerario.setVisitantesMaximos(Integer.valueOf(this.txtDisponibilidad.getText()));
        itinerario.setRecorrido(this.buscarZonasSeleccionadas());
        negocio.guardarItinerario(itinerario);
        
        JOptionPane.showMessageDialog(this,"Itinerario guardado con éxito","información",JOptionPane.INFORMATION_MESSAGE);
        
        this.reiniciarFrm();
    }
    
    /**
     * metodo que regresa una lista de objetos de zona
     * con la lista de zonas seleccionadas
     * @return lista de zonas 
     */
    public List<Zona> buscarZonasSeleccionadas(){
       
        List<Zona> listaZonaSeleccionada = new ArrayList<>();
          
        for (int i = 0; i < this.zonatblSeleccionada.size(); i++) {
            for (int j = 0; j < this.zonas.size(); j++) {
                if(zonas.get(j).getNombre().equalsIgnoreCase(this.zonatblSeleccionada.get(i))){
                    listaZonaSeleccionada.add(zonas.get(j));
                }
            }
        }
        return listaZonaSeleccionada;
    }
    
    
    /**
     * metodo que verificado los campos de las horas esten ingresados correctamente
     * @return true si tienen valores validos, false de lo contrario
     */
    public boolean verificarHora(){
        //verifica campo de las horas
        
        Pattern patron = Pattern.compile("\\d\\d\\:\\d\\d");
        Matcher matcher; 
        this.dhArray = new ArrayList();
        
        if(this.checkLunes.isSelected()){
            if(!this.txtLunes.getText().isEmpty()){
            String[] split = this.txtLunes.getText().split(",");
            DiasHorario dh = new DiasHorario("Lunes");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    this.mostrarError("La hora número: "+(i+1)+"  en el campo del día lunes contiene un valor invalido");
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("El formato de las horas en el día lunes es incorrecto");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día lunes vacío");
                return false;
            }
        }
        if(this.checkMartes.isSelected()){
            if(!this.txtMartes.getText().isEmpty()){
            String[] split = this.txtMartes.getText().split(",");
            DiasHorario dh = new DiasHorario("Martes");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("La hora número: "+(i+1)+"  en el campo del día martes contiene un valor invalido");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día martes vacío");
                return false;
            }
        }
        if(this.checkMiercoles.isSelected()){
            if(!this.txtMiercoles.getText().isEmpty()){
            String[] split = this.txtMiercoles.getText().split(",");
            DiasHorario dh = new DiasHorario("Miércoles");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("La hora número: "+(i+1)+"  en el campo del día miércoles contiene un valor invalido");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día miércoles vacío");
                return false;
            }
        }
        if(this.checkJueves.isSelected()){
            if(!this.txtJueves.getText().isEmpty()){
            String[] split = this.txtJueves.getText().split(",");
            DiasHorario dh = new DiasHorario("Jueves");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                   this.mostrarError("La hora número: "+(i+1)+"  en el campo del día jueves contiene un valor invalido");
                   return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("El formato de las horas en el día jueves es incorrecto");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día jueves vacío");
                return false;
            }
        }
        if(this.checkViernes.isSelected()){
            if(!this.txtViernes.getText().isEmpty()){
            String[] split = this.txtViernes.getText().split(",");
            DiasHorario dh = new DiasHorario("Viernes");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    this.mostrarError("La hora número: "+(i+1)+"  en el campo del día viernes contiene un valor invalido");
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("El formato de las horas en el día viernes es incorrecto");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día viernes vacío");
                return false;
            }
        }
        if(this.checkSabado.isSelected()){
            if(!this.txtSabado.getText().isEmpty()){
            String[] split = this.txtSabado.getText().split(",");
            DiasHorario dh = new DiasHorario("Sábado");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    this.mostrarError("La hora número: "+(i+1)+"  en el campo del día sábado contiene un valor invalido");
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("El formato de las horas en el día sábado es incorrecto");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día sábado vacío");
                return false;
            }
        }
        if(this.checkDomingo.isSelected()){
            if(!this.txtDomingo.getText().isEmpty()){
            String[] split = this.txtDomingo.getText().split(",");
            DiasHorario dh = new DiasHorario("Domingo");
            
            for (int i = 0; i < split.length; i++) {
                
                if(!this.verificarValorHora(split[i])){
                    this.mostrarError("La hora número: "+(i+1)+"  en el campo del día domingo contiene un valor invalido");
                    return false;
                }
                
                matcher = patron.matcher(split[i]);
                if(!matcher.matches()){
                this.mostrarError("El formato de las horas en el día domingo es incorrecto");
                return false;
                }
                dh.agregarHora(split[i]);
            }  
            dhArray.add(dh);
            }else{
                this.mostrarError("Campo de día domingo vacío");
                return false;
            }
        }
        
        
        return true;
    }
    
    /**
     * metodo que verifica si la hora tiene un formato correcto, y si 
     * tiene un valor correcto vease que no esten fuera de los rangos como
     * 24 am o 59 minutos
     * @param verificar
     * @return true si tienen un valor correcto, false si ocurre lo contrario
     */
    public boolean verificarValorHora(String verificar){
        String[] split = new String[2];
        
        
        try{
            
        split[0]= verificar.substring(0, 2);
        split[1]= verificar.substring(3, 5);    
            
        if(Integer.valueOf(split[0])>23 || Integer.valueOf(split[1])>59 ||
                Integer.valueOf(split[0])<0 || Integer.valueOf(split[1])<0 ){
            return false;
        }
        
        }catch(Exception e){
//            this.mostrarError("Una o varias horas no tienen el formato correcto"
//                    + "por favor introducir hora como 01:00 o 01:00,20:00");
            return false;
        }
        
        return true;
        
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
        lblEncabezado = new javax.swing.JLabel();
        btnRegresarMenu = new javax.swing.JButton();
        pnlVerNombre = new javax.swing.JPanel();
        txtVerificarNombre = new javax.swing.JTextField();
        lblVerificarNombre = new javax.swing.JLabel();
        btnBuscarItinerario = new javax.swing.JButton();
        pnlFormPrincipal = new javax.swing.JPanel();
        lblDatos = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        lblLongitud = new javax.swing.JLabel();
        lblDisponibilidad = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        txtDisponibilidad = new javax.swing.JTextField();
        lblMin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        checkLunes = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkMiercoles = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        checkViernes = new javax.swing.JCheckBox();
        checkSabado = new javax.swing.JCheckBox();
        checkDomingo = new javax.swing.JCheckBox();
        btnContinuar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        pnlHorario = new javax.swing.JPanel();
        lblHorario = new javax.swing.JLabel();
        txtMiercoles = new javax.swing.JTextField();
        txtJueves = new javax.swing.JTextField();
        txtViernes = new javax.swing.JTextField();
        txtSabado = new javax.swing.JTextField();
        txtDomingo = new javax.swing.JTextField();
        lblDomingo = new javax.swing.JLabel();
        lblLunes = new javax.swing.JLabel();
        lblMartes = new javax.swing.JLabel();
        lblMiercoles = new javax.swing.JLabel();
        lblJueves = new javax.swing.JLabel();
        lblViernes = new javax.swing.JLabel();
        lblSabado = new javax.swing.JLabel();
        txtLunes = new javax.swing.JTextField();
        txtMartes = new javax.swing.JTextField();
        lblFormatoHoras = new javax.swing.JLabel();
        txtHorarioAviso = new javax.swing.JLabel();
        pnlZonas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SpnZonasSeleccionadas = new javax.swing.JScrollPane();
        tblZonasSeleccionadas = new javax.swing.JTable();
        SpnZonas = new javax.swing.JScrollPane();
        tblZonas = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        pnlEncabezado.setBackground(new java.awt.Color(33, 47, 69));

        lblEncabezado.setBackground(new java.awt.Color(33, 47, 69));
        lblEncabezado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(204, 204, 204));
        lblEncabezado.setText("Registro de Itinerarios");

        btnRegresarMenu.setText("Menú");
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addComponent(lblEncabezado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblEncabezado)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(btnRegresarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtVerificarNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtVerificarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVerificarNombreActionPerformed(evt);
            }
        });

        lblVerificarNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblVerificarNombre.setText("Verificar Itinerario");

        btnBuscarItinerario.setText("Buscar");
        btnBuscarItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarItinerarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVerNombreLayout = new javax.swing.GroupLayout(pnlVerNombre);
        pnlVerNombre.setLayout(pnlVerNombreLayout);
        pnlVerNombreLayout.setHorizontalGroup(
            pnlVerNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVerNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVerificarNombre)
                    .addGroup(pnlVerNombreLayout.createSequentialGroup()
                        .addComponent(txtVerificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVerNombreLayout.setVerticalGroup(
            pnlVerNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVerNombreLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblVerificarNombre)
                .addGap(27, 27, 27)
                .addGroup(pnlVerNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVerificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblDatos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDatos.setText("Datos");

        txtDuracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });

        lblDuracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDuracion.setText("Duración: ");

        lblLongitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLongitud.setText("Longitud:");

        lblDisponibilidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDisponibilidad.setText("Visitantes:");

        txtLongitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDisponibilidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMin.setText("minutos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("metros");

        checkLunes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkLunes.setText("Lunes");

        checkMartes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkMartes.setText("Martes");

        checkMiercoles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkMiercoles.setText("Miércoles");

        checkJueves.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkJueves.setText("Jueves");

        checkViernes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkViernes.setText("Viernes");

        checkSabado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkSabado.setText("Sábado");

        checkDomingo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkDomingo.setText("Domingo");

        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setEditable(false);

        javax.swing.GroupLayout pnlFormPrincipalLayout = new javax.swing.GroupLayout(pnlFormPrincipal);
        pnlFormPrincipal.setLayout(pnlFormPrincipalLayout);
        pnlFormPrincipalLayout.setHorizontalGroup(
            pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatos)
                            .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(checkJueves)
                                .addGap(18, 18, 18)
                                .addComponent(checkDomingo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDuracion)
                                .addComponent(lblLongitud)
                                .addComponent(lblDisponibilidad)
                                .addComponent(checkLunes)
                                .addComponent(checkMartes)
                                .addComponent(checkMiercoles, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                                .addComponent(checkViernes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinuar))
                            .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblMin))
                                    .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel1))
                                        .addComponent(checkSabado, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(50, 50, 50))
        );
        pnlFormPrincipalLayout.setVerticalGroup(
            pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracion)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMin))
                .addGap(18, 18, 18)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLongitud)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisponibilidad))
                .addGap(18, 18, 18)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLunes)
                    .addComponent(checkJueves)
                    .addComponent(checkDomingo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMartes)
                    .addComponent(checkViernes)
                    .addComponent(btnContinuar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMiercoles)
                    .addComponent(checkSabado))
                .addGap(122, 122, 122))
        );

        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHorario.setText("Horarios");

        txtMiercoles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMiercolesActionPerformed(evt);
            }
        });

        txtJueves.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtViernes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSabado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDomingo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDomingo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDomingo.setText("Domingo");

        lblLunes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLunes.setText("Lunes");

        lblMartes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMartes.setText("Martes");

        lblMiercoles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMiercoles.setText("Miércoles");

        lblJueves.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblJueves.setText("Jueves");

        lblViernes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblViernes.setText("Viernes");

        lblSabado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSabado.setText("Sábado");

        txtLunes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMartes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFormatoHoras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormatoHoras.setText("Formato de horas:");

        txtHorarioAviso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHorarioAviso.setText("hh:mm,hh:mm");

        javax.swing.GroupLayout pnlHorarioLayout = new javax.swing.GroupLayout(pnlHorario);
        pnlHorario.setLayout(pnlHorarioLayout);
        pnlHorarioLayout.setHorizontalGroup(
            pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHorarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHorarioLayout.createSequentialGroup()
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMiercoles)
                            .addComponent(lblMartes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLunes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMartes)
                            .addComponent(txtMiercoles)
                            .addComponent(txtLunes)))
                    .addGroup(pnlHorarioLayout.createSequentialGroup()
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDomingo)
                            .addComponent(lblSabado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDomingo)
                            .addComponent(txtSabado)))
                    .addGroup(pnlHorarioLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblViernes)
                            .addComponent(lblJueves))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJueves)
                            .addComponent(txtViernes)))))
            .addGroup(pnlHorarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHorarioAviso)
                    .addGroup(pnlHorarioLayout.createSequentialGroup()
                        .addComponent(lblHorario)
                        .addGap(50, 50, 50)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHorarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFormatoHoras)
                .addGap(55, 55, 55))
        );
        pnlHorarioLayout.setVerticalGroup(
            pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHorarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHorario)
                .addGap(26, 26, 26)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLunes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLunes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMartes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMiercoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJueves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJueves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViernes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSabado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSabado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomingo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDomingo))
                .addGap(18, 18, 18)
                .addComponent(lblFormatoHoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorarioAviso)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Zonas");

        tblZonasSeleccionadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "zona"
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
        tblZonasSeleccionadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblZonasSeleccionadasMouseClicked(evt);
            }
        });
        SpnZonasSeleccionadas.setViewportView(tblZonasSeleccionadas);
        if (tblZonasSeleccionadas.getColumnModel().getColumnCount() > 0) {
            tblZonasSeleccionadas.getColumnModel().getColumn(0).setResizable(false);
        }

        tblZonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "extensión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblZonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblZonasMouseClicked(evt);
            }
        });
        SpnZonas.setViewportView(tblZonas);
        if (tblZonas.getColumnModel().getColumnCount() > 0) {
            tblZonas.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout pnlZonasLayout = new javax.swing.GroupLayout(pnlZonas);
        pnlZonas.setLayout(pnlZonasLayout);
        pnlZonasLayout.setHorizontalGroup(
            pnlZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlZonasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlZonasLayout.createSequentialGroup()
                        .addComponent(SpnZonas, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(SpnZonasSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlZonasLayout.setVerticalGroup(
            pnlZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnlZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SpnZonasSeleccionadas, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(SpnZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFormPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlVerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnlHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnGuardar)
                        .addGap(101, 101, 101)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlVerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlFormPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed

        this.reiniciarFrm();

        Container frame = this.getParent().getParent().getParent();

        CardLayout cl = (CardLayout) (frame.getLayout());
        cl.show(frame, "Menú");
        
        parent.setTitle("Zoológico");
       
    }//GEN-LAST:event_btnRegresarMenuActionPerformed

    private void txtVerificarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVerificarNombreActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtVerificarNombreActionPerformed

    private void txtMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMiercolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMiercolesActionPerformed

    private void btnBuscarItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarItinerarioActionPerformed
        this.buscarItinerario();
        
    }//GEN-LAST:event_btnBuscarItinerarioActionPerformed

    private void tblZonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblZonasMouseClicked
        String nombre = this.getNombreZonaSeleccionado();
        this.agregarZonaSeleccionada(nombre);
        this.llenarTablaZonasSeleccionadas();
    }//GEN-LAST:event_tblZonasMouseClicked

    private void tblZonasSeleccionadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblZonasSeleccionadasMouseClicked
        this.zonatblSeleccionada.remove(this.getNombreEliminarZonaSeleccionada());
        this.llenarTablaZonasSeleccionadas();
    }//GEN-LAST:event_tblZonasSeleccionadasMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(this.verificarDatos()){
           this.guardarItinerario();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        this.registraDatosItinerario();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.reiniciarFrm();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SpnZonas;
    private javax.swing.JScrollPane SpnZonasSeleccionadas;
    private javax.swing.JButton btnBuscarItinerario;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JCheckBox checkDomingo;
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblDomingo;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFormatoHoras;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblJueves;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblLunes;
    private javax.swing.JLabel lblMartes;
    private javax.swing.JLabel lblMiercoles;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSabado;
    private javax.swing.JLabel lblVerificarNombre;
    private javax.swing.JLabel lblViernes;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFormPrincipal;
    private javax.swing.JPanel pnlHorario;
    private javax.swing.JPanel pnlVerNombre;
    private javax.swing.JPanel pnlZonas;
    private javax.swing.JTable tblZonas;
    private javax.swing.JTable tblZonasSeleccionadas;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtDomingo;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JLabel txtHorarioAviso;
    private javax.swing.JTextField txtJueves;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtLunes;
    private javax.swing.JTextField txtMartes;
    private javax.swing.JTextField txtMiercoles;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSabado;
    private javax.swing.JTextField txtVerificarNombre;
    private javax.swing.JTextField txtViernes;
    // End of variables declaration//GEN-END:variables
}
