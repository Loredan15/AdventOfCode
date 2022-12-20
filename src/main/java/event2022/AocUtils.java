package event2022;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;

public class AocUtils {
    public static void downloadFile(int numberOfDay) throws IOException {
        String cookie = "53616c7465645f5f108ae04fda7cd05c9f4651477fa66a7c49c77a6c043c46a8594cc62553824865dd17c84917f0e789859a912120d9acc96c579abbd7e12ead";
        String cookie2 = System.getenv("SESSION");
        int year = LocalDate.now().getYear();
        String stringUrl = "https://adventofcode.com/" + year + "/day/" + numberOfDay + "/input";
        URL url = new URL(stringUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Cookie", "session=" + cookie);
        con.setInstanceFollowRedirects(true);
        int status = con.getResponseCode();
        if (status > 299) {
            System.out.println("Connection status " + status);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                System.exit(0);
            }
        }

        String fileName = "input_day" + numberOfDay + ".txt";
        try (InputStream is = con.getInputStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/2022/" + fileName)) {
                PrintStream ps = new PrintStream(fos);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    ps.println(inputLine);
                }
            }
            System.out.println("Input data saved to " + fileName);

        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }
    }

    public static String fileContents(int numberOfDay) throws IOException {
        String filename = "input_day" + numberOfDay + ".txt";
        return Files.readString(new File("src/main/resources/2022/" + filename).toPath());
    }

}
