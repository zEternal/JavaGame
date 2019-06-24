package com.yhtos.games.letter;

import java.awt.Canvas;
import java.awt.Graphics;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.yhtos.games.word.Word;

public class MyCanvas extends Canvas {
	
	public final List<Word> words = new ArrayList<>();

	String sss[] = {"ab","abb","abc","ad","aa","ac","ba","cb","bc","j","k"};	
	/*�ɰ����
	 * private int x = 200;
	private int y = 10;
	
	public void setY(int y) {
		this.y = y;
	}
	*/
	/*��ʼ��UI
	 * public void initUI() {
		Word word = new Word();
		word.setWord("w");
		word.setX(x);
		word.setY(y);
		word.setAddY(10);
		
		words.add(word);
		rondomPutWord();
	}*/
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		for(Word w : words) {
			drawAWord(g, w);
		}
	}
	
	
	//�������X��λ�õ���ĸ��X���������ĸ����һ��
	public void rondomPutWord() {
		Word word = new Word();
		word.setWord(sss[(int)(Math.random()*10)]);
		word.setX((int)(Math.random()*500));
		word.setY(10);
		word.setAddY(20);
		words.add(word);
	}
	
	//������ĸ
	public void drawAWord(Graphics g, Word word) {
		g.drawString(word.getWord(), word.getX(), word.getY());
	}
}
