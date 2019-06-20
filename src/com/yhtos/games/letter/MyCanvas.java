package com.yhtos.games.letter;

import java.awt.Canvas;
import java.awt.Graphics;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.yhtos.games.word.Word;

public class MyCanvas extends Canvas {
	
	public List<Word> words = new ArrayList<>();

	private int x = 200;
	private int y = 10;
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void initUI() {
		Word word = new Word();
		word.setWord("w");
		word.setX(x);
		word.setY(y);
		word.setAddY(10);
		
		words.add(word);
		rondomPutWord();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		for(Word w : words) {
			drawAWord(g, w);
		}
	}
	
	public void rondomPutWord() {
		int x = 100;
		Word word = new Word();
		word.setWord("hello");
		//word.setX(x);
		word.setX((int)(Math.random()*500));
		word.setY(this.y);
		word.setAddY(20);
		words.add(word);
	}
	
	public void drawAWord(Graphics g, Word word) {
		g.drawString(word.getWord(), word.getX(), word.getY());
	}
}
