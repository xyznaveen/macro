package np.com.naveenniraula.multipeviewrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import np.com.naveenniraula.genericrecyclerview.RecyclerAdapter
import np.com.naveenniraula.genericrecyclerview.callbacks.RecyclerItemClickListener
import np.com.naveenniraula.multipeviewrecycler.ui.movie.MovieAdapter
import np.com.naveenniraula.multipeviewrecycler.ui.movie.MyModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recycler view
        val adapter = MovieAdapter()
        adapter.setRecyclerItemClickListener(object :
            RecyclerItemClickListener {
            override fun onItemClicked(position: Int) {
                Log.i("BQ7CH72", "Clicked $position")
            }
        })
        adapter.addNewMultiple(getData())

        am_rv.layoutManager = LinearLayoutManager(this)
        am_rv.adapter = adapter
        am_rv.setHasFixedSize(true)
    }

    private fun getData(): List<MyModel> {

        val arr = ArrayList<MyModel>()

        for (i in 0..10) {
            arr.add(MyModel())
        }

        return arr
    }

}
