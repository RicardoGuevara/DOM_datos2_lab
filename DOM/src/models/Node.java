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
        //node.setNivel(this.getNivel()+1);
        levelup(node,1);
        node.setHorizontal(this.subNodes.size());
        this.subNodes.add(node);
        //System.out.println("nivel / pos_grado "+node.getNivel()+" "+node.getHorizontal());
    }
    
    public void add(String ob){
        add(new Node(ob));
    }
    
    public void add(Object ob){
        add(new Node(ob.toString()));
    }
    
    public void levelup(Node node,int i)
    {
        node.setNivel(i);
        for (Node subNode : node.subNodes) 
        {
            levelup(subNode,++i);
        }
    }
    
//ATRIB_________________________________________________________________________
    
    public ArrayList<Node> subNodes;
    private boolean open_state;
    private String label_name;
    private int nivel=0, horizontal=0;

    public ArrayList<Node> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(ArrayList<Node> subNodes) {
        this.subNodes = subNodes;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }
    
    
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
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
