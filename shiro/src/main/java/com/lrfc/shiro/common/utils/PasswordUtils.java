package com.lrfc.shiro.common.utils;

import com.lrfc.shiro.entity.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Title:       [Learn — Shiro]
 * Description: [密码加密工具]
 * Created on   2019年07月18日
 *
 * @author 来日方长
 * @version v1.0
 */
public class PasswordUtils {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
	public static final int HASH_ITERATIONS = 2; // 自定义散列次数

	public void encryptPassword(SysUser user) {
		// 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), HASH_ITERATIONS).toHex();
		user.setPassword(newPassword);
	}
}
