package cn.hxh.demo111.core.crypt.loader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: xinhao.hu
 * @date: 2022/3/15 4:17 下午
 * @description:
 **/
public class CryptoLoader {

    private static final ConcurrentHashMap<Class<?>, CryptoLoader> LOADERS = new ConcurrentHashMap<>();

    private Class<?> type;

    public static CryptoLoader getExtensionLoader(Class<?> type) {
        return null;
    }

    private CryptoLoader(Class<?> type) {
        this.type = type;
    }

    public Class<?> getExtension(String classType) {
        return null;
    }

    private void loadFile(Map<String, Class<?>> extensionClasses, String dir) {
    }
}
