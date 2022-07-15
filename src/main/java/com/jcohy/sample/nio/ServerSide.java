package com.jcohy.sample.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/15:00:46
 * @since 2022.04.0
 */
public class ServerSide {

	public static void main(String[] args) throws IOException {
		// 1.获取通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 2.绑定端口
		serverSocketChannel.bind(new InetSocketAddress(8080));
		//3.获取客户端连接的通道
		SocketChannel socketChannel = serverSocketChannel.accept();
		//4.分配指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//5.接收客户端的数据,并保存到本地
		FileChannel outChannel = FileChannel.open(Path.of("d:/414.avi"),  StandardOpenOption.CREATE,StandardOpenOption.WRITE);
		while (socketChannel.read(buffer) != -1) {
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
		//6.发送反馈给客户端
		buffer.put("服务端接收数据成功".getBytes());
		buffer.flip();
		socketChannel.write(buffer);

		serverSocketChannel.close();
		outChannel.close();
		socketChannel.close();
	}
}
