import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> rows = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        DateTime dt = new DateTime();
        dt.setDateTime(2,3,2019,2,1);
        System.out.println(dt);

        //loadDataFromTxt();

        for (String str:rows)
        {
            System.out.println(str);
        }
    }



    static void loadDataFromTxt() throws FileNotFoundException
    {
        String path = "res/data.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            //Scan everyline and append to arrayList
            rows.add(scanner.nextLine());
        }
    }
}
