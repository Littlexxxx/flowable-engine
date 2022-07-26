package cn.hxh.demo111.core.adapter.application.case3.jucTest.cas;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author: xinhao.hu
 * @date: 2021/12/31 11:43 上午
 * @description:
 **/
@Data
public class Unsafe {
    private int value;
    private volatile sun.misc.Unsafe unsafe;

    public Unsafe(int value){
        this.value = value;
        unsafe = getUnsafe();
    }

    public void addWithCAS(int A) throws NoSuchFieldException, IllegalAccessException{
       while(!compareAndSwap(value,getValueByMemory(),A));

    }

    public int getValueByMemory() throws NoSuchFieldException{
        Field field = this.getClass().getDeclaredField("value");
        field.setAccessible(true);
        Long offest = this.unsafe.objectFieldOffset(field);
        return unsafe.getIntVolatile(value,offest);
    }

    public sun.misc.Unsafe getUnsafe() {
        try{
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            sun.misc.Unsafe unsafe = (sun.misc.Unsafe) field.get(null);
            return unsafe;
        }catch (NoSuchFieldException e){
        }catch (IllegalAccessException ex){
        }
        return null;
    }

    public boolean compareAndSwap(int V,int A,int B){
        synchronized (this){
            if(V == A){
                value = A+B;
                return true;
            }
            return false;
        }

    }
}
