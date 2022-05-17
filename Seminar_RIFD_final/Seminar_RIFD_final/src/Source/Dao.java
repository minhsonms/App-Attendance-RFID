/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mthuan
 */
public class Dao {

    ConnectionDB connect = null;
    final int TIME=3;
    public Dao() {
        connect = new ConnectionDB();
    }

    public Student getStudentFromEPC(String EPC) {

        String qry = "select * from `student` WHERE `EPC`='" + EPC + "'";
        ResultSet rs = connect.sqlExcute(qry);

        if (rs == null) {
            return null;
        }
        try {
            if (rs.next()) {
                return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error getStudentFromEPC");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Student> getAllStudent() {
        String qry = "select * from `student`";
        ResultSet rs = connect.sqlExcute(qry);
        ArrayList<Student> resultList = new ArrayList<>();

        if (rs == null) {
            return resultList;
        }
        try {
            while (rs.next()) {
                resultList.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public InOut getLastInOutById(String id) {
        String qry = "select * from `in_out` Where `ID_STU`='" + id + "'";
        ResultSet rs = connect.sqlExcute(qry);
        InOut lastElement = null;
        if (rs == null) {
            return null;
        }
        try {
            while (rs.next()) {
                lastElement = new InOut(rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastElement;
    }

    public InOut getLastInOutById(String id, boolean status) {
        String qry = "select * from `in_out` Where `ID_STU`='" + id + "' And `STATUS`= " + status;
        ResultSet rs = connect.sqlExcute(qry);
        InOut lastElement = null;
        if (rs == null) {
            return null;
        }
        try {
            while (rs.next()) {
                lastElement = new InOut(rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastElement;
    }

    public void addnewInOut(Student stu, String time, JTable table, ArrayList<Student> dataStu) {
        InOut io = getLastInOutById(stu.getId());
        boolean status = true;

        if (io == null) {
            String qry = "INSERT INTO `in_out`(`ID_STU`, `TIME`, `STATUS`) VALUES ('" + stu.getId() + "','" + time + "',true);";
            connect.sqlUpdate(qry);
            updateGui(dataStu, table, stu, time, status);
        } else {
            status = io.isStatus() ? false : true;
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime last = LocalDateTime.parse(io.getTime());

            int second = (int) last.until(now, ChronoUnit.SECONDS);
            if (second >= TIME) {
                String qry = "INSERT INTO `in_out`(`ID_STU`, `TIME`, `STATUS`) VALUES ('" + stu.getId() + "','" + time + "'," + status + ");";
                connect.sqlUpdate(qry);
                updateGui(dataStu, table, stu, time, status);
            }

        }
    }

    private void updateGui(ArrayList<Student> dataStu, JTable table, Student stu, String time, boolean status) {
        for (int i = 0; i < dataStu.size(); i++) {
            if (dataStu.get(i).getId().compareTo(stu.getId()) == 0) {
                Student tmp = dataStu.get(i);
                if (status) {
                    tmp.setIn(time);
                } else {
                    tmp.setOut(time);
                }
                break;
            }

        }

        loadTableData(dataStu, table);
    }

    

    private void loadTableData(ArrayList<Student> dataStudent, JTable table) {
        deleteTable(table);

        DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
        for (Student stu : dataStudent) {
            stu.setIn(stu.getIn());
            stu.setOut(stu.getOut());

            Object[] item = {stu.getId(), stu.getEPC(), stu.getName(), stu.getBirthday(), stu.getSex() ? "Nam" : "Nữ", stu.getClasses(),stu.getIn(), stu.getOut()};
            defaultTable.addRow(item);
        }

    }

    private void deleteTable(JTable table) {
        if(table == null){
           return;
        }
        DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
        for (int i = defaultTable.getRowCount() - 1; i >= 0; i--) {
            defaultTable.removeRow(i);
        }
    }

    public boolean removeStudent(String id) {
        String qry = "DELETE FROM `in_out` WHERE `ID_STU`='"+id+"';";       
        String qry_2 = "DELETE FROM `student` WHERE `ID`='"+id+"';";
        
        return connect.sqlUpdate(qry) && connect.sqlUpdate(qry_2);
    }

    Student getStudentById(String id) {
         String qry = "select * from `student` WHERE `ID`='" + id + "'";
        ResultSet rs = connect.sqlExcute(qry);

        if (rs == null) {
            return null;
        }
        try {
            if (rs.next()) {
                return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error getStudentFromID");
            e.printStackTrace();
        }
        return null;
    }

    boolean updateStu(Student editStu) {
        String qry = "UPDATE `student` SET `EPC`='"+editStu.getEPC()+"',`NAME`='"+editStu.getName()+"',`BIRTHDAY`='"+editStu.getBirthday()+"',`SEX`="+editStu.getSex()+",`CLASS`='"+editStu.getClasses()+"' WHERE `ID`='"+editStu.getId()+"';";
        return connect.sqlUpdate(qry);
    }

    boolean addNewStu(Student editStu) {
        String qry = "INSERT INTO `student`(`ID`, `EPC`, `NAME`, `BIRTHDAY`, `SEX`, `CLASS`) "
                + "VALUES ('"+editStu.getId()+"','"+editStu.getEPC()+"','"+editStu.getName()+"','"+editStu.getBirthday()+"',"+editStu.getSex()+",'"+editStu.getClasses()+"');";
        return connect.sqlUpdate(qry);
    }

    ArrayList<InOut> getAllInOut() {
        String qry = "select * from `in_out`";
        ResultSet rs = connect.sqlExcute(qry);
        ArrayList<InOut> resultList = new ArrayList<>();

        if (rs == null) {
            return resultList;
        }
        try {
            while (rs.next()) {
                resultList.add(new InOut(rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
    public ArrayList<InOut> getAllStudent_fil(String id) {
        String qry = "select * from `in_out`;";
        ResultSet rs = connect.sqlExcute(qry);
        ArrayList<InOut> resultList = new ArrayList<>();

        if (rs == null) {
            return resultList;
        }
        try {
            while (rs.next()) {
                String []ar = rs.getString(3).split("T");
                if(id.equals(ar[0])) {
                 resultList.add(new InOut( rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getString(4)) ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0; i < resultList.size(); i++)
            for(int j = 0 ; j !=i && j < resultList.size();j++)
            if(resultList.get(i).getId().equals(resultList.get(j).getId()))
                resultList.remove(resultList.get(i));
            
            
        return resultList;
    }
    ArrayList<InOut> getAllInOut_fil(String s) {
        String qry = "select * from `in_out` where `TIME`='" + s + "'";
        ResultSet rs = connect.sqlExcute(qry);
        ArrayList<InOut> resultList = new ArrayList<>();

        if (rs == null) {
            return resultList;
        }
        try {
            while (rs.next()) {
                resultList.add(new InOut(rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
    
    
}
