package com.jcohy.sample.nio;

import java.nio.ByteBuffer;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * 一、缓冲区(Buffer): 在 Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同(boolean 除外)，提供了相应类型的缓冲区: ByteBuffer CharBuffer ShortBuffer IntBuffer
 * LongBuffer FloatBuffer DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法: put() : 存入数据到缓冲区中 get() : 获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性: capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。 limit :
 * 界限，表示缓冲区中可以操作数据的大小。(limit 后数据不能进行读写) position : 位置，表示缓冲区中正在操作数据的位置。
 *
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区与非直接缓冲区: 非直接缓冲区: 通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中 直接缓冲区: 通过
 * allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
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
