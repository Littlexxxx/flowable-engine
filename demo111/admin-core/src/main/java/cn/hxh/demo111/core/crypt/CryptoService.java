package cn.hxh.demo111.core.crypt;

/**
 * @author: xinhao.hu
 * @date: 2022/3/15 4:01 下午
 * @description:
 **/
public interface CryptoService {

    CryptoResponse encrypt(CryptoRequest request) throws IllegalAccessException, InstantiationException;

    CryptoResponse decrypt(CryptoRequest request);
}
