import java.util.Scanner;

public class over60Member extends defaultMember
{

    int age;

    Scanner ovr60In = new Scanner(System.in);

    public void setAge()
    {
        System.out.println("Enter your Age :");

        while (true)
        {
            try
            {
                this.age = ovr60In.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter your Age!");
                ovr60In.next();
            }
        }
    }

    public int getAge() {return age;}

}
