/**
 * 
 */
package fr.lithie.matchup.database.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.database.DBManager;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public abstract class BaseDAO implements IDAOBase {
	private String table;
	private String id;

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Constructor
	 * @param table
	 * @param id
	 */
	public BaseDAO(String table, String id) {
		this.table = table;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#executeRequest(java.lang.String)
	 */
	@Override
	public ResultSet executeRequest(String request) {
		ResultSet result = null;

		try {
			Statement stmt = DBManager.getInstance().getCon().createStatement();
			result = stmt.executeQuery(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#executeRequestUpdate(java.lang.String)
	 */
	/**
	 * Excecute a resquest asking to modify the database
	 * @param request
	 * @return :
	 * 			positive : valid request executed
	 * 			 		0 : request without sql return
	 * 	 			 	others : id of the entity impacted 
	 * 			negative : SQL error code
	 */
	@Override
	public int executeRequestUpdate(String request) {
		int result=-1;
		
		try {
			Statement stmt = DBManager.getInstance().getCon().createStatement();
			result = stmt.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
			//for insert, useful when id in auto_increment
			ResultSet rSet = stmt.getGeneratedKeys();
			if (rSet.next()) {
				result = rSet.getInt(1);
			}
		} catch (SQLException e) {
			result = -e.getErrorCode();
//			e.printStackTrace();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#delete(fr.yas.matchup.entities.base.
	 * BaseEntity)
	 */
	@Override
	public void delete(BaseEntity item) {
		executeRequest("DELETE FROM " + table + "WHERE " + id + " = " + item.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#delete()
	 */
	@Override
	public void delete() {
		executeRequest("DELETE FROM " + table);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		BaseEntity entity = null;
		ResultSet rSet = executeRequest("SELECT * FROM " + table + " WHERE " + this.id + " = " + (int) id);

		try {
			if (rSet.next()) {
				entity = parseToObject(rSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#get()
	 */
	@Override
	public List<BaseEntity> get() {
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		ResultSet rSet = executeRequest("SELECT * FROM " + table);

		try {
			while (rSet.next()) {
				entities.add(parseToObject(rSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#insert(fr.yas.matchup.entities.base.
	 * BaseEntity)
	 */
	@Override
	public void insert(BaseEntity item) {
//		System.out.println("INSERT INTO "+ table + " VALUES ("+parseToString(item)+")");
		int res = executeRequestUpdate("INSERT INTO "+ table + " VALUES (" + parseToString(item) + ")");
//		System.out.println(res);
		if(res > 0) {
			item.setId(res);
		}	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.database.IDAOBase#update(fr.yas.matchup.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int update(BaseEntity item) {
		return executeRequestUpdate(
				"UPDATE " + table + " SET " + parseUpdateToString(item) + " WHERE " + id + " = " + item.getId());
	}

}
