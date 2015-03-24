package sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class PlaySound {
    private double[] amplitudy;
    private double[] fazy;

    public float SAMPLE_RATE = 150000;  /*440*2^6*/
        
        
    public PlaySound(double[] amplitudy, double[] fazy) {
        this.amplitudy = amplitudy;
        this.fazy = fazy;
    }
        
    public void sound(int hzs, int msecs, double vol) throws LineUnavailableException {
        if (vol > 1.0 || vol < 0.0) {
            throw new IllegalArgumentException("Hlasitost musi byt v rozsahu 0.0 - 1.0");
        }
                
        byte[] buf = new byte[(int)SAMPLE_RATE * msecs / 1000];
        for (int i=0; i < buf.length; i++) {
            /*buf[i] = (byte)((Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI) * 127.0 * 0.5)  //0,382993159
                                + (Math.sin(((i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI * 440) * 127.0 * 0.5) + 6.28))
                                + (Math.sin(((i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI * 440) * 127.0 * 0.5) + 3.14))
                                
                                );*/
                        
                            buf[i] = (byte)((Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI) * 127.0 * amplitudy[0]) + fazy[0]);
                            for(int j = 1; j < amplitudy.length; j++){
                                buf[i] += (byte)((127.0 * amplitudy[j] * Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI*j  + fazy[j])));
                            }
                            
                           
                    //buf[i] = (byte)(vol*(Math.sin(((i*hzs*2*Math.PI)) + ((2*Math.PI)/360)))); //
        }

        // shape the front and back 10ms of the wave form
        for (int i=0; i < SAMPLE_RATE / 100.0 && i < buf.length / 2; i++) {
            buf[i] = (byte)(buf[i] * i / (SAMPLE_RATE / 100.0));
            buf[buf.length-1-i] = (byte)(buf[buf.length-1-i] * i / (SAMPLE_RATE / 100.0));
        }

        AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 2, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        sdl.write(buf, 0, buf.length);
        sdl.drain();
        sdl.close();
    }
}
