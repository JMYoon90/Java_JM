package recipelist.controller;

import static recipelist.controller.IpriceCalSql.*;
import static recipelist.ojdbc.OracleJdbc.*;
import static recipelist.model.IpriceCal.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import recipelist.model.IpriceCal;

public class IpriceCalDaoImpl implements IpriceCalDao {
	
private static IpriceCalDaoImpl instance = null;
	
	private IpriceCalDaoImpl() {}
	
	public static IpriceCalDaoImpl getInstance() {
		if (instance == null) {
			instance = new IpriceCalDaoImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) 
            throws SQLException {
        rs.close();
        closeResources(conn, stmt);
    }

	@Override
	public List<IpriceCal> select(String productname) {
		List<IpriceCal> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_PNAME);
			stmt.setString(1, "%" + productname.toLowerCase()+ "%");
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				String ingrename = rs.getString(COL_INGRE_NAME);
				Integer weight = rs.getInt(COL_INGRE_WEIGHT);
				Integer price = rs.getInt(COL_PRICE);
				
				IpriceCal ipricecal = new IpriceCal(ingrename, productname, weight, price);
				list.add(ipricecal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
