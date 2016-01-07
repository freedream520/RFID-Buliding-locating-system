package control;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SQLQueryImpl;
import org.hibernate.transform.Transformers;

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
		s = sessionFactory.openSession();
	}

	public String Action() {
		Date a = new Date(timestamp);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		Inandout u = new Inandout(RFIDid, MACid, date.format(a), time.format(a));
		Factory.Inandout(u);

		List<Inandout> l = Factory.selectAll();
		ActionContext ctxt = ActionContext.getContext();
		ctxt.put("all", l);

		List<RFID> r = Factory.selectAllRFID();
		ctxt.put("RFID", r);

		List<MAC> m = Factory.selectAllMAC();
		ctxt.put("MAC", m);

		List<needtoAdd> n = Factory.selectAllneedtoAdd();
		ctxt.put("needtoAdd", n);
		return "Success";
		/*
		 * if(Factory.Inandout(u)){ //put List<Inandout> l=Factory.selectAll();
		 * ActionContext ctxt=ActionContext.getContext(); ctxt.put("all", l);
		 * return "Success"; } else{ this.addFieldError("name",
		 * "wrong username or password!!"); return "Fail"; }
		 */
	}

	public String ManualAction() {
		timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		Date a = new Date(timestamp);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		Inandout u = new Inandout(RFIDid, MACid, date.format(a), time.format(a));
		Factory.Inandout(u);
		/*
		 * List<Event> list= s.createSQLQuery(
		 * "SELECT employeeInfo.RFIDid,employeeInfo.empName,positionInfo.MACid,"
		 * +
		 * "positionInfo.posName,nowPos.Date_,nowPos.Time_ FROM employeeInfo,nowPos,positionInfo "
		 * +
		 * "WHERE employeeInfo.RFIDid=nowPos.RFIDid and nowPos.MACid=positionInfo.Macid;"
		 * )
		 * .setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		 * // Event ee=list.get(10); //
		 * System.out.println(ee.getEmpName()+ee.getDate_()+ee.getTime_());
		 */ActionContext ctxt = ActionContext.getContext();

		// ctxt.put("event", list);

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

	public String newestPos() {// 最新位置（本日）
		Date a = new Date(timestamp);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		System.out.println(timestamp + " " + System.currentTimeMillis());
		System.out.println(date.format(a));
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
		// for(Inandout i:lE)
		// System.out.println(i.getRFIDid()+i.getMACid()+i.getTime()+i.getDate());
		ActionContext ctxt = ActionContext.getContext();

		String title = "最新位置 " + date.format(a);
		ctxt.put("title", title);
		ctxt.put("all", lE);
		return "Success";
	}

	public String Event() {// 位置记录
		List<Event> liste = s.createSQLQuery("select * from Event;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();

		ActionContext ctxt = ActionContext.getContext();

		String title = "位置记录";
		ctxt.put("title", title);
		ctxt.put("all", liste);
		return "Success";
	}
	public String selectbyemp() {// 员工查询
		ActionContext ctxt = ActionContext.getContext();

		List<RFID> r = Factory.selectAllRFID();
		ctxt.put("RFID", r);
		String title = "查询员工";
		ctxt.put("title", title);
		System.out.println(choiceEmp);
		List<Event> liste;
		if(choiceEmp==null)
			liste = s.createSQLQuery("select * from Event;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
					liste = s.createSQLQuery("select * from Event where RFIDid="+choiceEmp+";")
			.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
			
		ctxt.put("all", liste);
		return "Success";
	}
	public String selectbypos() {// 位置查询
		ActionContext ctxt = ActionContext.getContext();

		List<MAC> r = Factory.selectAllMAC();
		ctxt.put("MAC", r);
		String title = "查询位置";
		ctxt.put("title", title);
		System.out.println(choicePos);
		List<Event> liste;
		if(choicePos==null)
			liste = s.createSQLQuery("select * from Event;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
			liste = s.createSQLQuery("select * from Event where MACid="+choicePos+";")
			.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
			
		ctxt.put("all", liste);
		return "Success";
	}
	public String selectbydate() {// 员工查询
		ActionContext ctxt = ActionContext.getContext();
		String title = "查询员工";
		ctxt.put("title", title);

		List<Date> r = s.createSQLQuery("select distinct d from Event;")
				.setResultTransformer(Transformers.aliasToBean(Date_.class)).list();
		ctxt.put("Date", r);
		List<Event> liste;

		System.out.println(choiceDate);
		if(choiceDate==null)
			liste = s.createSQLQuery("select * from Event;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
		else
			liste = s.createSQLQuery("select * from Event where d=" + choiceDate + ";")
			.setResultTransformer(Transformers.aliasToBean(Event.class)).list();
			
		ctxt.put("all", liste);
		return "Success";
	}
}
