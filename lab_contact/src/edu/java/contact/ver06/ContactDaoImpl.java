package edu.java.contact.ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import oracle.jdbc.OracleDriver;
import edu.java.contact.ver06.Contact;

import static edu.java.contact.ver06.OracleConnetion.*;
import static edu.java.contact.ver06.ContactSql.*;
import static edu.java.contact.ver06.Contact.Entity.*;



public class ContactDaoImpl implements ContactDao {
	
	// Singleton 적용
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		
		return DriverManager.getConnection(URL, USER, Password);
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
	public List<Contact> read() {
		List<Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_READ_ALL);
			stmt = conn.prepareStatement(SQL_READ_ALL);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
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
	public Contact read(Integer cid) {
		Contact contact = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_READ_BY_CID);
			stmt = conn.prepareStatement(SQL_READ_BY_CID);
			stmt.setInt(1, cid);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				contact = new Contact(cid, name, phone, email);
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
		
		return contact;
	}

	@Override
	public int create(Contact contact) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_CREATE);
			stmt = conn.prepareStatement(SQL_CREATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			
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
	public int update(Contact contact) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_UPDATE);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getCid());
			
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
	public int delete(Integer cid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
			
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
	public List<Contact> select(int type, String keyword) {
		List<Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			

			switch(type) {
			case 0:
				System.out.println(SQL_SELECT_BY_NAME);
				stmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
				stmt.setString(1, "%" + keyword.toLowerCase() + "%");
				break;
			case 1:
				System.out.println(SQL_SELECT_BY_PHONE);
				stmt = conn.prepareStatement(SQL_SELECT_BY_PHONE);
				stmt.setString(2, "%" + keyword.toLowerCase()+ "%");
				break;
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
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
