package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewguestFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewguestFrame frame = new NewguestFrame();
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
	public NewguestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(133, 63, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel_1.setBounds(133, 130, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		txtname = new JTextField();
		txtname.setBounds(265, 60, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setBounds(265, 127, 96, 27);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guest g=new Guest();
				GuestDAO gdao=new GuestDAO();
				g=gdao.findGuest(txtname.getText());
				if(txtname.getText().equals("")||txtphone.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "用户名和手机号不能为空","提示",JOptionPane.YES_OPTION);
				}
				else if(g!=null) {
					JOptionPane.showMessageDialog(getContentPane(), "该用户已存在","信息提示框",JOptionPane.YES_OPTION);
				}
				else {
					Guest u=new Guest();
					u.setGname(txtname.getText());
					u.setGphone(txtphone.getText());
					gdao.addGuest(u);
					JOptionPane.showMessageDialog(getContentPane(), "添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(41, 226, 103, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		btnNewButton_1.setBounds(405, 226, 103, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guest g=new Guest();
				GuestDAO gdao=new GuestDAO();
				g=gdao.findGuest(txtname.getText());
				if(txtname.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "姓名不能为空","提示",JOptionPane.YES_OPTION);
				}
				else if(g==null) {
					JOptionPane.showMessageDialog(getContentPane(), "该用户不存在","信息提示框",JOptionPane.YES_OPTION);
				}
				else {
					gdao.updateGuest(g);
					JOptionPane.showMessageDialog(getContentPane(), "修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(159, 226, 103, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guest g=new Guest();
				GuestDAO gdao=new GuestDAO();
				g=gdao.findGuest(txtname.getText());
				if(g==null) {
					JOptionPane.showMessageDialog(getContentPane(), "该用户不存在","信息提示框",JOptionPane.YES_OPTION);
				}
				else {
					gdao.DeleteGuest(txtname.getText());
					JOptionPane.showMessageDialog(getContentPane(), "删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(277, 226, 123, 29);
		contentPane.add(btnNewButton_3);
	}
}
