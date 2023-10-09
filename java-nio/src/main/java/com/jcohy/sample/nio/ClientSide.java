package com.jcohy.sample.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/15:00:56
 * @since 2022.04.0
 */
public class ClientSide {

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8080));
		FileChannel fileChannel = FileChannel.open(Paths.get("4.avi"), StandardOpenOption.READ);
		//2.分配一个缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//3.读取本地文件,并发送到服务端
		while (fileChannel.read(buffer) != -1){
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
		}
		socketChannel.shutdownOutput();
		//4.接受到服务端反馈
		int len = 0;
		while((len = socketChannel.read(buffer)) != -1){
			buffer.flip();
			System.out.println(new String(buffer.array(), 0, len));
			buffer.clear();
		}
		socketChannel.close();
		fileChannel.close();
	}
}
