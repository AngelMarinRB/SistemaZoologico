package pantallas;

import entidades.Queja;
import entidades.VisitaGuiada;
import fachada.FacadeNegocio;
import interfaces.INegocio;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alanf
 */
public class FrmAtencionVisitantes extends javax.swing.JFrame {

    private JFrame parent;
    
    /**
     * Creates new form FrmAtencionVisitantes
     */
    public FrmAtencionVisitantes(JFrame parent) {
        initComponents();
        this.parent = parent;
        this.setTitle("Registro Quejas");
        this.negocio = new FacadeNegocio();
    }
    
    private INegocio negocio;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtencionVisitantes = new javax.swing.JPanel();
        PnlAtencionVisitantes = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        pnlItinerarios = new javax.swing.JScrollPane();
        tbltinerario = new javax.swing.JTable();
        lblItinerario = new javax.swing.JLabel();
        lblQueja = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoQueja = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        lblDATOS = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEnviarQueja = new javax.swing.JButton();
        btnRegistrarQueja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlAtencionVisitantes.setName(""); // NOI18N
        PnlAtencionVisitantes.setPreferredSize(new java.awt.Dimension(1117, 606));

        pnlEncabezado.setBackground(new java.awt.Color(33, 47, 69));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 204, 204));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Formulario de quejas");

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
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbltinerario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Horario", "Duracion", "Guia", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbltinerario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbltinerarioMousePressed(evt);
            }
        });
        pnlItinerarios.setViewportView(tbltinerario);

        lblItinerario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblItinerario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItinerario.setText("Itinerario");

        lblQueja.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblQueja.setText("Escribe tu queja aquí");

        campoQueja.setColumns(20);
        campoQueja.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoQueja.setRows(5);
        jScrollPane1.setViewportView(campoQueja);

        lblDATOS.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDATOS.setText("Tus datos:");

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEmail.setText("E-mail: (*)");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTelefono.setText("Telefono: (*)");

        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre.setText("Nombre: (op)");

        btnEnviarQueja.setText("Enviar queja");
        btnEnviarQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarQuejaActionPerformed(evt);
            }
        });

        btnRegistrarQueja.setText("Registrar queja");
        btnRegistrarQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarQuejaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlAtencionVisitantesLayout = new javax.swing.GroupLayout(PnlAtencionVisitantes);
        PnlAtencionVisitantes.setLayout(PnlAtencionVisitantesLayout);
        PnlAtencionVisitantesLayout.setHorizontalGroup(
            PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(lblQueja))
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                                .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDATOS)
                                            .addComponent(lblEmail)
                                            .addComponent(lblTelefono)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAtencionVisitantesLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombre)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnRegistrarQueja)
                                .addGap(36, 36, 36)
                                .addComponent(btnEnviarQueja)))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAtencionVisitantesLayout.createSequentialGroup()
                        .addComponent(pnlItinerarios)
                        .addContainerGap())
                    .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())))
            .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                .addGap(471, 471, 471)
                .addComponent(lblItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnlAtencionVisitantesLayout.setVerticalGroup(
            PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblItinerario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItinerarios, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQueja, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDATOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlAtencionVisitantesLayout.createSequentialGroup()
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))
                        .addGap(20, 20, 20)
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(27, 27, 27)
                        .addGroup(PnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnviarQueja)
                            .addComponent(btnRegistrarQueja)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAtencionVisitantesLayout = new javax.swing.GroupLayout(pnlAtencionVisitantes);
        pnlAtencionVisitantes.setLayout(pnlAtencionVisitantesLayout);
        pnlAtencionVisitantesLayout.setHorizontalGroup(
            pnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlAtencionVisitantes, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        pnlAtencionVisitantesLayout.setVerticalGroup(
            pnlAtencionVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtencionVisitantesLayout.createSequentialGroup()
                .addComponent(PnlAtencionVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAtencionVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAtencionVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metodos
    
    /**
     * metodo que veriifca el email en su formato
     * @return regresa regresa la lista de las visitas que se realizaron en el ultimo mes
     */
    public List<VisitaGuiada> consultarVisitasGuiadasMes(){
       return negocio.consultarMes();
    }
    
    /**
     * metodo que veriifca el email en su formato
     * @return regresa la informacion 
     */
public String getItinerarioSeleccionado(){
String itinerarioSeleccionado ="";
int indiceFila = this.tbltinerario.getSelectedRow();
if (indiceFila != -1) {
            int indiceColumnaNombre = 0;
            int indiceColumnaGuia = 3;
            int indiceColumnaFecha = 4;
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tbltinerario.getModel();
            String nombre = (String) modeloTabla.getValueAt(indiceFila, indiceColumnaNombre);
            String guia = (String) modeloTabla.getValueAt(indiceFila, indiceColumnaGuia);
            String fecha = (String) modeloTabla.getValueAt(indiceFila, indiceColumnaFecha);
            itinerarioSeleccionado = nombre+ ", "+guia+", "+fecha; 
            
            return itinerarioSeleccionado;
        } else {
            return null;
        }
}

/**
     * metodo que construye y guarda una queja
     */
public void guardarQueja(){
    Queja queja = new Queja();
    String itinerario = this.getItinerarioSeleccionado();
    String textoQueja = this.campoQueja.getText();
    String email = this.txtEmail.getText();
    String numeroTelefonico = this.txtTelefono.getText();
    String nombre = this.txtNombre.getText();
    
    queja.setItinerario(itinerario);
    queja.setQueja(textoQueja);
    queja.setEmail(email);
    queja.setNumeroTelefonico(numeroTelefonico);
    queja.setNombre(nombre);
    
    boolean seGuardo =negocio.guardarQueja(queja);
    if(seGuardo){
        JOptionPane.showMessageDialog(this, "La queja se a enviado con exito, sera leida y atendida a la brevedad.", "información", JOptionPane.INFORMATION_MESSAGE);
        this.limpiarFormulario();
    }
}

    /**
     * metodo que limpia el formulario
     */
    public void limpiarFormulario(){
        this.campoQueja.setText("");
        this.txtEmail.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tbltinerario.getModel();
         modeloTabla.setRowCount(0);
    }
    
    /**
     * metodo que llena la tabla con la informacion del itinerario al cual se le hará una queja
     *  @param  itinerarios itinerarios de la base de datos que llenara en la tabla
     */
    public void llenarTablaNombreItinerario(List <VisitaGuiada> itinerarios){
        
        List<VisitaGuiada> listaVisitas = itinerarios;
        
         DefaultTableModel modeloTabla = (DefaultTableModel) this.tbltinerario.getModel();
         modeloTabla.setRowCount(0);
         
         listaVisitas.forEach(visita->{
          
         Date fechaVisita = visita.getInicio();
         int anio = fechaVisita.getYear()+1900;
         int mes = fechaVisita.getMonth()+1;
         int dia= fechaVisita.getDate();    
         String fechaFormato = anio+"/"+mes+"/"+dia;
             
         Object[] fila = new Object[5];
         fila[0] = visita.getItinerario().get(0).getNombre();
         fila[1] = visita.getItinerario().get(0).getDiasHorario();
         fila[2] = visita.getItinerario().get(0).getDuracion();
         fila[3] = visita.getGuia().getNombre();
         fila[4] = fechaFormato;
         modeloTabla.addRow(fila);
         });
    }
    
    
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        FrmPrincipal principal = new FrmPrincipal();
        principal.setVisible(true);
        parent.setTitle("Zoológico");
    }//GEN-LAST:event_btnMenuActionPerformed

    
    
    private void btnRegistrarQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarQuejaActionPerformed
        // TODO add your handling code here:
        this.llenarTablaNombreItinerario(this.consultarVisitasGuiadasMes());
    }//GEN-LAST:event_btnRegistrarQuejaActionPerformed

    private void tbltinerarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltinerarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbltinerarioMousePressed

    private void btnEnviarQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarQuejaActionPerformed
        // TODO add your handling code here:
        if(verificarFormulario())
        this.guardarQueja();
      
    }//GEN-LAST:event_btnEnviarQuejaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyReleased

    /**
     * metodo que veriifca los campos de los formularios 
     * @return regresa verdadero en caso que todos los campos sean correctos
     */
    public boolean verificarFormulario(){
        
        if(this.txtEmail.getText().isEmpty() || this.txtTelefono.getText().isEmpty() || this.tbltinerario.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Favor de llenar los campos oblogatorios (E-mail, correo electronico, queja) y de seleccionar un itinerario.", "información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!verificarEmail(this.txtEmail.getText())){
        this.mostrarError("Favor de escribir su correo en el formato: correoejemplo@ejemplo.com.");
            return false;
        } 
        if(!verificarTelefono(this.txtTelefono.getText())){
            this.mostrarError("Favor escribir su numero en el formato ### ### ####");
            return false;
        }
        return true;
    }
    
        /**
     * metodo que muestra un error con el string enviado
     * @param mensaje mensaje a mostrar
     */
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
    }
    
     /**
     * metodo que veriifca el email en su formato
     *  @param  correo  correo por validar
     * @return regresa verdadero en caso de encontrar coincidencia con  el formato especificado
     */
    public boolean verificarEmail(String correo){
    Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    Matcher mat = patron.matcher(correo);
    return mat.find();
    }
    
     /**
     * metodo que veriifca el email en su formato
     *  @param  telefono  telefono por validar
     * @return regresa verdadero en caso de encontrar coincidencia con  el formato especificado
     */
    public boolean verificarTelefono(String telefono){
    Pattern patron = Pattern.compile("^[\\d]{3}[\\s][\\d]{3}[\\s][\\d]{4}");
   
    Matcher mat = patron.matcher(telefono);
    return mat.find();
    
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlAtencionVisitantes;
    private javax.swing.JButton btnEnviarQueja;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistrarQueja;
    private javax.swing.JTextArea campoQueja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDATOS;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblItinerario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblQueja;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAtencionVisitantes;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JScrollPane pnlItinerarios;
    private javax.swing.JTable tbltinerario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
