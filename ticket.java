package com.example.ticketoop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

// ticket class for variables

class Tickets{
    private int ticketno;
    private String ticketname;
    private int tprice;



//constructor for ticket input

    Tickets(int ticketno, String ticketname, int tprice) {
        this.ticketno = ticketno;
        this.ticketname = ticketname;
        this.tprice = tprice;
    }


//grabs the variables for ticket and returns them

    public int  getTicketno(){
        return ticketno;
    }
    public int getTprice(){
        return tprice;
    }
    public String getTicketname(){
        return ticketname;
    }

    public String toString(){
        return ticketno+" "+ticketname+" "+tprice;
    }

}

//create a array list for ticket and use scanner to read the text,
// output to user list of options to change tickets

class ticket{
     public static void main(String[] args) {

         List<Tickets> c = new ArrayList<Tickets>();
         Scanner s = new Scanner(System.in);
         Scanner s1 = new Scanner(System.in);
         int ch;
         do {
             System.out.println("1.INSERT A TICKET");
             System.out.println("2.DISPLAY A TICKET");
             System.out.println("3.SEARCH FOR A TICKET");
             System.out.println("4.DELETE A TICKET");
             System.out.println("5.UPDATE A TICKET");
             System.out.println("Please Enter Your Choice : ");
             ch = s.nextInt();

             switch(ch){

                 //if user chooses 1 then run insert command which asks for new information about a ticket
                 //then new ticket will be inputted into application

                 case 1:
                     System.out.print("Please Enter The Ticket Number :");
                     int ticketno = s.nextInt();
                     System.out.print("Please Enter The Ticket Name :");
                     String ticketname = s1.nextLine();
                     System.out.print("Please Enter The Ticket Price :");
                     int tprice = s.nextInt();

                     c.add(new Tickets(ticketno,ticketname,tprice));
                     break;


                     //if user chooses 2 then the application will search for all tickets within the application
                     //these will then be printed to the user with a line to separate

                 case 2:
                     System.out.println("-------------------------------");
                     Iterator<Tickets> i = c.iterator();
                     while(i.hasNext()){
                         Tickets e = i.next();
                         System.out.println(e);
                     }
                     break;


                     //if user chooses 3 then it will search the whole database/application for the ticket number
                     //this will print it if it is find or say not found if its not in the application using the found command

                 case 3:
                     boolean found = false;
                     System.out.print("Please Enter Ticket Number To Search :");
                     int tickno = s.nextInt();
                     System.out.println("-------------------------------");
                     i = c.iterator();
                     while(i.hasNext()){
                         Tickets e = i.next();
                         if(e.getTicketno() == tickno) {
                             System.out.println(e);
                             found = true;
                         }

                     }

                     if(!found){
                         System.out.println("Ticket Not Found");
                     }
                     System.out.println("------------------------------------");
                     break;


                     //if user chooses 4 they will be able to delete a ticket from the application
                     //if the user enters the correct ticket number to delete it was be deleted successfully
                    //and will be printed to show user it has been successful


                 case 4:
                     found = false;
                     System.out.print("Please Enter Ticket Number To Delete :");
                     tickno = s.nextInt();
                     System.out.println("-------------------------------");
                     i = c.iterator();
                     while(i.hasNext()){
                         Tickets e = i.next();
                         if(e.getTicketno() == tickno) {
                             i.remove();
                             found = true;
                         }

                     }

                     if(!found){
                         System.out.println("Ticket Not Found");
                     }else{
                         System.out.println("Ticket Is Deleted Successfully....");
                     }

                     System.out.println("------------------------------------");
                     break;


                     //if user chooses 5 they are able to update a ticket which is already in the application
                    //the user has to enter the correct ticket number and then they will be shown options
                    //to be able to add a new name or a new ticket price
                    //this is useful if the user has added any ticket addons



                 case 5:
                     found = false;
                     System.out.print("Please Enter Ticket Number To Update :");
                     tickno = s.nextInt();

                     ListIterator<Tickets> li = c.listIterator();
                     while(li.hasNext()){
                         Tickets e = li.next();
                         if(e.getTicketno() == tickno) {
                             System.out.print("Please Enter New Ticket Name : ");
                             ticketname = s1.nextLine();

                             System.out.print("Please Enter New Ticket Price : ");
                             tprice = s.nextInt();
                             li.set(new Tickets(tickno,ticketname,tprice));
                             found = true;
                         }

                     }



                     if(!found){
                         System.out.println("Ticket Not Found");
                     }else{
                         System.out.println("Ticket Is Updated Successfully....");
                     }



                     break;
             }
         }while (ch!=0);
     }

}