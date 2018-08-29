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
        
    }
    
    public static Tree parseTree(java.io.File file){
        
        ArrayList<Node> aperturas = new ArrayList<>();
        Node    root = new Node("root"),
                temp;
        
        int control=0;
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
            String txt;
            while((txt = reader.readLine()) != null){
                if(txt.contains("!doctype")){continue;}
                if(txt.equals("html")){temp = new Node("html"); root.add(temp);}
                if(txt.endsWith("/")){
                    temp = aperturas.remove(aperturas.size());
                    aperturas.get(aperturas.size()).add(temp);
                }
                else{
                    aperturas.add(new Node(txt));
                }
            }
            reader.close();
        } 
        catch (java.io.IOException ioe) {
            System.out.println("Error de archvo");
            ioe.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Error de ejecución:");
            e.printStackTrace();
        }
        
        while(aperturas.size()>1){
            temp = aperturas.remove(aperturas.size());
            aperturas.get(aperturas.size()).add(temp);
        }
        
        return new Tree(root);
    } 
    
//ATRIB_________________________________________________________________________    
    
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    
}
