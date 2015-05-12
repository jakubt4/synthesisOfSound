package sound;

import java.util.ArrayList;

import gui.components.AbstractListenerElements;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JTextField;

public class PlaySound extends AbstractListenerElements{
    private double[] amplitudy;
    private double[] fazy;

    public float SAMPLE_RATE = 150000;  /*440*2^6*/
    private int hzs;
        
    public void sound(int msecs) throws LineUnavailableException {
        byte[] buf = new byte[(int)SAMPLE_RATE * msecs / 1000];
        for (int i=0; i < buf.length; i++) {
            buf[i] = (byte)((Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI) * 127.0 * amplitudy[0]) + fazy[0]*57.29);
            for(int j = 0; j < amplitudy.length; j++){
                buf[i] += (byte)((127.0 * amplitudy[j] * Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI*j  + fazy[j]*57.29)));
            }
        }
        
        AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 2, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        sdl.write(buf, 0, buf.length);
        sdl.drain();
        sdl.close();
    }
    
    public void play() throws LineUnavailableException {
        int size = ampls.size();
        fazy = new double[size];
        amplitudy = new double[size];
        
        setArrays(fazy, phases);
        setArrays(amplitudy, ampls);
        setFrekv();
        sound(1000);
    }

    private void setArrays(double[] array, ArrayList<JTextField> arrayList) {
        for(int i = 0; i <  arrayList.size(); i++){
            array[i] = Double.parseDouble(arrayList.get(i).getText());
        }
    }

    private void setFrekv() {
        hzs = frekv.get(0);
    }
}
