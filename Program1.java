import java.util.Scanner;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) 
	{
		
        Main obj=new Main();
        obj.quiz();
      
    }

public void quiz()
{
    
    Scanner in = new Scanner(System.in);
        System.out.println("Give Your Registartion Details");	
        System.out.println("Enter name: ");	
        String name=in.nextLine();
        while(name.length()!=0)
        {
            System.out.println("Enter age: ");	
            int age=in.nextInt();
            if (age>10)
            {
    	        System.out.println("You are eligible");
            }
            else
            {
                System.out.println("You are not eligible");
                quiz();
            }
            break;
        }
    System.out.println("welcome to "+name);
    System.out.println("Select your Subject to play Quiz");
    System.out.println("1.Computer Science - Press 1");
    int ch=in.nextInt();
    switch(ch)
    {
        case 1:
            System.out.println("Select Sub Topic Of Science Subject");
            System.out.println("1.Data Structure - press 1");
            System.out.println("2.DBMS - Press 2");
            int ch1=in.nextInt();
            switch(ch1)
            {
                case 1:
                    System.out.println("You are selected Data Structure");
                   menu();
                    break;
                case 2:
                    System.out.println("You are selected DBMS");
                    menu();
                    break;
                
            }
            
            
        
    }
    
    
}

public void menu()
{
    Scanner in1 = new Scanner(System.in);
    System.out.println("Profile");
    System.out.println("1.Add Friend - press 1");
    System.out.println("2.Add Quiz - press 2");
    System.out.println("3.Skip");
    int ch2=in1.nextInt();
    switch(ch2)
            {
                case 1:
                    addGuest();
                    break;
                case 2:
                    addquiz();
                    break;    
                case 3:
                    System.out.println("You are Exit From Profile Section");
                    break;
                
            }
   
}

private void addGuest()
{
 Scanner in2 = new Scanner(System.in);
 String add_guest[]=new String[6];
  for (int i=0;i<=5;i++)
   {
     
     System.out.println("Enter Friendname: ");	
   
     add_guest[i]=in2.next();
     
   }
 System.out.println(Arrays.toString(add_guest));
    
}

public void addquiz()
{
     String Question="";
     Scanner in3 = new Scanner(System.in);
     System.out.println("How many Question Do you want to Add:");
     int no=in3.nextInt();
     String creator="XYZ Person";
 for (int i=0;i<=no;i++)
 {
    Question=in3.nextLine();
     System.out.println("Add Question: ");	
   
     
     
 }
 System.out.println("Question is : " +Question+ "Created By:"+creator);
addoption();    
    
    
    
}
public void addoption()
{
 Scanner in4 = new Scanner(System.in);
 System.out.println("How many Option Do you Want to Add:");
 int no=in4.nextInt();
int add_option[]=new int[5];
System.out.println("Note:Select Numeric number for option");
 for (int i=1;i<=4;i++)
 {
     
     System.out.println("Add Option:");	
   
     add_option[i]=in4.nextInt();
     
 }
 System.out.println(add_option);
}


}


