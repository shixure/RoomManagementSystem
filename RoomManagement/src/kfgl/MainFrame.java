package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[] status = { "¿Õ·¿", "×¡·¿" };
	JComboBox comboBox = new JComboBox(status);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btn1 = new JButton("\u8BA2\u623F");
		btn1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn1.setBounds(257, 101, 123, 29);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReserveFrame reserveframe=new ReserveFrame();
				reserveframe.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("\u9000\u623F");
		btn2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn2.setBounds(408, 101, 123, 29);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckoutFrame checkoutframe=new CheckoutFrame();
				checkoutframe.setVisible(true);				
			}
		});
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("\u6362\u623F");
		btn3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn3.setBounds(546, 101, 123, 29);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeFrame changeframe=new ChangeFrame();
				changeframe.setVisible(true);
			}
		});
		contentPane.add(btn3);
		
		JButton btn6 = new JButton("\u5BA2\u6237\u4FE1\u606F\u67E5\u8BE2");
		btn6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn6.setBounds(309, 225, 154, 29);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindFrame2 findFrame2=new FindFrame2();
				findFrame2.setVisible(true);
			}
		});
		contentPane.add(btn6);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5BA2\u623F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.BOLD, 22));
		lblNewLabel.setBounds(285, 15, 246, 47);
		contentPane.add(lblNewLabel);
		
		JButton btn4 = new JButton("\u6DFB\u52A0");
		btn4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn4.setBounds(119, 101, 123, 29);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewguestFrame newguestframe=new NewguestFrame();
				newguestframe.setVisible(true);
			}
		});
		contentPane.add(btn4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 304, 543, 186);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u95F4", "\u7C7B\u578B", "\u4EF7\u683C", "\u8D1F\u8D23\u4EBA", "\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btn5 = new JButton("\u5165\u4F4F\u4FE1\u606F\u67E5\u8BE2");
		btn5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindFrame1 findFrame1=new FindFrame1();
				findFrame1.setVisible(true);
			}
		});
		btn5.setBounds(130, 225, 150, 29);
		contentPane.add(btn5);
		
		JButton btn7 =  new JButton("\u8BA2\u5355\u4FE1\u606F\u67E5\u8BE2");
		btn7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindFrame3 findFrame3=new FindFrame3();
				findFrame3.setVisible(true);
			}
		});
		btn7.setBounds(495, 225, 159, 29);
		contentPane.add(btn7);
		
		JButton btnNewButton_3 = new JButton("\u5237\u65B0");
		btnNewButton_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		btnNewButton_3.setBounds(658, 333, 76, 29);
		contentPane.add(btnNewButton_3);
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8", "\u4F4F\u623F", "\u7A7A\u623F"}));
		comboBox.setBounds(658, 378, 76, 27);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u57FA\u672C\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(53, 69, 668, 90);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u83DC\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(53, 197, 668, 87);
		contentPane.add(panel_1);
		
	}

	private void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		con=JDBCUtils.getConnection();
		try {
			RoomDAO roomdao=new RoomDAO();
			String r=(String) comboBox.getSelectedItem();
			
			ResultSet rs=roomdao.list(con,r);
			while(rs.next()) {
				//System.out.println(rs.getString("rid"));
				Vector v=new Vector();
				v.add(rs.getString("rid"));
				v.add(rs.getString("tname"));
				v.add(rs.getString("price"));
				v.add(rs.getString("pname"));
				v.add(rs.getString("sname"));
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
