# Macro

Collection of all the libraries developed for personal use

### Generic Recycler View (RecyclerView boilerplate for handling the obvious.)

<details>
<summary>click to expand</summary>

**STEP 1 :** Create a model for UI `MyModel` implementing `GrvModel` and override the `getDefaultValue()` as below:
```kotlin
data class MyModel(
    val name: String = ""
): GrvModel {
    override fun getDefaultValue(): String {
        return name
    }
}
```

Create Adapter Class Extending `GrvAdapter<T, ViewHolder>` where `T` is `DataType` which extends 
`GrvModel` as shown below:
```kotlin
// adapter class for the recycler view
class MovieAdapter : GrvAdapter<MyModel, MovieAdapter.MovieVh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVh {
        
        // the inflate method takes layoutId and viewgroup to inflate the view
        // you must do this
        val view = inflate(R.layout.item_movie, parent)
        return MovieVh(view)
    }
}

```

Create `ViewHolder` Class Extending `GrvViewHolder<T, GrvRowClickListener>` where `T` is `DataType`
```kotlin
// view holder class which will be used in movie adapter
class MovieVh(itemView: View) : GrvViewHolder<MyModel, GrvRowClickListener>(itemView) {

    override fun onBind(model: MyModel, listener: GrvRowClickListener) {
        // if you donot want to fire the listener when the root view is clicked don't call super.
        super.onBind(model, listener)
        
        // update views here ; data is available in model
    }
}
```

Using the adapter `MovieAdapter`  
```kotlin
// instantiate
val adapter = MovieAdapter()

// set on click listener; must be set even if nothing is being performed
// else exception will be thrown
adapter.setGrvRowClickListener(object : GrvRowClickListener {
    override fun onGrvRowClick(position: Int, vararg obj: Any) {
        Log.i("BQ7CH72", "clicked @ $position we have obj[0]")
    }
})

// add new ; List<MyModel> is provided by getData()
adapter.addNewMultiple(getData())
```
</details>

License
----

MIT