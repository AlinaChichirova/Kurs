import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class FileHandler {
   File file = new File("members.csv");
    public LinkedList<Member> readFile() {
        LinkedList<Member> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("members.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
               Member member = new Member('m',1,"dh",900);
                list.add(member);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void appendFile(String mem){
        try (FileWriter fw = new FileWriter("members.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(mem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void overwriteFile(LinkedList<Member> m){
        try (PrintWriter writer = new PrintWriter(new FileWriter("members.temp"))) {
        for (Member member : m) {
            writer.println(member);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

        File file = new File("members.csv");
        if (file.delete()) {
            File tempFile = new File("members.temp");
            if (!tempFile.renameTo(file)) {
                System.out.println("Could not rename temporary file");
            }
        } else {
            System.out.println("Could not delete original file");
        }
    }

}
