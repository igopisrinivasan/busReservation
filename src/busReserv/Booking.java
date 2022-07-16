package busReserv;
import java.awt.print.Book;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of Passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter Bus No : ");
        busNo = scanner.nextInt();
        System.out.println("Enter Date (dd-mm-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.parse(dateInput);
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses){
        int capacity = 0;
        for(Bus bus:buses){
            if(bus.getBusNo()== busNo)
                capacity = bus.getCapacity();

        }
        int booked = 0;
        for(Booking b:bookings){
            if(b.busNo == busNo && b.date.equals(date)){
                booked++;
            }
        }

        return booked<capacity?true:false;
    }
}
