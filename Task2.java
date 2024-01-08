import java.util.*;
class Task2 
{
    public static void main (String args[])
    {
        Random r=new Random();
        Scanner ob=new Scanner(System.in);
        int max=100;
        int min=1;
          
        int get;
        int i=1;
        int s=0;
        int a=0;
        System.out.println("Let's play Guess game ...\n");
        while(i!=4)
        { 
            int rno=r.nextInt(max-min+1)-min; 
            s=0;   
            System.out.println("Round "+i+" :");
            do
            { 
                
                System.out.print("Guess no. between "+min+" to "+max+" : ");
                get=ob.nextInt();
                if(get==rno)
                {
                    System.out.println("You guess correctly");
                    s++;
                }
                else if (get<rno)
                {
                    System.out.println("Too low! Try again");
                    s++;
            
                }
                else
                {
                    System.out.println("Too High! Try again");
                    s++;
                }
            }while (get != rno);
            
            int[] array = new int[]{ 100,90,80,70,60,50,40,30,20,10,0}; 
            if(s>10)
            {
                s=11;
            }
            System.out.println("Score : "+array[s-1]);  
            a+=(array[s-1]);
            i++;          
        }
        System.out.println("Final Score : "+a/3);  
        ob.close();
         
    }
     
}
