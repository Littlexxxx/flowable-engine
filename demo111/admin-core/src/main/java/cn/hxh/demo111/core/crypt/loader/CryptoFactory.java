package cn.hxh.demo111.core.crypt.loader;

import cn.hxh.demo111.core.crypt.CryptoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: xinhao.hu
 * @date: 2022/3/15 4:33 下午
 * @description:
 **/
public class CryptoFactory {
    private Map<String,Class<?>> cryptoServiceMap = new HashMap<>();

    private Map<String,Class<?>> keyGeneratorMap = new HashMap<>();

    private Map<String,Class<?>> keyPairGeneratorMap = new HashMap<>();

    private Map<String,Class<?>> saltGeneratorMap = new HashMap<>();

    static {
        // init

    }

    public CryptoService getInstance(String type) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = cryptoServiceMap.get(type);
        if(Objects.isNull(clazz)){
            clazz = CryptoLoader.getExtensionLoader(CryptoService.class).getExtension(type);
        }
        if(Objects.isNull(clazz)){
            throw new RuntimeException("");
        }
        return (CryptoService)clazz.newInstance();

    }

    public CryptoService getInstance() throws IllegalAccessException, InstantiationException {
        Class<?> clazz = cryptoServiceMap.get("defalut");
        return (CryptoService)clazz.newInstance();
    }

}
