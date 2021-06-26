package railway;

public class Berth {
    int lowerBerth=18,upperBerth=18,midBerth=18,sideUpper=9;
    public void allocateBerth(Ticket ticket)
    {
        if(ticket.getAge()<5)
        {
            System.out.println("children are not allowed");
        }
       else if (lowerBerth!=0&&ticket.getGender().equals("female")&&ticket.getAge()>=60&&ticket.getBerthPreference().equals("lowerBerth"))
        {
            lowerBerth--;
            ticket.setConfirmationStatus("booked lowerBerth");
        }
        else if(lowerBerth!=0&&ticket.getBerthPreference().equals("lowerBerth"))
        {
            lowerBerth--;
            ticket.setConfirmationStatus("Booked lowerBerth");
        }
        else if(upperBerth!=0&&ticket.getBerthPreference().equals("upperBerth"))
        {
            upperBerth--;
            ticket.setConfirmationStatus("Booked upperBerth");
        }
        else if(midBerth!=0&&ticket.getBerthPreference().equals("midBerth"))
        {
            midBerth--;
            ticket.setConfirmationStatus("Booked midBerth");
        }
        else if(sideUpper!=0&&ticket.getBerthPreference().equals("sideUpper"))
        {
            sideUpper--;
            ticket.setConfirmationStatus("Booked sideUpper");
        }
        else
            System.out.println("entered berth not match");

    }
}
