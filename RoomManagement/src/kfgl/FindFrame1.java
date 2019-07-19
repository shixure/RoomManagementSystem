package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtrid;
	private JTextField txtname;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFrame1 frame = new FindFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrid = new JTextField();
		txtrid.setBounds(225, 82, 96, 27);
		contentPane.add(txtrid);
		txtrid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(468, 82, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();
			}
		});
		btnNewButton.setBounds(201, 153, 107, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(398, 153, 107, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setBounds(113, 85, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u987E\u5BA2\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(364, 85, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 210, 526, 115);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u95F4\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F", "\u5E8A\u4F4D", "\u4EF7\u683C", "\u8D1F\u8D23\u4EBA"
			}
		));
		scrollPane.setViewportView(table);
	}
	private void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		con=JDBCUtils.getConnection();
		try {
			RoomDAO roomdao=new RoomDAO();
			String gna=txtname.getText();
			String rid=txtrid.getText();
			ResultSet rs=roomdao.list1(con,gna,rid);
			if(rs!=null) {
			while(rs.next()) {
				//System.out.println(rs.getString("rid"));
				Vector v=new Vector();
				v.add(rs.getString("rid"));
				v.add(rs.getString("gname"));
				v.add(rs.getString("gphone"));
				v.add(rs.getString("bednum"));
				v.add(rs.getString("price"));
				v.add(rs.getString("pname"));
				//if(StringUtil.isEmpty(rs.getString("exstart"))&&StringUtil.isEmpty(rs.getString("exstop")));
				//else
				dtm.addRow(v);
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(con, null, null);
		}

		
	}
}
