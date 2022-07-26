package cn.hxh.demo111.core.crypt;

import java.security.Key;
import java.security.KeyPair;

/**
 * @author: xinhao.hu
 * @date: 2022/3/15 4:10 下午
 * @description:
 **/
public interface KeyPairGenerator {
    KeyPair generatorKeyPair();
}
