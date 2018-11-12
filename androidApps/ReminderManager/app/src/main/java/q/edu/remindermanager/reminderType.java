package q.edu.remindermanager;
import java.util.ArrayList;

public class reminderType {
    public String listName;
    public ArrayList<Reminders> listOfReminderTypes;
    public int sizeOfReminderTypes;

    reminderType(String name){
        listName = name;
        listOfReminderTypes = new ArrayList<Reminders>();
    }

    void addReminderType(Reminders a){
        listOfReminderTypes.add(a);
        sizeOfReminderTypes = listOfReminderTypes.size();
    }

    void deleteReminder(int index) {
        listOfReminderTypes.remove(index);
        sizeOfReminderTypes = listOfReminderTypes.size();
    }

//	void editReminder(String a, int x) {
//		list.set(x, a);
//	}

    public ArrayList<Reminders>getReminderType(){
        return listOfReminderTypes;
    }

    public String getLisName() {
        return this.listName;
    }

    public int getReminderTypeSize() {
        return sizeOfReminderTypes;
    }


}
