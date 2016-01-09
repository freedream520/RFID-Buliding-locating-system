package module;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class DAOFactory{
	private DAOImpl dao;
	private PlatformTransactionManager txManager;
	
	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}


	public void setDao(DAOImpl s){
		dao=s;
	}


	public void Inandout(Inandout u) {
		TransactionTemplate t=new TransactionTemplate(txManager);
		t.execute(new TransactionCallback<Object>(){
			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				if(dao.selectbyRFID(u.getRFIDid())){
					if(dao.selectbyMAC(u.getMACid())){
						dao.insert(u);													
					}
					else{
						if(!dao.selectfromneedtoAdd(u.getMACid()))
							dao.insert(new needtoAdd(u.getMACid(),"MAC"));
					}
				}
				else
					if(!dao.selectfromneedtoAdd(u.getRFIDid())){
						dao.insert(new needtoAdd(u.getRFIDid(),"RFID"));
						if(!dao.selectbyMAC(u.getMACid())){
							if(!dao.selectfromneedtoAdd(u.getMACid()))
								dao.insert(new needtoAdd(u.getMACid(),"MAC"));
						}
					}
				return null;				
			}
		});
	}

	public List<Inandout> selectAll() {
		return dao.selectAll();
	}

	public List<RFID> selectAllRFID() {
		return dao.selectAllRFID();
	}

	public List<MAC> selectAllMAC() {
		return dao.selectAllMAC();
	}


	public List<needtoAdd> selectAllneedtoAdd() {
		return dao.selectAllneedtoAdd();
	}

	public void update(RFID u) {
		dao.update(u);		
	}

	public void update(MAC u) {
		dao.update(u);				
	}
}
