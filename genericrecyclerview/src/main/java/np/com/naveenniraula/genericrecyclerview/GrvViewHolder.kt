package np.com.naveenniraula.genericrecyclerview

import android.os.Build
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvBasicListener
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvInternalEventListener
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvRowClickListener

abstract class GrvViewHolder<T : GrvModel, L : GrvBasicListener>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val grvInternalEventListeners by lazy {
        SparseArray<GrvInternalEventListener>()
    }

    /**
     *
     * @param model the model of type [T]
     * @param listener the listener which will be called when item is clicked.
     */
    open fun onBind(model: T, listener: L) {
        (listener as? GrvRowClickListener)?.let {
            itemView.rootView.setOnClickListener {
                listener.onRowClick(adapterPosition)
            }
        }
    }

    fun addInternalEventListener(
        eventType: Int,
        grvInternalEventListener: GrvInternalEventListener
    ) {

        // check if already added
        if (grvInternalEventListeners.indexOfValue(grvInternalEventListener) < 0) {
            grvInternalEventListeners.put(eventType, grvInternalEventListener)
        }
    }

    fun removeInternalEventListener(grvInternalEventListener: GrvInternalEventListener) {

        val indexOfValue = grvInternalEventListeners.indexOfValue(grvInternalEventListener)

        // check if the event exists
        if (indexOfValue > 0) {
            grvInternalEventListeners.remove(indexOfValue)
        }
    }

    fun removeAllInternalEventListeners() {
        val size = grvInternalEventListeners.size()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            grvInternalEventListeners.removeAtRange(0, size)
        } else {
            for (i in 0 until size) {
                grvInternalEventListeners.removeAt(i)
            }
        }
    }

    fun hasInternalEvent(key: Int): Boolean {
        return grvInternalEventListeners.get(key) != null
    }

    fun getEvent(key: Int): GrvInternalEventListener? {
        return grvInternalEventListeners.get(key)
    }

}