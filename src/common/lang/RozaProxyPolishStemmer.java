package common.lang;

import org.getopt.stempel.Stemmer;
import org.tartarus.snowball.SnowballProgram;

public class RozaProxyPolishStemmer extends SnowballProgram {
    Stemmer stemmer = new Stemmer();
    volatile String word;

    @Override
    public void setCurrent(java.lang.String value) {
        synchronized (this) {
            word = value;
        }
    }

    @Override
    public boolean stem() {
        synchronized (this) {
            word = stemmer.stem(this.getCurrent(), true);
            return true;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    @Override
    public java.lang.String getCurrent() {
        synchronized (this) {
            return word;
        }
    }
}
