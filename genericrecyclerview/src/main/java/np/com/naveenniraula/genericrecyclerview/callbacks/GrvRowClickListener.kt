package np.com.naveenniraula.genericrecyclerview.callbacks

/**
 * This click listener is fired when a row is clicked.
 */
interface GrvRowClickListener : GrvBasicListener {

    /**
     * Send back the position of the row clicked.
     */
    fun onRowClick(position: Int)
}