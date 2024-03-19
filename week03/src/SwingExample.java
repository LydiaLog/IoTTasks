import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingExample extends JFrame{

	JLabel la_name;
	JTextField tf;
	JComboBox cbJob;
	JRadioButton rbMan, rbWoman;
	JTextArea ta;
	JButton btn;
	
	public SwingExample() {
		this.setTitle("Window_Title");
		
		//Label
		la_name = new JLabel("이름 : ");
		la_name.setBounds(10, 10, 100, 20);
		add(la_name);
		
		//TextField
		tf = new JTextField(20);
		tf.setBounds(50, 10, 200, 20);
		add(tf);
		
		//ComboBox
		String[] job_li = {"---", "대학생", "직장인", "자영업자"};
		cbJob = new JComboBox(job_li);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.setBounds(5, 40, 250, 40);
		pJob.add(cbJob);
		add(pJob);
		
		//RadioButton
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남", true);
		rbWoman = new JRadioButton("여", true);
		ButtonGroup group_gender = new ButtonGroup();
		group_gender.add(rbMan);group_gender.add(rbWoman);
		pGender.add(rbMan);pGender.add(rbWoman);
		pGender.setBounds(5, 80, 100, 30);
		add(pGender);
		
		//TextArea
		ta = new JTextArea();
		JScrollPane s_pane = new JScrollPane(ta);
		s_pane.setBounds(10, 110, 250, 100);
		add(s_pane);
		
		//Button
		btn = new JButton("PRINT");
		btn.setBounds(10, 220, 120, 20);
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn) {
					ta.setText("");
					ta.append("이름 : "+ tf.getText() + "\n");
					ta.append("직업 : " + cbJob.getSelectedItem().toString() + "\n");
					if(rbMan.isSelected()) {
						ta.append("성별 : " + rbMan.getText() + "\n");
					}else {
						ta.append("성별 : " + rbWoman.getText() + "\n");
					}
				}
			}
			
		});
		add(btn);
		
		//Frame Settings
		setSize(300, 300);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingExample();
	}
}
