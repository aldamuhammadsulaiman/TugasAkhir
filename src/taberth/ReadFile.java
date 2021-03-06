package taberth;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadFile {
    public ReadFile(String file, ArrayList<String[]> arrship,ArrayList<Ship> listship)throws IOException {        
        int lineNumber=0;
        String text="";    
        
            FileReader fcr = new FileReader(file);
            BufferedReader cr = new BufferedReader(fcr);
            while ((text = cr.readLine()) != null) {
                lineNumber++;
                //tabel ship
                //header
                //Type Draft Length Width DWT Arrival Des_depart Manoeuvring_time Cost_Wait Cost_Delay Process_times_in_berths(0=Incompatible)(matrix)
                if(lineNumber > 141){
                    arrship.add(text.split(" "));
                }
            }
        //loop semua ship i
        //bikin objek ship dengan id i
        //isi atribut objek ship dari masing masing kolom pada ship i
        for (int i = 0; i<arrship.size() ; i++) {
            Ship ship = new Ship(i);
            for (String strArr : arrship.get(i)) {
                
                
              
                ship.setArrival(Double.parseDouble(arrship.get(i)[5]));
                ship.setDesDepart(Double.parseDouble(arrship.get(i)[6]));
                ship.setManouvTime(Integer.parseInt(arrship.get(i)[7]));
                ship.setCostWait(Integer.parseInt(arrship.get(i)[8]));
                ship.setCostDelay(Integer.parseInt(arrship.get(i)[9]));
                
                int[] proc = new int[11]; //jumlah berth
                int j = 10;
                for (int k = 0; k < proc.length; k++) {
                    proc[k]=Integer.parseInt(arrship.get(i)[j]);
                    j++;
                }
                ship.setProcessTimes(proc);
            }
            listship.add(ship);
        }
    }
}