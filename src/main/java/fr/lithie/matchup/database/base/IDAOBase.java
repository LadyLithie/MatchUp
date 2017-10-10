/**
 * 
 */
package fr.lithie.matchup.database.base;

import java.sql.ResultSet;
import java.util.List;

import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public interface IDAOBase {
	/**
	 * 
	 * @param request
	 * @return
	 */
	public ResultSet executeRequest(String request);
	/**
	 * Excecute a resquest asking to modify the database
	 * @param request
	 * @return :
	 * 			positive : valid request executed
	 * 			negative : error code
	 */
	public int executeRequestUpdate(String request);
	/**
	 * Study the result of the SQL query result of the get(id) from BaseDAO
	 * @param resultSet
	 * @return an Entity of the corresponding DAOEntity for this id
	 */
	public BaseEntity parseToObject(ResultSet resultSet) ;
	/**
	 * Transform an Entity in a string for use in SQL INSERT INTO request
	 * @param item
	 * @return
	 */
	public String parseToString(BaseEntity item);
	/**
	 * Transform an Entity in a string for use in SQL UPDATE
	 * @param item
	 * @return
	 */
	public String parseUpdateToString(BaseEntity item);
	/**
	 * Insert an entity in a table
	 * @param item
	 */
	public void insert(BaseEntity item) ;

	/**
	 * Update the item in the table
	 * @param item
	 */
	public int update(BaseEntity item) ;
	
	/**
	 * Delete the item from the table
	 * @param item
	 */
	public void delete(BaseEntity item) ;
	
	/**
	 * Delete all items from the table
	 */
	public void delete();
	/**
	 * Retrieve from a table designed by the DAO a result for the id and transform it in an Entity
	 * @param id of the entity we want to retrieve
	 * @return an entity based on its id
	 */
	public BaseEntity get(double id) ;
	/**
	 * @return = all a list of all the entities of a table
	 */
	public List<BaseEntity> get();
	
}
