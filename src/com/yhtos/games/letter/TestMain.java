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
	private int sleep_count = 0;	//����¼������Ļˢ�´���
	JFrame jFrame;
	MyCanvas myCanvas;
	JTextField count_text;
	JLabel fenShL;
	List<Word> fuhe = new ArrayList<Word>();
	
	int td = 1000;//ʱ�� 
	
	boolean kaishi = false;
	
	
	boolean is = false;//��¼���ʿ�ʼ
	int jilu = 0;//��¼��ĸ����
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
		jFrame = new JFrame("С��Ϸ");
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
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {//���ʿ�ʼ
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("a")) {
								fuhe.add(word);
								
								if(firstW) {
									//buf = buf + "a";
									buf = "a";   //��ʼ
									firstW = false;
								}
								
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ����ʳ��ȣ�"+buf);
							}
						}
						is = true;      //is���ڼ�¼���ʿ�ʼ
					} else {
						for(Word fuWord : fuhe) {
							
							if(firstW) {
								buf = buf + "a";    //����ĸ���뵥��β��
								firstW = false;//ʹ��ĸ�ڱ�����ֻ�ۼ�һ��
							}
							
							if(fuWord.getWord().startsWith(buf)) {  //�ж��ۼ�������ĸ�Ƿ�Ϊ���������ʵ�ǰ�벿��
								if(fuWord.getWord().equals(buf)) {   // ���ж��ۼ������ַ��Ƿ���������������
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									//fuhe.remove(fuhe.indexOf(fuWord));//�ڷ��ϵļ�����ɾ��
																		//ͻȻ�뵽��Ȼ�Ѿ������ˣ�����ֱ
																		//�����������ϣ������е�������������һ������
																		//����������ϱ���Ҳ�Ѿ�����
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���");
									for(Word wasdw : myCanvas.words)
										System.out.println("++"+wasdw.getWord());
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���");
									for(Word wasdw : myCanvas.words)
										System.out.println("++"+wasdw.getWord());
									System.out.println("�ɹ�ɾ��");
								}  else {
									//buf = buf + "a";
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
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
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								}
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
									buf = "";
									is = false;
									System.out.println("�������ȣ�buf���,buf:"+buf);
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
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								}
							} else {
								if(fuWord.getWord().length() < buf.length()) {
									buf = "";
									is = false;
									System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'd':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("d")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "d";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'e':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("e")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "e";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'f':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("f")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "f";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'g':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("g")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "g";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'h':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("h")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "h";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'i':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("i")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "i";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'j':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("j")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "j";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'k':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("k")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "k";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'l':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("l")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "l";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'm':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("m")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "m";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'n':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("n")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "n";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'o':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("o")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "o";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'p':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("p")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "p";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'q':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("q")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "q";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'r':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("r")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "r";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 's':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("s")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "s";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 't':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("t")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "t";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'u':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("u")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "u";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'v':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("v")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "v";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'w':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("w")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "w";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'x':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("x")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "x";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'y':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("y")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "y";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
								}
							}
						}
						
					}
					break;
				case 'z':
					firstW = true;//��֤ÿ��ֻ����bufһ����ĸ
					if (!is) {
						
						for(Word word : myCanvas.words) {
							//������ʵ���ʼ��ĸ��ȷ�����뼯��
							if(word.getWord().startsWith("z")) {
								fuhe.add(word);
								if(firstW) {
									buf = buf + "z";
									firstW = false;
								}
								System.out.println("����ĸ���ϣ�"+ word.getWord() +"���뼯�ϣ�buf��"+buf);
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
									System.out.println("�жϳ���ȵ��ʣ���"+buf+";;");
									is = false;     //���¼�¼���ʱ�־
									buf = "";		//�ۼ������
									System.out.println("�������շ��ϣ��ۼ������,buf:"+buf+";");
									
									fraction++;			//������
									count_text.setText(Integer.toString(fraction));//���·���
									fenShL.setText("������"+Integer.toString(fraction));
									fuhe.clear();//��ռ���		
									System.out.println("��ǰ�ļ���"+myCanvas.words);
									myCanvas.words.remove(myCanvas.words.indexOf(fuWord));//�����Ļ�����з��ϵ�����
									/**/is = false;
									System.out.println("���ļ���"+myCanvas.words);
									System.out.println("�ɹ�ɾ��");
								}  else {
									System.out.println("���ַ���::"+fuWord.getWord()+";;;;buf::"+buf+";;");
								} 
								
							}  else {
								if(fuWord.getWord().length() < buf.length()) {
										buf = "";
										is = false;
										System.out.println("�������ȣ�buf���,buf:"+buf);
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
		fenShL.setText("������");
		fenShL.setBounds(10, 500, 50, 30);
		jFrame.add(fenShL);
		
		count_text = new JTextField();
		count_text.setBounds(300, 460, 60, 60);
		count_text.setText("0");
		jFrame.add(count_text);	
		
		JButton star = new JButton("��ʼ");
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
						
						//����һ������� 111
						/**///myCanvas.rondomPutWord();
						while (true) {
							//���ϵĲ��������  222
							if(sleep_count % 8 == 0) {
								myCanvas.rondomPutWord();
							}
							if(sleep_count % 10 == 0) {
								if(td	>	50)
									td -= 20;      //ʱ��ÿ��һ���룬��������ʱ��ͼ�20����
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
