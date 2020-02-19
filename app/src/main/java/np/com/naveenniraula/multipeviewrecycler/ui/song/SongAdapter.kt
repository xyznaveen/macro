package np.com.naveenniraula.multipeviewrecycler.ui.song

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_movie.view.*
import np.com.naveenniraula.genericrecyclerview.GrvAdapter
import np.com.naveenniraula.genericrecyclerview.GrvViewHolder
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvRowClickListener
import np.com.naveenniraula.multipeviewrecycler.R
import np.com.naveenniraula.multipeviewrecycler.ui.movie.MyModel

class SongAdapter : GrvAdapter<MyModel, SongAdapter.SongMv>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongMv {
        return SongMv(inflate(R.layout.item_movie, parent))
    }

    class SongMv(itemView: View) : GrvViewHolder<MyModel, GrvRowClickListener>(itemView) {
        val name = itemView.im_name
        override fun onBind(model: MyModel, listener: GrvRowClickListener) {
            super.onBind(model, listener)
            // update views
            val value = model
        }
    }

}