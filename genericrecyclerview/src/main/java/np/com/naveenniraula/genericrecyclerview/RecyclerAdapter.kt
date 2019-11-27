package np.com.naveenniraula.genericrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import np.com.naveenniraula.genericrecyclerview.callbacks.RecyclerItemClickListener

abstract class RecyclerAdapter<T : RecyclerModel, V : Vh<T, RecyclerItemClickListener>> :
    RecyclerView.Adapter<V>() {

    private val dataList: ArrayList<T> = arrayListOf()
    private lateinit var clickListener: RecyclerItemClickListener
    private lateinit var layoutInflater: LayoutInflater

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        try {
            holder.onBind(dataList[position], clickListener)
        } catch (upace: UninitializedPropertyAccessException) {
            upace.printStackTrace()
            Log.d("RecyclerAdapter", upace.localizedMessage)
        }
    }

    /**
     * Creates the view and returns the new view instance
     *
     * @param layoutResourceId the layout resource file
     * @param parent the parent view group from [onCreateViewHolder]
     * @return the inflated view.
     */
    fun inflate(layoutResourceId: Int, parent: ViewGroup): View {
        layoutInflater = LayoutInflater.from(parent.context)
        return layoutInflater.inflate(layoutResourceId, parent, false)
    }

    /**
     * Add list of item to this adapter's instance
     *
     * @param dataList list of item[T] whose common methods can be accessed.
     */
    fun addMultiple(dataList: List<T>) {
        this.dataList.addAll(dataList)
        notifyItemRangeInserted(this.dataList.size, dataList.size)
    }

    /**
     * Clear current list od data and add list of item to this adapter instance.
     *
     * @param dataList list of item[T] whose common methods can be accessed.
     */
    fun addNewMultiple(dataList: List<T>) {

        clearDataList()

        this.dataList.addAll(dataList)
        notifyItemRangeInserted(this.dataList.size, dataList.size)
    }

    /**
     * Add a single model item to the recycler view.
     *
     * @param item the item which extends [T] and whose common methods can be accessed.
     */
    fun addOne(item: T) {
        this.dataList.add(item)
        notifyItemInserted(this.dataList.size)
    }

    /**
     * Get value of [T] from specified position.
     *
     * @param position the position of the model.
     * @return
     */
    fun getItemAt(position: Int): T {
        return this.dataList[position]
    }

    /**
     * Clear all items in this list.
     */
    private fun clearDataList() {

        val prevSize = dataList.size
        dataList.clear()
        notifyItemRangeRemoved(0, prevSize)
    }

    /**
     * Click listener for internal navigation.
     */
    fun setRecyclerItemClickListener(recyclerItemClickListener: RecyclerItemClickListener) {
        this.clickListener = recyclerItemClickListener
    }

}
