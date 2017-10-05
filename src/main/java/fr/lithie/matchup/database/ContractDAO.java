/**
 * 
 */
package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.ContractType;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public class ContractDAO extends BaseDAO {
	public static final String TABLE = "contract_type";
	public static final String ID = "id_contract";
	public static final String NAME = "name_contract";

	/**
	 * 
	 */
	public ContractDAO() {
		super(TABLE, ID);
	}
	
	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToObject(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		ContractType contract=new ContractType();
		try {
			contract.setName(resultSet.getString(NAME));
			contract.setId(resultSet.getDouble(ID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contract;
		
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseToString(BaseEntity item) {
		String res = "null,";
		ContractType contract = (ContractType) item;
		
		res += "'" + contract.getName() + "'";
		return res;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdateToString(BaseEntity item) {
		ContractType contract = (ContractType) item;
		
		String res = "";
		res += NAME + " = '" + contract.getName() + "'";
		return res;
	}

}
