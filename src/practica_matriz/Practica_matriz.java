
package practica_matriz;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random; 
/**
 *
 * @author aleja
 */
public class Practica_matriz {
static Scanner leer = new Scanner (System.in);
static Random random = new Random();
    public static void main(String[] args) {
         System.out.println(" * * * * * MENU * * * * * ");
        System.out.println("1. Conjuntos");
        System.out.println("2. ¿Cuantos primos tienes?");
        System.out.println("3. Salir del programa");
        System.out.print("Ingrese una opcion: ");
        int opcion = leer.nextInt();
        
        
        while (opcion>0 && opcion<3){
            switch(opcion){
                case 1:
                    System.out.print("Size SET1: ");
                    int size1=leer.nextInt();
                    System.out.print("Size SET2: ");
                    int size2=leer.nextInt();
                    
                    
                    System.out.println("Conjuntos generados:");
                    System.out.print("SET1: " );
                    char [] set1 = genRandCharArray(size1);
                    imprimirchar(set1);
                    
                    System.out.print("SET2: " );
                    char [] set2 = genRandCharArray(size2);
                    imprimirchar(set2);
                    
                    System.out.println();
                    System.out.println("Operaciones");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingrese una opcion: ");
                    int op = leer.nextInt();
                    
                    switch(op){
                        case 1: 
                            char [] inter = intersection(set1, set2);
                            imprimirchar(inter);
                            break; 
                            
                        case 2:
                            char [] dif = new char [set1.length];
                            dif = difference(set1, set2);
                            imprimirchar(dif);
                            break; 
                    }
                    
                    break;
                    
                    
                case 2:
                    System.out.print("Ingrese el tamaño del arreglo: ");
                    int tam = leer.nextInt();
                    System.out.print("Ingrese el limite inferior: ");
                    int inf = leer.nextInt();
                    System.out.print("Ingrese el limite superior: ");
                    int sup = leer.nextInt();
                    
                    
                    while (tam<1){
                        System.out.println("EL tamaño del arreglo tiene que ser mayor a 1");
                        System.out.print("Ingrese el tamaño del arreglo denuevo: ");
                        tam = leer.nextInt();
                     }
                    while (sup<inf){
                        System.out.println("El limite superior no puede ser menor que el inferior");
                        System.out.print("Ingrese el limite inferior denuevo: ");
                       inf = leer.nextInt();
                       System.out.print("Ingrese el limite superior denuevo: ");
                       sup = leer.nextInt();
                     }
                    
                    int [] arreglo = genRandArray(tam,inf,sup);
                    
                    System.out.print("Arreglo generado: ");
                    imprimirint(arreglo);
                    
                    int [] arreglo2 = getTotalPrimeCount(arreglo);
                    System.out.print("No. divisores primos: ");
                    imprimirint(arreglo2);
                    
                    break;
            }
            
            
            
            System.out.println();
            System.out.println(" * * * * * MENU * * * * * ");
            System.out.println("1. Conjuntos");
            System.out.println("2. ¿Cuantos primos tienes?");
            System.out.println("3. Salir del programa");
            System.out.print("Ingrese una opcion: ");
            opcion = leer.nextInt(); 
            
        }
                
    }
    
    public static void imprimirchar (char arreglo [] ){
        for (int i=0;i<arreglo.length; i++){
            System.out.print("[" + arreglo [i] + "]" );
        }
        System.out.println("");
    }
    
    public static void imprimirint (int arreglo [] ){
        for (int i=0;i<arreglo.length; i++){
            System.out.print("[" + arreglo [i] + "]" );
        }
        System.out.println("");
    }
    
    public static char [] genRandCharArray(int size){
          char [] carac = new char [size];
          for (int i=0; i<size;i++){
              int num = random.nextInt(9)+65;
              char ascii = (char)num;
              carac [i]= ascii;
           }
          return carac;
    }
    
    public static char [] intersection (char [] set1, char[] set2){
        
        int menor= 0;
        
        if (set1.length>set2.length){
            menor = set2.length;
        }  
        else if(set2.length>set1.length){
            menor = set1.length;
        }
        char [] arreglo= new char [menor];
        int cont = 0;
        for (int i=0; i<set1.length; i++){
            for (int j=0; j<set2.length; j++){
                if (set1[i]==set2[j]){
                    arreglo[cont]=set1[i];
                    cont++;
                }
            }
        }
        char [] arreglo2 = new char [cont];
        for (int i=0; i<cont; i++){
                arreglo2[i]=arreglo[i];
        }
        
        
        return arreglo2;
       
}
    public static char[] difference (char []set1, char []set2){
        
        int menor=0;
        if (set1.length>set2.length){
           
            menor = set2.length;
        }  
        else if(set2.length>set1.length){
            
            menor = set1.length;
        }
        char [] arreglo= new char [menor];
        
        int cont = 0;
        for (int i=0; i<set1.length; i++){
               boolean esta=false;
            
            for (int j=0; j<set2.length; j++){
                if (set1[i]==set2[j]){
                     esta=true;
                     break;
                }
                
                if (esta!=true){
                    arreglo[cont]=set1[i];
                    if(cont<menor-1){
                       cont++;      
                    }
               }
            }
            
        }
        char [] arreglo2 = new char [cont];
        for (int i=0; i<cont; i++){
                arreglo2[i]=arreglo[i];
        }
        
        return arreglo2;
    
    }
    
    
    public static int [] genRandArray (int tam, int inf, int sup){
        int [] arreglo = new int [tam];
        int inf2= (sup-inf) + 1;
        
        for (int i=0; i<tam; i++){
            arreglo[i] = random.nextInt(inf2)+inf;
        }
        
       return arreglo; 
    }
    
    public static boolean isPrime (int num){
        boolean primo=false;
        if (num>0){
            int contfac=0;
            for (int i=1; i<=num; i++){
              if (num%i==0){
                  contfac=contfac+1;
                }         
            }
            if (contfac==2){
                primo=true;
            }
            else{
                primo=false;
            }
        }   
        
        return primo;
    }
    
    public static int countPrimeFactors (int num){
            int contfac=0;
            for (int i=1; i<=num; i++){
                if (isPrime(i)&& num%i==0){
                    contfac=contfac+1;
                }   
            }
            
        return contfac;
    }
    
    public static int [] getTotalPrimeCount (int [] arreglo){
        int[] arreglo2= new int [arreglo.length];
        for (int i=0; i<arreglo.length;i++){
            int num = arreglo[i];
            for (int j=0;j<arreglo2.length;j++){
                arreglo2[i]=countPrimeFactors(num);
            }
        }
        
        return arreglo2;
    }
        
    
       
}