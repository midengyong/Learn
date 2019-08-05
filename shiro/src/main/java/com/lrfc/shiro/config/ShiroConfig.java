package com.lrfc.shiro.config;

import com.lrfc.shiro.common.utils.PasswordUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Title:       [Learn — Shiro]
 * Description: [Shiro配置]
 * Created on   2019年07月18日
 *
 * @author 来日方长
 * @version v1.0
 */
@Configuration
public class ShiroConfig {
	/**
	 *Description:[创建一个HashedCredentialsMatcher,设置密码加密规则]
	 */
	@Bean
	public PasswordUtils passwordHelper() {
		return new PasswordUtils();
	}

	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName(PasswordUtils.ALGORITHM_NAME); // 散列算法
		hashedCredentialsMatcher.setHashIterations(PasswordUtils.HASH_ITERATIONS); // 散列次数
		return hashedCredentialsMatcher;
	}

	/**
	 *Description:[创建一个realmBean]
	 */
	@Bean("realm")
	public Realm realm(){
		ShiroRealm shiroRealm = new ShiroRealm();
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return shiroRealm;
	}

	/**
	 *Description:[创建一个DefaultSecurityManagerBean,用来关联用户自定义的Realm]
	 */
	@Bean
	public DefaultWebSecurityManager defaultSecurityManager(){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(realm());
		return defaultWebSecurityManager;

	}


	/**
	 *Description:[创建一个ShiroFilterFactoryBean]
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(defaultSecurityManager());
		Map<String, Filter> filterMap = new HashMap<>();
		filterMap.put("authc",new CustomFormAuthenticationFilter());

		Map<String,String> map = new LinkedHashMap<>();

		//过滤的流程从上至下执行，默认的过滤器有：anon,authc,perms,roles,user
		map.put("/tologin","anon");//不需要认证也可以进行访问,登录页面
		map.put("/verificationCode","anon");//验证码接口
		map.put("/","anon");
		map.put("/all","anon");
		map.put("/addUser","anon");
		map.put("/addPage","anon");
		map.put("/access/add","perms[access:add]");
		map.put("/access/test","perms[test]");
		map.put("/logout","logout");//配置使用LogoutFilter过滤器默认实现实现退出功能
		map.put("/**","authc");//所有请求都需要认证

		shiroFilterFactoryBean.setFilters(filterMap);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		return shiroFilterFactoryBean;
	}


}
