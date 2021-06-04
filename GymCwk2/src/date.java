public class date extends defaultMember
{

    String strtDate; int day; int month; int year;

    public void setStrtDate()
    {
        System.out.println("-------Enter your Start Date-------");

        while (true)
        {
            System.out.println("Day : ");
            try
            {
                this.day = in.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter the Day correctly!");
                in.next();
            }
        }

        while (true)
        {
            System.out.println("Month : ");
            try
            {
                this.month = in.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter the Month correctly!");
                in.next();
            }
        }

        while (true)
        {
            System.out.println("Year : ");
            try
            {
                this.year = in.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter the Year correctly!");
                in.next();
            }
        }

        strtDate = day + "/" + month + "/" + year;
    }

    public String getStrtDate()
    {
        return strtDate;
    }

}
