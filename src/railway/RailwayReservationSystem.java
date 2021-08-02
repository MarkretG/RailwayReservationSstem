package railway;

import java.util.Scanner;

public class RailwayReservationSystem {
    static Scanner sc=new Scanner(System.in);
    static Train train=new Train();
    public static void main(String[] args) {
        System.out.println("welcome to railway reservation system");
        System.out.println("Enter your choice");
        System.out.println("1.Booking Tickets"+" "+"2.cancel Tickets"+"3.print all booked tickets"+" "+"4.print available tickets"+" "+"5.exit");
        while (true)
        {
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    train.bookTicket(getTicketDetails());
                    break;
                case 2:
                    train.cancelTicket(getTicketDetails());
                    break;
                case 3:
                    train.displayAll();
                    break;
                case 4:
                    train.availableTicket();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    public static Ticket getTicketDetails()
    {
        System.out.println("enter name");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("enter age");
        int age=sc.nextInt();
        System.out.println("enter gender");
        sc.nextLine();
        String gender=sc.nextLine();
        System.out.println("enter berth");
        String berth=sc.nextLine();
         return new Ticket(name,age,gender,berth);
    }
}
