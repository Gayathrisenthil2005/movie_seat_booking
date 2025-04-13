package java_course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class movie_ticket {
    static ArrayList<JButton> selectedSeats = new ArrayList<>();
    static ArrayList<JButton> bookedSeats = new ArrayList<>();
    static JTextField messageField;

    public static void main(String args[]) {
        JFrame f = new JFrame("Movie Booking");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BackgroundPanel and set it as the content pane
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\gayat\\OneDrive\\Desktop\\movie_seat_booking\\movie_image.jpg");
        f.setContentPane(backgroundPanel);  // Set the background panel as content pane
        f.setLayout(null);  // Using null layout to manually position components

        messageField = new JTextField();
        messageField.setBounds(50, 430, 400, 30);
        f.add(messageField);

        // Seat buttons 
        JButton a1 = new JButton("A");
        a1.setBounds(50, 120, 50, 50);
        f.add(a1);
        JButton b2 = new JButton("B");
        b2.setBounds(50, 170, 50, 50);
        f.add(b2);
        JButton c3 = new JButton("C");
        c3.setBounds(50, 220, 50, 50);
        f.add(c3);
        JButton D4 = new JButton("D");
        D4.setBounds(50, 270, 50, 50);
        f.add(D4);
        JButton E5 = new JButton("E");
        E5.setBounds(50, 320, 50, 50);
        f.add(E5);
        JButton one = new JButton("A1");
        one.setBounds(120, 120, 50, 50);
        f.add(one);
        JButton two = new JButton("A2");
        two.setBounds(170, 120, 50, 50);
        f.add(two);
        JButton three = new JButton("A3");
        three.setBounds(220, 120, 50, 50);
        f.add(three);
        JButton four = new JButton("A4");
        four.setBounds(270, 120, 50, 50);
        f.add(four);

        JButton five = new JButton("B1");
        five.setBounds(120, 170, 50, 50);
        f.add(five);
        JButton six = new JButton("B2");
        six.setBounds(170, 170, 50, 50);
        f.add(six);
        JButton seven = new JButton("B3");
        seven.setBounds(220, 170, 50, 50);
        f.add(seven);
        JButton eight = new JButton("B4");
        eight.setBounds(270, 170, 50, 50);
        f.add(eight);

        JButton nine = new JButton("C1");
        nine.setBounds(120, 220, 50, 50);
        f.add(nine);
        JButton ten = new JButton("C2");
        ten.setBounds(170, 220, 50, 50);
        f.add(ten);
        JButton eleven = new JButton("C3");
        eleven.setBounds(220, 220, 50, 50);
        f.add(eleven);
        JButton twelve = new JButton("C4");
        twelve.setBounds(270, 220, 50, 50);
        f.add(twelve);

        JButton thirteen = new JButton("D1");
        thirteen.setBounds(120, 270, 50, 50);
        f.add(thirteen);
        JButton fourteen = new JButton("D2");
        fourteen.setBounds(170, 270, 50, 50);
        f.add(fourteen);
        JButton fifteen = new JButton("D3");
        fifteen.setBounds(220, 270, 50, 50);
        f.add(fifteen);
        JButton sixteen = new JButton("D4");
        sixteen.setBounds(270, 270, 50, 50);
        f.add(sixteen);

        JButton seventeen = new JButton("E1");
        seventeen.setBounds(120, 320, 50, 50);
        f.add(seventeen);
        JButton eighteen = new JButton("E2");
        eighteen.setBounds(170, 320, 50, 50);
        f.add(eighteen);
        JButton nineteen = new JButton("E3");
        nineteen.setBounds(220, 320, 50, 50);
        f.add(nineteen);
        JButton twenty = new JButton("E4");
        twenty.setBounds(270, 320, 50, 50);
        f.add(twenty);

        // Booking and canceling buttons
        JButton booking = new JButton("Booking");
        booking.setBounds(100, 370, 100, 50);
        booking.setBackground(Color.GREEN);
        f.add(booking);

        JButton canceling = new JButton("Cancel");
        canceling.setBounds(250, 370, 100, 50);
        canceling.setBackground(Color.RED);
        f.add(canceling);

        // Add seat listeners
        addSeatListener(one);
        addSeatListener(two);
        addSeatListener(three);
        addSeatListener(four);
        addSeatListener(five);
        addSeatListener(six);
        addSeatListener(seven);
        addSeatListener(eight);
        addSeatListener(nine);
        addSeatListener(ten);
        addSeatListener(eleven);
        addSeatListener(twelve);
        addSeatListener(thirteen);
        addSeatListener(fourteen);
        addSeatListener(fifteen);
        addSeatListener(sixteen);
        addSeatListener(seventeen);
        addSeatListener(eighteen);
        addSeatListener(nineteen);
        addSeatListener(twenty);

        // Booking button
        booking.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (selectedSeats.isEmpty())
                {
                    messageField.setText("No seats selected for booking.");
                } 
                else 
                {
                    String bookedSeatsText = "Booked: ";
                    for (JButton seat : selectedSeats) 
                    {
                        seat.setBackground(Color.ORANGE);
                        bookedSeats.add(seat);
                        bookedSeatsText += seat.getText() + " ";
                    }
                    messageField.setText(bookedSeatsText);
                    selectedSeats.clear();
                }
            }
        });

        // Cancel button
        canceling.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ArrayList<JButton> toRemove = new ArrayList<>();
                String canceledSeatsText = "Canceled: ";
                for (JButton seat : bookedSeats)
                {
                    if (seat.getBackground() == Color.RED) 
                    {
                        seat.setBackground(Color.WHITE);
                        toRemove.add(seat);
                        canceledSeatsText += seat.getText() + " ";
                    }
                }
                bookedSeats.removeAll(toRemove);
                if (toRemove.isEmpty()) 
                {
                    messageField.setText("No seats selected for cancellation.");
                } 
                else
                {
                    messageField.setText(canceledSeatsText);
                }
            }
        });

        f.setVisible(true);
    }

    public static void addSeatListener(JButton seat)
    {
        seat.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (bookedSeats.contains(seat)) 
                {
                    if (seat.getBackground() == Color.ORANGE) 
                    {
                        seat.setBackground(Color.RED);
                    }
                    else if (seat.getBackground() == Color.RED) 
                    {
                        seat.setBackground(Color.ORANGE);
                    }
                } 
                else
                {
                    if (selectedSeats.contains(seat))
                    {
                        seat.setBackground(Color.WHITE);
                        selectedSeats.remove(seat);
                    } 
                    else 
                    {
                        seat.setBackground(Color.GREEN);
                        selectedSeats.add(seat);
                    }
                }
            }
        });
    }
}
