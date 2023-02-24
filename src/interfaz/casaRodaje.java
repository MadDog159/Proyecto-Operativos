/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import main.Director;
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
import static main.ProjectManager.dias_restantes;

/**
 *
 * @author epidu
 */
public class casaRodaje extends javax.swing.JFrame {
           
           public static boolean iniciar = false;
           int x = 5;
           int maxEmpleadores = 13;
           double GastosTotales;
           double saldo;
           int inicio,creditos,cierre,intro,plot,ensamble;       
           public static int parteInicio,parteCreditos,parteCierre,parteIntro,partePlot;
           public static int CapitulosTotales, Ganancia, GananciaNeta, CapitulosSobrantes, DiasFaltantes;
           int clickInicio;
          
           
           
           public static boolean contador; 
           public static boolean Rick_Morty;
           public static boolean reviews;
           public static boolean verificar;
           public static int faltas;
           public static Semaphore drive_Intro = new Semaphore(Inicio_Sistema.tamanoIntro);
           public static Semaphore drive_Creditos = new Semaphore(Inicio_Sistema.tamanoCreditos);
           public static Semaphore drive_Inicio = new Semaphore(Inicio_Sistema.tamanoInicio);
           public static Semaphore drive_Cierre = new Semaphore(Inicio_Sistema.tamanoCierre);
           public static Semaphore drive_Plot = new Semaphore(Inicio_Sistema.tamanoPlot);
           public static Semaphore drive_Restantes = new Semaphore(1);
           
           public static DefaultListModel<String> modelo = new DefaultListModel();
                                 ProductorIntro pIntro = new ProductorIntro(drive_Intro); 
                                 ProductorCreditos pCreditos = new ProductorCreditos(drive_Creditos); 
                                 ProductorInicio pInicio = new ProductorInicio(drive_Inicio);
                                 ProductorCierre pCierre = new ProductorCierre(drive_Cierre); 
                                 ProductorPlotTwist pPlot = new ProductorPlotTwist(drive_Plot); 
                                 ProjectManager PM = new ProjectManager(drive_Restantes);
                                 Ensambladores Ensamble =  new Ensambladores();
                                 Director Director = new Director(drive_Restantes);
                                 
                                 double gastosIntro = pIntro.pagoSueldos();
                                 double gastosCierre = pCierre.pagoSueldos();
                                 double gastosCreditos = pCreditos.pagoSueldos();
                                 double gastosInicio = pInicio.pagoSueldos();
                                 double gastosPlot = pPlot.pagoSueldos();
                                 double gastosEnsambladores = pPlot.pagoSueldos();
                                 double gastosPM = PM.pagoSueldos();
                                 double gastosDirector = Director.getSueldo();
                                 
                                 
                                 Thread hilo = new Thread(){
//                                            
//                                            public synchronized void suspender(){
//                                                       iniciar = true;
//                                            }
//                                            public synchronized void reanudar(){
//                                                       iniciar = false;
//                                                       notifyAll();
//                                            }
//                                            public synchronized void enSuspension(){
//                                                       while(iniciar){
//                                                                  try {
////                                                                             System.out.println("entre aqui");
//                                                                             wait();
//                                                                  } catch (InterruptedException ex) {
//                                                                             Logger.getLogger(ProductorIntro.class.getName()).log(Level.SEVERE, null, ex);
//                                                                  }
//                                                       }
//                                            }
//                                            
                                            
                                            
                                            public void run(){
//                                                       if(iniciar == true){
//                                                                  suspender();
//                                                       }else{
//                                                                  reanudar();
//                                                       }
                                                       while(!isInterrupted()){
                                                       
//                                                                  System.out.println(iniciar);
                                                                  
//                                                                  System.out.println(iniciar);
//                                                                  enSuspension();
                                                                  
                                                                  
                                                                             
                                                                             try{
//                                                                                        System.out.println(iniciar);
                                                                                        maximo();
                                                                                        minimo();
                                                                                        outputIntro.setText(Integer.toString(pIntro.drive_Intro.availablePermits()));
                                                                                        outputCreditos.setText(Integer.toString(pCreditos.drive_Creditos.availablePermits()));
                                                                                        outputInicio.setText(Integer.toString(pInicio.drive_Inicio.availablePermits()));
                                                                                        outputCierre.setText(Integer.toString(pCierre.drive_Cierre.availablePermits()));
                                                                                        outputPlotTwist.setText(Integer.toString(pPlot.drive_PlotTwist.availablePermits()));
                                                                                        
                                                                                        GastosTotales += gastosIntro + gastosCierre + gastosCreditos + gastosInicio + gastosPlot + gastosEnsambladores + gastosPM + gastosDirector + faltas;
                                                                                        outputGastos.setText(Double.toString(GastosTotales ));
                                                                                        outputCapitulos.setText(Integer.toString(Ensamble.getCapitulos()));
                                                                                        
                                                                                        outputDias_Restantes.setText(Integer.toString(dias_restantes));
                                                                                        saldo += PM.getSueldo();
                                                                                        outputSalarioPM.setText(Double.toString(saldo));
                                                                                        outputFaltas.setText(Integer.toString(faltas));
                                                                                        
                                                                                        
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
                                                                                        if(PM.getDias_restantes() < Inicio_Sistema.dias_entrega){
                                                                                                   if(PM.getDias_restantes()%Inicio_Sistema.periodo_temporadas == 0){
                                                                                                              modelo.addElement(Integer.toString(Ensamble.getCapitulos()));
                                                                                                              Ensamble.setCapitulos(0);
                                                                                                   }
                                                                                        }
                                                                                        
                                                                                       
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        
                                                                                        //System.out.println("disponibilidad: "+ pCierre.drive_Cierre.availablePermits());
//                                                                                        DiasFaltantes = PM.getDias_restantes();
                                                                                        contador = true;
                                                                                        Thread.sleep(1000);
                                                                                        
                                                                                        }catch(InterruptedException e){
                                                                                                   interrupt();
                                                                             
                                                                  }
                                                       }
                                            }
                                 }; 
           
           
           /**
            * Creates new form casaRodaje
            */
           public casaRodaje() {
                      initComponents();
                      outputMAX.setText(Integer.toString(maxEmpleadores));
                      outputLotes.setText(Integer.toString(Inicio_Sistema.periodo_temporadas));
                      PM.setDias_restantes(Inicio_Sistema.dias_entrega);
                      this.setLocationRelativeTo(null);
                      this.setResizable(false);
                      
                      
           }
           
           
           public boolean maximo(){
                      int usoEmpleadores = inicio + creditos + cierre + intro + plot + ensamble;
                      if ( usoEmpleadores> maxEmpleadores){
                                 Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"Maximo de empleadores excedido");
                                 return false;
                      }else{
                                 return true;
                      }
           }
           public boolean minimo(){
                      if ( inicio == 0){
                                 this.Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (creditos == 0){
                                 this.Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (cierre == 0){
                                 this.Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (intro == 0){
                                 this.Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if (plot == 0){
                                 this.Boton_Parar.doClick();
                                 JOptionPane.showMessageDialog(null,"DESPEDIDO, INEFICIENTE, como puedes tener un departamiento sin nadie!!");
                                 return false;
                      }else if(ensamble == 0){
                                 this.Boton_Parar.doClick();
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
                      jScrollPane3 = new javax.swing.JScrollPane();
                      Lista = new javax.swing.JList<>();
                      jScrollPane4 = new javax.swing.JScrollPane();
                      listaTemp = new javax.swing.JList<>();
                      outputGanancias = new javax.swing.JLabel();
                      jButton1 = new javax.swing.JButton();

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
                      getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

                      jLabel10.setText("Project Manager:");
                      getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

                      jLabel11.setText("Director");
                      getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

                      jLabel12.setText("Faltas:");
                      getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

                      jLabel13.setText("Gastos de la planta:");
                      getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 120, -1));

                      jLabel14.setText("Salario:");
                      getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 50, -1));

                      Boton_Parar.setText("Parar");
                      Boton_Parar.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            Boton_PararActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(Boton_Parar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 120, -1));

                      jLabel15.setText("temporadas");
                      getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

                      jLabel16.setText("capitulos producidos:");
                      getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

                      jLabel17.setText("Ganancias Netas:");
                      getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 110, -1));

                      jLabel18.setText("Dias por lotes");
                      getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

                      outputCapitulos.setBackground(new java.awt.Color(204, 255, 255));
                      outputCapitulos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                      outputCapitulos.setText("0");
                      getContentPane().add(outputCapitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 90, 20));

                      outputGastos.setBackground(new java.awt.Color(204, 255, 255));
                      outputGastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                      outputGastos.setText("0");
                      getContentPane().add(outputGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 60, 20));

                      outputCreditos.setBackground(new java.awt.Color(204, 255, 255));
                      outputCreditos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                      outputCreditos.setText("0");
                      getContentPane().add(outputCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 80, 20));

                      outputInicio.setBackground(new java.awt.Color(204, 255, 255));
                      outputInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                      outputInicio.setText("0");
                      getContentPane().add(outputInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 80, 20));

                      outputCierre.setBackground(new java.awt.Color(204, 255, 255));
                      outputCierre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                      outputCierre.setText("0");
                      getContentPane().add(outputCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 80, 20));

                      Boton_Simulacion.setText("Simulacion");
                      Boton_Simulacion.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            Boton_SimulacionActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(Boton_Simulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 120, -1));

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
                      getContentPane().add(outputIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 80, 20));

                      outputPlotTwist.setBackground(new java.awt.Color(204, 255, 255));
                      outputPlotTwist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                      outputPlotTwist.setText("0");
                      getContentPane().add(outputPlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 80, 20));

                      jLabel30.setText("Empleados disponibles: ");
                      getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

                      outputPM.setText("...");
                      getContentPane().add(outputPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 270, -1));

                      outputDias_Restantes.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
                      outputDias_Restantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      outputDias_Restantes.setText("000");
                      getContentPane().add(outputDias_Restantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 60, 30));

                      outputLotes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                      outputLotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      outputLotes.setText("000");
                      getContentPane().add(outputLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 30, -1));

                      outputFaltas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                      outputFaltas.setText("00");
                      getContentPane().add(outputFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 40, -1));

                      outputSalarioPM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                      outputSalarioPM.setText("00");
                      getContentPane().add(outputSalarioPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 50, -1));

                      outputDirector.setText("...");
                      getContentPane().add(outputDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 270, -1));

                      jScrollPane3.setViewportView(Lista);

                      getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 50, 170));

                      listaTemp.setModel(new javax.swing.AbstractListModel<String>() {
                                 String[] strings = { "tem 1", "tem 2", "tem 3", "tem 4", "tem 5", "tem 6", "tem 8", "tem 9", "tem 10" };
                                 public int getSize() { return strings.length; }
                                 public String getElementAt(int i) { return strings[i]; }
                      });
                      jScrollPane4.setViewportView(listaTemp);

                      getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 50, 170));

                      outputGanancias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                      outputGanancias.setText("0");
                      getContentPane().add(outputGanancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 60, -1));

                      jButton1.setText("Terminar");
                      jButton1.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton1ActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 120, -1));

                      pack();
           }// </editor-fold>//GEN-END:initComponents

           private void Boton_PararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_PararActionPerformed
                      //iniciar = true;
                      //ProductorIntro pIntro = new ProductorIntro();
                      this.Boton_Parar.setEnabled(false);
                     
                     this.Boton_Simulacion.setEnabled(true);
                      System.out.println("q cono");
                      System.out.println(iniciar);       
                     
//                                 pIntro.interrupt();
//                                 pCreditos.interrupt();
//                                 pInicio.interrupt();
//                                 pCierre.interrupt();
//                                 pPlot.interrupt();
//                                 Ensamble.interrupt();
//                                 PM.interrupt();
//                                 Director.interrupt();
                                 
                                 if(clickInicio > 0){
                                            pIntro.suspender();
                                            pCreditos.suspender();
                                            pInicio.suspender();
                                            pCierre.suspender();
                                            pPlot.suspender();
                                            Ensamble.suspender();
                                            PM.suspender();
                                            Director.suspender();
                                            hilo.suspend();
                                            iniciar = true;
                                 }
                                 
//                                 System.out.println(iniciar + "33");
                     

                      
                   
           }//GEN-LAST:event_Boton_PararActionPerformed

           private void Boton_SimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_SimulacionActionPerformed
                      // TODO add your handling code here:
                      iniciar = false;
                      this.Boton_Simulacion.setEnabled(false);
                      this.Boton_Parar.setEnabled(true);
                      boolean continuar =this.maximo();
                      boolean minimo = this.minimo();
                      
                      
                      if(continuar == false){
                                 
                      }else if(minimo == false){
                                 
                      }else if (continuar == true){
                                 
                                 Lista.setModel(modelo);

                                 
                                 pIntro.setProductor_Intro((int) Spinner_Intro.getValue());
                                 pCreditos.setProductor_Creditos((int) Spinner_Creditos.getValue());
                                 pInicio.setProductor_Inicio((int) Spinner_Inicio.getValue());
                                 pCierre.setProductor_cierre((int) Spinner_cierre.getValue());
                                 pPlot.setProductor_plottwist((int) Spinner_plottwist.getValue());
                                 Ensamble.setEnsambladores((int) Spinner_ensamble.getValue());
                                 
                                 
                                 
                                 pIntro.introCreada();
                                 pCreditos.creditosCreada();
                                 pInicio.inicioCreada();
                                 pCierre.cierreCreada();
                                 pPlot.plottwistCreada();
                                 
                                 if(clickInicio == 0){
//                                            System.out.println("Claramente entre aqui q pepa");
                                            
                                            System.out.println("entre");
                                            pIntro.start();
                                            pCreditos.start();
                                            pInicio.start();
                                            pCierre.start();
                                            pPlot.start();
                                            Ensamble.start();
                                            PM.start();
                                            Director.start();
                                            hilo.start();
                                 }clickInicio ++;
                                 if(iniciar == false && clickInicio > 0){
//                                            System.out.println(iniciar +"69");
                                            pIntro.reanudar();
                                            pCreditos.reanudar();
                                            pInicio.reanudar();
                                            pCierre.reanudar();
                                            pPlot.reanudar();
                                            Ensamble.reanudar();
                                            PM.reanudar();
                                            Director.reanudar();
                                            hilo.resume();
                                 }
                                 
                                 
                                 
                                 

                                         
                                 
                                 
                                 
                                 
                                 
                                 
                      }
                      
           }//GEN-LAST:event_Boton_SimulacionActionPerformed

           private void Spinner_IntroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_IntroStateChanged
                      // TODO add your handling code here:
                      intro = (int) Spinner_Intro.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_IntroStateChanged

           private void Spinner_CreditosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_CreditosStateChanged
                      // TODO add your handling code here:
                      creditos = (int) Spinner_Creditos.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_CreditosStateChanged

           private void Spinner_InicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_InicioStateChanged
                      // TODO add your handling code here:
                      inicio = (int) Spinner_Inicio.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_InicioStateChanged

           private void Spinner_cierreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_cierreStateChanged
                      // TODO add your handling code here:
                      cierre = (int) Spinner_cierre.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_cierreStateChanged

           private void Spinner_plottwistStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_plottwistStateChanged
                      // TODO add your handling code here:
                      plot = (int) Spinner_plottwist.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_plottwistStateChanged

           private void Spinner_ensambleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_ensambleStateChanged
                      // TODO add your handling code here:
                      ensamble = (int) Spinner_ensamble.getValue();
                      this.Boton_Parar.doClick();
           }//GEN-LAST:event_Spinner_ensambleStateChanged

           private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                      // TODO add your handling code here:
                     this.Boton_Parar.setEnabled(false);
                     Director.GananciasNetas();
                     outputGanancias.setText(Integer.toString(GananciaNeta));
                     outputSalarioPM.setText(Double.toString(saldo -=  faltas));
                     
                                 pIntro.interrupt();
                                 pCreditos.interrupt();
                                 pInicio.interrupt();
                                 pCierre.interrupt();
                                 pPlot.interrupt();
                                 Ensamble.interrupt();
                                 PM.interrupt();
                                 Director.interrupt();
           }//GEN-LAST:event_jButton1ActionPerformed

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
                                            new casaRodaje().setVisible(true);
                                 }
                      });
           }

           // Variables declaration - do not modify//GEN-BEGIN:variables
           private javax.swing.JButton Boton_Parar;
           private javax.swing.JButton Boton_Simulacion;
           private javax.swing.JList<String> Lista;
           private javax.swing.JSpinner Spinner_Creditos;
           private javax.swing.JSpinner Spinner_Inicio;
           private javax.swing.JSpinner Spinner_Intro;
           private javax.swing.JSpinner Spinner_cierre;
           private javax.swing.JSpinner Spinner_ensamble;
           private javax.swing.JSpinner Spinner_plottwist;
           private javax.swing.JButton jButton1;
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
           private javax.swing.JScrollPane jScrollPane3;
           private javax.swing.JScrollPane jScrollPane4;
           private javax.swing.JTabbedPane jTabbedPane1;
           private javax.swing.JList<String> listaTemp;
           private javax.swing.JLabel outputCapitulos;
           private javax.swing.JLabel outputCierre;
           private javax.swing.JLabel outputCreditos;
           private javax.swing.JLabel outputDias_Restantes;
           public static javax.swing.JLabel outputDirector;
           private javax.swing.JLabel outputFaltas;
           private javax.swing.JLabel outputGanancias;
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
