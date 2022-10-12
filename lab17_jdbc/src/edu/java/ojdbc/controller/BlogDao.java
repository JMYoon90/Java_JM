package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

import edu.java.ojdbc.model.Blog.Entity.*;

public interface BlogDao {

    List<Blog> select(); // SQL_SELECT_ALL
    Blog select(Integer blogno); // SQL_SELECT_BY_NO
    int insert(Blog blog); // SQL_INSERT
    int update(Blog blog); // SQL_UPDATE
    int delete(Integer blogNo); // SQL_DELETE
    
    // SELECT_BY_TITLE, SELECT_BY_CONTENT, SELECT_BY_AUTHOR, SELECT_BY_TITLE_OR_CONTENT
    List<Blog> select(int type, String keyword);
    
    
    
    
}
