package ddr;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
 public class sound {

	URL sound;
	AudioClip noise;
	public sound() {
	    
		playBadis();
	    
	}
	
	private void playBadis()
    {
        try
        {
            sound = new URL("file:src/BeepBox-Song.wav") ;
            noise = JApplet.newAudioClip(sound);
           // noise.play();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
	
}
