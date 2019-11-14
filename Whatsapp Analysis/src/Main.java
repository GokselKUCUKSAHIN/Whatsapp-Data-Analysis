import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{

    static ArrayList<String> rows = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        loadDataFromTxt();
        String text = rows.get(41);
        Matcher matcher;
        //                DAY.MONTH.YEAR HOUR:MINUTE - USER_NAME: SOME TEXT FOO BAR BLAH BLAH
        String regex = "(\\d{2}).(\\d{2}).(\\d{4}) (\\d{2}):(\\d{2}) - ([A-Za-z ığüşöçİĞÜŞÖÇ]+): (.*)"; //tested
        Pattern newlinePattern = Pattern.compile(regex);
        for (String line : rows)
        {
            matcher = newlinePattern.matcher(line);
            if (matcher.find())
            {
                // 0 is whole line
                int day = Integer.parseInt(matcher.group(1));
                int month = Integer.parseInt(matcher.group(2));
                int year = Integer.parseInt(matcher.group(3));
                int hour = Integer.parseInt(matcher.group(4));
                int minute = Integer.parseInt(matcher.group(5));
                DateTime dt = new DateTime(day, month, year, hour, minute);
                //System.out.println(matcher.group(6));*/
                new Message(dt, matcher.group(6), matcher.group(7));
            }
        }
        Message.doAnalysis();
        for (int i = 0; i < Message.names.size(); i++)
        {
            System.out.println(Message.names.get(i) + ": " + Message.counts.get(i));
        }
        System.out.println("-------");
        for (int i = 0; i < Message.messageCount.size(); i++)
        {
            System.out.println(Message.names.get(i) + ": " + Message.messageCount.get(i));
        }
    }

    static void loadDataFromTxt() throws FileNotFoundException
    {
        String path = "../privateData/res/data.txt"; //res/data.txt //default
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            //Scan everyline and append to arrayList
            rows.add(scanner.nextLine());
        }
    }
}