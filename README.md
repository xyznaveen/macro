# Macro

Collection of all the libraries developed for personal use

### multiplerecyclerview (RecyclerView boilerplate)

<details>
<summary>click to expand</summary>

Create Adapter Class Extending `RecyclerAdapter<T, ViewHolder>` where `T` is `DataType`
```
// adapter class for the recycler view
class MovieAdapter : RecyclerAdapter<MyModel, MovieAdapter.MovieVh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVh {
        
        // the inflate method takes layoutId and viewgroup to inflate the view
        // you must do this
        val view = inflate(R.layout.item_movie, parent)
        return MovieVh(view)
    }
}

```

Create `ViewHolder` Class Extending `Vh<T, RecyclerItemClickListener>` where `T` is `DataType`
```
// view holder class which will be used in movie adapter
class MovieVh(itemView: View) : Vh<MyModel, RecyclerItemClickListener>(itemView) {
    val name = itemView.im_name
    override fun onBind(model: MyModel, listener: RecyclerItemClickListener) {
        super.onBind(model, listener)
        
        // update views here ; taking data from model
        // the listener ; will always be fired when the root view is clicked
    }
}
```

Using the adapter `MovieAdapter`  
```
// instantiate
val adapter = MovieAdapter()

// set on click listener; must be set even if nothing is being performed
// else exception will be thrown
adapter.setRecyclerItemClickListener(object :
    RecyclerItemClickListener {
    override fun onItemClicked(position: Int) {
        Log.i("BQ7CH72", "Clicked $position")
    }
})

// add new ; List<MyModel> is provided by getData()
adapter.addNewMultiple(getData())
```
</details>

License
----

MIT