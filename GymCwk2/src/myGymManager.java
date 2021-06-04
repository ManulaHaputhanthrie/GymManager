import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class myGymManager
{

    /*---------------------------------------Connecting to MongoDB--------------------------------------*/

    public static MongoClient mngoClnt = new MongoClient("localhost", 27017);
    public static MongoDatabase db = mngoClnt.getDatabase("MyGymDatabase");
    public static void main(String[] args)
    {
        int Membrs = 0;

        if(db.getCollection("Our Members")==null)
        {
            db.createCollection("Our Members");
        }

        MongoCollection<Document> coll = db.getCollection("Our Members");

        Scanner input = new Scanner(System.in);

        while(true)
        {
            try
            {

                System.out.println("***---------------------My Gym Manager---------------------***\n\n");

                System.out.println("Enter '1' to Add a new member");
                System.out.println("Enter '2' to Print the list of members");
                System.out.println("Enter '3' to Sort the items in Ascending Order");
                System.out.println("Enter '4' to Delete a Member");
                System.out.println("Enter '-1' to Exit the program\n");
                System.out.println("Select a Choice : ");

                int choice = input.nextInt();

                if (choice == 1)
                {
                    if (Membrs >= 100)
                    {
                        System.out.println("The Amount of members Surpassed!! No Spaces Available");
                    }
                    else
                        {
                        System.out.println("***------Add a new member------*** \n");

                        System.out.println("Enter '1' if you are a 'Student'");
                        System.out.println("Enter '2' if you are an 'Over 60 person'");
                        System.out.println("Enter '3' if None of the above \n");
                        System.out.print("Select a Choice :  \n");

                        int age_range = input.nextInt();

                        if (age_range == 1)
                        {

                            System.out.println("********Student Member********\n");

                            studentMember newStud = new studentMember();

                            newStud.setMemId();
                            newStud.setFrstName();
                            newStud.setLstName();
                            newStud.setCntactNum();
                            newStud.setSchl();
                            newStud.setAdrs();

                            date dtNew = new date();
                            dtNew.setStrtDate();
                            newStud.setDfltStrtDt(dtNew.getStrtDate());

                            Document doc = new Document();
                            doc.put("Member ID", newStud.getMemId());
                            doc.put("First Name", newStud.getFrstName());
                            doc.put("Last Name", newStud.getLstName());
                            doc.put("Contact Number", newStud.getCntactNum());
                            doc.put("School", newStud.getSchl());
                            doc.put("Address", newStud.getAdrs());
                            doc.put("Start Date",dtNew.getStrtDate());

                            coll.insertOne(doc);

                        }
                        else if (age_range == 2)
                        {

                            System.out.println("********Over 60 Member********\n");

                            over60Member newOvr60 = new over60Member();

                            newOvr60.setMemId();
                            newOvr60.setFrstName();
                            newOvr60.setLstName();
                            newOvr60.setAge();
                            newOvr60.setCntactNum();
                            newOvr60.setAdrs();

                            date dtNew = new date();
                            dtNew.setStrtDate();
                            newOvr60.setDfltStrtDt(dtNew.getStrtDate());

                            Document doc = new Document();
                            doc.put("Member ID", newOvr60.getMemId());
                            doc.put("First Name", newOvr60.getFrstName());
                            doc.put("Last Name", newOvr60.getLstName());
                            doc.put("Age", newOvr60.getAge());
                            doc.put("Contact Number", newOvr60.getCntactNum());
                            doc.put("Address", newOvr60.getAdrs());
                            doc.put("Start Date",dtNew.getStrtDate());

                            coll.insertOne(doc);

                        }
                        else if (age_range == 3)
                        {

                            System.out.println("********Normal Member********\n");

                            defaultMember norMem = new defaultMember();

                            norMem.setMemId();
                            norMem.setFrstName();
                            norMem.setLstName();
                            norMem.setCntactNum();
                            norMem.setAdrs();

                            date dtNew = new date();
                            dtNew.setStrtDate();
                            norMem.setDfltStrtDt(dtNew.getStrtDate());

                            Document doc = new Document();
                            doc.put("Member ID", norMem.getMemId());
                            doc.put("First Name", norMem.getFrstName());
                            doc.put("Last Name", norMem.getLstName());
                            doc.put("Contact Number", norMem.getCntactNum());
                            doc.put("Address", norMem.getAdrs());
                            doc.put("Start Date",dtNew.getStrtDate());

                            coll.insertOne(doc);

                        }
                        else
                            {
                            System.out.println("Invalid Integer..Try again!");
                        }

                    }

                }

                else if (choice == 2)
                {
                    System.out.println("***------Print the list of members------***\n");

                    for (Document list : coll.find())
                    {
                        System.out.println("Member ID      --> " + list.get("Member ID"));
                        System.out.println("First Name     --> " + list.get("First Name"));
                        System.out.println("Last Name      --> " + list.get("Last Name"));
                        System.out.println("Contact Number --> " + list.get("Contact Number"));
                        System.out.println("Address        --> " + list.get("Address"));
                        System.out.println("School         --> " + list.get("School"));
                        System.out.println("Age            --> " + list.get("Age"));
                        System.out.println("Start Date     --> " + list.get("Start Date"));
                        System.out.println();
                    }


                }
                else if (choice == 3)
                {

                    System.out.println("***------Sort the items in Ascending Order------***\n");

                    FindIterable<Document> sortAsc = coll.find().sort(new BasicDBObject("First Name",1));
                    for (Document doc : sortAsc)
                    {
                        System.out.println(doc.get("Member ID") + " --> " + doc.get("First Name") + " " + doc.get("Last Name"));
                    }


                }

                else if (choice == 4)
                {
                    System.out.println("***------Delete a member------***\n");

                    System.out.println("Enter the ID of the Member You Want to Delete :");
                    int id = input.nextInt();
                    BasicDBObject query = new BasicDBObject();
                    query.put("Member ID",id);
                    coll.deleteOne(query);
                    System.out.println("Member ID "+id+" deleted from the Database!\n");

                }

                else if (choice == -1)
                {
                    System.out.println("Program Exited!");
                    break;
                }
                else
                    {
                    System.out.println("Invalid Integer..Try again!");
                }

            }
            catch (Exception e)
            {
                System.out.println("Invalid input..Please Insert a Valid Integer!");
                input.next();
            }
        }

    }

}
