import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by cao on 2017/2/17.
 */
public class test {

    @Test
    public void tests() throws UnsupportedEncodingException {
        System.out.println(Charset.defaultCharset().name());
        System.out.println(new String(new byte[]{-27, -111, -88, -26, -99, -80, -28, -68, -90}));
        byte[] str=new byte[]{-42,-36,-67,-36,-62,-41};
        System.out.println(new String(new byte[]{-42,-36,-67,-36,-62,-41}));
        System.out.println(new String(str,"gbk"));
        System.out.println(new String(str,"iso-8859-1"));
    }
}
