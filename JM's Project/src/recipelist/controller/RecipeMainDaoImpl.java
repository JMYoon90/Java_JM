package recipelist.controller;

import static recipelist.ojdbc.OracleJdbc.*;
import static recipelist.controller.RecipeMainSql.*;
import static recipelist.model.RecipeMain.Entity.*;

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
import recipelist.model.RecipeMain;


public class RecipeMainDaoImpl implements RecipeMainDao {

	private static RecipeMainDaoImpl instance = null;
	
	private RecipeMainDaoImpl() {}
	
	public static RecipeMainDaoImpl getInstance() {
		if (instance == null) {
			instance =  new RecipeMainDaoImpl();
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
	public List<RecipeMain> select() {
		List<RecipeMain> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer productNo = rs.getInt(COL_PRODUCT_NO);
				String productName = rs.getString(COL_PRODUCT_NAME);
				String productClass = rs.getString(COL_PRODUCT_CLASS);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				String ectText = rs.getString(COL_ETC_INGRE);
				String cookingMethod = rs.getString(COL_MAIN_CONTENT);
				
				RecipeMain recipemain = new RecipeMain(productNo, productName, productClass, modifiedDate, ectText, cookingMethod);
				list.add(recipemain);
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
	public RecipeMain select(Integer productNo) {
		RecipeMain recipemain = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
			stmt.setInt(1, productNo);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				
				String productName = rs.getString(COL_PRODUCT_NAME);
				String productClass = rs.getString(COL_PRODUCT_CLASS);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				String ectIngre = rs.getString(COL_ETC_INGRE);
				String mainContent = rs.getString(COL_MAIN_CONTENT);
				
				recipemain = new RecipeMain(productNo, productName, productClass, modifiedDate, ectIngre, mainContent);
				
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
		return recipemain;
	}

	@Override
	public int insert(RecipeMain recipemain) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, recipemain.getProductName());
			stmt.setString(2, recipemain.getProductClass());
			stmt.setString(3, recipemain.getEctIngre());
			stmt.setString(4, recipemain.getMainContent());
			
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
	public int update(RecipeMain recipemain) {
		int result = 0;
		
		Connection conn =null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, recipemain.getProductName());
			stmt.setString(2, recipemain.getProductClass());
			stmt.setString(3, recipemain.getEctIngre());
			stmt.setString(4, recipemain.getMainContent());
			stmt.setInt(5, recipemain.getProductNo());
			
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
	public int delete(Integer productNo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, productNo);
			
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
