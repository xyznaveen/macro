package np.com.naveenniraula.multipeviewrecycler.ui.movie

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_movie.view.*
import np.com.naveenniraula.multipeviewrecycler.R
import np.com.naveenniraula.genericrecyclerview.callbacks.RecyclerItemClickListener
import np.com.naveenniraula.genericrecyclerview.RecyclerAdapter
import np.com.naveenniraula.genericrecyclerview.Vh

class MovieAdapter : RecyclerAdapter<MyModel, MovieAdapter.MovieVh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVh {
        val view = inflate(R.layout.item_movie, parent)
        return MovieVh(view)
    }

    class MovieVh(itemView: View) : Vh<MyModel, RecyclerItemClickListener>(itemView) {
        val name = itemView.im_name
        override fun onBind(model: MyModel, listener: RecyclerItemClickListener) {
            super.onBind(model, listener)
            // update views
            val value = model
        }
    }

}