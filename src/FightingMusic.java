import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class FightingMusic {
	public static void main(String[] args) {

		String storeMusic = "resources/music/BattleTheme.wav"; //Music file used
		MenuTheme(storeMusic);
	}

	static void MenuTheme(String locateMusic) {
		try {
			File musicPath = new File(locateMusic);  

			if (musicPath.exists()) { //Check if it exists
				AudioInputStream input = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(input);
				clip.start();
			}
		} catch (Exception use) {
			System.out.println(use);
		}
	}
}
