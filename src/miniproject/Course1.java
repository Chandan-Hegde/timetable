/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;


public class Course1 {
    private String subname;
    private int subcredits;
    
    void setName(String s){
        this.subname = s;
    }
    void setCredits(int d){
        this.subcredits = d;
    }
    
    String getName(){
        return this.subname;
    }
    int getCredits(){
        return this.subcredits;
    }
}

    

