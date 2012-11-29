package methode;

import global.Global;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sauvgarde.HotSave;


	public class ConnexionMysql extends DataBase implements Global {
		private HotSave BackOsp;
		
		/**
		 * Constructor of ConnexionMysql class
		 * @param url
		 * @param user
		 * @param password 
		 * @param ChainCo
		 * @param Db
		 * @author BOERO-TEYSSIER Grégory
		 * @version 0.1
		 */
		public ConnexionMysql(String url,String user,char[] cs,String ChainCo,String Db){
			
			super.dbUrl          = url;
			super.user           = user;
			super.pasword        = cs;
			super.ChaineConexion = ChainCo;
			super.DataBase       = Db;
			BackOsp = new HotSave(user,String.valueOf(cs),WAMP_MYSQL_DUMP_PATH, Db, WAMP_MYSQL_PATH);
			
		}
/**
 * Récupération des base de donnée 
 * @return requête 
 * @author BOERO-TEYSSIER Grégory
 * @version 0.1
 */
	   public ResultSet getDataBases(){
		   ResultSet requete = null;
		   try {
			   	requete =  exec("SHOW DATABASES");
			   	return requete;
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   Logger.getLogger(ConnexionMysql.class.getName()).log(Level.SEVERE,e.getMessage());
		   }
		   return null;
	   }
	   /**
	    * Récupère les table dans un base de donnée 
	    * @param table
	    * @return requête
	    * @author BOERO-TEYSSIER Grégory
	    * @version 0.1
	    */
	   public ResultSet getTable (String table){
		   ResultSet requete = null;
		   try {
			   	requete =  exec("SHOW TABLES  FROM "+table);
			   	return requete;
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   Logger.getLogger(ConnexionMysql.class.getName()).log(Level.SEVERE,e.getMessage());
		   }
		   return null;
	   }
	   
	   /**
	    * Récupération du nombre de table dans la base de donnée eslectionner 
	    * @param table
	    * @return nbRow
	    * @author BOERO-TEYSSIER Grégory
	    * @version 0.1
	    */
	   public int getRowCont (String table){
		   ResultSet requete = null;
		   int nbRow =0;
		   try {
			   	requete =  exec("SHOW TABLES  FROM "+table);
			   	while (requete.next()){
			   		nbRow++;
			   	}
			   	return nbRow;
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   Logger.getLogger(ConnexionMysql.class.getName()).log(Level.SEVERE,e.getMessage());
		   }
		   return nbRow;
	   }
	}
