/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
package numbers;
import java.util.ArrayList;
import java.util.HashSet;
public class Numbers
{
    public  boolean isEven(int input)
    {   boolean output=false;
        if(input%2==0)
            output=true;
        return output;
    }
     public boolean isOdd(int input)
    {  
        return !(isEven(input));
    }
    /*int evenCount(int input[]) 
    {   int count=0;
        for(int i:input)
            if(isEven(i))
                count+=1;
        return count;
    }
    int oddCount(int input[]) 
    {   int output=0;
        for(int i:input)
            if(isOdd(i))  
                output+=1;
        return output;
        /*Alternate
        return input.length-evenCount(input);*/  /*
           
    }*/
    public int isPrime(int input)
    {   int output=1;
        if(input==1||input==0)//Prime numbers are concerned only with 'NATURAL NUMBERS' but still...
           output=-1;
        else
        {    
           for(int i=2;i<=input/2;i++)
          {
             if(input%i==0)
             { 
               output=0;
               break;
             }
          }
        }
        return output;
    }
    public int isNotPrime(int input)
    {
        int output=isPrime(input);
        if(output>=0)
            output=((output==1)?0:1);
        return output;
    }
    
    public boolean isCOPrime(int input1,int input2)
    {  /*Two numbers are said to be coprimes , if they have 
        no other common factors other than 1
        i.e  12(1,2,3,4,6,12) and 25(1,5,25) have no common factor than '1' */
        boolean output=true;
        int minimum=(input1>input2)?input2:input1;
        int maximum=(input1>input2)?input1:input2;
        //Doesnt require the use of 'minimum' because the arguements(Actual)
        //passed from 'totient' to this method are 'input' and 'i' , 
        //and wkt 'input' is always greater than 'i'in the loop iteration of method 'totient'
        if((input1==1)||(input2==1)||(maximum%minimum==0))
           output=false; 
        else
        for(int i=2;i<=minimum/2;i++)
           if((input1%i==0)&&(input2%i==0))
           { 
             output=false;
             break;
           }
        return output;
    }
    public int totient(int input)
    //Totient function psi(n)=no.of coprimes within 'n' 
    //i.e no.of co-primes within 1 to n-1
    {   int output=1;
        if(isPrime(input)==1)
            output=input-1;
        else
        {    
        for(int i=2;i<input;i++)
           if(isCOPrime(input,i))//calling 'isCOPrime' method here....
           {
            ++output;
            //System.out.print(i+" ");
           }  
        }
        return output;
    } 
    public ArrayList factors(int input)
    {
        ArrayList<Integer> output=new ArrayList();
        output.add(1);
        for(int i=2;i<=input/2;i++)
            if(input%i==0)
                output.add(i);
        output.add(input);
        return output;
    }
    public int noOfFactors(int input)
    {
        int output=factors(input).size();
        return output;
    }
        
    public  boolean isPerfectSquare(int input)
    {
        boolean output=isOdd(noOfFactors(input));
        return output;
    }
    public HashSet unique(ArrayList input)   
    {
     HashSet output=new HashSet();
     int size=input.size();
     for(int i=0;i<size;i++)
        output.add(input.get(i));
     return output;         
    }
  
}
