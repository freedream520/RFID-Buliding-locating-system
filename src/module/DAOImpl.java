package module;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import module.Inandout;

public class DAOImpl implements DAO{
	private HibernateTemplate hi;
	
	public void setHibTemplate(HibernateTemplate s){
		this.hi=s;
	}
	
	public List<Inandout> selectAll(){		
		List<Inandout> q=(List<Inandout>) hi.find("from Inandout",new String[]{});
		return q;		
	}

	@Override
	public void insert(Inandout u) {
		hi.save(u);
	}
/*
	@Override
	public Inandout selectByUser(Inandout u) {
		List<Inandout> q=(List<Inandout>) hi.find("select new User(name,password) from User where name=? and password=?",new String[]{u.getName(),u.getPassword()});
		if(q.size()>0)
			return (Inandout)q.get(0);	
		else
			return null;
	}*/

	@Override
	public boolean selectbyRFID(String RFIDid) {
		List<RFID> q=(List<RFID>) hi.find("select new RFID(RFIDid,empName) from RFID where rfidid=?",new String[]{RFIDid});
		
		if(q.size()>0)
			return true;	
		else
			return false;
	}

	@Override
	public boolean selectbyMAC(String MACid) {
		List<RFID> q=(List<RFID>) hi.find("select new MAC(MACid,posName) from MAC where MACid=?",new String[]{MACid});
		if(q.size()>0)
			return true;	
		else
			return false;
	}

	@Override
	public List<RFID> selectAllRFID() {
		return (List<RFID>) hi.find("from RFID",new String[]{});	
	}

	@Override
	public List<MAC> selectAllMAC() {
		return (List<MAC>) hi.find("from MAC",new String[]{});	
	}

	@Override
	public List<needtoAdd> selectAllneedtoAdd() {
		return (List<needtoAdd>) hi.find("from needtoAdd",new String[]{});	
	}

	@Override
	public void insert(needtoAdd u) {
		hi.save(u);		
	}

	@Override
	public boolean selectfromneedtoAdd(String id) {
		List<needtoAdd> q=(List<needtoAdd>) hi.find("select new needtoAdd(id,type) from needtoAdd where id=?",new String[]{id});
		if(q.size()>0)
			return true;	
		else
			return false;
	}
}
