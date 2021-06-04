import java.util.Scanner;

public class studentMember extends defaultMember
{

    String schl;

    Scanner schlIn = new Scanner(System.in);

    public void setSchl()
    {
        System.out.println("Enter your School :");
        this.schl = schlIn.nextLine();

        while(true)
        {
            try
            {
                Integer.parseInt(this.schl);
                System.out.println("Invalid input..Please enter the School Name!");
                this.schl = schlIn.next();
            }
            catch(Exception e)
            {
                break;
            }
        }
    }

    public String getSchl() {return schl;}

}
