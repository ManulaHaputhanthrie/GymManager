import java.util.Scanner;

public class defaultMember
{

    int memId; String frstNm; String lstNm; int cntctNum; String adrs; String dfltStrtDt;

    Scanner in = new Scanner(System.in);

    public void setMemId()
    {
        System.out.println("Enter your Member ID :");

        while (true)
        {
            try
            {
                this.memId = in.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter the Member ID!");
                in.next();

            }
        }
    }

    public void setFrstName()
    {
        System.out.println("Enter your First Name :");
        this.frstNm = in.next();

        while (true)
        {
            try
            {
                Integer.parseInt(this.frstNm);
                System.out.println("Invalid input..Please enter the First Name!");
                this.frstNm = in.next();
            }
            catch (Exception e)
            {
                break;
            }
        }
    }

    public void setLstName()
    {
        System.out.println("Enter your Last Name :");
        this.lstNm = in.next();

        while (true)
        {
            try
            {
                Integer.parseInt(this.lstNm);
                System.out.println("Invalid input..Please enter the Last Name!");
                this.lstNm = in.next();
            }
            catch (Exception e)
            {
                break;
            }
        }
    }

    public void setCntactNum()
    {
        System.out.println("Enter your Contact Number :");

        while (true)
        {
            try
            {
                this.cntctNum = in.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please enter the Contact Number!");
                in.next();
            }
        }
    }

    public void setAdrs()
    {
        System.out.println("Enter your Address :");
        this.adrs = in.next();

        while (true)
        {
            try
            {
                Integer.parseInt(this.adrs);
                System.out.println("Invalid input..Please enter the Address!");
                this.adrs = in.next();
            }
            catch (Exception e)
            {
                break;
            }
        }
    }

    public void setDfltStrtDt(String dfltDt)
    {this.dfltStrtDt = dfltDt;}

    public int getMemId() {return memId; }
    public String getFrstName() {return frstNm; }
    public String getLstName() {return lstNm; }
    public int getCntactNum() {return cntctNum; }
    public String getAdrs() {return adrs; }
    public String getDfltStrtDt() { return dfltStrtDt; }

}
