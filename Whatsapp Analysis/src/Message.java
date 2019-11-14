import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;

public class Message
{

    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();
    //
    DateTime dateTime;
    String sender;
    int senderID;
    String text;

    //
    public Message(DateTime dateTime, String sender, String text)
    {
        this.dateTime = dateTime;
        this.sender = sender;
        this.text = text;
        checkID();
        messages.add(this);
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s", dateTime, sender, text);
    }

    private void checkID()
    {
        if (names.contains(sender))
        {
            senderID = names.indexOf(sender);
        } else
        {
            names.add(sender);
            senderID = names.size() - 1; //last index of list
        }
    }

    public String getSender()
    {
        return sender;
    }

    public int getSenderID()
    {
        return senderID;
    }

}
