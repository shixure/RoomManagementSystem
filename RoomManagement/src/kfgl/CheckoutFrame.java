package kfgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckoutFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtrid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutFrame frame = new CheckoutFrame();
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
	public CheckoutFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u9000\u623F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gna=txtname.getText();
				int rno=Integer.parseInt(txtrid.getText());	
				Procedure pro=new Procedure();
				pro.ProChe(gna, rno);
				JOptionPane.showMessageDialog(getContentPane(), "退房成功","提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(108, 261, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(334, 261, 123, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u5BA2\u6237\u59D3\u540D");
		lblNewLabel.setBounds(138, 90, 81, 21);
		contentPane.add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(328, 87, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel_1.setBounds(138, 167, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		txtrid = new JTextField();
		txtrid.setBounds(328, 164, 96, 27);
		contentPane.add(txtrid);
		txtrid.setColumns(10);
	}
}
