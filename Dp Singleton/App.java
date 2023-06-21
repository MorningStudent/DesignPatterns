import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        DataCollection dataCollection = DataCollection.getInastance();
        dataCollection.add(10);
        dataCollection.add(20);
        dataCollection.add(30);

        //System.out.println(dataCollection.get(2));
        
        DataCollection dataCollection2 = DataCollection.getInastance();
        dataCollection2.add(40);

        System.out.println(dataCollection2.get(1));

        dataCollection2.remove(1);

        System.out.println(dataCollection2.get(1));

    }
}

class DataCollection {
    private Object[] data;

    private static DataCollection instance;

    public static DataCollection getInastance() {
        if(instance == null) {
            instance = new DataCollection();
        }
        return instance;

    }

    private DataCollection() {

    }

    public void add(Object object) {
        if(data == null) {
            data = new Object[1];
        } else {
            data = Arrays.copyOf(data, data.length + 1);
        }
        data[data.length - 1] = object;
    }

    public void remove(int index) {
        if(data == null) {

        } else {
            Object[] newData = new Object[data.length - 1];
            for (int i=0, j=0; i<data.length; i++) {
            if (i != index) {
                newData[j++] = data[i];
            }
        }
        data = newData;
        }
    }

    public Object get(int index) {
        return data[index];
    }
}