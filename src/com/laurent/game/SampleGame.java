	package com.laurent.game;

import com.laurent.framework.Screen;
import com.laurent.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		return new LoadingScreen(this); 
	}
	
	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}
}
