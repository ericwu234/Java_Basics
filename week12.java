
import java.io.*;
public class week12 {
    public static void main(String[] args) throws IOException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        n=n-1;
        String str_l = "";//string that one line
        String str_r="";//string that replce sign
        String file = "article.txt";
        File a = new File(file);
        if (a.exists()) {
            BufferedReader input = new BufferedReader(new FileReader(a)); 
            while((str_l = input.readLine()) != null){
                String[] str_o = str_l.split(" ");//string that one word
                if(n<str_o.length){
                    str_r=str_o[n].replaceAll("\\pP","");
                    System.out.println(str_r);
                    break;
                }
                else{
                    n=n-str_o.length;
                }
            }
        }
    }
}