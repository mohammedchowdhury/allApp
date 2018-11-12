package q.edu.remindermanager;
import java.util.ArrayList;
public class Reminders {
    public ArrayList<String> list;
    public String appointMentType;
    public int listSize;

    Reminders(String name){
        appointMentType = name;
        list = new ArrayList<String>();
    }

    void addReminder(String rem){
        list.add(rem);
        listSize = list.size();
    }

    void deleteReminder(int index) {
        list.remove(index);
        listSize = list.size();
    }

    void editReminder(String a, int x) {
        list.set(x, a);
    }

    public ArrayList<String>getReminder(){
        return list;
    }

    public String getAppointTypeName() {
        return this.appointMentType;
    }

    public int getListSize() {
        return listSize;
    }

}
