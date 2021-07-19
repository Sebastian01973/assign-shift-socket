package persistence;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagerJson {

    public static final String PATH_FILE_OUT = "resources/Clients.out";
    private File file;


    public File getFile() {
        return file;
    }

    public void writeClientToFile(ArrayList<Object[]> arrayList){
        try {
            file = new File(PATH_FILE_OUT);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            JsonObject root = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (Object[] o:arrayList) {
                JsonObject jsonObject1 = new JsonObject();
                jsonObject1.put("Name",o[0]);
                jsonObject1.put("Turn",o[1]);
                jsonArray.add(jsonObject1);
            }
            root.put("Root",jsonArray );
            fileWriter.write(root.toJson());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
