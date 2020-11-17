package Guest_User_Registration; //create package

import java.util.Scanner;

public class Guest_User {

	/*------------------------------------------Guest Register Module--------------------------------------*/
    public void guestUser()
    {
        System.out.println("Give Your Nickname: ");	
        Scanner select_GuestName = new Scanner(System.in);
        String guest_Name = select_GuestName.nextLine();
        System.out.println("Welcome To "+guest_Name+"");
        
      
    }
    
}
