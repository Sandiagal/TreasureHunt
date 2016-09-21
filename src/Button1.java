
public class Button1 extends MyButton implements Runnable {
	public static Button1 b = null;
	public boolean shown = false;
	public static boolean fail = false;
	public boolean mine = false;
	public boolean flag = false;
	public boolean unkonw = false;
	public int row;
	public int col;
	public int square;
	public boolean errer = false;
	/**
	 * ∂ØÃ¨±¨’®œﬂ≥Ã
	 */
	Thread t;

	private Button1() {
	}

	public static Button1 getButton() {
		b = new Button1();
		b.t = new Thread(b); // Â•ΩÂÉèÊ≤°Áî®
		return b;
	}

	public void setIcon1_1() {
		this.SetIcon("image\\1_1.jpg");
	}

	public void setIcon1_2() {
		this.SetIcon("image\\1_2.jpg");
	}

	public void setIcon1_3() {
		this.SetIcon("image\\1_4.jpg");
	}
	
	public void setIcon1_4() {
		this.SetIcon("image\\1_4.jpg");
	}
	
	public void setIcon2_1() {
		this.SetIcon("image\\2_1.jpg");
	}

	public void setIcon2_2() {
		this.SetIcon("image\\2_2.jpg");
	}
	
	public void setIcon2_3() {
		this.SetIcon("image\\2_3.jpg");
	}

	public void setIcon2_4() {
		this.SetIcon("image\\2_4.jpg");
	}
	
	public void setIcon2_5() {
		this.SetIcon("image\\2_5.jpg");
	}

	public void setFlag_1() {
		this.SetIcon("image\\flag_1.jpg");
	}
	
	public void setFlag_2() {
		this.SetIcon("image\\flag_2.jpg");
	}

	public void setFlag_3() {
		this.SetIcon("image\\flag_3.jpg");
	}

	public void setwen() {
		this.SetIcon("image\\wen.jpg");
	}

	public void setwakai(boolean shown) {
		this.shown = shown;
	}

	public static void setfail(boolean f) {
		fail = f;
	}

	public void setlei(boolean mine) {
		this.mine = mine;
	}
	
	public void setrow(int row) {
		this.row = row;
	}

	public void setcol(int col) {
		this.col = col;
	}

	public void setbiaoji(boolean flag) {
		this.flag = flag;
	}

	public void setwenhao(boolean unkonw) {
		this.unkonw = unkonw;
	}

	public void setpingfanghe(int square) {
		this.square = square;
	}

	public void setonebao(boolean errer) {
		this.errer = errer;
	}

	@Override
	public void run() {
		this.setIcon2_2();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 2; i++) { // ÁàÜÁÇ∏Ê¨°Êï∞
			this.setIcon2_3();
			try {
				Thread.sleep(100);
				this.setIcon2_4();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.errer == false) {
			if (this.flag == true)
				this.setFlag_3();
			else
				this.setIcon2_5();
		} else
			this.setIcon2_1();
	}
}
