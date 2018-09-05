/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author rick
 */
public class Tree {

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
    }
    
//METHODS_______________________________________________________________________

    public void printTree(){
        recursivePrint(this.root,0);
    }
    
    private void recursivePrint(Node node,int identation){
        for (int i = 0; i < identation; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getLabel_name());
        for (Node subNode : node.subNodes) {
            recursivePrint(subNode,++identation);
            identation--;
        }
    }
    
    public static Tree parseTree(String filename){
        return parseTree(new java.io.File(filename));
    }
    
    public static Tree parseTree(java.io.File file){
        
        ArrayList<Node> aperturas = new ArrayList<>();
        //Node    root = new Node("root"),
        //        temp;
        //aperturas.add(root);
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
            String txt;
            while((txt = reader.readLine()) != null){
                
                System.out.println("lectura: "+txt);
                
                if(txt.contains("!DOCTYPE")||txt.contains("!doctype")|| txt.contains("br")|| txt.contains("nobr")){continue;}
                if(txt.equals("html")){aperturas.add(new Node("html"));continue;}
                if(txt.startsWith("/")){
                    //temp = aperturas.remove(aperturas.size()-1);
                    System.out.println("cierre "+aperturas.get(aperturas.size()-1));
                    (aperturas.get(aperturas.size()-2)).add(aperturas.remove(aperturas.size()-1));
                    
                }
                else{
                    aperturas.add(new Node(txt));
                    aperturas.get(aperturas.size()-1).setNivel(aperturas.size()-1);
                    System.out.println("apertura "+aperturas.get(aperturas.size()-1));
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
            while(aperturas.size()>1){
                (aperturas.get(aperturas.size()-2)).add(aperturas.remove(aperturas.size()-1));
            }
            return new Tree(aperturas.get(0));
        }
        catch (Exception e){
            System.out.println("Error de ejecución:");
            e.printStackTrace();
        }
        
        while(aperturas.size()>1){
            (aperturas.get(aperturas.size()-2)).add(aperturas.remove(aperturas.size()-1));
        }
        
        return new Tree(aperturas.get(0));
    } 
    
    public int altura()
    {
        return altura(this.root);
    }
    
    private int altura(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        
        if(node.subNodes == null || node.subNodes.isEmpty())
        {
            return 1;
        }
        
        int control=-1,temp;
        for (Node subNode : node.subNodes) 
        {
            temp=altura(subNode);
            if (temp>control) {
                control= temp;
            }
        }
        return 1+control;
    }
    
    public int maxGrado()
    {
        maxGrado(this.root);
        return m_g;
    }
    
    public static int m_g=0;
    private void maxGrado(Node node)
    {
        if(node.subNodes.size()>m_g) m_g = node.subNodes.size();
        for (Node subNode : node.subNodes) 
        {
            maxGrado(subNode);
        }
    }
    
    ArrayList<Cont> conts;
    public ArrayList<Cont> components_conts()
    {
        conts = new ArrayList<models.Cont>();
        contar(this.root);
        return conts;
    }
    
    private void contar(Node node)
    {
        if(!search_and_up(node.getLabel_name()))
        {
            conts.add(new Cont(node.getLabel_name()));
        }
        
        for (Node subNode : node.subNodes) 
        {
            contar(subNode);
        }
    }
    
    private boolean search_and_up(String s)
    {
        for (Cont cont : conts) 
        {
            if (cont.getName().equals(s)) {
                cont.up();
                return true;
            }
        }
        return false;
    }
    
//ATRIB_________________________________________________________________________    
    
    private Node root;

    public static int getM_g() {
        return m_g;
    }

    public static void setM_g(int m_g) {
        Tree.m_g = m_g;
    }
    
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    
}