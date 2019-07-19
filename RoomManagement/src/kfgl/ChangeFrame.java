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

public class ChangeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtrid1;
	private JTextField txtrid2;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeFrame frame = new ChangeFrame();
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
	public ChangeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u73B0\u623F\u95F4\u53F7");
		lblNewLabel.setBounds(145, 100, 81, 21);
		contentPane.add(lblNewLabel);
		
		txtrid1 = new JTextField();
		txtrid1.setBounds(364, 97, 96, 27);
		contentPane.add(txtrid1);
		txtrid1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u60F3\u6362\u7684\u623F\u95F4\u53F7");
		lblNewLabel_1.setBounds(145, 162, 123, 21);
		contentPane.add(lblNewLabel_1);
		
		txtrid2 = new JTextField();
		txtrid2.setBounds(364, 159, 96, 27);
		contentPane.add(txtrid2);
		txtrid2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BA2\u6237\u59D3\u540D");
		lblNewLabel_2.setBounds(145, 222, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setBounds(364, 219, 96, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6362\u623F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gna=txtname.getText();
				int rno1=Integer.parseInt(txtrid1.getText());
				int rno2=Integer.parseInt(txtrid2.getText());
				RoomDAO rdao=new RoomDAO();
				try {
					boolean a = rdao.judge(rno2);
					if(a==false) {
						JOptionPane.showMessageDialog(getContentPane(), "房间已被预订","信息提示框",JOptionPane.WARNING_MESSAGE);
					}
					else {
						Procedure pro=new Procedure();
						pro.ProCha(gna, rno1, rno2);
						JOptionPane.showMessageDialog(getContentPane(), "换房成功","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(120, 302, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(364, 302, 123, 29);
		contentPane.add(btnNewButton_1);
	}

}
