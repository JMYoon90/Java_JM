package recipelist.controller;

import java.util.List;

import recipelist.model.IpriceCal;

public interface IpriceCalDao {
	
	List<IpriceCal> select(String productname);

}
