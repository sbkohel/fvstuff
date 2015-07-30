
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SKohel
 */
public class DrakeCSVParser {
    
    private static ArrayList readFile(String filename){
        String line, field;
        int rowIndex = 0, colIndex;
        ArrayList<ArrayList> table = new ArrayList();
        try{
            Scanner scan = new Scanner(new File(filename));            
            while (scan.hasNext()){
                colIndex = 0;
                line = scan.nextLine();
                line = line.replaceAll(",,", ",***,");
                line = line.replaceAll(",,", ",***,");
                ArrayList<String> row = new ArrayList();
                Scanner scan2 = new Scanner(line);
                scan2.useDelimiter("[,]+");
                while (scan2.hasNext()){
                    field = scan2.next();
                    if (!field.equals("***"))
                        row.add(colIndex,field);
                    else 
                        row.add(colIndex,"null");
                    colIndex++;
                }
                table.add(rowIndex, row);
                rowIndex++;                
            }            
            scan.close();            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return table;
    }
    
    private static void printByList(int[] printList, ArrayList<ArrayList> dataList){
        for (ArrayList tempList : dataList) {
            for (int index : printList){
                System.out.print(tempList.get(index) + " ");
            }
            System.out.print("\n");
        }
    }
    
    public static void main(String args[]){
        int[] Customer = new int[] {1,2,3};
        ArrayList<ArrayList> myList =  DrakeCSVParser.readFile("/home/sterling/Downloads/CLIENT.CSV");
        DrakeCSVParser.printByList(Customer, myList);
    }
}
