package hercerm.uady.fmtreviewsback.math;

public final class MathUtils {

    /**
     * <p>
     *     Compute the updated arithmetic mean provided the old mean, the old amount of values and the new value.
     *     Does not provide support for weighted arithmetic means.
     * </p>
     *
     * @param oldMean           previous arithmetic mean.
     * @param oldAmountOfValues amount of values before the new value.
     * @param newValue          new value to be accounted for in the new mean.
     * @return arithmetic mean accounting the new value.
     */
    public static double computeMeanProvidedNewValue(double oldMean, int oldAmountOfValues, double newValue) {
        return ((oldAmountOfValues * oldMean) + newValue) / (oldAmountOfValues + 1.0);
    }
}
