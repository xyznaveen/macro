package np.com.naveenniraula.genericrecyclerview.callbacks

interface GrvInternalEventListener : GrvBasicListener {
    /**
     * When some event has happened at the specified position.
     */
    fun onInternalEvent(position: Int, vararg obj: Any)
}