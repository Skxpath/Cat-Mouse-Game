package ca.cmpt213.as2.gui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * SoundMaker class to make a sound.
 */
public class SoundMaker {

    private static File Won = new File("sounds/won.wav");
    private static File Lost = new File("sounds/lost.WAV");
    private static File Invalid = new File("sounds/invalidmove.WAV");

    public static void play(Sounds sound) {
        switch(sound) {
            case INVALID:
                playSound(Invalid);
                break;
            case LOST:
                playSound(Lost);
                break;
            case WON:
                playSound(Won);
                break;
        }
    }
    private static void playSound(File sound) {
        try {
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
