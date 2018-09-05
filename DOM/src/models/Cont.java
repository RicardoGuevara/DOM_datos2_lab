/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author rpayan
 */
public class Cont {
    private String name;
    private int cy;

    public Cont(String name) {
        this.name = name;
        this.cy = 1;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void up()
    {
        this.cy++;
        System.out.println(this.name+" "+this.cy);
    }

    @Override
    public String toString()
    {
        return this.name+"      n: "+this.cy;
    }
    
}
