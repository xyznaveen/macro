package np.com.naveenniraula.genericrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvRowClickListener

abstract class GrvAdapter<M : GrvModel, V : GrvViewHolder<M, GrvRowClickListener>> :
    RecyclerView.Adapter<V>() {

    private val models: ArrayList<M> by lazy {
        ArrayList<M>()
    }
    private lateinit var grvRowClickListener: GrvRowClickListener
    private lateinit var layoutInflater: LayoutInflater

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        if (::grvRowClickListener.isInitialized) {
            holder.onBind(models[position], grvRowClickListener)
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
     * Get value of [T] from specified position.
     *
     * @param position the position of the model.
     * @return
     */
    fun get(position: Int): M {
        return this.models[position]
    }

    /**
     * Add list of item to this adapter's instance
     *
     * @param dataList list of item[M] whose common methods can be accessed.
     */
    fun addMultiple(dataList: List<M>) {
        this.models.addAll(dataList)
        notifyItemRangeInserted(this.models.size, dataList.size)
    }

    /**
     * Clear current list od data and add list of item to this adapter instance.
     *
     * @param dataList list of item[M] whose common methods can be accessed.
     */
    fun addNewMultiple(dataList: List<M>) {

        clearDataList()

        this.models.addAll(dataList)
        notifyItemRangeInserted(this.models.size, dataList.size)
    }

    /**
     * Add a single model item to the recycler view.
     *
     * @param item the item which extends [M] and whose common methods can be accessed.
     */
    fun addOne(item: M) {
        this.models.add(item)
        notifyItemInserted(this.models.size)
    }

    fun add(position: Int, item: M) {

        if (position <= -1) return

        models.add(position, item)
        notifyItemInserted(position)
    }

    fun update(position: Int, item: M) {

        if (position <= -1) {
            return
        }

        if (models.isEmpty()) {
            return
        }

        models[position] = item
        notifyItemChanged(position)
    }

    /**
     * Add a single model item to the recycler view.
     *
     * @param item the item which extends [T] and whose common methods can be accessed.
     */
    fun remove(position: Int) {

        if (position != -1) {
            this.models.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * Removes the last item from the data set.
     */
    fun removeLast() {
        val itemPosition = models.size - 1
        if (itemPosition > -1 && models.isNotEmpty()) {
            this.models.removeAt(itemPosition)
            notifyItemRemoved(itemPosition)
        }
    }

    /**
     * Removes the last item from the data set.
     */
    fun removeFirst() {
        val itemPosition = 0
        if (models.isNotEmpty()) {
            this.models.removeAt(itemPosition)
            notifyItemRemoved(itemPosition)
        }
    }

    /**
     * Clear all items in this list.
     */
    private fun clearDataList() {

        val prevSize = models.size
        models.clear()
        notifyItemRangeRemoved(0, prevSize)
    }

    /**
     * Click listener for internal navigation.
     */
    fun setGrvRowClickListener(grvRowClickListener: GrvRowClickListener) {
        this.grvRowClickListener = grvRowClickListener
    }

    /**
     * Add a single model item to the recycler view.
     *
     * @param item the item which extends [T] and whose common methods can be accessed.
     */
    fun remove(item: M) {

        val itemPosition = getItemPosition(item)

        if (itemPosition != -1) {
            this.models.remove(item)
            notifyItemRemoved(itemPosition)
        }
    }

    /**
     * Returns the position of the item in the [ArrayList].
     *
     * @return [Int] the position of the item. -1 if not found
     */
    private fun getItemPosition(item: M): Int {
        for ((currentIndex, data) in models.withIndex()) {
            if (data == item) return currentIndex
        }
        return -1
    }

}
