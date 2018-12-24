import java.io.IOException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
            System.out.println("Write your expression");
            Scanner scanner=new Scanner(System.in);
            String string = scanner.nextLine();
            System.out.println(PolishRecord.NewExpression(string));
            System.out.println(PolishRecord.ToAnswer(PolishRecord.NewExpression(string)));

//        FileInputStream in = null;
//        BufferedReader bufferedReader = null;

//        try {
//            bufferedReader = new BufferedReader(
//                    new FileReader("/Users/vladimirlozickiy/Desktop/project/src/main/resources/data.csv"));
//            String line = bufferedReader.readLine();
//            while(line != null){
//                //read your line
//            }
//            in = new FileInputStream("/Users/vladimirlozickiy/Desktop/project/src/main/resources/data.csv");
//            int c;
//            while ((c = in.read()) != -1) {
//                //read your bytes (c)
//            }
//
//
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if(bufferedReader!=null){
//                bufferedReader.close();
//            }
//        }

        }

      }





