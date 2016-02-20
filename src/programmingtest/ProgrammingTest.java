/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifelix
 */
public class ProgrammingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  int n = sumMultiples();
        //  System.out.println("The sum is: " + n);
        //  fibbonacciNumbers();
        
        primeNumbers(3);
        connectToAndQueryDatabase("root", "gorditabonita12#A");
        
    }
    
    /////// 
    // Jesus!
    // Cristo
    public static void connectToAndQueryDatabase(String username, String password) {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull",username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammingTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        try {
            stmt = con.createStatement();
        }
        catch (SQLException ex) {
            Logger.getLogger(ProgrammingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM actor;");
        } 
        catch (SQLException ex) {
            Logger.getLogger(ProgrammingTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(rs.toString());
}
    
    // Generate a list of numbers, test what elements are multiples of 3 and 5.
    // If a number
    public static int sumMultiples(){
        int sum = 0;
        
        for(int i = 0; i < 1000 ; i++){
            if(i % 3 == 0 || i % 5 == 0)
                sum+=i;
        }
        return sum;
    }
    
    public static int fibbonacciNumbers(){

        int fibn_1 = 2;
        int fibn_2 = 1;
        int fibn;
        int sum = fibn_1;
        System.out.println("The " + 1 + "-th Fibonacci number is: " + fibn_2);
        System.out.println("The " + 2 + "-th Fibonacci number is: " + fibn_1);
        for(int i = 3; ; i++ ){
            fibn = fibn_1 + fibn_2;
            System.out.println("The " + i + "-th Fibonacci number is: " + fibn);
            fibn_2 = fibn_1;
            fibn_1 = fibn;
            
            if(fibn%2 == 0 && fibn < 4000000)
                sum+=fibn;
            if(fibn > 4000000)
                break;
        }
        System.out.println("The sum: " + sum);
        return sum;
    }
    
    
    public static void primeNumbers(int n){

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
        
        // mark non-primes <= n using Sieve of Eratosthenes
        for (int i = 2; i*i <= n; i++) {
            listOfPrimes.add(i);
            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., n/i
            if (isPrime[i]) {
                for (int j = i; i*j <= n; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        for( int p : listOfPrimes){
            System.out.println(p);
        }
        
        ArrayList<Integer> listOfPrimeFactors = new ArrayList<Integer>();  
        int position = 0;
        for( int p : listOfPrimes){
            if( n % p == 0){
                listOfPrimeFactors.add(p);
                position++;
                System.out.println("The prime factor : " + p +", position: " + position);
            }
        }
  
     //   int max = listOfPrimeFactors.get(position-1);
       // System.out.println("The maximum number is: " + max);
      
    }
    
}
