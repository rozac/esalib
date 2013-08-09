package common.graph;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.FileUtils;


/**
 * Created with IntelliJ IDEA.
 * User: roza
 * Date: 04/08/13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class ReadJsonCategory {

    public Category parseJson() throws IOException {

        String jsonTxt = FileUtils.readFileToString(new File("categories.json"));

        JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );
        String nauka = json.getString( "name" );
        Category root = new Category(nauka);
        JSONArray children = json.getJSONArray("children");
        for (int i = 0; i < children.length(); i++) {
            JSONObject subJson = children.getJSONObject(i);
            String name = subJson.getString("name");
            Category c = root.addSubcategory(name);
            System.out.println(name);
            if(subJson.has("children")){
                JSONArray grandchildren = subJson.getJSONArray("children");
                for (int j = 0; j < children.length(); j++) {
                    JSONObject subJson2 = grandchildren.getJSONObject(j);
                    String name2 = subJson2.getString("name");
                    c.addSubcategory(name2);
                }
            }
        }
        return root;
    }

    private StringBuilder innerSaveToJson(Category c){

        String name = c.name;
        StringBuilder jsonString = new StringBuilder("");
        jsonString.append("{\"name\": \"" + name + "\",\n\"size\": " + 4000);
        if(c.hasChildren()){
            jsonString.append(",\n\"children\": [\n");
            for(Category subCat : c.getSubcategories()){
                jsonString.append(innerSaveToJson(subCat));
                jsonString.append(",\n");
            }
            jsonString.delete(jsonString.length() - 2, jsonString.length());
            jsonString.append("\n]");
        }
        jsonString.append("\n}");
        return jsonString;

    }

    public void saveToJson(Category root) throws IOException {

        StringBuilder jsonString = innerSaveToJson(root);

        FileUtils.writeStringToFile(new File("categories2.json"), jsonString.toString());

    }
}
