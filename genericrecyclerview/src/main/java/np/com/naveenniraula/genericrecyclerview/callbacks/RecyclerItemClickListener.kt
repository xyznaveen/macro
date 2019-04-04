package np.com.naveenniraula.genericrecyclerview.callbacks

interface RecyclerItemClickListener : BaseListener {
    fun onItemClicked(position: Int) {}
}