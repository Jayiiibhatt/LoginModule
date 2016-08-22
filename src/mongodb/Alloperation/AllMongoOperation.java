package mongodb.Alloperation;

import java.net.UnknownHostException;

import com.SpringMongo.LoginModule.UserRegistration;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class AllMongoOperation {
	public DBCollection getDataBase() throws UnknownHostException{
		DB db=(new MongoClient()).getDB("UserRegistration");
		DBCollection dbcollection=db.getCollection("UserLogin");
		BasicDBObject key=new BasicDBObject("email",1);
		BasicDBObject options=new BasicDBObject("unique", "true");
		dbcollection.createIndex(key, options);
		return dbcollection;
	}
	public boolean insertData(UserRegistration userregistration1){
		try{
			DBCollection dbcollection=getDataBase();
			BasicDBObject basicdbobject=new BasicDBObject();
			basicdbobject.put("name", userregistration1.getUserName());
			basicdbobject.put("password", userregistration1.getUserPassword());
			basicdbobject.put("email", userregistration1.getUserEmail());
			basicdbobject.put("number", userregistration1.getUserMobile());
			System.out.println("-------basicdbobject"+basicdbobject);
			dbcollection.insert(basicdbobject);
		}catch(UnknownHostException e){
			System.out.println("---------insert data method-------"+e.getMessage());
			return false;
		}catch(MongoException e){
			System.out.println("---------duplicate key entry-------"+e.getMessage());
			return false;
		}
		return true;
	}
	public boolean checkUserLogin(UserRegistration userregistration1) {
		boolean flag=false;
		String userEmail=userregistration1.getUserEmail();
		String userPassword=userregistration1.getUserPassword();
		System.out.println("--------in method mongo------"+userEmail+"--------"+userPassword);
		try{
			DBCollection dbcollection=getDataBase();
			for(DBObject dbobject: dbcollection.find()){
				String email=(String) dbobject.get("email");
				String password=(String) dbobject.get("password");
				System.out.println(email+"----------------"+password);
				if(userEmail.equals(email)){
					System.out.println("--------in first if loop mongo------");
					if(userPassword.equals(password)){
						System.out.println("--------in second if loop mongo------");
						userregistration1.setUserName((String) dbobject.get("name"));
						System.out.println("-------user name-----"+(String) dbobject.get("name"));
						flag=true;
						break;
					}
					
				}
			}
		}catch(UnknownHostException e){
			System.out.println("---------check logindata method-------"+e.getMessage());
			return flag;
		}
		
		return flag;
	}
	
	public boolean updatePassword(UserRegistration userregistration1) {
		String userEmail=userregistration1.getUserEmail();
		String userNumber=userregistration1.getUserMobile();
		String userPassword=userregistration1.getUserPassword();
		DBObject fromdbobject=new BasicDBObject();
		DBObject toomdbobject=new BasicDBObject();
		DBObject updatedbobject=new BasicDBObject();
		try{
			DBCollection dbcollection=getDataBase();
			for(DBObject dbobject:dbcollection.find()){
				String email=(String) dbobject.get("email");
				String mobile=(String) dbobject.get("number");
				if(userEmail.equals(email)&&userNumber.equals(mobile)){
					//dbobject1.put("password",userregistration1.getUserPassword());
					fromdbobject.put("password", (String) dbobject.get("password"));
					toomdbobject.put("password",userPassword);
					updatedbobject.put("$set", toomdbobject);
					dbcollection.update(fromdbobject, updatedbobject);
					break;
				}
			}
		}catch(UnknownHostException e){
			
		}
		
		return true;
	}
}
