package com.ibeifeng.niodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNIO {

	public static void main(String[] args) {
		//********哈哈
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel fic = null;
		FileChannel foc = null;
		try {
			fis = new FileInputStream("c:/test.txt");
			fos = new FileOutputStream("e:/result.txt");
			fic = fis.getChannel();
			foc = fos.getChannel();
			// 缓冲区大小分配
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			int len = -1;
			// fic.read(byteBuffer) 往缓冲区写入(相对缓冲区来说是读数据)
			while ((len = fic.read(byteBuffer)) != -1) {
				// 从写模式切换到读模式
				byteBuffer.flip();
				foc.write(byteBuffer);
				// 读-->写
				byteBuffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (foc != null) {
					foc.close();
				}
				if (fic != null) {
					fic.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
