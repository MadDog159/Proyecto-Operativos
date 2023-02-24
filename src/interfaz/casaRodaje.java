/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import main.Ensambladores;
import static main.Ensambladores.capitulo_creado;
import static main.Ensambladores.capitulo_creadoPlot;
import static main.Ensambladores.reducir_Plot;
import main.ProductorCierre;
import main.ProductorCreditos;
import main.ProductorInicio;
import main.ProductorIntro;
import main.ProductorPlotTwist;
import main.ProjectManager;



/**
 *
 * @author epidu
 */
public class casaRodaje extends javax.swing.JFrame {
           boolean iniciar = true;
           int x = 5;
           int maxEmpleadores = 13;
           double GastosTotales;
           double saldo;
           int inicio,creditos,cierre,intro,plot,ensamble;       
           public static int parteInicio,parteCreditos,parteCierre,parteIntro,partePlot;
           
           public static boolean contador; 
           public static boolean Rick_Morty;
           public static boolean reviews;
           public static Semaphore drive_Intro = new Semaphore(Inicio_Sistema.tamanoIntro);
           public static Semaphore drive_Creditos = new Semaphore(Inicio_Sistema.tamanoCreditos);
           public static Semaphore drive_Inicio = new Semaphore(Inicio_Sistema.tamanoInicio);
           public static Semaphore drive_Cierre = new Semaphore(Inicio_Sistema.tamanoCierre);
           public static Semaphore drive_Plot = new Semaphore(Inicio_Sistema.tamanoPlot);
           
           public static Semaphore drive_Restantes = new Semaphore(1);
           
           
           /**
            * Creates new form casaRodaje
            */
            private int maxDriveCierre;
            private int duracionDias;
            private int diasEntreLanzamientos;
            private int maxDriveCreditos;
            private int maxDriveInicio;
            private int maxDriveIntro;
            private int maxDrivePlotTwist;
            private int inicProdCierre;
            private int inicProdCreditos;
            private int inicProdInicio;
            private int inicProdIntro;
            private int inicProdPlotTwist;    
            private int inicEnsambladores;
            
           public casaRodaje(int maxDriveCierre, int diasEntreLanzamientos, int duracionDias, int inicProdCierre, int inicProdCreditos,
                            int inicProdInicio, int inicProdIntro, int inicProdPlotTwist, int maxDriveCreditos, int maxDriveInicio,
                            int maxDriveIntro, int maxDrivePlotTwist, int inicEnsambladores) {
               super();       
               initComponents();
                      outputMAX.setText(Integer.toString(maxEmpleadores));
                      outputLotes.setText(Integer.toString(Inicio_Sistema.periodo_temporadas));
                      this.setLocationRelativeTo(null);
                      this.setResizable(false);
                      this.maxDriveCierre = maxDriveCierre;
                    this.duracionDias = duracionDias;
                    this.diasEntreLanzamientos = diasEntreLanzamientos;
                    this.maxDriveCreditos = maxDriveCreditos;
                    this.maxDriveInicio = maxDriveInicio;
                    this.maxDriveIntro = maxDriveIntro;
                    this.maxDrivePlotTwist = maxDrivePlotTwist;
                    this.inicProdCierre = inicProdCierre;
                    this.inicProdCreditos = inicProdCreditos;
                    this.inicProdInicio = inicProdInicio;
                    this.inicProdIntro = inicProdIntro;
                    this.inicProdPlotTwist = inicProdPlotTwist;
                    this.inicEnsambladores = inicEnsambladores;
                    Spinner_Intro.setValue(inicProdIntro);
                    Spinner_Creditos.setValue(inicProdCreditos);
                    Spinner_Inicio.setValue(inicProdInicio);
                    Spinner_cierre.setValue(inicProdCierre);
                    Spinner_plottwist.setValue(inicProdPlotTwist);
                    Spinner_ensamble.setValue(inicEnsambladores);
                    System.out.println("esto es max drive cierreÑ " + this.maxDriveCierre);
                    System.out.println("esto es duracion de dias " + this.duracionDias);
                    System.out.println("esto es inicProdIntro " + this.inicProdIntro);
                    System.out.println("esto es inic ensamb " + this.inicEnsambladores);
                    
   
           }
           
           
           public boolean maximo(){
                      int usoEmpleadores = inicio + creditos + cierre + intro + plot + ensamble;
                      if ( usoEmpleadores> maxEmpleadores){
                                 JOptionPane.showMessageDialog(null,"Maximo de empleadores excedido");
                                 return false;
                      }else{
                                 return true;
                      }
           }
           public boolean minimo(){
                      if ( inicio == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (creditos == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (cierre == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (intro == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (plot == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if(ensamble == 0){
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else{
                                 return true;
                      }
           }

           /**
            * This method is called from within the constructor to initialize
            * the form. WARNING: Do NOT modify this code. The content of this
            * method is always regenerated by the Form Editor.
            */
           @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Spinner_plottwist = new javax.swing.JSpinner();
        Spinner_Intro = new javax.swing.JSpinner();
        Spinner_Inicio = new javax.swing.JSpinner();
        Spinner_cierre = new javax.swing.JSpinner();
        outputMAX = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Spinner_ensamble = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Boton_Parar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextPane16 = new javax.swing.JTextPane();
        jLabel18 = new javax.swing.JLabel();
        outputCapitulos = new javax.swing.JLabel();
        outputGastos = new javax.swing.JLabel();
        outputCreditos = new javax.swing.JLabel();
        outputInicio = new javax.swing.JLabel();
        outputCierre = new javax.swing.JLabel();
        Boton_Simulacion = new javax.swing.JButton();
        Spinner_Creditos = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        outputIntro = new javax.swing.JLabel();
        outputPlotTwist = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        outputPM = new javax.swing.JLabel();
        outputDias_Restantes = new javax.swing.JLabel();
        outputLotes = new javax.swing.JLabel();
        outputFaltas = new javax.swing.JLabel();
        outputSalarioPM = new javax.swing.JLabel();
        outputDirector = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jLabel28.setText("jLabel28");

        jLabel29.setText("jLabel29");

        jMenu1.setText("jMenu1");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 138, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Casa de Rodaje Game of Thrones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 340, 30));

        jLabel2.setText("Intro");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, -1));

        jLabel3.setText("creditos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setText("inicio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel5.setText("cierre");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel6.setText("plot twist");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        Spinner_plottwist.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_plottwist.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_plottwistStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_plottwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 50, -1));

        Spinner_Intro.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_Intro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_IntroStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_Intro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, -1));

        Spinner_Inicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_Inicio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_InicioStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, -1));

        Spinner_cierre.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_cierre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_cierreStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_cierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 50, -1));

        outputMAX.setText("0");
        getContentPane().add(outputMAX, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 40, -1));

        jLabel8.setText("ensambladores");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        Spinner_ensamble.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_ensamble.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_ensambleStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_ensamble, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 50, -1));

        jLabel9.setText("Dias hasta la entrega");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        jLabel10.setText("Project Manager:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel11.setText("Director");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jLabel12.setText("Faltas:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel13.setText("Gastos de la planta:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 120, -1));

        jLabel14.setText("Salario:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 50, -1));

        Boton_Parar.setText("Parar");
        Boton_Parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_PararActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Parar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 120, -1));

        jLabel15.setText("temporadas");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        jLabel16.setText("capitulos producidos:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel17.setText("Recaudado en ventas:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 130, -1));

        jScrollPane16.setViewportView(jTextPane16);

        getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 60, -1));

        jLabel18.setText("Dias por lotes");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        outputCapitulos.setBackground(new java.awt.Color(204, 255, 255));
        outputCapitulos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputCapitulos.setText("0");
        getContentPane().add(outputCapitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 90, 20));

        outputGastos.setBackground(new java.awt.Color(204, 255, 255));
        outputGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputGastos.setText("0");
        getContentPane().add(outputGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 60, 20));

        outputCreditos.setBackground(new java.awt.Color(204, 255, 255));
        outputCreditos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputCreditos.setText("0");
        getContentPane().add(outputCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 90, 20));

        outputInicio.setBackground(new java.awt.Color(204, 255, 255));
        outputInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputInicio.setText("0");
        getContentPane().add(outputInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 90, 20));

        outputCierre.setBackground(new java.awt.Color(204, 255, 255));
        outputCierre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputCierre.setText("0");
        getContentPane().add(outputCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 90, 20));

        Boton_Simulacion.setText("Simulacion");
        Boton_Simulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_SimulacionActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Simulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 120, -1));

        Spinner_Creditos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        Spinner_Creditos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_CreditosStateChanged(evt);
            }
        });
        getContentPane().add(Spinner_Creditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("40 GB /");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 50, 20));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("disponible");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 20));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("25 GB /");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 70, 20));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("50 GB /");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 50, 20));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("55 GB /");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, 20));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("30 GB /");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 70, 20));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("maxima");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 70, 20));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("memoria ");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 60, 20));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("capacidad");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 70, 20));

        outputIntro.setBackground(new java.awt.Color(204, 255, 255));
        outputIntro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputIntro.setText("0");
        getContentPane().add(outputIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 90, 20));

        outputPlotTwist.setBackground(new java.awt.Color(204, 255, 255));
        outputPlotTwist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputPlotTwist.setText("0");
        getContentPane().add(outputPlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 90, 20));

        jLabel30.setText("Empleados disponibles: ");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        outputPM.setText("...");
        getContentPane().add(outputPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 250, -1));

        outputDias_Restantes.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        outputDias_Restantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputDias_Restantes.setText("000");
        getContentPane().add(outputDias_Restantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 60, 30));

        outputLotes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        outputLotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLotes.setText("000");
        getContentPane().add(outputLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 30, -1));

        outputFaltas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        outputFaltas.setText("00");
        getContentPane().add(outputFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 40, -1));

        outputSalarioPM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        outputSalarioPM.setText("00");
        getContentPane().add(outputSalarioPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 50, -1));

        outputDirector.setText("...");
        getContentPane().add(outputDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

           private void Boton_PararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_PararActionPerformed
                      //iniciar = true;
                      //ProductorIntro pIntro = new ProductorIntro();
                      
                   
           }//GEN-LAST:event_Boton_PararActionPerformed

           private void Boton_SimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_SimulacionActionPerformed
                      // TODO add your handling code here:
                      boolean continuar =this.maximo();
                      boolean minimo = this.minimo();
                      
                      if(continuar == false){
                                 
                      }else if(minimo == false){
                                 
                      }else if (continuar == true){
                                 
                                 ProductorIntro pIntro = new ProductorIntro(drive_Intro); 
                                 ProductorCreditos pCreditos = new ProductorCreditos(drive_Creditos); 
                                 ProductorInicio pInicio = new ProductorInicio(drive_Inicio);
                                 ProductorCierre pCierre = new ProductorCierre(drive_Cierre); 
                                 ProductorPlotTwist pPlot = new ProductorPlotTwist(drive_Plot); 
                                 ProjectManager PM = new ProjectManager(drive_Restantes);
                                 Ensambladores Ensamble =  new Ensambladores();
                                 
                                 
                                 iniciar = true;
                                 this.Boton_Simulacion.setEnabled(false);
                                 pIntro.setProductor_Intro((int) Spinner_Intro.getValue());
                                 pCreditos.setProductor_Creditos((int) Spinner_Creditos.getValue());
                                 pInicio.setProductor_Inicio((int) Spinner_Inicio.getValue());
                                 pCierre.setProductor_cierre((int) Spinner_cierre.getValue());
                                 pPlot.setProductor_plottwist((int) Spinner_plottwist.getValue());
                                 Ensamble.setEnsambladores((int) Spinner_ensamble.getValue());
                                 PM.setDias_restantes(Inicio_Sistema.dias_entrega);
                                 
                                 
                                 pIntro.introCreada();
                                 pCreditos.creditosCreada();
                                 pInicio.inicioCreada();
                                 pCierre.cierreCreada();
                                 pPlot.plottwistCreada();
                                 
                                 pIntro.start();
                                 pCreditos.start();
                                 pInicio.start();
                                 pCierre.start();
                                 pPlot.start();
                                 Ensamble.start();
                                 PM.start();
                                 
                                 double gastosIntro = pIntro.pagoSueldos();
                                 double gastosCierre = pCierre.pagoSueldos();
                                 double gastosCreditos = pCreditos.pagoSueldos();
                                 double gastosInicio = pInicio.pagoSueldos();
                                 double gastosPlot = pPlot.pagoSueldos();
                                 double gastosEnsambladores = pPlot.pagoSueldos();
                                 double gastosPM = PM.pagoSueldos();
                                 
                                 
                                         
                                 Thread hilo = new Thread(){
                                 public void run(){                               
                                            for( ; ;){
                                                       if(iniciar == true){
                                                                  try{                                          
                                                                             outputIntro.setText(Integer.toString(pIntro.drive_Intro.availablePermits()));
                                                                             outputCreditos.setText(Integer.toString(pCreditos.drive_Creditos.availablePermits()));
                                                                             outputInicio.setText(Integer.toString(pInicio.drive_Inicio.availablePermits()));
                                                                             outputCierre.setText(Integer.toString(pCierre.drive_Cierre.availablePermits()));
                                                                             outputPlotTwist.setText(Integer.toString(pPlot.drive_PlotTwist.availablePermits()));
                                                                             
                                                                             outputGastos.setText(Double.toString(GastosTotales += gastosIntro + gastosCierre + gastosCreditos + gastosInicio + gastosPlot + gastosEnsambladores + gastosPM ));
                                                                             outputCapitulos.setText(Integer.toString(Ensamble.getCapitulos()));
                                                                             outputDias_Restantes.setText(Integer.toString(PM.getDias_restantes()));
                                                                             outputSalarioPM.setText(Double.toString(saldo+= PM.getSueldo() ));
                                                                             
                                                                             
                                                                             if(Rick_Morty == true){
                                                                                        outputPM.setText("Viendo Rick y Morty");
                                                                             }
                                                                             else if(reviews == true){
                                                                                        outputPM.setText("Revisando reviews");
                                                                             }
                                                                             
                                                                             parteIntro = Inicio_Sistema.tamanoIntro - pIntro.drive_Intro.availablePermits();
                                                                             parteInicio = Inicio_Sistema.tamanoInicio - pInicio.drive_Inicio.availablePermits();
                                                                             parteCierre= Inicio_Sistema.tamanoCierre - pCierre.drive_Cierre.availablePermits();
                                                                             parteCreditos = Inicio_Sistema.tamanoCreditos - pCreditos.drive_Creditos.availablePermits();
                                                                             partePlot = Inicio_Sistema.tamanoPlot - pPlot.drive_PlotTwist.availablePermits();
                                                                             
                                                                            
                                                                             
                                                                             if(parteIntro > 0 && parteInicio > 0 && parteCierre > 0 && parteCreditos > 0 ){
                                                                                        
                                                                                        capitulo_creado = true;
                                                                                        if((int)Ensamble.getCapitulos() >= x && partePlot >0){
                                                                                                   capitulo_creadoPlot = true;
                                                                                                   x += 5;
                                                                                                   
                                                                                        }       
                                                                             }
                                                                             
                                                                             for(int i=0; i < Ensamble.getCapCreados();i++){
                                                                                        pIntro.reducir();
                                                                                        pInicio.reducir();
                                                                                        pCierre.reducir();
                                                                                        pCreditos.reducir();
                                                                                        if(reducir_Plot == true ){
                                                                                                   pPlot.reducir();
                                                                                                   reducir_Plot = false;
                                                                                        }
                                                                                        
                                                                             }
                                                                            
                                                                             
                                                                             
                                                                             
                                                                             
                                                                             
                                                                             //System.out.println("disponibilidad: "+ pCierre.drive_Cierre.availablePermits());
                                                                             contador = true;
                                                                             Thread.sleep(1000);
                                                                             
                                                                  }catch(InterruptedException e){
                                                                            
                                                                  }
                                                       }
                                            }
                                 }
                      };hilo.start();
                      }
                      
           }//GEN-LAST:event_Boton_SimulacionActionPerformed

           private void Spinner_IntroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_IntroStateChanged
                      // TODO add your handling code here:
                      intro = (int) Spinner_Intro.getValue();
           }//GEN-LAST:event_Spinner_IntroStateChanged

           private void Spinner_CreditosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_CreditosStateChanged
                      // TODO add your handling code here:
                      creditos = (int) Spinner_Creditos.getValue();
           }//GEN-LAST:event_Spinner_CreditosStateChanged

           private void Spinner_InicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_InicioStateChanged
                      // TODO add your handling code here:
                      inicio = (int) Spinner_Inicio.getValue();
           }//GEN-LAST:event_Spinner_InicioStateChanged

           private void Spinner_cierreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_cierreStateChanged
                      // TODO add your handling code here:
                      cierre = (int) Spinner_cierre.getValue();
           }//GEN-LAST:event_Spinner_cierreStateChanged

           private void Spinner_plottwistStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_plottwistStateChanged
                      // TODO add your handling code here:
                      plot = (int) Spinner_plottwist.getValue();
           }//GEN-LAST:event_Spinner_plottwistStateChanged

           private void Spinner_ensambleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_ensambleStateChanged
                      // TODO add your handling code here:
                      ensamble = (int) Spinner_ensamble.getValue();
           }//GEN-LAST:event_Spinner_ensambleStateChanged

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
                                 java.util.logging.Logger.getLogger(casaRodaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                      } catch (InstantiationException ex) {
                                 java.util.logging.Logger.getLogger(casaRodaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                      } catch (IllegalAccessException ex) {
                                 java.util.logging.Logger.getLogger(casaRodaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                                 java.util.logging.Logger.getLogger(casaRodaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                      }
                      //</editor-fold>

                      /* Create and display the form */
                      java.awt.EventQueue.invokeLater(new Runnable() {
                                 public void run() {
                                    /*new casaRodaje(this.maxDriveCierre, this.diasEntreLanzamientos, this.duracionDias, this.inicProdCierre, this.inicProdCreditos,
                                            this.inicProdInicio, this.inicProdIntro, this.inicProdPlotTwist, this.maxDriveCierre, this.maxDriveCreditos, this.maxDriveInicio,
                                            this.maxDriveIntro, this.maxDrivePlotTwist).setVisible(true);*/
                                 }
                      });
           }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Parar;
    private javax.swing.JButton Boton_Simulacion;
    private javax.swing.JSpinner Spinner_Creditos;
    private javax.swing.JSpinner Spinner_Inicio;
    private javax.swing.JSpinner Spinner_Intro;
    private javax.swing.JSpinner Spinner_cierre;
    private javax.swing.JSpinner Spinner_ensamble;
    private javax.swing.JSpinner Spinner_plottwist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane16;
    private javax.swing.JLabel outputCapitulos;
    private javax.swing.JLabel outputCierre;
    private javax.swing.JLabel outputCreditos;
    private javax.swing.JLabel outputDias_Restantes;
    private javax.swing.JLabel outputDirector;
    private javax.swing.JLabel outputFaltas;
    private javax.swing.JLabel outputGastos;
    private javax.swing.JLabel outputInicio;
    private javax.swing.JLabel outputIntro;
    private javax.swing.JLabel outputLotes;
    private javax.swing.JLabel outputMAX;
    public static javax.swing.JLabel outputPM;
    private javax.swing.JLabel outputPlotTwist;
    private javax.swing.JLabel outputSalarioPM;
    // End of variables declaration//GEN-END:variables
}
