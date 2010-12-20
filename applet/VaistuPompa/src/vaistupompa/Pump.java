package vaistupompa;

/**
 *
 * @author Vytautas
 */
public class Pump {

    // <editor-fold defaultstate="collapsed" desc="Private members">

    private int _blockingTime;
    private int _lastRequest = Integer.MIN_VALUE;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ctor">

    public Pump(int blockingTime) {
        _blockingTime = blockingTime;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Public methods">

    public boolean allowed(int tm) {
        if ((_lastRequest + getBlockingTime()) < tm) {
            _lastRequest = tm;

            return true;
        }

        return false;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get/Set methods">

    /**
     * @return the _blockingTime
     */
    public int getBlockingTime() {
        return _blockingTime;
    }

    /**
     * @param blockingTime the _blockingTime to set
     */
    public void setBlockingTime(int blockingTime) {
        this._blockingTime = blockingTime;
    }

    // </editor-fold>
}
