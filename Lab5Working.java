import java.util.*;
import java.util.ArrayList;

public class Lab5Working {

    public static void main(String args[]){
        
        FileIO reader = new FileIO();
        Scanner sc = new Scanner(System.in);
 
        String[] temp = reader.load("dictionary.txt"); //Reading the File as a String array
        String[] dictionary = new String[temp.length];
        for(int i =0;i<temp.length;i++){
            dictionary[i]= temp[i].substring(0, temp[i].length()-1);
        }
        
        System.out.println("Please enter 9 letters:");
        String input= sc.nextLine();
           while(input.length() !=9)
           {
               System.out.println("Whoops, thats not 9 letters, try again:");
               input= sc.nextLine();
           }
        
        
        //Creating an array list 
        //go through dictionary, take out words of length greater than 9
        
          ArrayList<String> contents = new ArrayList<String>();
        int count = -1;
        
        for(int i=0;i<dictionary.length;i++){
            if(dictionary[i].length()<=10){
                count++;
                contents.add(dictionary[count]);
            }
        }
        
        char[] inChar=input.toCharArray();
        Arrays.sort(inChar);
        
        String biggest="";
        String[] longer= new String[20];
        int counter=0;
        
        for(int i=0;i<contents.size();i++){
            if(isElement(inChar,contents.get(i))){
                
                if(contents.get(i).length()>= biggest.length()-2)
                {
                    if(counter==20)
                    {
                       longer[isSmallest(longer)]=contents.get(i);
                        
                    }
                    else{
                    longer[counter]=contents.get(i);
                    counter++;
                   }
                if(contents.get(i).length()>biggest.length()){
                    biggest=contents.get(i);
                    //System.out.println(contents.get(i));
                }
                }
            }
        }
        System.out.println("The biggest words found was of length " + biggest.length() + " which is: ");
        System.out.println(biggest);
        System.out.println("some other good words are ");
        for(int i=0; i<longer.length;i++)
        {
            System.out.println(longer[i]);
        }
    }
    
        public static boolean isElement(char[] ar1, String str){
            
              char[] ar2 = str.toCharArray();
              //sort the array
              Arrays.sort(ar2);
              
              int count=0;
              if(ar1.length==ar2.length){
                  for(int i = 0; i < ar1.length;i++) {
                      //Check to make sure that the elements are not the same, i.e they dont match
                      if(ar1[i] != ar2[i]) {
                          return false;
                      }
                  }
                  //if they match, retrun true
                  return true;
                }
              
              //if they are of different length
              else if(ar2.length<ar1.length){
                  int[] check1=new int[ar2.length];
                  int[] check2=new int[ar1.length];
                  for(int i = 0; i < ar2.length;i++) {
  
                      for(int j = 0; j < ar1.length;j++) {
                          if(ar2[i]==ar1[j]){
                              check1[i]=1;
                              //checks duplicates and fills in the integer array  
                              if(check2[j]<1){
                                  check2[j]=1;
                                  break;
                              }
                              

                          }
                          
                      }
                  }
                  int add=0;
                  for(int i=0;i<check2.length;i++){
                      if(check2[i]>1){
                          return false;
                      }
                      else{
                          add=add+check2[i];
                      }
                  }
                  //the add number is checking if the number equals the length of the words in the dictionary you are on
                  for(int i = 0; i < check1.length;i++) {
                      
                      if(check1[i]!=1 | add!=check1.length){
                          
                          return false;
                      }
                  }
                return true;
                  
                    
              }
              return false;
    }
    
    public static void swap(String st1, String st2)
    {
        String temp =new String(st2);
        st2=st1;
        st1=temp;
    }
    
    public static int isSmallest(String[] ar)
    {
        int smallest=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i].length()<=ar[smallest].length())
            {smallest=i;
            }
        }
        return smallest;
    }
}

