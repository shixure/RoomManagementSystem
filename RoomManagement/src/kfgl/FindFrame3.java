package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindFrame3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtname;
	private JTextField txtrid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFrame3 frame = new FindFrame3();
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
	public FindFrame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 181, 727, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u5BA2\u6237\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u623F\u95F4\u53F7", "\u8BA2\u623F\u65F6\u95F4", "\u9000\u623F\u65F6\u95F4"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u5BA2\u6237\u59D3\u540D");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setBounds(105, 64, 81, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		btnNewButton.setBounds(174, 120, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton_1.setBounds(422, 120, 123, 29);
		contentPane.add(btnNewButton_1);
		
		txtname = new JTextField();
		txtname.setBounds(216, 61, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtrid = new JTextField();
		txtrid.setBounds(478, 61, 96, 27);
		contentPane.add(txtrid);
		txtrid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(362, 64, 81, 21);
		contentPane.add(lblNewLabel_1);
	}
	private void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		con=JDBCUtils.getConnection();
		try {
			BookDAO bookdao=new BookDAO();
			String gna=txtname.getText();
			String rid=txtrid.getText();
			ResultSet rs=bookdao.list(con,gna,rid);
			while(rs.next()) {
				//System.out.println(rs.getString("rid"));
				Vector v=new Vector();
				v.add(rs.getString("bid"));
				v.add(rs.getString("gid"));
				v.add(rs.getString("gname"));
				v.add(rs.getString("rid"));
				v.add(rs.getString("btime"));
				v.add(rs.getString("utime"));
				//if(StringUtil.isEmpty(rs.getString("exstart"))&&StringUtil.isEmpty(rs.getString("exstop")));
				//else
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(con, null, null);
		}
	}
}
