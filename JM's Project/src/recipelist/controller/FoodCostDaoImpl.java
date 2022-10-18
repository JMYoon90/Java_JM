package recipelist.controller;

import static recipelist.ojdbc.OracleJdbc.*;
import static recipelist.model.FoodCost.Entity.*;
import static recipelist.controller.FoodCostSql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import recipelist.model.FoodCost;

public class FoodCostDaoImpl implements FoodCostDao {
	
	private static FoodCostDaoImpl instance = null;
	
	private FoodCostDaoImpl(){}
	
	public static FoodCostDaoImpl getInstance() {
		if (instance == null) {
			instance = new FoodCostDaoImpl();
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
	public List<FoodCost> select() {
		List<FoodCost> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer fNo = rs.getInt(COL_FOOD_NO);
				String fName = rs.getString(COL_FOOD_NAME);
				Integer fCost = rs.getInt(COL_FOODCOST);
				Integer fprice = rs.getInt(COL_PRICE_FOR_G);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				Integer fWeight = rs.getInt(COL_FOOD_WEIGHT);
				
				FoodCost foodcost = new FoodCost(fNo, fName, fCost, fprice, modifiedDate, fWeight);
				list.add(foodcost);
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

	@Override
	public List<FoodCost> select(String foodname) {
		List<FoodCost> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_INAME);
			stmt.setString(1, "%" + foodname.toLowerCase() + "%");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer fNo = rs.getInt(COL_FOOD_NO);
				String fName = rs.getString(COL_FOOD_NAME);
				Integer fCost = rs.getInt(COL_FOODCOST);
				Integer fprice = rs.getInt(COL_PRICE_FOR_G);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				Integer fWeight = rs.getInt(COL_FOOD_WEIGHT);
				
				FoodCost foodcost = new FoodCost(fNo, fName, fCost, fprice, modifiedDate, fWeight);
				list.add(foodcost);
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

	@Override
	public int insert(FoodCost foodcost) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, foodcost.getFoodName());
			stmt.setInt(2, foodcost.getfWeight());
			stmt.setInt(3, foodcost.getFoodCost());
			stmt.setDouble(4, foodcost.getPriceForG());
			
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int delete(Integer foodNo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, foodNo);
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int select_existence(String foodname) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_INAME);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(FoodCost foodcost) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setInt(1, foodcost.getfWeight());
			stmt.setInt(2, foodcost.getFoodCost());
			stmt.setDouble(3, foodcost.getPriceForG());
			stmt.setString(4, foodcost.getFoodName());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	

}
