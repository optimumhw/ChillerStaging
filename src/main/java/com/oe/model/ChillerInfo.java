
package com.oe.model;


public class ChillerInfo {
    private final String name;
    private final int chillerNumber;
    private final int chillerRanking;
    
    public ChillerInfo( String name, int chillerNumber, int chillerRanking){
        this.name = name;
        this.chillerNumber = chillerNumber;
        this.chillerRanking = chillerRanking;
    }
    
    public String getName(){
        return name;
    }
    
    public int getChillerNumber(){
        return chillerNumber;
    }
    
    public int getChillerRanking(){
        return chillerRanking;
    }
    
          
}
