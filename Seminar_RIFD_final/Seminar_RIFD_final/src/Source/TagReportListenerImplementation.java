package Source;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagData;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class TagReportListenerImplementation implements TagReportListener {

    ArrayList<TagData> listTag = new ArrayList<>();
    Dao dao = null;
    JTable table = null;
    ArrayList<Student> dataStu = null;

    public TagReportListenerImplementation( Dao d, JTable t, ArrayList<Student> stuData) {
        
        this.dao = d;
        this.table = t;
        this.dataStu = stuData;
    }

    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        List<Tag> tags = report.getTags();

        for (Tag t : tags) {
            if (isExistTag(listTag, t.getEpc())) {
                continue;
            }
            listTag.add(t.getEpc());
        }

        System.out.println(listTag);

       if (listTag.isEmpty()) {
            return;
        }

        for (TagData t : listTag) {
            
            Student stu = dao.getStudentFromEPC(t.toHexString());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");//HH:mm:ss
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");//
            
            LocalDateTime now = LocalDateTime.now();
            
            if (stu != null) {
                dao.addnewInOut(stu, dtf.format(now) + "T" + dtf2.format(now), table, dataStu);
            }

        }

        listTag = new ArrayList<>();
         System.out.println(listTag);
    }

    private boolean isExistTag(ArrayList<TagData> listTag, TagData t) {
        for (TagData value : listTag) {
            if (value.toHexString().compareTo(t.toHexString()) == 0) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<TagData> getListTag() {
        return listTag;
    }
}
