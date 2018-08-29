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
public class Node {

    public Node(String label_name) {
        this.label_name = label_name;
        subNodes = new ArrayList<>();
        open_state = false;
    }

    public Node(boolean open_state, String label_name) {
        this.open_state = open_state;
        this.label_name = label_name;
        subNodes = new ArrayList<>();
    }

    @Override
    public String toString(){
        return this.label_name; 
    }
    
    @Override
    public boolean equals(Object ob){
        if(ob instanceof Node) return this.label_name.equals(((Node) ob).label_name);
        return this.label_name.equals(ob);
    }
    
//METHODS_______________________________________________________________________    
    
    public void add(Node node){
        this.subNodes.add(node);
    }
    
    public void add(String ob){
        this.subNodes.add(new Node(ob));
    }
    
    public void add(Object ob){
        this.subNodes.add(new Node(ob.toString()));
    }
    
//ATRIB_________________________________________________________________________
    
    public ArrayList<Node> subNodes;
    private boolean open_state;
    private String label_name;

    public boolean isOpen_state() {
        return open_state;
    }

    public void setOpen_state(boolean open_state) {
        this.open_state = open_state;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }
    
}
