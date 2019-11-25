/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

    public class Batch1 extends TimeTable1{
    boolean adding(Course1 x)
    {
        int i,j,credits=0;
    
         credits = x.getCredits();      // g stores credits...
         
        for(i=0;i<6;i++)
        {
            for(j=0;j<6;j++)
            {
                if(this.timetable[i][j]==null)
                {
                    if(credits != 0)
                   
                    {
                        this.timetable[i][j]= x.getName();
                        
                        credits-- ;
                    }
				
                }
               
            }
        }
        return credits==0;
  
    }
}
    
    

