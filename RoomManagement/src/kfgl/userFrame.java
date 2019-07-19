package kfgl;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userFrame frame = new userFrame();
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
	public userFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(107, 64, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(107, 116, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		txtname = new JTextField();
		txtname.setBounds(228, 61, 130, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnOK = new JButton("\u786E\u5B9A");
		btnOK.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) {
				if(txtname.getText().equals("")||txtpwd.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "用户名和密码不能为空","信息提示框",JOptionPane.WARNING_MESSAGE);
				}
				else {
					UserDAO udao=new UserDAO();
					Users u=udao.findUser(txtname.getText(),txtpwd.getText());
					if(u!=null) {
						JOptionPane.showMessageDialog(getContentPane(), "登录成功！","信息提示框",JOptionPane.WARNING_MESSAGE);
						MainFrame mainframe=new MainFrame();
						mainframe.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "登录失败","信息提示框",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnOK.setBounds(82, 190, 123, 29);
		contentPane.add(btnOK);
		
		JButton btnNO = new JButton("\u53D6\u6D88");
		btnNO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNO.setBounds(264, 190, 123, 29);
		contentPane.add(btnNO);
		
		txtpwd = new JTextField();
		txtpwd.setBounds(228, 113, 130, 27);
		contentPane.add(txtpwd);
		txtpwd.setColumns(10);
	}
}
