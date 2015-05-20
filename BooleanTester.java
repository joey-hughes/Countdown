
/**
 * Write a description of class BooleanTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class BooleanTester
{
    public static void main(String[] args)
  {
            FileIO reader = new FileIO();
            String[] contents = reader.load("dictionary.txt");
            //also run a counter to see how many words are over length 9
            int count=0;
            for(int i=0;i<contents.length;i++)
            {
                contents[i]=contents[i].trim();
                if(contents[i].length()<=9)
                {count++;}
                
            }
           Scanner sc=new Scanner(System.in);
           System.out.println("Please enter 9 random characters");
           String input= sc.nextLine();
           while(input.length() !=9)
           {
               System.out.println("Whoops, thats not 9 letters, try again:");
               input= sc.nextLine();
           }
          
           //converting the string into a sorted char array
           char[] inChar= new char[9];
           inChar=input.toCharArray();
           Arrays.sort(inChar);
           String sorted=new String(inChar.toString());
           String[] words=new String[count];
           int q=0;
           
           //now go through the dictionary and remove all words that are more than 9 letters
           for(int i=0;i<contents.length;i++)
           {
               if(contents[i].length() <= 9)
               {words[q]=contents[i];
                q++;}
           }
           
           int max=0;
           String[] top=new String[50];
           int position=0;

            
            //not to try and find best possible outcomes
            //if you go to the word in the dictionary and see if every element of that word is contained within the string
            
            for(int i=0;i<words.length;i++)
            {   
                char[] temp=words[i].toCharArray();
                Arrays.sort(temp);
                String tempStr=new String(temp.toString());
                int counter=0;
                boolean[] isElement=new boolean[temp.length];                
                for(int j=0;j<temp.length;j++)
                {
                   for(int k=0;k<inChar.length;k++)
                    {
                        if(temp[j]==inChar[k])
                        {
                            isElement[j]=true;
                            if((checker(isElement)) && j==temp.length-1)
                            {
                                if(words[i].length()>max)
                                {
                                    max=words[i].length();
                                    position=i;
                                    System.out.println(words[position]);
                                 }
                            }
                            break;
                            //else isElement=false;
                        }
                    }
                }
            }
            
                       //conundrum solver
           for(int i=0;i<words.length;i++)
           {
                char[] temp=words[i].toCharArray();
                Arrays.sort(temp);
                String tempStr=new String(temp.toString());
                if(Arrays.equals(temp, inChar))
                {
                    if(words[i].length()>=max)
                            {
                               max=words[i].length();
                               position=i;
                               System.out.println(words[i]);
                            }
                }
            }

           System.out.println(words[position]);
  }
  
  
  public static boolean checker(boolean[] ar)
  {
      boolean result=true;
      for(int i=0;i<ar.length;i++)
      {
          if(ar[i]==false)
          {
              result=false;
              break;
            }
        }
        
        return result;
        
    }
}
