package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Interface extends JFrame {

	private JPanel contentPane;
	private BufferedImage image;
//	private PicturePanel picturePanel;
	private JFileChooser fileChooser;
	private ImagePanel imgPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setTitle("Image Slicing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("."));
		image = null;
		
		imgPanel = new ImagePanel();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenu mnProcessing = new JMenu("Processing");
		mnProcessing.setMnemonic('P');
		menuBar.add(mnProcessing);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mntmNew = new JMenuItem(" New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onNew();
			}
		});
		
		
		JMenuItem mntmOpen = new JMenuItem(" Open");
		ImageIcon icon = (new ImageIcon("./icons/open.png"));
		mntmOpen.setIcon(icon);
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.add(new JSeparator());
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onOpen();
			}
		});
		mntmOpen.add(new JSeparator());
		
		JMenuItem mntmSave = new JMenuItem(" Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				onSave();
			}
		});
		JMenuItem mntmExit = new JMenuItem(" Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onExit();
			}
		});
		mntmExit.add(new JSeparator());
		
		mnFile.add(mntmNew);
		mnFile.add(mntmOpen);
		mnFile.add(mntmSave);
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

	
	private void onOpen() {
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			BufferedImage img = Image.OpenImage(fileChooser.getSelectedFile().getPath());
			imgPanel.setImage(img);
		}
		
	}
	
	private void onSave() {
		// TODO Auto-generated method stub
		
	}
	
	private void onNew() {
		// TODO Auto-generated method stub
		repaint();
	}
	
	private void onExit() {
		int choice = JOptionPane.showConfirmDialog(this,"Are you sure you want to exit","EXIT",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_NO_OPTION);
				System.exit(0);
	}

}
