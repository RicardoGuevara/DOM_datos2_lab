/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import models.Cont;
import models.Node;
import models.Tree;

/**
 *
 * @author rick
 */
public class UserGUI extends javax.swing.JFrame {

    /**
     * Creates new form UserGUI
     */
    public UserGUI() {
        initComponents();
        tree_panel.setBackground(Color.white);
        dns.setText(getDefaultTestText());
    }

    private String getDefaultTestText()
    {
        try {
            java.io.File file = new java.io.File("paginarealnofeik.html");
            return "file://"+file.getAbsolutePath();
        } catch (Exception e) 
        {
            System.out.println("Error de archivo");
            e.printStackTrace();
            return "no fué posible encontrar la página de test por defecto";
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphTree = new javax.swing.JPanel();
        dns = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        labels_original = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labels_parsed = new javax.swing.JTextArea();
        tree_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visual_conts = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graphTree.setPreferredSize(new java.awt.Dimension(550, 550));

        javax.swing.GroupLayout graphTreeLayout = new javax.swing.GroupLayout(graphTree);
        graphTree.setLayout(graphTreeLayout);
        graphTreeLayout.setHorizontalGroup(
            graphTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        graphTreeLayout.setVerticalGroup(
            graphTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("DNS / IP :");

        jButton1.setText("vamos!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labels_original.setEditable(false);
        labels_original.setColumns(20);
        labels_original.setRows(5);
        labels_original.setPreferredSize(new java.awt.Dimension(270, 238));
        jScrollPane3.setViewportView(labels_original);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Original", jPanel4);

        labels_parsed.setEditable(false);
        labels_parsed.setColumns(20);
        labels_parsed.setRows(5);
        labels_parsed.setPreferredSize(new java.awt.Dimension(261, 238));
        jScrollPane2.setViewportView(labels_parsed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Gerarquía de etiquetas", jPanel3);

        javax.swing.GroupLayout tree_panelLayout = new javax.swing.GroupLayout(tree_panel);
        tree_panel.setLayout(tree_panelLayout);
        tree_panelLayout.setHorizontalGroup(
            tree_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        tree_panelLayout.setVerticalGroup(
            tree_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONCURRENCIA DE ETIQUETAS:");

        jScrollPane1.setViewportView(visual_conts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dns)
                .addGap(1, 1, 1)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tree_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graphTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphTree, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tree_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        tree = DOM.default_extract(dns.getText());
        tree.printTree();
        run_0.run();
        run_1.run();
        run_2.run();
        try 
        {
            Thread.sleep(100); // wait jtree repaint before tree-draw repainting
        }
        catch (InterruptedException ex) 
        {
            System.out.println("error in waiting :"); ex.printStackTrace();
        }
        run_3.run();
        run_4.run();

    }//GEN-LAST:event_jButton1ActionPerformed

    //THREADS
    
    Runnable run_0 = new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    fill_original();
                } 
                catch (IOException ex) 
                {
                    System.out.println("error de archivo");
                    ex.printStackTrace();
                }
            }
        };
    
    Runnable run_1 = new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    fill_labels();
                } 
                catch (IOException ex) 
                {
                    System.out.println("error de archivo");
                    ex.printStackTrace();
                }
            }
        };
    
    Runnable run_2 = new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    tree_panel.removeAll();
                    fill_tree();
                } 
                catch (IOException ex) 
                {
                    System.out.println("error de archivo");
                    ex.printStackTrace();
                }
            }
        };
    
    Runnable run_3 = new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    //drawDefaultTree();
                    draw_tree();
                } 
                catch (Exception ex) 
                {
                    System.out.println("error de archivo");
                    ex.printStackTrace();
                }
            }
        };
    
    Runnable run_4 = new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    //drawDefaultTree();
                    show_conts(tree.components_conts());
                } 
                catch (Exception ex) 
                {
                    System.out.println("error de archivo");
                    ex.printStackTrace();
                }
            }
        };
    
    
    //METHODS___________________________________________________________________
    
    private void show_conts(ArrayList<models.Cont> conts)
    {
        System.out.println("contadores: "+conts);
        
        DefaultListModel lista = new DefaultListModel();
        for (Cont cont : conts) 
        {
            lista.addElement(cont.toString());
        }
        visual_conts.setModel(lista);
    }
    
    private void fill_original() throws java.io.IOException
    {
        labels_original.setText("");
        BufferedReader bs = new BufferedReader(new java.io.FileReader("codigo_fuente"));
        String txt;
        while((txt= bs.readLine()) !=null) labels_original.append(txt+"\n"); 
        bs.close();
    }
    
    private void fill_labels() throws java.io.IOException
    {
        labels_parsed.setText("");
        BufferedReader bs = new BufferedReader(new java.io.FileReader("paginareal"));
        String txt;
        while((txt= bs.readLine()) !=null) labels_parsed.append(txt+"\n"); 
        bs.close();
    }
    
    private void fill_tree() throws java.io.IOException
    {
        javax.swing.JTree kill_me_pls =new javax.swing.JTree(get_tree_base(new java.io.File("paginareal")));
//        kill_me_pls.setBounds(tree_panel.getBounds());
//        kill_me_pls.setVisible(true);
//        tree_panel.add(kill_me_pls);
            
        tree_panel.add(new Arb_pane(kill_me_pls,tree_panel.getBounds()));
        tree_panel.repaint();
            
    }
    
    int grado_maximo,
        altura_raiz;
    
    private void draw_tree() throws java.io.IOException
    {
        //graphTree.revalidate();
        //graphTree.repaint();
        grado_maximo = tree.maxGrado();
        altura_raiz = tree.altura();
        
        Tree.m_g = 0; // restaurar valor de grado máximo estático
        
        // -> debug
            System.out.println("\naltura: "+altura_raiz+"\ngrado: "+grado_maximo);
        // <- debug
        
        
        Graphics g = graphTree.getGraphics();
        g.setColor(Color.white);
        g.fillRect(graphTree.getX(),graphTree.getY(),graphTree.getWidth(),graphTree.getHeight());
        
        recursiveDraw(tree.getRoot(),new Point(0,0));
        
    }
    
    private void recursiveDraw(Node node,Point ant)
    {
        int y= (graphTree.getHeight()/altura_raiz)*node.getNivel(), // error, siempre va a ser 0
            x= (int) ((graphTree.getWidth()/(int)Math.pow(grado_maximo,node.getNivel()))*node.getHorizontal());
        Point antpos;
        System.out.println("posicion del nodo: "+node.getLabel_name()+" "+x+" , "+y);
        
        Point p = new Point(x,y);
        
        draw_point(p);
        for (Node subNode : node.subNodes) {
            draw_line(p,ant);
            recursiveDraw(subNode,p);
        }
        //antpos= p;
    }
    
    int diameter = 10;
    
    void draw_point (Point p)
    {
        Graphics g = graphTree.getGraphics();
        g.setColor(Color.red);
        g.fillOval((int)p.getX(), (int)p.getY(), diameter, diameter);
        //this.repaint();
    }
    
    void draw_line (Point p,Point antpos)
    {
        Graphics g = graphTree.getGraphics();
        g.setColor(Color.BLUE);
        g.drawLine((int)p.getX()+diameter/2, (int)p.getY()+diameter/2, (int)antpos.getX()+diameter/2, (int)antpos.getY()+diameter/2);
        //this.repaint();
    }
    
    private DefaultMutableTreeNode get_tree_base(java.io.File file)
    {
        System.out.println("generando jtree....");
        ArrayList<DefaultMutableTreeNode> aperturas = new ArrayList<>();
        //Node    root = new Node("root"),
        //        temp;
        //aperturas.add(root);
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
            String txt;
            while((txt = reader.readLine()) != null){
                
                System.out.println("2 lectura: "+txt);
                
                if(txt.contains("!DOCTYPE")||txt.contains("!doctype")|| txt.contains("br")|| txt.contains("nobr")){continue;}
                if(txt.equals("html")){aperturas.add(new DefaultMutableTreeNode("html"));continue;}
                if(txt.startsWith("/")){
                    //temp = aperturas.remove(aperturas.size()-1);
                    System.out.println("2 cierre "+aperturas.get(aperturas.size()-1));
                    (aperturas.get(aperturas.size()-2)).add(aperturas.remove(aperturas.size()-1));
                    
                }
                else{
                    aperturas.add(new DefaultMutableTreeNode(txt));
                    System.out.println("2 apertura "+aperturas.get(aperturas.size()-1));
                }
                System.out.println(aperturas);
                //(new Tree(aperturas.get(aperturas.size()-1))).printTree();
            }
            reader.close();
        } 
        catch (java.io.IOException ioe) {
            System.out.println("Error de archvo");
            ioe.printStackTrace();
        }
        catch(IndexOutOfBoundsException e)
        {
            return aperturas.get(0);
        }
        catch (Exception e){
            System.out.println("Error de ejecución:");
            e.printStackTrace();
        }
        
        while(aperturas.size()>1){
            (aperturas.get(aperturas.size()-2)).add(aperturas.remove(aperturas.size()-1));
        }
        
        return aperturas.get(0);
    }
    
    
    
    //AUTOGENERADO______________________________________________________________
    
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
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserGUI().setVisible(true);
            }
        });
    }

    public static models.Tree tree;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dns;
    private javax.swing.JPanel graphTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea labels_original;
    private javax.swing.JTextArea labels_parsed;
    private javax.swing.JPanel tree_panel;
    private javax.swing.JList<String> visual_conts;
    // End of variables declaration//GEN-END:variables
}

class Arb_pane extends javax.swing.JPanel
{
    public Arb_pane(JTree arbol, Rectangle space)
    {
        space.setLocation(0, 0);
        setLayout(new BorderLayout());
        arbol.setVisible(true);
        arbol.setBounds(space);
        add(arbol,BorderLayout.NORTH);
        setVisible(true);
        setBounds(space);
        
        arbol.addMouseListener(new java.awt.event.MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                setBounds(space);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
    }
}