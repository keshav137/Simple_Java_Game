/**
 * @author kmalhtr3,langley1
 * @reviewed gbojan2,remypd2
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0, level = 1;
		String text = "";
		long startTime = System.currentTimeMillis();
		int r = 0;
		int g = 100;
		int b = 150;
		
		Zen.setFont("MonotypeCorsiva-64");
		startTime = System.currentTimeMillis();

		while (Zen.isRunning()) {
			//long elapsed = (int)(System.currentTimeMillis() - startTime)%100;
			if (text.length() == 0) {
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx = 20;
				dy = 20;
				text = "" + (int) (Math.random() * 999);
//				long elapsed = System.currentTimeMillis() - startTime;
//				startTime = System.currentTimeMillis();
				//score += 3000 / elapsed; // change score 
			}
			Zen.setColor(r, g, b);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 100);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: " + level,10,50);
			Zen.drawText("Score: " + score,10,100);
			
			x += dx;
			y += dy;
		
			if (y == Zen.getZenHeight() || y == -Zen.getZenHeight()){
			//	dx = -dx;
				dy = -dy;
			}
			if (x == Zen.getZenWidth() || x == 0){
				dx = -dx;
				dy = -dy;
				
			}
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0)){
					text = text.substring(1,text.length());// all except first character
					score = score + 10;
					r = r + (int)(100 * Math.random());
					b = b + (int)(50 * Math.random());
					if(score%50 == 0) {
						r = 50;
						g = 100;
						b = 100;
						level +=1;
					}
				}

			}

			Zen.sleep(90);// sleep for 90 milliseconds
			
		}
	}

}
