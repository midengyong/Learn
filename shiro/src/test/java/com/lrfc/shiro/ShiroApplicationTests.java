package com.lrfc.shiro;

import com.lrfc.shiro.common.enums.Constant;
import com.lrfc.shiro.config.menu.CustomMenu;
import com.lrfc.shiro.config.menu.Menu;
import com.lrfc.shiro.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShiroApplicationTests {
	@Autowired
	private CustomMenu customMenu;

	@Test
	public void contextLoads() {
		List<Menu> menus = customMenu.getMenu();
		log.info("------------");

	}
	public static void main(String[] args) throws IOException {
		// 封装数据与(创建集合对象)
		SysUser sysUser = new SysUser();
		sysUser.setIsDeleted(Constant.SHIRO_LOGIN_FAILURE.getValue());
		sysUser.setAccount("1");
		sysUser.setName("lrfc");
		sysUser.setModifier("lrfc");
		ArrayList<SysUser> array = new ArrayList();
		array.add(sysUser);
		array.add(sysUser);
		array.add(sysUser);
		array.add(sysUser);
		File file =new File("test.txt");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objOut=new ObjectOutputStream(out);
			objOut.writeObject(array);
			objOut.flush();
			objOut.close();
			System.out.println("write object success!");
		} catch (IOException e) {
			System.out.println("write object failed");
			e.printStackTrace();
		}


		Object temp=null;
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn=new ObjectInputStream(in);
			temp=objIn.readObject();
			objIn.close();
			System.out.println("read object success!");
		} catch (IOException e) {
			System.out.println("read object failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(temp.toString());
	}

}
