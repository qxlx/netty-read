package io.netty.qxlxi;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/9/2 21:52
 */
public class TestByteBuffer {

    private static Unsafe unsafe = null;

    static {

        try {

            Field getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");

            getUnsafe.setAccessible(true);

            unsafe = (Unsafe) getUnsafe.get(null);

        } catch (NoSuchFieldException | IllegalAccessException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws InterruptedException {
//        ByteBuffer byteBuffer = ByteBuffer.allocate(10 * 1024 * 1024);
//
        System.out.println(unsafe);
        long address = unsafe.allocateMemory(100 * 1024 * 1024);
        System.out.println(address);

        TimeUnit.MINUTES.sleep(1);
    }

}
