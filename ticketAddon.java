// Decorator Pattern for ticket addons

package com.example.ticketoop;


import org.jetbrains.annotations.TestOnly;

//this is for the ticket addons by using a decorator to modify each class/ticket


public interface ticketAddon {
    String Addon();
}

//once ticket has a new addon return this

class ticketAddonImpl implements ticketAddon {

    @Override
    public String Addon() {
        return "Ticket Addon";
    }
}

//when the ticket is changed send the addon to the ticket to the application

abstract class ticketChange implements ticketAddon {
    private ticketAddon ticket;

    public ticketChange(ticketAddon ticket) {
    }

    // standard constructors
    @Override
    public String Addon() {
        return ticket.Addon();
    }

}


// ---------------------------- Additional front row seats to ticket
// change the ticket to add front row seats
//super is used to show the different classes


class FrontRowSeats extends ticketChange {

    public FrontRowSeats(ticketAddon ticket) {
        super(ticket);
    }

    public String Addon() {
        return super.Addon() + AddFrontRowSeats();
    }

    private String AddFrontRowSeats() {
        return " With Front Row Seats";
    }



// ---------------------------- Additional Tour of the ground to ticket
//change the ticket to add with tour of the ground

public class Tour extends ticketChange {

        public Tour(ticketAddon ticket) {
            super(ticket);
        }

        public String Addon() {
            return super.Addon() + AddTour();
        }

        private String AddTour() {
            return " With Tour of The Ground";
        }
}


// ---------------------------- Additional pie to ticket
// change the ticket to add a pie with the ticket


    public class Pie extends ticketChange {

        public Pie(ticketAddon ticket) {
            super(ticket);
        }

        public String Addon() {
            return super.Addon() + AddPie();
        }

        private String AddPie() {
            return " With Pie";
        }
    }



// ---------------------------- Additional pint to ticket
// change the ticket to add a pie with the ticket


    public class Pint extends ticketChange {

        public Pint(ticketAddon ticket) {
            super(ticket);
        }

        public String Addon() {
            return super.Addon() + AddPint();
        }

        private String AddPint() {
            return " With Pint";
        }
    }



// --------------------------------- additional tour and front row seats to ticket
//use the decorator classes to add multiple addons to a ticket
    // this is useful as a user may want to have multiple different addons
    //this can be done by using decorators to add multiple addons to one ticket
    //this will be printed out to the user if successful



    public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {

        //tour ticket addons
        ticketAddon ticket1 = new Tour(new ticketAddonImpl());
        assertEquals(ticket1.Addon(),
                "Ticket With Tour Of The Ground");


        ticketAddon ticket2 = new FrontRowSeats(
                new Tour(new ticketAddonImpl()));
        assertEquals(ticket2.Addon(),
                "Ticket With Front Row Seats and Tour Of The Ground");


        ticketAddon ticket3 = new Pie(
                new Tour(new ticketAddonImpl()));
        assertEquals(ticket3.Addon(),
                "Ticket With Pie and Tour Of The Ground");


        ticketAddon ticket4 = new Pint(
                new Tour(new ticketAddonImpl()));
        assertEquals(ticket4.Addon(),
                "Ticket With Pint and Tour Of The Ground");


        //front row seats ticket addons
        ticketAddon ticket5 = new FrontRowSeats(
                new Pie(new ticketAddonImpl()));
        assertEquals(ticket5.Addon(),
                "Ticket With Front Row Seats and Pie");


        ticketAddon ticket6 = new FrontRowSeats(
                new Pint(new ticketAddonImpl()));
        assertEquals(ticket6.Addon(),
                "Ticket With Front Row Seats and Pint");


        //pie and pint ticket addons
        ticketAddon ticket7 = new Pie(
                new Pint(new ticketAddonImpl()));
        assertEquals(ticket7.Addon(),
                "Ticket With Pie and Pint");
    }



//auto created code for assert equals command


    private void assertEquals(String Addon, String s) {
    }


}
