package com.demo.student;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

@Before(StudentInterceptor.class)
public class StudentController extends Controller {

	@Inject
	StudentService service;

	public void index() {
		Integer pageNum = getParaToInt("pageNum", 1);
		Integer pageSize = getParaToInt("pageSize", 10);
		String name = getPara("name", null);
		String school = getPara("school", null);
		Page<Record> records = service.page(pageNum, pageSize, name, school);
		set("students", records);
		render("student.html");
	}

	public void studentJson() {
		Integer limit = getParaToInt("limit", 10);
		Integer page = getParaToInt("page", 1);
		String name = getPara("name", null);
		String school = getPara("school", null);
		Page<Record> records = service.page(page, limit, name, school);
		Ret ret = Ret.by("code", 0).set("count", records.getTotalRow()).set("msg", "").set("data", records.getList());
		renderJson(ret);
	}

	public void getById() {
		Record findById = Db.findById("student", getParaToInt("id"));
		renderJson(findById);
	}

	public void studentAdd() {
		Record record = new Record();
		record.set("name", getPara("name"));
		record.set("gendar", getPara("gendar"));
		record.set("idcard", getPara("idcard"));
		record.set("baominghao", getPara("baominghao"));
		record.set("zhunkaozhenghao", getPara("zhunkaozhenghao"));
		record.set("school", getPara("school"));
		record.set("type", getPara("type"));
		boolean save = Db.save("student", record);
		renderText(save + "");
	}

	public void studentEdit() {
		Record record = new Record();
		record.set("name", getPara("name"));
		record.set("id", getPara("addOrEditId"));
		record.set("gendar", getPara("gendar"));
		record.set("idcard", getPara("idcard"));
		record.set("baominghao", getPara("baominghao"));
		record.set("zhunkaozhenghao", getPara("zhunkaozhenghao"));
		record.set("school", getPara("school"));
		record.set("type", getPara("type"));
		boolean update = Db.update("student", "id", record);
		renderText(update + "");
	}

	public void studentDel() {
		Integer id = getParaToInt("id", 10);
		int delete = Db.delete("delete from student where id=?", id);
		renderText(delete + "");
	}

}
