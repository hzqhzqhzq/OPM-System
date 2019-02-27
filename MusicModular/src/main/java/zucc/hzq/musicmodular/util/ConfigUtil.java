package zucc.hzq.musicmodular.util;

import java.util.ResourceBundle;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:47 2019/1/28
 * @Description:
 * @Modified By:
 */
public class ConfigUtil {

    private static final ResourceBundle rs = ResourceBundle.getBundle("Config");

    public static String getKeyType(String key) {
        if (!rs.containsKey(key)) {
            return null;
        }
        return rs.getString(key);
    }
}
