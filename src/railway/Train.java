package railway;
import java.util.ArrayList;
public class Train {
     ArrayList<Ticket> confirmedTickets=new ArrayList<>();
    ArrayList<Ticket> racTickets=new ArrayList<>();
    ArrayList<Ticket> waitingTickets=new ArrayList<>();
    static ArrayList<Ticket> applyTickets=new ArrayList<>();
    Berth b=new Berth();
    public  void bookTicket(Ticket ticket)
    {

        if(confirmedTickets.size()<=63)
        {
            b.allocateBerth(ticket);
            if(ticket.getAge()>5)
              confirmedTickets.add(ticket);
            applyTickets.add(ticket);
        }
        else if(racTickets.size()<=18)
        {
            ticket.setConfirmationStatus("In rac");
            racTickets.add(ticket);
            applyTickets.add(ticket);
        }
        else if(waitingTickets.size()>10)
        {
            ticket.setConfirmationStatus("waiting list");
            waitingTickets.add(ticket);
            applyTickets.add(ticket);
        }
        else
            System.out.println("no available tickets");
        display(ticket);

    }
    public void cancelTicket(Ticket ticket)
    {
       if(remove(ticket,confirmedTickets))
        {
            confirmedTickets.add(confirmedTickets.size(),racTickets.get(0));
            racTickets.remove(0);
            if(!waitingTickets.isEmpty())
            {
                racTickets.add(racTickets.size(),waitingTickets.get(0));
                waitingTickets.remove(0);
            }
       }
       else if(remove(ticket,racTickets))
        {
            if(!waitingTickets.isEmpty())
            {
            racTickets.add(racTickets.size(),waitingTickets.get(0));
            waitingTickets.remove(0);
            }
        }
       else if(remove(ticket,waitingTickets))
           return;
       else {
           System.out.println("cancel ticket is not available");
           return;
       }
    }
    public boolean remove(Ticket ticket,ArrayList<Ticket> deleteTickets)
    {
        for (Ticket tics:deleteTickets)
        {
            if(tics.getName().equals(ticket.getName())&&tics.getAge()==ticket.getAge())
                return true;
        }
        return false;
    }
    public void display(Ticket t)
    {
        System.out.println("Name:"+t.getName()+" "+"Age:"+t.getAge()+" "+"Gender:"+t.getGender()+" "+"BerthPreference:"+t.getBerthPreference()+" "+"Booked Status:"+t.getConfirmationStatus()+"Ticket status:"+ticketStatus(t).indexOf(t));
    }
    public ArrayList<Ticket> ticketStatus(Ticket t)
    {
        if(confirmedTickets.contains(t))
            return confirmedTickets;
        else if (racTickets.contains(t))
            return racTickets;
        else
            return waitingTickets;
    }
    public void displayAll()
    {
        System.out.println("Confirmed tickets:");
        for (Ticket t:confirmedTickets)
            System.out.println("Name:"+t.getName()+" "+"Age:"+t.getAge()+" "+"Gender:"+t.getGender()+" "+"BerthPreference:"+t.getBerthPreference()+" "+"Booked Status:"+t.getConfirmationStatus()+"Ticket status:"+ticketStatus(t).indexOf(t));
        System.out.println("Rac Tickets:");
        for (Ticket t:racTickets)
            System.out.println("Name:"+t.getName()+" "+"Age:"+t.getAge()+" "+"Gender:"+t.getGender()+" "+"BerthPreference:"+t.getBerthPreference()+" "+"Booked Status:"+t.getConfirmationStatus()+"Ticket status:"+ticketStatus(t).indexOf(t));
        System.out.println("Rac Tickets:");
        System.out.println("Waiting tickets");
        for (Ticket t:waitingTickets)
            System.out.println("Name:"+t.getName()+" "+"Age:"+t.getAge()+" "+"Gender:"+t.getGender()+" "+"BerthPreference:"+t.getBerthPreference()+" "+"Booked Status:"+t.getConfirmationStatus()+"Ticket status:"+ticketStatus(t).indexOf(t));
        System.out.println("Rac Tickets:");
        System.out.println("All applied tickets:");
        for (Ticket t:applyTickets)
            System.out.println("Name:"+t.getName()+" "+"Age:"+t.getAge()+" "+"Gender:"+t.getGender()+" "+"BerthPreference:"+t.getBerthPreference()+" "+"Booked Status:"+t.getConfirmationStatus()+" "+"Ticket status:"+ticketStatus(t).indexOf(t));
        System.out.println("Rac Tickets:");
    }
    public void availableTicket()
    {
        System.out.println("Available Tickets:");
        int confirmedCount=63-confirmedTickets.size();
        int RacCount=18-racTickets.size();
        int waitingCount=10-confirmedTickets.size();
        System.out.println("confirmedTickets:"+confirmedCount);
        System.out.println("RacTickets:"+RacCount);
        System.out.println("waitingTickets:"+waitingCount);
    }
}
