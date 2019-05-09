
package com.oe.model;


public class ChillerInfo {
    private final String name;
    private final int size;
    private final double eff;
    
    public ChillerInfo( String name, int size, double eff){
        this.name = name;
        this.size = size;
        this.eff = eff;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSize(){
        return size;
    }
    
    public double getEff(){
        return eff;
    }
          
}
