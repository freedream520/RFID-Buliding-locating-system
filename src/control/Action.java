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
import module.Event;

public class Action extends ActionSupport{
	private String RFIDid;
	private String MACid;
	private long timestamp;
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
	
	public void setFactory(DAOFactory Factory){
		this.Factory=Factory;
	}
	private SessionFactory sessionFactory;
	
	public void setsessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public String Action(){
		Date a=new Date(timestamp);		
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time=new SimpleDateFormat("HH:mm:ss");
		Inandout u=new Inandout(RFIDid,MACid,date.format(a),time.format(a));
		Factory.Inandout(u);

		List<Inandout> l=Factory.selectAll();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("all", l);

		List<RFID> r=Factory.selectAllRFID();
		ctxt.put("RFID", r);

		List<MAC> m=Factory.selectAllMAC();
		ctxt.put("MAC", m);
		
		List<needtoAdd> n=Factory.selectAllneedtoAdd();
		ctxt.put("needtoAdd", n);
		return "Success";
		/*if(Factory.Inandout(u)){
			//put 
			List<Inandout> l=Factory.selectAll();
			ActionContext ctxt=ActionContext.getContext();
			ctxt.put("all", l);
			return "Success";
		}
		else{
			this.addFieldError("name", "wrong username or password!!");
			return "Fail";
		}*/
	}
	public String ManualAction(){
		timestamp=System.currentTimeMillis();
		System.out.println(timestamp);
		Date a=new Date(timestamp);		
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time=new SimpleDateFormat("HH:mm:ss");
		Inandout u=new Inandout(RFIDid,MACid,date.format(a),time.format(a));
		Factory.Inandout(u);

		Session s=sessionFactory.openSession();
		List<Event> list=new ArrayList<Event>();		
		list= s.createSQLQuery("SELECT employeeInfo.empName,nowPos.Date_,nowPos.Time_ FROM employeeInfo,nowPos WHERE employeeInfo.RFIDid=nowPos.RFIDid;")
				.setResultTransformer(Transformers.aliasToBean(Event.class)).list();		
		Event ee=list.get(0);
		System.out.println(ee.getDate_()+ee.getTime_());
		ActionContext ctxt=ActionContext.getContext();
		
		ctxt.put("event", list);

		List<Inandout> l=Factory.selectAll();
		ctxt.put("all", l);

		List<RFID> r=Factory.selectAllRFID();
		ctxt.put("RFID", r);

		List<MAC> m=Factory.selectAllMAC();
		ctxt.put("MAC", m);
		
		List<needtoAdd> n=Factory.selectAllneedtoAdd();
		ctxt.put("needtoAdd", n);
		return "Success";
	}
}
