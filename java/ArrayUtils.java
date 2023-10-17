import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ArrayUtils {

    private ArrayUtils() {
        // Utility class.
    }

    /**
     * Copy the source array in the destination one at 0 index
     * If length of the source array is greeter than the destination one
     * copy from 0 to destination length otherwise 0 to source length.
     * <br>
     * Equivalent of:
     * <pre>
     * ArrayUtils.copy(src, dest, 0);
     * </pre>
     *
     * @param src The source array
     * @param dest The destination array.
     * @see ArrayUtils#copy(Object[], Object[], int)
     */
    public static void copy(final Object[] src, final Object[] dest) {
        ArrayUtils.copy(src, dest, 0);
    }

    /**
     * Copy the source array in the destination one at 0 index.
     * If length of the source array is greeter than the destination one
     * copy from 0 to destination length otherwise 0 to source length.
     * @param src The source array
     * @param dest The destination array.
     * @param srcPos Starting position in the source array.
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public static void copy(final Object[] src, final Object[] dest, final int srcPos) {
        if (src.length <= srcPos) {
            return;
        }
        System.arraycopy(src, srcPos, dest, 0, src.length > dest.length
                        ? dest.length
                        : src.length);
    }

    /**
     * Fill the array with the results of the given factory.
     * @param <T> Array type
     * @param array Array to fill.
     * @param factory Object supplier.
     * @return The same input array.
     */
    public static <T> T[] fill(final T[] array, final Supplier<T> factory) {
        for (int i = 0; i < array.length; i++) {
            array[i] = factory.get();
        }
        return array;
    }

    /**
     * Fill the array with the results of the given factory.
     * @param <T> Array type
     * @param array Array to fill.
     * @param factory Object supplier.
     * @return The same input array.
     */
    public static <T> T[] fill(final T[] array, final IntFunction<T> factory) {
        for (int i = 0; i < array.length; i++) {
            array[i] = factory.apply(i);
        }
        return array;
    }
}
