/**
 * 
 */
package bl.selectBL;

import java.util.ArrayList;
import java.util.Iterator;

import data.UserData;
import po.UserPO;
import utility.exception.ExistID_exception;
import utility.exception.NotExistId_exception;
import utility.exception.NotFoundName_exception;

/**
 * @author run
 *
 */
public class ChooseHelper {
	UserData userData;
	UserPO userPO;
	
	public ChooseHelper(){
		userData=new UserData();
	}
	
	/**
	 * choose a stock as prefered
	 * @param id
	 * @return
	 * @throws NotFoundName_exception 
	 */
	public boolean delete(String name,String id) throws NotFoundName_exception{
		boolean result=false;
		boolean exist=false;
		boolean temp=false;
		userPO=userData.getUser(name);
		
		ArrayList<String> arrayList=userPO.getStocks();
		Iterator<String> iterator=arrayList.iterator();
		while(iterator.hasNext()){
			String s=iterator.next();
			if(s.equals(id)){
				exist=true;
			}
		}
		
		if(exist){
			try {
				temp=userData.remove(name, id);
			} catch (NotExistId_exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			result=true;
			try {
				temp=userData.add(name, id);
			} catch (ExistID_exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
