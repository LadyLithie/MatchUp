/**
 * 
 */
package fr.lithie.matchup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import fr.lithie.matchup.utils.file.FileManager;

/**
 * @author Audrey
 *
 */
public class DBManager {
	/**
	 * Singleton
	 */
	private static DBManager instance = null;

	protected DBManager() {
		// Exists only to defeat instantiation.
		connectCrea();
		if (canConnect()) {
			connect();
		}else {
			createDB(CONFIG,"matchup.sql");
//			createDB(CONFIG,"structDB.sql");
//			createDB(CONFIG, "ScriptData.sql");
		}
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	/* Fin singleton */

	/**
	 * Attributes
	 */
	private static final String PASSWORD = "password";
	private static final String LOGIN = "login";
	private static final String DB_NAME = "dbName";
	private static final String PORT = "port";
	private static final String SERVER_ADDRESS = "serverAddress";
	private static final String DBCONFIG = "dbconfig";
	private static final String CONFIG = "config";

	private Connection con;
	private Connection creaCon;
	private String dbName = "mydb";

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @return the creaCon
	 */
	public Connection getCreaCon() {
		return creaCon;
	}

	/**
	 * @return the dBNAME
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Try the connection to our DB
	 * to allow the application to function
	 * @return 	
	 * 			true if present
	 * 			false, if not -> so we need to create it 
	 */
	private boolean canConnect() {
		try {
			Statement stmt = creaCon.createStatement();
			ResultSet rSet = stmt.executeQuery("SHOW DATABASES");
			while (rSet.next()) {
				if(rSet.getString(1).equals(dbName)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Function create a new database with a script SQL
	 * @param path
	 * @param file
	 */
	private void createDB(String path, String file) {
		Statement stmt;
		
		try {
			stmt = creaCon.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS "+dbName+" CHARACTER SET utf8 COLLATE utf8_general_ci;");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		connect();
		
		FileManager fileManager = new FileManager(path, file);
		String creationRequest = "";
		for (String string : fileManager.loadFromFile()) {
			creationRequest += string+"\n";
		}
				
		try {
			stmt = con.createStatement();
			for(String it : creationRequest.split(";")) {
				if(!it.equals("\n") && !it.equals("")) {
					stmt.execute(it);					
				}
			}
			stmt.execute(creationRequest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	}
	
	/**
	 * Allow to delete the database and close all link to the database and serverBase
	 */
	public void deleteDB() {
		Statement stmt;
		
		try {
			stmt = creaCon.createStatement();
			stmt.execute("DROP DATABASE IF EXISTS "+dbName+";");
			con.close();
			con = null;
			creaCon.close();
			creaCon = null;
			instance = null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Function to connect to a database
	 */
	public void connect() {
		connect(CONFIG, DBCONFIG);
	}

	/**
	 * Function to connect to a database with path/file
	 */
	public void connect(String path, String file) {
		FileManager fileManager = new FileManager(path, file);
		Map<String, Object> datas = fileManager.extractFromPattern();
		String password = "";

		if (datas.containsKey(PASSWORD)) {
			password = datas.get(PASSWORD).toString();
		}
		connect(datas.get(SERVER_ADDRESS).toString(), datas.get(PORT).toString(), datas.get(DB_NAME).toString(),
				datas.get(LOGIN).toString(), password);
	}

	/**
	 * Function to connect to a database with separate string
	 */
	public void connect(String serverAddress, String port, String dbName, String login, String password) {
		this.dbName = dbName;
		try {
			// Charge the class Driver from added libs
			Class.forName("com.mysql.jdbc.Driver");
			// DriverMangaer = Manager the drivers in java
			// Localize our database and how to access it
			con = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/" + dbName, login,
					password);
			// Close connection
			// con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Function to connect to a serverBase
	 */
	public void connectCrea() {
		connectCrea(CONFIG, DBCONFIG);
	}

	/**
	 * Function to connect to a serverBase with path/file
	 */
	public void connectCrea(String path, String file) {
		FileManager fileManager = new FileManager(path, file);
		Map<String, Object> datas = fileManager.extractFromPattern();
		String password = "";

		if (datas.containsKey(PASSWORD)) {
			password = datas.get(PASSWORD).toString();
		}
		
		dbName = datas.get(DB_NAME).toString();
		
		connectCrea(datas.get(SERVER_ADDRESS).toString(), datas.get(PORT).toString(), datas.get(LOGIN).toString(),
				password);
	}

	/**
	 * Function to connect to serverBase with separate strings
	 */
	public void connectCrea(String serverAddress, String port, String login, String password) {
		try {
			// Charge the class Driver from added libs
			Class.forName("com.mysql.jdbc.Driver");
			// DriverMangaer = Manager the drivers in java
			// Localize our database and how to access it
			creaCon = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/", login, password);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
