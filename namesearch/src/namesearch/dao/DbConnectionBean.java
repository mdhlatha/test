package namesearch.dao;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class provides the database connection. The datasource name
 * (local or remote) is supplied by the requesting call which is then
 * looked up from the JNDI tree and a local DataSource (dsLocal) or
 * a remote DataSource (dsRemote) instance is created with the parameters
 * read from the DB.properties file in the Web folder and loaded at the
 * time of application startup by the ConfigServlet class. A connection
 * is then returned from the resulting pool. Both the DataSource instances 
 * are static to mean that the whole application will share the 
 * connection pool created by the DataSource rather than creating a 
 * separate connection pool for each request received.
 * Creation date: (8/17/2001 11:48:04 AM)
 * @author: Accenture
 */
public class DbConnectionBean {

	protected Connection con;
	protected String loginID;
	protected String password;
	protected String Address; // Local address would be 'iiop:///'
	protected String JNDIName; 
	

	/**
	 * dbConnectionBean_DS constructor comment.
	 */
	public DbConnectionBean() {
		super();
	}

/** This method gets called whenever a connection is required 
  * across the whole application. The method takes the location
  * of the database as a parameter and reads the parameters 
  * required to obtain the connection by calling the setParameters()
  * method. The naming Context is then created. If the required 
  * DataSource is not available a DataSource instance is created and
  * a connection is returned. If the DataSource is already available
  * then a connection is returned from it.
  * @return Connection
  * @param dbLocation String
*/

		public Connection connectToDS(String dbLocation)
			throws NamingException, SQLException, ClassNotFoundException {

				try{
				// Set the parameters necessary for connection				
				setParameters(dbLocation);
				java.util.Hashtable env = new java.util.Hashtable(20);
				env.put(Context.PROVIDER_URL, Address);
				javax.naming.Context ctx = new javax.naming.InitialContext(env);
				//If a connection to the local DataSource is required 
				if(dbLocation.equals("local")){
					if(dsLocal == null){
						dsLocal = (DataSource) ctx.lookup(JNDIName);
					}
					con = dsLocal.getConnection(loginID, password);
					con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//TRANSACTION_READ_COMMITTED (ANSI level 1), SQL eqv of CS
				}else{
					//If a connection to the remote DataSource is required 
					if(dsRemote == null){
						dsRemote = (DataSource) ctx.lookup(JNDIName);
					}
					con = dsRemote.getConnection(loginID, password);
					con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//TRANSACTION_READ_COMMITTED (ANSI level 1), SQL eqv of CS
				}
				}catch(Exception ex){
					System.out.println("Exception From Connection:");
				  ex.printStackTrace(System.out);
				}
				
			return con;
			}

/** This method reads the parameters required to establish a 
  * Connection with the database and look up a DataSource in the
  * Naming Context from the System properties.
  * @param dbLocation String
*/

	protected void setParameters(String dbLocation) {

		if (dbLocation.equals("local")) {
			JNDIName = System.getProperty("localJNDIName");
			Address = System.getProperty("localAddress");
			loginID = System.getProperty("localDbLoginID");
			password = System.getProperty("localDbPassword");

		} else {
			JNDIName = System.getProperty("remoteJNDIName");
			Address = System.getProperty("remoteAddress");
			loginID = System.getProperty("remoteDbLoginID");
			password = System.getProperty("remoteDbPassword");
		}
		
	}

	public static DataSource dsLocal;
	public static DataSource dsRemote;
}