package com.zjmByte.ArtConcurrentBook.chapterSeven;

import sun.misc.Unsafe;

/**
 * @author zhujianmin
 */
public class AtomicChar  implements java.io.Serializable {

    // setup to use Unsafe.compareAndSwapInt for updates
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (AtomicChar.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile char value;

    /**
     * Creates a new {@code AtomicBoolean} with the given initial value.
     *
     * @param initialValue the initial value
     */
    public AtomicChar(char initialValue) {
        value = initialValue;
    }

    public final char get() {
        return value;
    }

}
