package q.edu.remindermanager;
import java.util.ArrayList;

public class listType {
    public int listSize ;
    public ArrayList<reminderType> finalList;

    listType() {
        finalList = new ArrayList<reminderType>();
    }

    public ArrayList<reminderType> getFinalList(){
        return finalList;
    }

    public int getListSize(){
        return listSize;
    }

    public void deleteList(int a) {

        finalList.remove(a);
        listSize = finalList.size();
    }
}
