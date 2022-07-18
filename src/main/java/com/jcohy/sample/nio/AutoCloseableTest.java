package com.jcohy.sample.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/19:02:16
 * @since 2022.04.0
 */
public class AutoCloseableTest {

	// tag::close[]
	//自动资源管理: 自动关闭实现 AutoCloseable 接口的资源
	@Test
	public void close(){
		try(FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
			FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)){

			ByteBuffer buf = ByteBuffer.allocate(1024);
			inChannel.read(buf);

		}catch(IOException e){
			e.printStackTrace();
		}
	}
	// end::close[]
}
