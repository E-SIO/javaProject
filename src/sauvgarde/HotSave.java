package sauvgarde;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class HotSave {

	private String Login ;
	private String Pass;
	private String PathSave;
	private String PathMysql;
	private String PathMysqlRes;
	private String dbName;
	private String outPut;
	
	/**
	 * constructeur de la classe HotSave 
	 * @param login
	 * @param path
	 * @param save
	 * @param dosDump
	 * @param db
	 */
	public HotSave(String login,String pass,String dosDump,String db,String resto) {
		this.Login = login;
		this.Pass = pass ;
		this.PathMysql = dosDump ;
		this.dbName = db ;
		this.PathMysqlRes = resto;
		this.outPut = PathMysql + db + GregorianCalendar.DATE ;
	}
	/**
	 * sauvegarde de la base de donner sélectionner 
	 */
	public void Save(){
		try {
			final Runtime rt = Runtime.getRuntime();
			Process proc = null;
			if (this.Pass.equals("")) {
				 proc = rt.exec("cmd.exe /c "+this.PathMysql+" -u "+this.Login+"--lock-all-tables  "+this.dbName+" --result-file="+this.PathSave);
			}
			else{
				 proc = rt.exec("cmd.exe /c "+this.PathMysql+" -u "+this.Login+"-p"+this.Pass +"--lock-all-tables  "+this.dbName+" --result-file="+this.PathSave);
			}
            java.io.BufferedReader out = new java.io.BufferedReader( new java.io.InputStreamReader( proc.getInputStream() ) );
			proc.getInputStream().close();
			proc.getOutputStream().close();
			proc.getErrorStream().close();
		}catch (IOException e) {
			Logger.getLogger(Logger.class.getName()).log(null, e.getMessage());
		}
	}
	
	/**
	 * restoration de la base de donnée a partir du ficher demander 
	 * @param id
	 */
	public void Restor(String outFile){
		// restoration  des data bas
		try {
			final Runtime rt = Runtime.getRuntime();
			Process proc = null;
			if (this.Pass.equals("")) {
				 proc = rt.exec("cmd.exe /c "+this.PathMysqlRes+"--verbose --user="+this.Login+"--lock-all-tables "+this.dbName+" <"+this.PathSave);
			}
			else{
				 proc = rt.exec("cmd.exe /c "+this.PathMysqlRes+"--verbose --user="+this.Login+"--password="+this.Pass+"--lock-all-tables "+this.dbName+" <"+this.PathSave+outFile);
			}
            java.io.BufferedReader out = new java.io.BufferedReader( new java.io.InputStreamReader( proc.getInputStream() ) );
			proc.getInputStream().close();
			proc.getOutputStream().close();
			proc.getErrorStream().close();
		}catch (IOException e) {
			Logger.getLogger(Logger.class.getName()).log(null, e.getMessage());
		}
		
	}
	public void SetSavePath(String Path){
		this.PathSave = Path;
	}
}
