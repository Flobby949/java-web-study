package top.flobby.web.util;

import org.apache.commons.codec.binary.Base64;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static top.flobby.web.common.Const.*;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 09:16
 **/

public class DownloadUtil {

    private DownloadUtil() {

    }

    /**
     * TODO encode方法异常
     */
    public static String getFileName(String agent, String filename) {
        if (agent.toLowerCase().contains(MSIE)) {
            // IE浏览器
            // filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            filename = filename.replace("+", " ");
        } else if (agent.toLowerCase().contains(FIREFOX)) {
            // 火狐浏览器
            Base64 base64Encoder = new Base64();
            filename = "=utf-8?B?" + Arrays.toString(base64Encoder.encode(filename.getBytes(StandardCharsets.UTF_8)));
        } else {
            // 其他服务器
            // filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        }
        return filename;
    }
}
