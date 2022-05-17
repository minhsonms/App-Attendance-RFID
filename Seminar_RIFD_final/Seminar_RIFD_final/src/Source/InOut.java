/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author mthuan
 */
public class InOut {
    String id;
    String time;
    boolean status;

    public InOut(String id, String time, boolean status) {
        this.id = id;
        this.time = time;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InOut{" + "id=" + id + ", time=" + time + ", status=" + status + '}';
    }
    
    
    
}
