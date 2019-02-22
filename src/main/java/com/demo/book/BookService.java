package com.demo.book;

import java.util.List;

import com.demo.common.model.Book;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BookService
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
public class BookService {
	
	/**
	 * 所有的 dao 对象也放在 Service 中，并且声明为 private，避免 sql 满天飞
	 * sql 只放在业务层，或者放在外部 sql 模板，用模板引擎管理：
	 * 			http://www.jfinal.com/doc/5-13
	 */
	private Book dao = new Book().dao();
	
	public Page<Book> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from book order by id asc");
	}
	
	public Book findById(int id) {
		
		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	public Page<Record> pageJson(){
		int pageNum=1;
		int pageSize=10;
		int start=pageSize*(pageNum-1);		
		List<Record> records = Db.find("select * from book limit ?,?", start,pageSize);		
		Integer totalRow = Db.findFirst("select count(*) as co from book").getInt("co");		
		Integer totalPage=totalRow/10+1;		
		Page<Record> page = new Page<>(records, pageNum, pageSize, totalPage, totalRow);
		return page;
	}
	
}
