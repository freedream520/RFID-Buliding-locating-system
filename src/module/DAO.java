package module;

import java.util.List;

import module.Inandout;


public interface DAO {
	public List<Inandout> selectAll();
	public void insert(Inandout u);
	public void insert(needtoAdd u);
	public void update(RFID u);
	public void update(MAC u);
	public boolean selectbyRFID(String RFIDid);
	public boolean selectbyMAC(String MACid);
	public boolean selectfromneedtoAdd(String id);
	public List<RFID> selectAllRFID();
	public List<MAC> selectAllMAC();
	public List<needtoAdd> selectAllneedtoAdd();
}
