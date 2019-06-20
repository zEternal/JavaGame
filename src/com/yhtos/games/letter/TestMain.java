package com.yhtos.games.letter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.yhtos.games.word.Word;



public class TestMain {
	
	JFrame jFrame;
	
	public static void main(String[] args) {
		new TestMain().initview();
	}
	
	public void initview() {
		jFrame = new JFrame("小游戏");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 500, 500);
		jFrame.setLayout(null);
		
		MyCanvas myCanvas = new MyCanvas();
		myCanvas.setBounds(0, 60, 500, 500);
		jFrame.add(myCanvas);
		setKeyboardListener();
		
		/*
		JButton star = new JButton("开始");
		star.setBounds(100, 5, 200, 50);
		star.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int y = 10;
						while (true) {
							y += 10;
							try {
								Thread.sleep(500);
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							myCanvas.setY(y);
							//myCanvas.repaint();
							//myCanvas
							myCanvas.invalidate();
						}
					}
				});
				thread.start();
			}
		});
		jFrame.add(star);
		*/
		
		jFrame.setVisible(true);
		//myCanvas.initUI();
		while (true) {
			if(sleep_count % 4 == 0) {
				myCanvas.rondomPutWord();
			}
			for(Word word : myCanvas.words) {
				word.setY(word.getY() + word.getAddY());
			}
			
			try {
				sleep_count++;
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myCanvas.repaint();
			//myCanvas
			//myCanvas.invalidate();
		}
		//while(true) {}
	}
	private int sleep_count = 0;	//　记录程序屏幕刷新次数
	
	private void setKeyboardListener() {
		jFrame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getKeyCode()) {
				case KeyEvent.VK_A:
					
					System.out.println("a");
					break;
				case KeyEvent.VK_B:
					System.out.println("b");
					break;

				default:
					break;
				}
			}
		});
	}
}
