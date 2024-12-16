import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AttackSoundEffect1 {
 public static void main(String[] args) { 
	String storeMusic = "Attack2Effect.wav"; //Sound effect
	MenuTheme(storeMusic);
  }
   static void MenuTheme(String locateMusic) {
	
	try {
      File musicPath = new File(locateMusic);
      if(musicPath.exists()) //If it exists and is called it will play the audio
     {
      AudioInputStream input = AudioSystem.getAudioInputStream(musicPath);
      Clip clip = AudioSystem.getClip();
      clip.open(input);
      clip.start();
      }
  }
     catch(Exception use) {
     System.out.println(use);
     }
   }
}
