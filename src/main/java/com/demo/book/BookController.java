package com.demo.book;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.demo.common.model.Book;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BookController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
//@Before(BookInterceptor.class)
public class BookController extends Controller {
	
	@Inject
	BookService service;
	
	//测试接收参数
	public void index(String para01,String para02) {
		Integer paraToInt = getParaToInt(0, 1);
		setAttr("bookPage", service.paginate(paraToInt, 10));
		render("book.html");
	}
	public void json() {
		Page<Record> recordsPage = service.pageJson();
		renderJson(recordsPage);
	}
	
	/**
	 * 接收json
	 */
	public void receiveJson() {
		String json = getRawData();		
		renderJson(json);
	}
	
	public void fileUpdadTest() {
		UploadFile file = getFile("file","book",102400000);
		System.out.println(file.getUploadPath() + File.separator + file.getFileName());
		System.out.println(getPara("name"));
		renderJson("{\"name\":\"lisi\"}");
	}
	
	public void responseText() throws IOException {
		HttpServletResponse response = getResponse();
		PrintWriter writer = response.getWriter();		
		writer.write("ok");
		writer.flush();
		writer.close();
	}
	
	

	@SuppressWarnings("deprecation")
	public void downloadFile01() {
		HttpServletResponse response = getResponse();
		//response.setContentType("application/octet-stream");//设置文件类型
		response.setContentType("application-xdownload;charset=UTF-8");
		//attachment;filename="encoded_text";filename*=utf-8''encoded_text
		response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode("简易程序-身份证照片.docx" )+ 
				"\";filename*=utf-8''" + URLEncoder.encode("简易程序-身份证照片.docx"));
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(new String("测试".getBytes("UTF-8")));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public void downloadFile02() {
		renderFile("中考流程图.docx");
	}
	
	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	//@Before(BookValidator.class)
	public void save() {
		getBean(Book.class).save();
		redirect("/book");
	}
	
	public void edit() {
		setAttr("book", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	//@Before(BookValidator.class)
	public void update() {
		getBean(Book.class).update();
		redirect("/book");
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/book");
	}
}


