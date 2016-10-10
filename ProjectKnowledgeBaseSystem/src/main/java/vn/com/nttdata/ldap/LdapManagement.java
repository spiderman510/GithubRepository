/**
 * 
 */
package vn.com.nttdata.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author vitt
 *
 */
@Component
public class LdapManagement {
	public static String ldapIp;
	public static String ldapDomain;
	public static String ldapUser;
	public static String ldapAdmin;
	public static String ldapPwd;
	public static String ldapUserOU;
	public static String ldapGroupOU;
	public static String ldapGroupName;
	public static String ldapGroupUsers;
	
	@Autowired
	public LdapManagement(@Value("${ldap.ip}") String ldapIp,
			@Value("${ldap.domain}") String ldapDomain,
			@Value("${ldap.user}") String ldapUser,
			@Value("${ldap.admin}") String ldapAdmin,
			@Value("${ldap.pw}") String ldapPwd,
			@Value("${ldap.usrOu}") String ldapUserOU,
			@Value("${ldap.groupOU}") String ldapGroupOU,
			@Value("${ldap.groupName}") String ldapGroupName,
			@Value("${ldap.groupUser}") String ldapGroupUsers) {
		this.ldapIp = ldapIp;
		this.ldapDomain = ldapDomain;
		this.ldapUser = ldapUser;
		this.ldapAdmin = ldapAdmin;
		this.ldapPwd = ldapPwd;
		this.ldapUserOU = ldapUserOU;
		this.ldapGroupOU = ldapGroupOU;
		this.ldapGroupName = ldapGroupName;
		this.ldapGroupUsers = ldapGroupUsers;
	}
}
