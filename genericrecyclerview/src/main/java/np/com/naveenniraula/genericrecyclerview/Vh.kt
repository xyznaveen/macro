package np.com.naveenniraula.genericrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import np.com.naveenniraula.genericrecyclerview.callbacks.BaseListener
import np.com.naveenniraula.genericrecyclerview.callbacks.RecyclerItemClickListener

abstract class Vh<T : RecyclerModel, L : BaseListener>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    /**
     *
     * @param model the model of type [T]
     * @param listener the listener which will be called when item is clicked.
     */
    open fun onBind(model: T, listener: L) {
        if (listener is RecyclerItemClickListener) {
            itemView.rootView.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }
}