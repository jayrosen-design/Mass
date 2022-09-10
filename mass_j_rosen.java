//****************************************************************************** 
// Jay Rosen
// 09/14/14
// COP2660.0M1
// Module 3 : mass_j_rosen.java
//
// This program converts Mass to Weight.
//******************************************************************************


import javax.swing.JOptionPane;                                        //Import the dialogue box.

import java.text.DecimalFormat;                                        //Import the precision format.

public class mass_j_rosen
{
   public static void main(String[] args)
   {
     final double CONVERSION_RATE = 9.8;                              //Constant conversion rate.
     
     double weight_Newton;                   
     
     int tooHeavy = 1000,                                             //Establish tresholds for weights.
         tooLight = 10,
         negativeError = 0;
          
     String warningMessage = "";                                      //Null string to prevent compile errors.
                                  
     String mass_String =                                             //Dialogue Box prompting user to input mass.
      JOptionPane.showInputDialog
          ("This program converts an object's mass to weight.\n" +     
           "Enter a mass in kilograms.");   
                                                                     
     double mass_Kilogram = Double.parseDouble(mass_String);         //Convert string input to a double variable.
     
     weight_Newton = mass_Kilogram * CONVERSION_RATE;                //Formula to convert mass to weight

      if (weight_Newton > tooHeavy)                                  //If weight is more than 100 Newtons, display this message.
         warningMessage = "The object is too heavy.";
                                                     
      if (weight_Newton < tooLight)                                  //If weight is less than 10 Newtons, display this message.
         warningMessage = "The object is too light.";   
        
      if (weight_Newton <= negativeError)                            //If the weight is less than or equal to 0, display error message and close program.
          { 
            JOptionPane.showMessageDialog
             (null, "Error: You have entered an invalid mass.\n" + 
              "Please try again and enter a mass greater than 0.");
            System.exit(0);
          }
       
       DecimalFormat formatter = new DecimalFormat ("#0.00");       // Create new DecimalFormat object with 2 decimal place precision.
   
       JOptionPane.showMessageDialog                                //Display results with conditional warning message.
                (null, formatter.format(mass_Kilogram) + " kilograms = " + 
          formatter.format(weight_Newton) + " newtons\n" + warningMessage);
   
      System.exit(0);      //Close program.
   }
}