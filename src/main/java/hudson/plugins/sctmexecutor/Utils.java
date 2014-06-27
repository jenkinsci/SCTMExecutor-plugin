package hudson.plugins.sctmexecutor;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Utils {
  public static List<Integer> splitToIntList(String execDefIds) {
    List<Integer> list = new LinkedList<Integer>();
    if (execDefIds.contains(",") || execDefIds.contains(" ")) { //$NON-NLS-1$
      String[] ids = execDefIds.split(" *[ ,] *"); //$NON-NLS-1$
      for (String str : ids) {
        list.add(Integer.valueOf(str));
      }
    } else {
      list.add(Integer.valueOf(execDefIds));
    }
    return list;
  }
  
  public static Map<String, String> splitToMap(String content) {    
    Map<String, String> map = new LinkedHashMap<String, String>();    
    if (content != null && !content.isEmpty()) {      
        for (String keyValue: content.split(" *\n *")) {
          String[] pair = keyValue.split(" *= *", 2);
          map.put(pair[0], pair.length == 1 ? "" : pair[1]);          
          
          System.out.println("KeyValue=" + keyValue);          
        }
    }    
    return map;
  }
}
