package donggi.whiteship_java.week6;

import static org.junit.jupiter.api.Assertions.*;

import donggi.whiteship_java.week6.Tv.CaptionTv;
import org.junit.jupiter.api.Test;

class TvTest {

    @Test
    void CaptionTvTest() {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCation("Hello, World!");
        ctv.caption = true;
        ctv.displayCation("Hello, World!!!");
    }
}
