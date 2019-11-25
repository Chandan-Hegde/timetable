/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

    public class TimeTable1 {
    private String subname;
    String[][] timetable=new String[6][6];
    
    void setName(String s)
    {
        this.subname=s;
    }
    
    String getName()
    {
        return this.subname;
    }
}

