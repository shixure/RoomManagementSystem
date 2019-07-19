package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ReserveFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtrid;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveFrame frame = new ReserveFrame();
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
	public ReserveFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u8BA2\u623F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestDAO udao=new GuestDAO();
				Guest u=udao.findGuest(txtname.getText());
				RoomDAO rdao=new RoomDAO();
				int rno=Integer.parseInt(txtrid.getText());
				try {
					boolean a = rdao.judge(rno);
					if(u==null) {
						JOptionPane.showMessageDialog(getContentPane(), "不存在该用户","信息提示框",JOptionPane.WARNING_MESSAGE);
					}
					else if(a==false) {
						JOptionPane.showMessageDialog(getContentPane(), "房间已被预订","信息提示框",JOptionPane.WARNING_MESSAGE);
					}
					else {
						Procedure pro=new Procedure();
						String gna=txtname.getText();
						pro.ProRes(gna,rno);
						JOptionPane.showMessageDialog(getContentPane(), "订房成功","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		btnNewButton.setBounds(107, 267, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(322, 267, 123, 29);
		contentPane.add(btnNewButton_1);
		
		txtname = new JTextField();
		txtname.setBounds(278, 67, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtrid = new JTextField();
		txtrid.setBounds(278, 153, 96, 27);
		contentPane.add(txtrid);
		txtrid.setColumns(10);
		
		lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(121, 70, 81, 21);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel_1.setBounds(121, 156, 81, 21);
		contentPane.add(lblNewLabel_1);
	}
}
