package com.yhtos.games.letter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import com.yhtos.games.word.Word;


public class TestMain {
	private int sleep_count = 0;	//　记录程序屏幕刷新次数
	JFrame jFrame;
	MyCanvas myCanvas;
	JTextField count_text;
	JLabel fenShL;
	List<Word> fuhe = new ArrayList<Word>();
	
	int td = 1000;//时间 
	
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
		myCanvas.setBounds(0, 0, 500, 400);
		myCanvas.setBackground(Color.gray);
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
					if (!is) {//单词开始
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("a")) {
								fuhe.add(word);
								
								if(firstW) {
									//buf = buf + "a";
									buf = "a";   //开始
									firstW = false;
								}
								
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，单词长度："+buf);
							}
						}
						is = true;      //is用于记录单词开始
					} else {
						for(Word fuWord : fuhe) {
							
							if(firstW) {
								buf = buf + "a";    //将字母加入单词尾部
								firstW = false;//使字母在遍历是只累加一次
							}
							
							if(fuWord.getWord().startsWith(buf)) {  //判断累计输入字母是否为所遍历单词的前半部分
								if(fuWord.getWord().equals(buf)) {   // 再判断累计输入字符是否和所遍历单词相等
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									//fuhe.remove(fuhe.indexOf(fuWord));//在符合的集合中删除
																		//突然想到既然已经符合了，索性直
																		//接清空这个集合，除非有单词里面套着另一个单词
																		//否则这个集合本身也已经空了
									fuhe.clear();//清空集合		
									System.out.println("清前的集合");
									for(Word wasdw : myCanvas.words)
										System.out.println("++"+wasdw.getWord());
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合");
									for(Word wasdw : myCanvas.words)
										System.out.println("++"+wasdw.getWord());
									System.out.println("成功删除");
								}  else {
									//buf = buf + "a";
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'b':
					firstW = true;
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
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'c':
					firstW = true;
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
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("d")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "d";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "d";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'e':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("e")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "e";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "e";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'f':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("f")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "f";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "f";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'g':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("g")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "g";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "g";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'h':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("h")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "h";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "h";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'i':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("i")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "i";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "i";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'j':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("j")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "j";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "j";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'k':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("k")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "k";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "k";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'l':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("l")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "l";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "l";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'm':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("m")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "m";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "m";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'n':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("n")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "n";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "n";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'o':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("o")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "o";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "o";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'p':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("p")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "p";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "p";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'q':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("q")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "q";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "q";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'r':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("r")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "r";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "r";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 's':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("s")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "s";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "s";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 't':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("t")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "t";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "t";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'u':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("u")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "u";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "u";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'v':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("v")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "v";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "v";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'w':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("w")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "w";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "w";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'x':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("x")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "x";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "x";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'y':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("y")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "y";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "y";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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
				case 'z':
					firstW = true;//保证每次只存入buf一个字母
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//如果单词的起始字母正确，存入集合
							if(word.getWord().startsWith("z")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "z";
									firstW = false;
								}
								System.out.println("首字母符合，"+ word.getWord() +"加入集合，buf："+buf);
							}
						}
						is = true;
					} else {
						for(Word fuWord : fuhe) {
							if(firstW) {
								buf = buf + "z";
								firstW = false;
							}
							if(fuWord.getWord().startsWith(buf)) {
								if(fuWord.getWord().equals(buf)) {
									System.out.println("判断出相等单词：："+buf+";;");
									is = false;     //重新记录单词标志
									buf = "";		//累加器清空
									System.out.println("单词最终符合，累加器清空,buf:"+buf+";");
									
									fraction++;			//分数加
									count_text.setText(Integer.toString(fraction));//更新分数
									fenShL.setText("分数："+Integer.toString(fraction));
									fuhe.clear();//清空集合		
									System.out.println("清前的集合"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//清除屏幕集合中符合的内容
									/**/is = false;
									System.out.println("清后的集合"+myCanvas.words);
									System.out.println("成功删除");
								}  else {
									System.out.println("部分符合::"+fuWord.getWord()+";;;;buf::"+buf+";;");
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


				default:
					break;
				}
			}
		});
		jFrame.add(myCanvas);
		//setKeyboardListener();
		
		fenShL = new JLabel();
		fenShL.setText("分数：");
		fenShL.setBounds(10, 500, 50, 30);
		jFrame.add(fenShL);
		
		count_text = new JTextField();
		count_text.setBounds(300, 460, 60, 60);
		count_text.setText("0");
		jFrame.add(count_text);	
		
		JButton star = new JButton("开始");
		star.setBounds(100, 460, 200, 50);
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
							if(sleep_count % 8 == 0) {
								myCanvas.rondomPutWord();
							}
							if(sleep_count % 10 == 0) {
								if(td	>	50)
									td -= 20;      //时间每过一段秒，单词生成时间就减20毫秒
							}
							for(Word word : myCanvas.words) {
									word.setY(word.getY() + word.getAddY());
							}
							try {
								sleep_count++;
								Thread.sleep(td);
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
