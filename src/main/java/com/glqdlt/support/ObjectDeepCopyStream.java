package com.glqdlt.support;

import java.io.*;

/**
 * @author glqdlt
 */
public class ObjectDeepCopyStream {

    public static class Output extends ObjectOutputStream {

        public Output(OutputStream out) throws IOException {
            super(out);
        }
    }

    public static class Input extends ObjectInputStream {

        public Input(InputStream in) throws IOException {
            super(in);
        }
    }


}
