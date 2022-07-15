package com.jcohy.sample.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/15:01:22
 * @since 2022.04.0
 */
public class ClientSideWithNio {

	public static void main(String[] args) throws IOException {
		//1. 获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		//2. 切换非阻塞模式
		sChannel.configureBlocking(false);

		//3. 分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		//4. 发送数据给服务端
		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()){
			String str = scan.next();
			buf.put((new Date().toString() + "\n" + str).getBytes());
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		//5. 关闭通道
		sChannel.close();
	}
}
