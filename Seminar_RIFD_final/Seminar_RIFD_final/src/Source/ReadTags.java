package Source;

import com.impinj.octane.*;
import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class ReadTags {

    ArrayList<TagData> listTag = new ArrayList<>();
    Dao dao = null;
    JTable table = null;
    ArrayList<Student> dataStu = null;
    ImpinjReader reader = null;

    public ReadTags(Dao d, JTable t,ArrayList<Student> data) {
        this.dao = d;
        this.table = t;
        this.dataStu = data;
    }

    public void read(String command) {
         try {
            //String hostname = System.getProperty(SampleProperties.hostname);
            String hostname = "169.254.96.13";

            if (hostname == null) {
                throw new Exception("Must specify the '"
                        + SampleProperties.hostname + "' property");
            }

            reader = new ImpinjReader();

            System.out.println("Connecting");
            reader.connect(hostname);

            Settings settings = reader.queryDefaultSettings();

            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(true);
            report.setMode(ReportMode.Individual);

            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments.
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader's configuration
            settings.setReaderMode(ReaderMode.AutoSetDenseReader);

            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            antennas.disableAll();
            antennas.enableById(new short[]{1});
            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
            antennas.getAntenna((short) 1).setTxPowerinDbm(20.0);
            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);

            reader.setTagReportListener(new TagReportListenerImplementation(dao,table,dataStu));

            System.out.println("Applying Settings");
            reader.applySettings(settings);

            System.out.println("Starting");
            reader.start();

            System.out.println("Press Enter to exit.");
            Scanner s = new Scanner(System.in);
            s.nextLine();
                    


            reader.stop();
            reader.disconnect();
            
        } catch (OctaneSdkException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
         
    }

    public ArrayList<TagData> getListTag() {
        return listTag;
    }
    
    public void close(){
        try {
            reader.stop();
            reader.disconnect();
        } catch (OctaneSdkException ex) {
            Logger.getLogger(ReadTags.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
