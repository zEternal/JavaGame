package com.yhtos.games.letter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.yhtos.games.word.Word;

public class TestMain {
	private int sleep_count = 0;	//　记录程序屏幕刷新次数
	JFrame jFrame;
	MyCanvas myCanvas;
	JTextField count_text;
	List<Word> fuhe = new ArrayList<Word>();
	
	boolean kaishi = false;
	
	
	boolean is = false;//记录单词开始
	int jilu = 0;//记录字母数量
	String buf = "";
	boolean firstW;
	
	int fraction = 0;
	public static void main(String[] args) {
//		if("asdfd".startsWith("asdf"))
//			System.out.println("aaaaaaaaaaaaa");
//		else
//			System.out.println("ssssssss");
		new TestMain().initview();
	}
	
	public void initview() {
		jFrame = new JFrame("小游戏");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 500, 500);
		jFrame.setLayout(null);
		
		myCanvas = new MyCanvas();
		myCanvas.setBounds(0, 60, 500, 500);
		myCanvas.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				char ch = arg0.getKeyChar();
				String ss = String.valueOf(ch);
				System.out.println(ch);
				switch (ch) {
				case 'a':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("a")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "a";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "a";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									is = false;
									buf = "";
									System.out.println("最终符合，buf清空,buf:"+buf);
									fraction++;
									count_text.setText(Integer.toString(fraction));
									
									fuhe.remove(fuhe.indexOf(fuWord));
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));
									System.out.println("成功删除");
								}  else {
									//buf = buf + "a";
									System.out.println("部分符合,buf:"+buf);
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("超出长度，buf清空,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'b':firstW = true;
					if (!is) {
						
						for(Word word : myCanvas.words) {
							if(word.getWord().startsWith("b")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "b";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
						//buf = buf + "b";
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "b";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									is = false;
									buf = "";
									System.out.println("最终符合，buf清空,buf:"+buf);
									fraction++;
									count_text.setText(Integer.toString(fraction));
									fuhe.remove(fuhe.indexOf(fuWord));
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));
									System.out.println("成功删除");
								}  else {
									//buf = buf + "b";
									System.out.println("部分符合,buf:"+buf);
								}
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
									buf = "";
									is = false;
									System.out.println("超出长度，buf清空,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'c':firstW = true;
					if (!is) {
						
						for(Word word : myCanvas.words) {
							if(word.getWord().startsWith("c")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "c";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "c";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									is = false;
									buf = "";
									System.out.println("最终符合，buf清空,buf:"+buf);
									fraction++;
									count_text.setText(Integer.toString(fraction));
									fuhe.remove(fuhe.indexOf(fuWord));
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));
									System.out.println("成功删除");
								}  else {
									//buf = buf + "c";
									System.out.println("部分符合,buf:"+buf);
								}
							} else {
								if(fuWord.getWord().length() < buf.length()) {
									buf = "";
									is = false;
									System.out.println("超出长度，buf清空,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'd':
					for(Word word : myCanvas.words) {
						if(word.getWord().equals("c")) { 
							fraction++;
							count_text.setText(Integer.toString(fraction));
						}
					}
					break;
				case 'e':
					
					break;
				case 'f':
					
					break;
				case 'g':
					
					break;
				case 'h':
					
					break;
				case 'i':
					
					break;
				case 'j':
					
					break;
				case 'k':
					
					break;
				case 'l':
					
					break;
				case 'm':
					
					break;
				case 'n':
					
					break;
				case 'o':
					
					break;
				case 'p':
					
					break;
				case 'q':
					
					break;
				case 'r':
					
					break;
				case 's':
					
					break;
				case 't':
					
					break;
				case 'u':
					
					break;
				case 'v':
					
					break;
				case 'w':
					
					break;
				case 'x':
					
					break;
				case 'y':
					
					break;
				case 'z':
					
					break;


				default:
					break;
				}
			}
		});
		jFrame.add(myCanvas);
		//setKeyboardListener();
		
		count_text = new JTextField();
		count_text.setBounds(300, 5, 60, 60);
		count_text.setText("12365");
		jFrame.add(count_text);		
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
						//myCanvas.initUI();
						
						//产生一个随机数 111
						/**///myCanvas.rondomPutWord();
						while (true) {
							//不断的产生随机数  222
							if(sleep_count % 4 == 0) {
								myCanvas.rondomPutWord();
							}
							for(Word word : myCanvas.words) {
								//if (word.getY() < 500)
									word.setY(word.getY() + word.getAddY());
								//else word.setY(10);
							}
							try {
								sleep_count++;
								Thread.sleep(1000);
								System.out.println((int)(Math.random()*10));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							myCanvas.repaint();
						}
					}
				});
				thread.start();
				
			}
		});
		jFrame.add(star);
		
		jFrame.setVisible(true);
		
	}

	
}
