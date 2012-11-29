package IHM;

import global.Global;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.Control;

public class IHM_Entree extends JFrame implements Global {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652618910618931746L;
	private JPanel contentPane;
	private JTextField jtxf_Login;
	private JPasswordField jpf_Pasword;
	private JComboBox<String> cbx_Type;
	private Control controleur ;
	private JTextField jtxtf_url;
	private JLabel lbl_BaseDeDonne ;
	private JComboBox<String> cbx_BaseDeDonnée;
	private JButton btn_ChoisireLaBase;
	private JLabel lbl_erreur;
	private JTable jtbl_TableDataSelected;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu menu_1;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;



	/**
	 * Create the frame.
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1
	 */
	public IHM_Entree(Control uncontrol) {
		super();
		controleur = uncontrol;
		setTitle("connexion a la base de donn\u00E9e");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbx_Type.setBounds(242, 65, 195, 22);
		contentPane.add(cbx_Type);
		
		JLabel lbl_Login = new JLabel("Login :");
		lbl_Login.setBounds(125, 171, 47, 16);
		contentPane.add(lbl_Login);
		
		JLabel lbl_Password = new JLabel("password :");
		lbl_Password.setBounds(102, 228, 70, 16);
		contentPane.add(lbl_Password);
		
		jtxf_Login = new JTextField();
		jtxf_Login.setBounds(242, 168, 195, 22);
		contentPane.add(jtxf_Login);
		jtxf_Login.setColumns(10);
		
		jpf_Pasword = new JPasswordField();
		jpf_Pasword.setBounds(242, 225, 195, 22);
		contentPane.add(jpf_Pasword);
		
		JButton btn_RecuperationDesTable = new JButton("Recuperation des table ");
		btn_RecuperationDesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
							
				controleur.actionConnexion(jtxtf_url.getText(), jtxf_Login.getText(), jpf_Pasword.getPassword(),CHAINE_DE_CO, String.valueOf(cbx_Type.getSelectedItem()));
			}
		});
		btn_RecuperationDesTable.setBounds(497, 268, 190, 25);
		contentPane.add(btn_RecuperationDesTable);
		
		JLabel lblUrlDeConnexion = new JLabel("URL de connexion:");
		lblUrlDeConnexion.setBounds(60, 115, 114, 16);
		contentPane.add(lblUrlDeConnexion);
		lbl_BaseDeDonne = new JLabel("Base de donn\u00E9e");
		lbl_BaseDeDonne.setVisible(false);
		lbl_BaseDeDonne.setEnabled(true);
		lbl_BaseDeDonne.setBounds(71, 319, 101, 22);
		contentPane.add(lbl_BaseDeDonne);
		
		cbx_BaseDeDonnée = new JComboBox<String>();
		cbx_BaseDeDonnée.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbx_BaseDeDonnée.isValid()){
					btn_ChoisireLaBase.setVisible(true);
					contentPane.add(scrollPane);
					menuBar.setVisible(true);
					 System.out.println("jTable visible");
				}
				
			}
		});
		cbx_BaseDeDonnée.setVisible(false);
		cbx_BaseDeDonnée.setEnabled(true);
		cbx_BaseDeDonnée.setBounds(242, 319, 197, 22);
		contentPane.add(cbx_BaseDeDonnée);
		
		btn_ChoisireLaBase = new JButton("Choisire la base de donn\u00E9e");
		btn_ChoisireLaBase.setVisible(false);
		btn_ChoisireLaBase.setEnabled(true);
		btn_ChoisireLaBase.setBounds(497, 431, 190, 38);
		contentPane.add(btn_ChoisireLaBase);
		
		lbl_erreur = new JLabel("");
		lbl_erreur.setVisible(false);
		lbl_erreur.setBounds(50, 366, 417, 24);
		contentPane.add(lbl_erreur);
		
		jtxtf_url = new JTextField();
		jtxtf_url.setBounds(242, 112, 195, 22);
		contentPane.add(jtxtf_url);
		jtxtf_url.setColumns(10);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 742, 26);
		contentPane.add(menuBar);
		menuBar.setVisible(false);
		
		menu_1 = new JMenu("Operation ");
	
		menuItem_1 = new JMenuItem("Sauvegarde");
		menu_1.add(menuItem_1);
		
		menuItem_2 = new JMenuItem("Restoration");
		menu_1.add(menuItem_2);
		
		
		menuBar.add(menu_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 395, 317, 186);
		
		
		jtbl_TableDataSelected = new JTable();
		scrollPane.setViewportView(jtbl_TableDataSelected);
		jtbl_TableDataSelected.setVisible(false);
	}
	
	/**
	 * mise en place d'un composent ajouter plus tard
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1 
	 * @return un composent a mette en place 
	 */
	public JComboBox<String> getData (){
		return cbx_BaseDeDonnée;
	}
	/**
	 * mise en place d'un composent ajouter plus tard
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1 
	 * @return un composent a mette en place 
	 */
	public JLabel getlabData(){
		return lbl_BaseDeDonne;
	}
	/**
	 * mise en place d'un composent ajouter plus tard
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1 
	 * @return un composent a mette en place 
	 */
	public JButton getBtnData(){
		return btn_ChoisireLaBase;
		
	}
	/**
	 * mise en place d'un composent ajouter plus tard
	 * @author BOERO-TEYSSIER Grégory
	 * @version 0.1 
	 * @return un composent a mette en place 
	 */
	public JLabel getErreur(){
		return lbl_erreur ;
	}
	
	public JTable getEtatJdata(){
		return jtbl_TableDataSelected;
		
	}
}
