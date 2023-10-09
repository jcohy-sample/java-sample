package com.jcohy.sample.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/19:02:13
 * @since 2022.04.0
 */
public class PipeTest {
	@Test
	public void pipe() throws IOException {
		//1. 获取管道
		Pipe pipe = Pipe.open();
		//2. 将缓冲区中的数据写入管道
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Pipe.SinkChannel sinkChannel = pipe.sink();
		buffer.put("通过单向管道发送数据".getBytes());
		buffer.flip();
		sinkChannel.write(buffer);
		//3. 读取缓冲区中的数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		buffer.flip();
		int len = sourceChannel.read(buffer);
		System.out.println(new String(buffer.array(), 0, len));

		sourceChannel.close();
		sinkChannel.close();
	}
}
