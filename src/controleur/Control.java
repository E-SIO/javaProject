package controleur;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import methode.ConnexionMysql;
import IHM.IHM_Entree;

public class Control {
	private ConnexionMysql DbCo;
	private IHM_Entree frmconnexion;
	
	public Control() {
		
		
		frmconnexion = new IHM_Entree(this);
		frmconnexion.setVisible(true);
	}
	
	public void actionConnexion(String url ,String login,char[] password ,String chaineDeCo, String Db){
			DbCo = new ConnexionMysql(url,login,password,chaineDeCo,Db);
			try {
				DbCo.connect();
				ResultSet requete = DbCo.getDataBases();
				requete.next();
				frmconnexion.getData().addItem(requete.getString(1));
				while (requete.next()) {
					frmconnexion.getData().addItem(requete.getString(1));
				}
				frmconnexion.getData().setVisible(true);
				frmconnexion.getlabData().setVisible(true);
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException ex) {
				// TODO Auto-generated catch block
				frmconnexion.getErreur().setForeground(Color.RED);
				frmconnexion.getErreur().setText("Connexion imposible voir Log");
				frmconnexion.getErreur().setVisible(true);
				Logger.getLogger(Control.class.getName()).log(Level.SEVERE, ex.getMessage());
			}
	}

}