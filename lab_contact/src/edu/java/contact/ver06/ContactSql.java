package edu.java.contact.ver06;

import static edu.java.contact.ver06.Contact.Entity.*;

public interface ContactSql {

	// ContactDao.read() 메서드에서 사용할 SQL
	
	String SQL_READ_ALL = String.format(
			"select * from %s order by %s",
			TBL_CONTACTS, COL_NAME);
	
	// ContactDao.read(Integer cid) 메서드에서 사용할 SQL
	
	String SQL_READ_BY_CID = String.format(
			"select * from %s where %s = ?",
			TBL_CONTACTS, COL_CID);
	
	// ContactDao.create(Contact contact) 메서드에서 사용할 SQL
	
	String SQL_CREATE = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)",
			TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL);
	
	// ContactDao.update(Contact contact) 메서드에서 사용할 SQL
	
	String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ?, %s = ? where %s = ?",
			TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL, COL_CID);
	
	// Contact.delete(Integer cid) 메서드에서 사용할 SQL
	
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?",
			TBL_CONTACTS, COL_CID);
	
	// 제목으로 검색하기
	
	String SQL_SELECT_BY_NAME = String.format(
			"select * from %s where lower(%s) like ? order by %s, %s",
			TBL_CONTACTS, COL_NAME, COL_NAME, COL_PHONE);
	
	// 전화번호로 검색하기
	String SQL_SELECT_BY_PHONE = String.format(
			"select * from %s where lower(%s) like ? order by %s, %s",
			TBL_CONTACTS, COL_PHONE, COL_NAME, COL_PHONE);
	
	
}
