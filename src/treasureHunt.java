
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class treasureHunt extends JFrame {
	private static Button1 array[][];
	private static List<Button1> list;
	private int cols = 0;
	private int rows = 0;

	static int length = 10;
	static int width = 10;
	static int mineAmt = 30;
	static int lifeAmt = 5;

	private int treaseureAmt = length * width - mineAmt;

	private JFrame frame;

	private JMenuBar barNorth;
	private JMenu menu;

	private GridBagConstraints c;
	private GridBagLayout gridbag;
	private Container contentPane;
	private JLabel voidLabel;
	private int[][] pointLeft = new int[width][length];
	private JPanel pointLeftPanel;
	private int[][] pointAbove = new int[length][width];
	private JPanel pointAbovePanel;
	private JPanel mineFields;
	private boolean ifGenrt = true;

	private JPanel pSouth;
	private int leftTime = 0;
	private JLabel leftTimeLable;
	private int leftMineInt = mineAmt;
	private JLabel leftMineLabel;
	private int leftLife = lifeAmt;
	private JLabel leftLifeLabel;
	private boolean ifTiming = true;
	private int fontSize = 10;

	// private MusicPlay mainSound = new MusicPlay("sound\\Soft Sunshine.wav");
	private MusicPlay trueSound = new MusicPlay("sound\\emotion_success.wav");
	private MusicPlay errerSound = new MusicPlay("sound\\emotion_fail.wav");
	private MusicPlay winSound = new MusicPlay("sound\\enchant_success.wav");
	private MusicPlay failSound = new MusicPlay("sound\\enchant_fail.wav");

	treasureHunt() {
		frame = new JFrame();
		frame.setTitle("TreasureHunt_1.00"); // 窗口名
		try { // 基于用户偏好设置UI
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("不能被设置外观的原因:" + e);
		}

		// 北方部分
		barNorth = new JMenuBar();
		menu = new JMenu("Menu");
		JMenuItem primary = new JMenuItem("Start a primary game");
		primary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initialize();
				ifGenrt = true;
				pointLeftPanel.removeAll();
				pointAbovePanel.removeAll();
				length = 7;
				width = 7;
				mineAmt = 15;
				leftMineInt = mineAmt;
				pointLeft = new int[width][length];
				pointAbove = new int[width][length];
				pointLeftPanel = new JPanel(new GridLayout(length, 0, 5, 0));
				pointAbovePanel = new JPanel(new GridLayout(0, width, 13, 0));
				generateMineField();
				centrelSet();
			}
		});
		JMenuItem intermediate = new JMenuItem("Start an intermediate game");
		intermediate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initialize();
				ifGenrt = true;
				pointLeftPanel.removeAll();
				pointAbovePanel.removeAll();
				length = 10;
				width = 10;
				mineAmt = 30;
				leftMineInt = mineAmt;
				pointLeft = new int[width][length];
				pointAbove = new int[width][length];
				pointLeftPanel = new JPanel(new GridLayout(length, 0, 5, 0));
				pointAbovePanel = new JPanel(new GridLayout(0, width, 13, 0));
				generateMineField();
				centrelSet();
			}
		});
		JMenuItem advanced = new JMenuItem("Start an advanced game");
		advanced.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initialize();
				ifGenrt = true;
				pointLeftPanel.removeAll();
				pointAbovePanel.removeAll();
				length = 13;
				width = 13;
				mineAmt = 60;
				leftMineInt = mineAmt;
				pointLeft = new int[width][length];
				pointAbove = new int[width][length];
				pointLeftPanel = new JPanel(new GridLayout(length, 0, 5, 0));
				pointAbovePanel = new JPanel(new GridLayout(0, width, 13, 0));
				generateMineField();
				centrelSet();
			}
		});
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(primary);
		menu.add(intermediate);
		menu.add(advanced);
		menu.add(exit);
		barNorth.add(menu);

		// 中心部分
		generateMineField();
		gridbag = new GridBagLayout();
		contentPane = new Container();
		contentPane.setLayout(gridbag);
		voidLabel = new JLabel();
		pointLeftPanel = new JPanel(new GridLayout(length, 0, 5, 0));
		pointAbovePanel = new JPanel(new GridLayout(0, width, 13, 0));

		centrelSet();

		// 南方部分
		pSouth = new JPanel();
		pSouth.setBackground(new Color(102, 102, 255));
		leftTimeLable = new JLabel(
				"<html><font size = " + fontSize + " color = white>Clock:" + leftTime + "</font></html>",
				SwingConstants.CENTER);
		leftTimeLable.setFont(new Font("方正准圆_GBK", Font.BOLD, 0));
		leftTimeLable.setPreferredSize(new Dimension(200, 40));
		leftMineLabel = new JLabel(
				"<html><font size = " + fontSize + " color = white>Mines:" + leftMineInt + "</font></html>",
				SwingConstants.CENTER);
		leftMineLabel.setFont(new Font("方正准圆_GBK", Font.BOLD, 0));
		leftMineLabel.setPreferredSize(new Dimension(300, 40));
		leftLifeLabel = new JLabel(
				"<html><font size = " + fontSize + " color = white>Life:" + leftLife + "</font></html>",
				SwingConstants.CENTER);
		leftLifeLabel.setFont(new Font("方正准圆_GBK", Font.BOLD, 0));
		leftLifeLabel.setPreferredSize(new Dimension(150, 40));
		pSouth.add(leftTimeLable);
		pSouth.add(leftMineLabel);
		pSouth.add(leftLifeLabel);

		// 把各方部分放进主界面内
		frame.add(barNorth, BorderLayout.NORTH); // 最上方栏目位置
		frame.add(contentPane, BorderLayout.CENTER); // 雷区位置
		frame.add(pSouth, BorderLayout.SOUTH); // 最下方栏目位置

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1080, 1080); // 窗口大小
		frame.setLocationRelativeTo(null); // 让窗体居中显示

		// mainSound.loop();
	}

	/**
	 * 重绘中心区域
	 */
	private void centrelSet() {
		contentPane.removeAll();

		c = new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0);
		gridbag.setConstraints(new JPanel(), c);
		contentPane.add(voidLabel, 0);

		c = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
				new Insets(5, 0, 0, 0), 0, 0);
		gridbag.setConstraints(pointAbovePanel, c);
		contentPane.add(pointAbovePanel, 1);

		c = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0);
		gridbag.setConstraints(pointLeftPanel, c);
		contentPane.add(pointLeftPanel, 2);

		c = new GridBagConstraints(1, 1, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		gridbag.setConstraints(mineFields, c);
		contentPane.add(mineFields, 3);

		voidLabel.setText(" ");
	}

	/**
	 * 随机生成算法
	 * 
	 * @param x1
	 * @param y1
	 */
	private void randomMethod(int x1, int y1) { // 随机布雷，并将是雷的Button1加入list中
		list = new ArrayList<Button1>();
		int x, y;
		Random r = new Random();
		// for(int i=0;i<mineAmt;i++){//随机产生NUM个地雷
		// x=(int)r.nextInt(length);
		// y=(int)(int)r.nextInt(width);
		// if(array[x][y].mine==true||(x==x1&&y==y1))i--;
		// else {
		// array[x][y].setlei(true);
		// list.add(array[x][y]);
		// }

		// }
		int a[] = new int[length * width];
		for (int i = 0; i < length * width; i++)
			a[i] = i;
		int t = a[x1 * width + y1];
		a[x1 * width + y1] = a[length * width - 1];
		a[length * width - 1] = t;
		for (int i = 1; i <= mineAmt; i++) {
			x = r.nextInt(length * width - i);
			t = a[x];
			a[x] = a[length * width - i - 1];
			a[length * width - i - 1] = t;
		}
		for (int i = length * width - mineAmt - 1; i < length * width - 1; i++) {
			x = a[i] / width;
			y = a[i] % width;
			array[x][y].setlei(true);
			list.add(array[x][y]);
		}
	}

	/**
	 * 创建MXN个Button1(砖块)添加到panel中
	 */
	private void generateMineField() {
		mineFields = new JPanel(new GridLayout(length, width)); // 变紧凑了
		mineFields.setPreferredSize(new Dimension(1080 * width / 22, 1080 * width / 22));
		array = new Button1[length][width];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				array[i][j] = Button1.getButton();
				array[i][j].setrow(i);
				array[i][j].setcol(j);
				array[i][j].setIcon1_1();
				array[i][j].setPreferredSize(new Dimension(50, 50));
				mineFields.add(array[i][j]);
				/**
				 * 为每个砖块添加鼠标点击事件监控
				 */
				array[i][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON3) { // 右击事件
							if (((Button1) e.getSource()).shown == false) {
								if (((Button1) e.getSource()).flag == false
										&& ((Button1) e.getSource()).unkonw == false) {
									((Button1) e.getSource()).setFlag_1();
									((Button1) e.getSource()).setbiaoji(true);
									leftMineInt--;
									leftMineLabel.setText("<html><font size = " + fontSize + " color = white>Mines:"
											+ leftMineInt + "</font></html>");
								} else if (((Button1) e.getSource()).unkonw == false) {
									((Button1) e.getSource()).setwen();
									((Button1) e.getSource()).setwenhao(true);
									((Button1) e.getSource()).setbiaoji(false);
									leftMineInt++;
									leftMineLabel.setText("<html><font size = " + fontSize + " color = white>Mines:"
											+ leftMineInt + "</font></html>");
								} else {
									((Button1) e.getSource()).setIcon1_1();
									((Button1) e.getSource()).setwenhao(false);
								}
							}
						} else if (((Button1) e.getSource()).shown == false
								&& ((Button1) e.getSource()).flag == false) { // 左键事件
							((Button1) e.getSource()).setwakai(true);
							if (((Button1) e.getSource()).mine == true) { // 踩到雷
								((Button1) e.getSource()).setIcon2_1();
								((Button1) e.getSource()).setonebao(true);
								leftLife--;
								leftMineInt--;
								leftLifeLabel.setText("<html><font size = " + fontSize + " color = white>Life:"
										+ leftLife + "</font></html>");
								leftMineLabel.setText("<html><font size = " + fontSize + " color = white>Mines:"
										+ leftMineInt + "</font></html>");
								errerSound.replay();
								if (leftLife == 0) {
									ifTiming = false;
									Button1.setfail(true);
									rows = ((Button1) e.getSource()).row;
									cols = ((Button1) e.getSource()).col;
									new explosion().start();
								}
							} else {
								int rowrow = ((Button1) e.getSource()).row;
								int colcol = ((Button1) e.getSource()).col;
								trueSound.replay();
								if (ifGenrt == true) { // 生成雷区
									randomMethod(rowrow, colcol);
									ifGenrt = false;
									ifTiming = true;
									new timing().start();
									analyzePoint();
									showpoint();
									frame.pack();
								}
								((Button1) e.getSource()).setIcon1_3();
								treaseureAmt--;
								if (treaseureAmt == 0) {
									result(1);
								}
							}
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						if (((Button1) e.getSource()).shown == false && ((Button1) e.getSource()).unkonw == false
								&& Button1.fail == false && ((Button1) e.getSource()).flag == false)
							((Button1) e.getSource()).setIcon1_2();
					}

					@Override
					public void mouseExited(MouseEvent e) {
						if (((Button1) e.getSource()).shown == false && ((Button1) e.getSource()).unkonw == false
								&& Button1.fail == false && ((Button1) e.getSource()).flag == false)
							((Button1) e.getSource()).setIcon1_1();
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseReleased(MouseEvent e) {
					}

				});
			}
		}
	}

	/**
	 * 得到雷区的提示
	 */
	private void analyzePoint() {
		int k = 0;
		for (int i = 0; i < length; i++) {
			k = 0;
			for (int j = 0; j < width; j++) {
				if (array[i][j].mine != true) {
					pointLeft[i][k]++;
				} else if (pointLeft[i][k] != 0) {
					k++;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			k = 0;
			for (int j = length - 1; j > -1; j--) {
				if (array[j][i].mine != true) {
					pointAbove[i][k]++;
				} else if (pointAbove[i][k] != 0) {
					k++;
				}
			}
		}
	}

	/**
	 * 显示雷区的提示
	 */
	private void showpoint() {
		JLabel temp = new JLabel();
		int[] effectiveLength = BasicTool.effectiveLength2(pointLeft);
		int panelWidth = BasicTool.max(effectiveLength);
		int k = 0;
		for (int i = 0; i < pointLeft.length; i++) {
			k = 0;
			for (int j = 0; j < panelWidth; j++) {
				if (j > panelWidth - effectiveLength[i] - 1) {
					temp = new JLabel(String.valueOf(pointLeft[i][k++]), JLabel.CENTER);
					temp.setFont(new Font("方正准圆_GBK", Font.BOLD, 20));
					pointLeftPanel.add(temp);
				} else {
					pointLeftPanel.add(new JLabel(""));
				}
			}
		}
		effectiveLength = BasicTool.effectiveLength2(pointAbove);
		panelWidth = BasicTool.max(effectiveLength);
		for (int i = panelWidth - 1; i > -1; i--) {
			for (int j = 0; j < pointAbove.length; j++) {
				if (i == 0 || pointAbove[j][i] != 0) {
					temp = new JLabel(String.valueOf(pointAbove[j][i]), JLabel.CENTER);
					temp.setFont(new Font("方正准圆_GBK", Font.BOLD, 20));
					pointAbovePanel.add(temp);
				} else {
					pointAbovePanel.add(new JLabel(""));
				}
			}
		}
		voidLabel.setText(" ");
	}

	/**
	 * 开始新游戏的初始化
	 */
	private void initialize() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				array[i][j].t = new Thread(array[i][j]);
				array[i][j].setwakai(false);
				array[i][j].setbiaoji(false);
				array[i][j].setwenhao(false);
				array[i][j].setonebao(false);
				array[i][j].setlei(false);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				array[i][j].setIcon1_1();
			}
		}
		Button1.setfail(false);
		leftTime = 0;
		leftLife = lifeAmt;
		ifTiming = false;
		leftMineInt = mineAmt;
		treaseureAmt = length * width - mineAmt;
		leftTimeLable.setText("<html><font size = " + fontSize + " color = white>Clock:" + leftTime + "</font></html>");
		leftMineLabel
				.setText("<html><font size = " + fontSize + " color = white>Mines:" + leftMineInt + "</font></html>");
		leftLifeLabel.setText("<html><font size = " + fontSize + " color = white>Life:" + leftLife + "</font></html>");
	}

	/**
	 * 输了时弹出对话框，并更改各级连胜和连败信息并输出到文件中
	 */
	private void result(int rslt) {
		ifTiming = false;
		String[] choices = new String[] { "Exit", "Try again", "New game" };
		String shuyin = new String();
		DecimalFormat df = new DecimalFormat("#.00");
		double score = 100 / (1 + Math.pow(Math.E, (leftTime - length * width * 3) / Math.pow(length * width, 1)));
		if (rslt == 0) {
			shuyin = "Condolence. You are naiver than " + df.format(score) + "% of all the players.";
			failSound.replay();
		} else {
			shuyin = "Congratulation! You are wiser than " + df.format(score) + "% of all the players.";
			winSound.replay();
		}
		int xx = JOptionPane.showOptionDialog(null, shuyin, "Please choose", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		if (xx == 0) {
			System.exit(0);
		} else {
			initialize();
			if (xx == 1) {// 选择重玩游戏只需要对已有对象进行重新初始化属性
				int ux, uy;
				for (Button1 b : list) { // 还原雷区
					b.setIcon1_1();
					ux = b.row;
					uy = b.col;
					array[ux][uy].setlei(true);
				}
			} else if (xx == 2) {// 选择新游戏
				ifGenrt = true;
				pointLeft = new int[width][length];
				pointAbove = new int[width][length];
				pointLeftPanel.removeAll();
				pointAbovePanel.removeAll();
			}
		}
	}

	/**
	 * 计时进程
	 * 
	 * @author Administrator
	 *
	 */
	class timing extends Thread {
		public void run() {
			while (ifTiming == true) {
				try {
					leftTime++;
					leftTimeLable.setText(
							"<html><font size = " + fontSize + " color = white>Clock:" + leftTime + "</font></html>");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 爆炸进程
	 * 
	 * @author Administrator
	 *
	 */
	class explosion extends Thread {
		public void run() {
			int x;
			int y;
			for (Button1 aa : list) {
				x = aa.row;
				y = aa.col;
				int he = (Math.abs(rows - x)) * (Math.abs(rows - x)) + (Math.abs(cols - y)) * (Math.abs(cols - y));// 求平方和
				aa.setpingfanghe(he);// 将求得的平方和赋给Button1对象的pingfanghe属性
			}
			/**
			 * 以点击位置为中心重拍所有雷区列表
			 */
			Comparator compare = new Comparator() {

				@Override
				public int compare(Object arg0, Object arg1) {
					if (Button1.class.isInstance(arg0) && Button1.class.isInstance(arg1)) {
						Button1 b0 = (Button1) arg0;
						Button1 b1 = (Button1) arg1;
						return b0.square > b1.square ? 1 : b0.square < b1.square ? -1 : 0;
					}
					return 1;
				}

			};
			Collections.sort(list, compare);
			for (Button1 b : list) {// 取出set的Button1对象并启动相应的线程打到动态爆炸效果
				if (b.shown == false || b.errer == true) {
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					b.t.start();
					leftMineInt--;
					leftMineInt = leftMineInt > 0 ? leftMineInt : 0;
					leftMineLabel.setText("<html><font size = " + fontSize + " color = white>Mines:" + leftMineInt
							+ "</font></html>");
				}
			}
			leftMineLabel.setText("<html><font size = " + fontSize + " color = white>Mines:" + 0 + "</font></html>");
			result(0);
			return;
		}
	}

	public static void main(String[] args) {
		treasureHunt treasure1 = new treasureHunt();
	}
}
