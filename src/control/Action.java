package control;

import java.io.IOException;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SQLQueryImpl;
import org.hibernate.transform.Transformers;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import module.Inandout;
import module.MAC;
import module.RFID;
import module.needtoAdd;
import module.DAOFactory;
import module.Date_;
import module.Event;

public class Action extends ActionSupport {
	private String RFIDid;
	private String MACid;
	private long timestamp;
	private Session s;
	private String choiceEmp;
	private String choicePos;
	private String choiceDate;
	private String choiceRFID;
	private String choiceMAC;
	private String empName;
	private String posName;
	private String android;
	public String getAndroid() {
		return android;
	}

	public void setAndroid(String android) {
		this.android = android;
	}

	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}


	public String getChoiceRFID() {
		return choiceRFID;
	}

	public void setChoiceRFID(String choiceRFID) {
		this.choiceRFID = choiceRFID;
	}

	public String getChoiceMAC() {
		return choiceMAC;
	}

	public void setChoiceMAC(String choiceMAC) {
		this.choiceMAC = choiceMAC;
	}

	public String getChoicePos() {
		return choicePos;
	}

	public void setChoicePos(String choicePos) {
		this.choicePos = choicePos;
	}

	public String getChoiceDate() {
		return choiceDate;
	}

	public void setChoiceDate(String choiceDate) {
		this.choiceDate = choiceDate;
	}

	public String getChoiceEmp() {
		return choiceEmp;
	}

	public void setChoiceEmp(String choiceEmp) {
		this.choiceEmp = choiceEmp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getRFIDid() {
		return RFIDid;
	}

	public void setRFIDid(String rFIDid) {
		RFIDid = rFIDid;
	}

	public String getMACid() {
		return MACid;
	}

	public void setMACid(String mACid) {
		MACid = mACid;
	}

	private DAOFactory Factory;

	public void setFactory(DAOFactory Factory) {
		this.Factory = Factory;
	}

	private SessionFactory sessionFactory;

	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		date.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		time.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	}

	public String Action() {
		addEvent();
		return "Success";
	}
	public String backStage(){
		ActionContext ctxt = ActionContext.getContext();
		List<Inandout> l = Factory.selectAll();
		ctxt.put("all", l);
		List<RFID> r = Factory.selectAllRFID();
		ctxt.put("RFID", r);
		List<MAC> m = Factory.selectAllMAC();
		ctxt.put("MAC", m);
		List<needtoAdd> n = Factory.selectAllneedtoAdd();
		ctxt.put("needtoAdd", n);
		return "Success";		
	}

	public String ManualAction() {
		timestamp = System.currentTimeMillis();
		addEvent();
		return "Success";
	}
	public String index(){
		timestamp=System.currentTimeMillis();
		return newestPos();
	}

	public String newestPos() {// 最新位置（本日）
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("all", getNewestPos());
		return "Success";
	}
	public String newestPosA() {// 最新位置（本日）
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getNewestPos()));
		return "Success";
	}
	public String Event() {// 位置记录
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("all", getEvent());
		return "Success";
	}
	public String EventA() {// 位置记录
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getEvent()));
		return "Success";
	}
	public String selectbyemp() {// 员工查询
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("RFID", getEmp());
		ctxt.put("all", getselectbyemp());
		return "Success";
	}
	public String getEmpA() {// 员工查询
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getEmp()));
		return "Success";
	}
	public String selectbyempA() {// 员工查询
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getselectbyemp()));
		return "Success";
	}
	public String selectbypos() {// 位置查询
		ActionContext ctxt = ActionContext.getContext();			
		ctxt.put("MAC", getPos());			
		ctxt.put("all", getselectbypos());
		return "Success";
	}
	public String getPosA() {
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getPos()));
		return "Success";
	}
	public String selectbyposA() {
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getselectbypos()));
		return "Success";
	}
	public String selectbydate() {// 日期查询
		ActionContext ctxt = ActionContext.getContext();		
		ctxt.put("Date", getDate());			
		ctxt.put("all", getselectbydate());
		return "Success";
	}
	public String getDateA() {
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getDate()));
		return "Success";
	}
	public String selectbydateA() {
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("json", new Gson().toJson(getselectbydate()));
		return "Success";
	}
	public String alterbyemp() {// 人员信息修改
		ActionContext ctxt = ActionContext.getContext();
		getalterbyemp();
		ctxt.put("RFID", getEmp());		
		return "Success";
	}
	public String alterbyempA() {
		ActionContext ctxt = ActionContext.getContext();
		getalterbyemp();
		ctxt.put("json", new Gson().toJson(getEmp()));
		return "Success";
	}
	public String alterbypos() {// 位置信息修改
		ActionContext ctxt = ActionContext.getContext();	
		getalterbypos();
		ctxt.put("MAC", getPos());		
		return "Success";
	}
	public String alterbyposA() {// 位置信息修改
		ActionContext ctxt = ActionContext.getContext();	
		getalterbypos();
		ctxt.put("json", new Gson().toJson(getPos()));
		return "Success";
	}
	public String needtoAdd() {// 信息添加
		ActionContext ctxt = ActionContext.getContext();
		getneedtoAdd();
		ctxt.put("needtoAdd", Factory.selectAllneedtoAdd());		
		return "Success";
	}
	public String needtoAddA() {// 信息添加
		ActionContext ctxt = ActionContext.getContext();
		getneedtoAdd();
		ctxt.put("needtoAdd", Factory.selectAllneedtoAdd());		
		return "Success";
	}
	public List<Event> getNewestPos(){
		s=sessionFactory.openSession();
		Date a = new Date(timestamp);
		List<Event> lE = new ArrayList<Event>();
		List list = s.createSQLQuery("select distinct RFIDid from nowPos where d=\'" + date.format(a) + "\'")
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			// System.out.println(map.get("RFIDid"));
			List<Event> liste = s
					.createSQLQuery("select * from Event where RFIDid=" + map.get("RFIDid") + " and d=\'"
							+ date.format(a) + "\' order by t desc limit 1;")
					.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
			lE.add(liste.get(0));
		}
		if(s!=null)
			s.close();
		return lE;
	}
	public List<Event> getEvent(){
		s=sessionFactory.openSession();
		Date a = new Date(timestamp);
		List<Event> lE = new ArrayList<Event>();
		lE = s.createSQLQuery("select * from Event order by d desc, t desc;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		if(s!=null)
			s.close();
		return lE;
	}
	public List<RFID> getEmp(){
		return Factory.selectAllRFID();
	}
	public List<Event> getselectbyemp() {// 员工查询
		s=sessionFactory.openSession();
		List<Event> liste;
		if(choiceEmp==null||choiceEmp=="ALL"||choiceEmp.equals("ALL"))
			liste = s.createSQLQuery("select * from Event order by d desc,t desc;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
			liste = s.createSQLQuery("select * from Event where RFIDid='"+choiceEmp+"' order by d desc,t desc;")
			.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		if(s!=null)
			s.close();
		return liste;
	}
	public List<MAC> getPos(){
		return Factory.selectAllMAC();
	}
	public List<Event> getselectbypos() {
		s=sessionFactory.openSession();
		List<Event> liste;
		if(choicePos==null ||choicePos=="ALL"||choicePos.equals("ALL"))
			liste = s.createSQLQuery("select * from Event order by d desc,t desc;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
			liste = s.createSQLQuery("select * from Event where MACid='"+choicePos+"' order by d desc,t desc;")
			.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		if(s!=null)
			s.close();
		return liste;
	}
	public List<Date_> getDate(){
		s=sessionFactory.openSession();
		List<Date_> l=s.createSQLQuery("select distinct d from Event order by d desc;")
				.setResultTransformer(Transformers.aliasToBean(Date_.class)).list();
		if(s!=null)
			s.close();
		return  l;			
	}
	public List<Event> getselectbydate() {
		s=sessionFactory.openSession();
		List<Event> liste;
		if(choiceDate==null ||choiceDate=="ALL"||choiceDate.equals("ALL"))
			liste = s.createSQLQuery("select * from Event order by d desc,t desc;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
			liste = s.createSQLQuery("select * from Event where d='" + choiceDate + "' order by d desc,t desc;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		if(s!=null)
			s.close();
		return liste;
	}
	public void getalterbyemp() {// 人员信息修改
		s=sessionFactory.openSession();		
		if(choiceEmp != null)
			s.createSQLQuery("update employeeInfo set empName='"+empName+"' where RFIDid='" + choiceEmp + "';").executeUpdate();
		if(s!=null)
			s.close();
	}
	public void getalterbypos() {// 	
		s=sessionFactory.openSession();
		if(choicePos != null)
			s.createSQLQuery("update positionInfo set posName='"+posName+"' where MACid='" + choicePos + "';").executeUpdate();
		if(s!=null)
			s.close();
	}
	public void getneedtoAdd() {// 	
		s=sessionFactory.openSession();
		if(choiceEmp != null){
			if(choicePos=="RFID"||choicePos.equals("RFID"))
				s.createSQLQuery("insert into employeeInfo values('"+choiceEmp+"','"+empName+"');").executeUpdate();
			else
				s.createSQLQuery("insert into positionInfo values('"+choiceEmp+"','"+empName+"');").executeUpdate();
			s.createSQLQuery("delete from needtoAdd where id='"+choiceEmp+"';").executeUpdate();
		}
		if(s!=null)
			s.close();
	}
	public void addEvent(){
		System.out.println(timestamp);
		Date a = new Date(timestamp);
		
		if(RFIDid != null && MACid != null){
			Inandout u = new Inandout(RFIDid, MACid, date.format(a), time.format(a));
			Factory.Inandout(u);
		}
	}
}
