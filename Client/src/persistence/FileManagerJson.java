package persistence;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.util.ArrayList;

public class FileManagerJson {



    public ArrayList<Object[]> readClients(String packedClients) throws DeserializationException {
        ArrayList<Object[]> arrayList = new ArrayList<>();
        JsonObject jSonObj = (JsonObject) Jsoner.deserialize(packedClients);
        JsonArray jsonArray =(JsonArray)jSonObj.get("Root");
        for (Object client:jsonArray) {
            JsonObject object1 = (JsonObject) client;
            String name = object1.getString("Name");
            String turn = object1.getString("Turn");
            arrayList.add(new Object[]{name,turn});
        }
        return arrayList;
    }
}
