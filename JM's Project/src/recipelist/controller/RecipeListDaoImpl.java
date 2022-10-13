package recipelist.controller;

import static recipelist.ojdbc.OracleJdbc.*;
import static recipelist.controller.RecipeListSql.*;
import static recipelist.model.RecipeList.Entity.*;

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
import recipelist.model.RecipeList;


public class RecipeListDaoImpl implements RecipeListDao {

	private static RecipeListDaoImpl instance = null;
	
	private RecipeListDaoImpl() {}
	
	public static RecipeListDaoImpl getInstance() {
		if (instance == null) {
			instance =  new RecipeListDaoImpl();
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
	public List<RecipeList> select() {
		List<RecipeList> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer productNo = rs.getInt(COL_RECIPE_NO);
				String productName = rs.getString(COL_PRODUCT_NAME);
				String productGroup = rs.getString(COL_GROUP);
				Integer productWeight = rs.getInt(COL_PRODUCT_WEIGHT);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				String ectText = rs.getString(COL_ETC_TEXT);
				String cookingMethod = rs.getString(COL_COOKING_METHOD);
				String ingredientName = rs.getString(COL_INGREDIENT_NAME);
				
				RecipeList recipelist = new RecipeList(productNo, productName, productGroup, productWeight, modifiedDate, ectText, cookingMethod, ingredientName);
				list.add(recipelist);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public RecipeList select(Integer productNo) {
		RecipeList recipelist = null;
		
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
				String productGroup = rs.getString(COL_GROUP);
				Integer productWeight = rs.getInt(COL_PRODUCT_WEIGHT);
				LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
				String ectText = rs.getString(COL_ETC_TEXT);
				String cookingMethod = rs.getString(COL_COOKING_METHOD);
				String ingredientName = rs.getString(COL_INGREDIENT_NAME);
				
				recipelist = new RecipeList(productNo, productName, productGroup, productWeight, modifiedDate, ectText, cookingMethod, ingredientName);
				
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
		return recipelist;
	}

	@Override
	public int insert(RecipeList recipelist) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, recipelist.getProductName());
			stmt.setString(2, recipelist.getProductGroup());
			stmt.setString(3, recipelist.getIngredientName());
			stmt.setInt(4, recipelist.getProductWeight());
			stmt.setString(5, recipelist.getEctText());
			stmt.setString(6, recipelist.getCookingMethod());
			
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
	public int update(RecipeList recipelist) {
		int result = 0;
		
		Connection conn =null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, recipelist.getProductName());
			stmt.setString(2, recipelist.getProductGroup());
			stmt.setString(3, recipelist.getIngredientName());
			stmt.setInt(4, recipelist.getProductWeight());
			stmt.setString(5, recipelist.getEctText());
			stmt.setString(6, recipelist.getCookingMethod());
			stmt.setInt(7, recipelist.getProductNo());
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
