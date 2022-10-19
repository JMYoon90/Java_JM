package recipelist.controller;

import static recipelist.ojdbc.OracleJdbc.*;
import static recipelist.controller.RecipeIngreSql.*;
import static recipelist.model.RecipeIngre.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import recipelist.model.RecipeIngre;

public class RecipeIngreDaoImpl implements RecipeIngreDao {
	
	private static RecipeIngreDaoImpl instance = null;
	
	private RecipeIngreDaoImpl() {}
	
	public static RecipeIngreDaoImpl getInstance() {
		if (instance == null) {
			instance = new RecipeIngreDaoImpl();
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
	public List<RecipeIngre> select() {
		List<RecipeIngre> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer ingreIndex = rs.getInt(COL_INGRE_INDEX);
				String ingreName = rs.getString(COL_INGRE_NAME);
				Integer ingreWeight = rs.getInt(COL_INGRE_WEIGHT);
				String pName = rs.getString(COL_PRODUCT_NAME);
				
				RecipeIngre recipeingre = new RecipeIngre(ingreIndex, ingreName, ingreWeight, pName);
				list.add(recipeingre);
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

	/**
	 * @param iIndex
	 * @return
	 */
	@Override
	public List<RecipeIngre> select(String productName) {
		List<RecipeIngre> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_PNAME);
			stmt.setNString(1, "%" + productName.toLowerCase() + "%");
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer ingreIndex = rs.getInt(COL_INGRE_INDEX);
				String ingreName = rs.getString(COL_INGRE_NAME);
				Integer ingreWeight = rs.getInt(COL_INGRE_WEIGHT);
				String pName = rs.getString(COL_PRODUCT_NAME);
				
				RecipeIngre recipeingre = new RecipeIngre(ingreIndex, ingreName, ingreWeight, pName);
				list.add(recipeingre);
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
	public int insert(RecipeIngre recipeingre) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, recipeingre.getpName());
			stmt.setString(2, recipeingre.getIngreName());
			stmt.setInt(3, recipeingre.getIngreWeight());
			
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
	public int delete(Integer iIndex) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, iIndex);
			
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
	public List<RecipeIngre> select(String productName, String IngreName) {
		List<RecipeIngre> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_PNAME_AND_INAME);
			stmt.setString(1, productName);
			stmt.setString(2, IngreName);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer ingreIndex = rs.getInt(COL_INGRE_INDEX);
				String ingreName = rs.getString(COL_INGRE_NAME);
				Integer ingreWeight = rs.getInt(COL_INGRE_WEIGHT);
				String pName = rs.getString(COL_PRODUCT_NAME);
				
				RecipeIngre recipeingre = new RecipeIngre(ingreIndex, ingreName, ingreWeight, pName);
				list.add(recipeingre);
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
	public int update(RecipeIngre recipeingre) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, recipeingre.getIngreName());
			stmt.setDouble(2, recipeingre.getIngreWeight());
			stmt.setString(3, recipeingre.getpName());
			stmt.setString(4, recipeingre.getIngreName());
			
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
