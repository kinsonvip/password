package top.kinson.java;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.shiro.crypto.hash.Md5Hash;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class IndexFrame {

	private JFrame frame;
	private JTextField account;
	private JTextField password;
	private JTextField textField_result;
	private JTextField textField_app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexFrame window = new IndexFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IndexFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("华文楷体", Font.BOLD, 20));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(IndexFrame.class.getResource("/img/password.png")));
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBackground(Color.CYAN);
		frame.setResizable(false);
		frame.setTitle("\u5BC6\u7801\u751F\u6210\u5668");
		frame.setBounds(100, 100, 400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(93, 38, 55, 32);
		frame.getContentPane().add(lblNewLabel);
		
		account = new JTextField();
		account.setBounds(151, 43, 170, 24);
		frame.getContentPane().add(account);
		account.setColumns(20);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(93, 78, 55, 18);
		frame.getContentPane().add(label);
		
		password = new JTextField();
		password.setBounds(151, 75, 170, 24);
		frame.getContentPane().add(password);
		password.setColumns(20);
		
		JButton btn_build = new JButton("\u751F\u6210");
		btn_build.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btn_build.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = account.getText().trim();
				String str2 = password.getText().trim();
				String str3 = textField_app.getText().trim();
				String md5Pswd = new Md5Hash(str2, str1+str3, 14).toString().substring(0, 16);
				textField_result.setText(md5Pswd);
			}
		});
		btn_build.setBounds(93, 140, 113, 27);
		frame.getContentPane().add(btn_build);
		
		JLabel label_1 = new JLabel("\u52A0\u5BC6\u540E\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_1.setBounds(40, 183, 108, 18);
		frame.getContentPane().add(label_1);
		
		JButton btn_copy = new JButton("\u590D\u5236");
		btn_copy.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btn_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取系统剪贴板
		        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		        // 封装文本内容
		        Transferable trans = new StringSelection(textField_result.getText());
		        // 把文本内容设置到系统剪贴板
		        clipboard.setContents(trans, null);
			}
		});
		btn_copy.setBounds(208, 140, 113, 27);
		frame.getContentPane().add(btn_copy);
		
		textField_result = new JTextField();
		textField_result.setBounds(151, 180, 170, 24);
		frame.getContentPane().add(textField_result);
		textField_result.setColumns(20);
		
		JLabel label_2 = new JLabel("\u5E94\u7528\uFF1A");
		label_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_2.setBounds(93, 109, 55, 18);
		frame.getContentPane().add(label_2);
		
		textField_app = new JTextField();
		textField_app.setBounds(151, 106, 170, 24);
		frame.getContentPane().add(textField_app);
		textField_app.setColumns(20);
	}
}
