package cn.hxh.demo111.core.crypt.impl;

import cn.hxh.demo111.core.crypt.*;
import cn.hxh.demo111.core.crypt.loader.CryptoLoader;

/**
 * @author: xinhao.hu
 * @date: 2022/3/15 4:06 下午
 * @description:
 **/
public class SM1 implements CryptoService {
    @Override
    public CryptoResponse encrypt(CryptoRequest request) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = CryptoLoader.getExtensionLoader(KeyGenerator.class).getExtension("default");
        KeyGenerator key = (KeyGenerator)clazz.newInstance();
        return null;
    }

    @Override
    public CryptoResponse decrypt(CryptoRequest request) {
        return null;
    }

}
