/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;


/**
 *
 * @author RICARDO
 */
public class MergeSort {
   
  public int A[];
  
     public int[] OrdenaMerge(int[] L) {
        int n = L.length;
 
        if (n > 1){
            int m = (int) (Math.ceil(n/2.0));
            int [] L1 = new int[m];
            int [] L2 = new int[n-m];
 
            for (int i = 0; i < m; i++){
                L1[i] = L[i];
            }
            for (int i = m; i < n; i++){
                L2[i-m] = L[i];
            }
            L = merge(OrdenaMerge(L1), OrdenaMerge(L2));
        }
        return L;
    }
 
    public int[] eliminar(int [] l){
        int [] L = new int[l.length-1];
        for(int i = 1; i < l.length; i++){
            L[i-1] = l[i];
        }
        return L;
    }
 
    public int[] merge(int[] L1, int[] L2) {
         int[] L = new int[L1.length+L2.length];
         int i = 0;
         while ((L1.length != 0) && (L2.length != 0)) {
             if (L1[0] < L2[0]){
                 L[i++] = L1[0];
                 L1 = eliminar(L1);
                 if (L1.length == 0){
                     while (L2.length != 0) {
                         L[i++] = L2[0];
                         L2 = eliminar(L2);
                     }
                 }
             }
             else{
                 L[i++] = L2[0];
                 L2 = eliminar(L2);
                 if (L2.length == 0) {
                    while (L1.length != 0) {
                         L[i++] = L1[0];
                         L1 = eliminar(L1);
                    }
                 }
             }
         }
         return L;
    }
 
    public void generarNumeros(int n){
        A = new int[n];
        Random ran = new Random();
        int x;
        for(int i = 0; i <n; i++){             
            x = (int) (Math.random()*(5000)+1);            
            A[i] = x;
        }
    }
 
    public void imprimir(){
       for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
         }
    }
    
 
    public int[] getA(){
        return A;
    }
 
    public void setA(int []A){
        this.A = A;
    }
   
}

