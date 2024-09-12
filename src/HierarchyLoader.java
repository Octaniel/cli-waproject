import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.Map;

public class HierarchyLoader {
    private Map<String, Object> hierarchy;

    public HierarchyLoader(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            hierarchy = new Gson().fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getHierarchy() {
        return hierarchy;
    }
}
