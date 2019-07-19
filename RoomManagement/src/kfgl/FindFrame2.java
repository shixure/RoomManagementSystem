package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTable table;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFrame2 frame = new FindFrame2();
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
	public FindFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();
			}
		});
		btnNewButton_1.setBounds(194, 139, 123, 29);
		contentPane.add(btnNewButton_1);
		
		txtname = new JTextField();
		txtname.setBounds(452, 49, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5BA2\u6237\u59D3\u540D");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setBounds(157, 52, 221, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(425, 139, 123, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 203, 499, 156);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BA2\u6237\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
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
			GuestDAO guestdao=new GuestDAO();
			String gna=txtname.getText();
			if(gna.equals("")) {
			List<Guest> list=guestdao.findAllGuest();
			for(Guest rs:list) {
				Vector v=new Vector();
				v.add(rs.getGid());
				v.add(rs.getGname());
				v.add(rs.getGphone());
				dtm.addRow(v);
			}
			}
			else {
			Guest rs=guestdao.findGuest(gna);
			Vector v=new Vector();
			v.add(rs.getGid());
			v.add(rs.getGname());
			v.add(rs.getGphone());
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
