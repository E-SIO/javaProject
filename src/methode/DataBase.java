package methode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase implements global.Global{
	protected String dbUrl;
	protected String user;
	protected char[] pasword;
	protected String ChaineConexion;
	protected String DataBase;
	protected Connection dbCon = null ;
	protected Statement dbStat = null;
	
	

	/**
	 * connecter a la base de donner 
	 * @return retourne vrais en connexion 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @see  connect()
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1
	 */
	public boolean connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Class.forName(this.ChaineConexion).newInstance();
			System.out.println("jdbc:"+this.DataBase+":"+this.dbUrl);
			System.out.println("jdbc:mysql:"+this.dbUrl +","+ this.user+ ","+ String.valueOf(this.pasword));
			this.dbCon = DriverManager.getConnection("jdbc:mysql:"+this.dbUrl,this.user,String.valueOf(this.pasword));
			this.dbStat = this.dbCon.createStatement();
			return true ;
		}
	
	/**
	 * execution de la requête S.Q.L. 
	 * @param sql
	 * @return le résultat de la requête 
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1
	 * @throws SQLException 
	 */
	public  ResultSet exec(String sql) throws SQLException{
			ResultSet rs = this.dbStat.executeQuery(sql);
			return rs;
		
	}
	
/**
 * met fin a la connexion 
 * @author BOERO-TEYSSIER Grégory
 * @version 0.1
 * @throws SQLException 
 */
	public void close() throws SQLException{
	  this.dbStat.close();
	  this.dbCon.close();
	  this.dbCon.close();
	}
	
	
}
