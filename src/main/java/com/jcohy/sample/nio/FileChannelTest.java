package com.jcohy.sample.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/14:22:47
 * @since 2022.04.0
 */
public class FileChannelTest {

	@Test
	void scatterAndGather() throws Exception {
		// 分散读取
		RandomAccessFile file = new RandomAccessFile("src/main/java/com/jcohy/sample/nio/1.txt","rw");
		FileChannel channel = file.getChannel();

		ByteBuffer buffer1 = ByteBuffer.allocate(48);
		ByteBuffer buffer2 = ByteBuffer.allocate(1024);

		ByteBuffer[] buffers = {buffer1,buffer2};

		channel.read(buffers);
		for (ByteBuffer byteBuffer : buffers) {
			byteBuffer.flip();
		}
		System.out.println(new String(buffer1.array(), 0, buffer1.limit()));
		System.out.println(new String(buffer2.array(),0,buffer2.limit()));

		// 聚集写入
		RandomAccessFile outFile = new RandomAccessFile("src/main/java/com/jcohy/sample/nio/2.txt","rw");
		outFile.getChannel().write(buffers);
	}

	/**
	 * 通道之间的数据传输(直接缓冲区)
	 * @throws IOException
	 */
	@Test
	void transTo() throws IOException {
		FileChannel inChannel = FileChannel.open(Path.of("d:/413.avi"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Path.of("d:/414.avi"), StandardOpenOption.READ, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
		inChannel.transferTo(0,inChannel.size(),outChannel);
		inChannel.close();
		outChannel.close();
	}

	/**
	 * MappedByteBuffer 采用 direct buffer 的方式读写文件内容,这种方式就是内存映射。
	 * 这种方式直接调用系统底层的缓存,没有JVM和系统之间的复制操作，所以效率非常高。主要用于操作大文件。
	 */
	@Test
	void mappedBuf() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("d:/413.avi"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("d:/444.mkv"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		MappedByteBuffer inMap = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMap = outChannel.map(MapMode.READ_WRITE, 0, outChannel.size());

		//直接对缓冲区进行数据的读写操作
		byte[] dst = new byte[inMap.limit()];
		inMap.get(dst);
		outMap.put(dst);
		inChannel.close();
		outChannel.close();
	}

	/**
	 * 利用通道完成文件的复制(非直接缓冲区)
	 */
	@Test
	void copy() throws IOException {
		try(var  inputStream = new FileInputStream("413.avi");
				var outputStream = new FileInputStream("414.avi")) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			var inChannel = inputStream.getChannel();
			var outChannel = outputStream.getChannel();
			while (inChannel.read(buffer) != -1) {
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear(); //清空缓冲区
			}
		}
	}
}

