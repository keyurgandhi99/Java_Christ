package Add_Friends;

import java.util.Arrays;
import java.util.Scanner;

public class Add_friends {

	/*--------------------------------------Add Friend Module---------------------------------*/
	public void addFriend()
	{
	    System.out.println("You can Add Only Five Friends");
	    Scanner select_Friend = new Scanner(System.in);
	    String add_friends[]=new String[6];
	    System.out.println("Please Provide Your Friends Name");
	    for (int i=1; i <= 5; i++)
	    {
	     
	        System.out.print("Friend Name "+i+": ");	
	   
	       add_friends[i]=select_Friend.next();
	     
	    }
	    System.out.println(Arrays.toString(add_friends));
		/* mainMenu(); */
	}
	
	
}
