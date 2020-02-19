package np.com.naveenniraula.multipeviewrecycler.ui.movie

import np.com.naveenniraula.genericrecyclerview.GrvModel

data class MyModel(
    val test: String = ""
): GrvModel {
    override fun getDefaultValue(): String {
        return test
    }
}