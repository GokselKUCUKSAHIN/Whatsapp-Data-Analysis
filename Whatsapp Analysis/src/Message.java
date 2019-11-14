import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;

public class Message
{

    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();
    public static ArrayList<Integer> counts = new ArrayList<>();
    public static ArrayList<Integer> messageCount = new ArrayList<>();
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
            counts.add(0);
            messageCount.add(0);
            senderID = names.size() - 1; //last index of list
        }
    }

    public static void doAnalysis()
    {
        for (Message message : messages)
        {
            //For every messages
            int mCount = 0;
            int sid = message.senderID;
            String txt = message.text;
            for (int i = 0; i < txt.length(); i++)
            {
                if (txt.charAt(i) != ' ')
                {
                    mCount++;
                }
            }
            counts.set(sid, counts.get(sid) + mCount);
            //
            messageCount.set(sid,messageCount.get(sid)+1);
        }

    }
}
