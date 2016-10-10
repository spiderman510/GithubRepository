package vn.com.nttdata.ldap;

/*--

 #Modify: HoangNM2
 #Date modify: 2014-03-28

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

@SuppressWarnings("unchecked")
public class LDAPManager {
	

    /** The OU (organizational unit) to add users to */
    private static String USERS_OU = "";

    /** The OU (organizational unit) to add groups to */
    private static final String GROUPS_OU = LdapManagement.ldapGroupOU;

    /** The default LDAP port */
    private static final int DEFAULT_PORT = 389;

    /** The LDAPManager instance object */
    private static Map instances = new HashMap();

    /** The connection, through a <code>DirContext</code>, to LDAP */
    private DirContext context;

    /** The hostname connected to */
    private String hostname;

    /** The port connected to */
    private int port;

    private static void loadProperties() {
        USERS_OU = LdapManagement.ldapUserOU;
    }

    /**
     * Constructor
     * @param hostname
     * @param port
     * @param username
     * @param password
     * @throws NamingException
     */
    public LDAPManager(String hostname, int port, String username,
            String password) throws NamingException {
        context = getInitialContext(hostname, port, username, password);

        // Only save data if we got connected
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Get instance
     * @param hostname
     * @param port
     * @param username
     * @param password
     * @return
     * @throws NamingException
     */
    public static LDAPManager getInstance(String hostname, int port,
            String username, String password) throws NamingException {
        // Construct the key for the supplied information
        String key = new StringBuffer().append(hostname).append(":").append(
                port).append("|").append((username == null ? "" : username))
                .append("|").append((password == null ? "" : password))
                .toString();

        if (!instances.containsKey(key)) {
            synchronized (LDAPManager.class) {
                if (!instances.containsKey(key)) {
                    LDAPManager instance = new LDAPManager(hostname, port,
                            username, password);
                    instances.put(key, instance);
                    return instance;
                }
            }
        }
        return (LDAPManager) instances.get(key);
    }

    /**
     * getInstance
     * @param hostname
     * @param port
     * @return
     * @throws NamingException
     */
    public static LDAPManager getInstance(String hostname, int port)
            throws NamingException {

        return getInstance(hostname, port, null, null);
    }

    /**
     * getInstance
     * @param hostname
     * @return
     * @throws NamingException
     */
    public static LDAPManager getInstance(String hostname)
            throws NamingException {

        return getInstance(hostname, DEFAULT_PORT, null, null);
    }

    /**
     * check user
     * @param username
     * @param password
     * @return
     */
    public boolean isValidUser(String username, String password) {
        try {
            @SuppressWarnings("unused")
            DirContext context = getInitialContext(hostname, port,
                    getUserDN(username), password);
            return true;
        } catch (javax.naming.NameNotFoundException e) {
            return false;
        } catch (NamingException e) {
            // Any other error indicates couldn't log user in
            return false;
        }
    }

    /**
     * Check user in group
     * @param username
     * @param groupName
     * @return
     * @throws NamingException
     */
    public boolean userInGroup(String username, String groupName)
            throws NamingException {

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "member";
        String[] listGroupName = groupName.split(",");
        for (String groupNameItem : listGroupName) {
            Attributes attributes = context.getAttributes(
                    getGroupDN(groupNameItem.trim()), searchAttributes);
            if (attributes != null) {
                Attribute memberAtts = attributes.get("member");
                if (memberAtts != null) {
                    for (NamingEnumeration vals = memberAtts.getAll(); vals
                            .hasMoreElements();) {
                        String curUserName = getUserUID((String) vals
                                .nextElement());
                        curUserName = getSamAccountName(curUserName);
                        if (username.equalsIgnoreCase(curUserName)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * get user in group
     * @param listgroup
     * @return
     * @throws NamingException
     */
    public String getUserInGroup(String listgroup) throws NamingException {

        // Set up attributes to search for
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "member";
        String listUser = "[";

        String[] group = listgroup.split(",");
        for (int i = 0; i < group.length; i++) {
            Attributes attributes = context.getAttributes(getGroupDN(group[i]),
                    searchAttributes);
            if (attributes != null) {
                Attribute memberAtts = attributes.get("member");
                if (memberAtts != null) {
                    for (NamingEnumeration vals = memberAtts.getAll(); vals
                            .hasMoreElements();) {
                        String curUserName = getUserUID((String) vals
                                .nextElement());
                        curUserName = getSamAccountName(curUserName);
                        listUser += "'" + curUserName + "',";
                    }
                }
            }
        }
        listUser += "'not']";
        return listUser;
    }

    /**
     * Get user DN
     * @param username
     * @return
     * @throws NamingException
     */
    private String getUserDN(String username) throws NamingException {
        String FullName = getUserName(username);
        return new StringBuffer().append("cn=").append(FullName).append(",")
                .append(USERS_OU).toString();
    }

    /**
     * get username
     * @param userId
     * @return
     * @throws NamingException
     */
    private String getUserName(String userId) throws NamingException {
        String returnedAtts[] = { "cn" };
        String searchFilter = "(&(objectClass=user)(saMAccountName=" + userId
                + "))";

        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);

        searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);

        NamingEnumeration answer = context.search(USERS_OU, searchFilter,
                searchCtls);

        while (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();
            Attributes attrs = sr.getAttributes();

            if (attrs != null) {
                NamingEnumeration ne = attrs.getAll();

                while (ne.hasMore()) {
                    Attribute attr = (Attribute) ne.next();
                    return attr.get().toString();
                }
            }
        }
        return userId;
    }

    /**
     * get Sam Account name
     * @param cn
     * @return
     * @throws NamingException
     */
    public String getSamAccountName(String cn) throws NamingException {
        String returnedAtts[] = { "saMAccountName" };
        String searchFilter = "(&(objectClass=user)(cn=" + cn + "))";

        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);

        searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);

        NamingEnumeration answer = context.search(USERS_OU, searchFilter,
                searchCtls);

        while (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();
            Attributes attrs = sr.getAttributes();

            if (attrs != null) {
                NamingEnumeration ne = attrs.getAll();

                while (ne.hasMore()) {
                    Attribute attr = (Attribute) ne.next();
                    return attr.get().toString();
                }
            }
        }
        return cn;
    }

    /**
     * get user UID
     * @param userDN
     * @return
     */
    private String getUserUID(String userDN) {
        int start = userDN.indexOf("=");
        int end = userDN.indexOf(",");

        if (end == -1) {
            end = userDN.length();
        }

        return userDN.substring(start + 1, end);
    }

    /**
     * Get group DN
     * @param name
     * @return
     */
    private String getGroupDN(String name) {
        return new StringBuffer().append("cn=").append(name).append(",")
                .append(GROUPS_OU).toString();
    }

    /**
     * get initial context
     * @param hostname
     * @param port
     * @param username
     * @param password
     * @return
     * @throws NamingException
     */
    private DirContext getInitialContext(String hostname, int port,
            String username, String password) throws NamingException {
        loadProperties();
        String providerURL = new StringBuffer("ldap://").append(hostname)
                .append(":").append(port).toString();

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, providerURL);
        if ((username != null) && (!username.equals(""))) {
            // props.put(Context.SECURITY_PROTOCOL, "ssl");
            // props.put(Context.SECURITY_AUTHENTICATION,
            // "EXTERNAL DIGEST-MD5 GSS-SPNEGO GSSAPI");
            props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_PRINCIPAL, username);
            props.put(Context.SECURITY_CREDENTIALS, ((password == null) ? ""
                    : password));
        }

        return new InitialDirContext(props);
    }
    
    public String getUsernameFromUserId(String userId) throws NamingException{
    	return getUserName(userId);
    }
}
