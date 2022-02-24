package xyz.akaksr.scs.util.map;

import java.util.HashMap;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

public class ConvertHashMap {
    // private final Logger logger = LoggerFactory.getLogger(ConvertHashMap.class);
    String data;

    public ConvertHashMap(String data) {
        this.data = data;
    }

    public HashMap<String, String> getData() {
        HashMap<String, String> result = new HashMap<>();

        String tmp = data.replace("ServerVo(", "").replace(")", ")");
        String[] tmpArr = tmp.split(", ");

        for (int i = 0; i < tmpArr.length; i++) {
            String key = tmpArr[i].split("=")[0];
            String value = tmpArr[i].split("=")[1];
            result.put(key, value);
        }

        return result;
    }
}
