package np.com.naveenniraula.multipeviewrecycler.ui.movie

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import np.com.naveenniraula.multipeviewrecycler.R
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvRowClickListener
import np.com.naveenniraula.genericrecyclerview.GrvAdapter
import np.com.naveenniraula.genericrecyclerview.GrvViewHolder
import np.com.naveenniraula.genericrecyclerview.callbacks.GrvInternalEventListener

class MovieAdapter : GrvAdapter<MyModel, MovieAdapter.MovieGrvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGrvViewHolder {
        val view = inflate(R.layout.item_movie, parent)
        return MovieGrvViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieGrvViewHolder, position: Int) {

        holder.addInternalEventListener(ON_DRAG, object : GrvInternalEventListener {
            override fun onInternalEvent(position: Int, vararg obj: Any) {
                Log.d("MovieAdapter", "ON_DRAG[$position] ${obj[0]}")
            }
        })

        super.onBindViewHolder(holder, position)
    }

    class MovieGrvViewHolder(itemView: View) :
        GrvViewHolder<MyModel, GrvRowClickListener>(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.im_name)
        override fun onBind(model: MyModel, listener: GrvRowClickListener) {
            super.onBind(model, listener)
            name.text = model.getDefaultValue()

            itemView.setOnClickListener {
                getEvent(ON_DRAG)?.onInternalEvent(adapterPosition, 3, 4, 5, 6)
            }
        }

    }

    companion object {
        const val ON_DRAG = 2
    }

}