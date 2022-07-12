package com.jcohy.sample.nio;

import java.nio.ByteBuffer;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/12:18:12
 * @since 2022.0.1
 */
public class NioTest {

    @Test
    void allocate() {
        // 分配直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.isDirect());
    }

    @Test
    void method() {
        String str = "abcde";
        // 1、分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("-------------allocate----------");
        // 0
        System.out.println(buf.position());
        // 1024
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());

        // 2、利用put()存入数据到缓冲区
        System.out.println("-------------put----------");
        buf.put(str.getBytes());
        // 5
        System.out.println(buf.position());
        // 1024
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());

        // 3、切换到读取数据的模式
        System.out.println("-------------flip----------");
        buf.flip();
        // 0
        System.out.println(buf.position());
        // 5
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());

        // 4、读取数据
        System.out.println("-------------get----------");
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        // abcde
        System.out.println(new String(dst,0,dst.length));
        // 5
        System.out.println(buf.position());
        // 5
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());

        // 5、rewind()重读
        System.out.println("-------------rewind----------");
        buf.rewind();
        // 0
        System.out.println(buf.position());
        // 5
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());

        // 6、清空缓冲区,缓冲区中的数据依然存在,但是出于被 "遗忘状态"
        System.out.println("-------------clear----------");
        buf.clear();
        // 0
        System.out.println(buf.position());
        // 1024
        System.out.println(buf.limit());
        // 1024
        System.out.println(buf.capacity());
    }

    @Test
    void test2() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());

        buffer.flip();

        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        // ab
        System.out.println(new String(dst,0,2));
        // 2
        System.out.println(buffer.position());

        buffer.mark();
        buffer.get(dst,2,2);
        // cd
        System.out.println(new String(dst,2,2));
        // 4
        System.out.println(buffer.position());

        //reset() : 恢复到 mark 的位置
        buffer.reset();
        // 2
        System.out.println(buffer.position());

        //判断缓冲区中是否还有剩余数据
        if(buffer.hasRemaining()){
            //获取缓冲区中可以操作的数量
            // 3
            System.out.println(buffer.remaining());
        }
    }


}
