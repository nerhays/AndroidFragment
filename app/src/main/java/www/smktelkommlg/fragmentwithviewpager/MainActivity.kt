package www.smktelkommlg.fragmentwithviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SendMassage {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun sendData(massage: String?) {

        val tag = "android:switcher:"+R.id.viewPager.toString()+":"+1
        val f = supportFragmentManager.findFragmentByTag(tag) as FragmentTwo?

        f!!.displayReceiveData(massage!!)
        var currentItem = getItem(+1)
        viewPager.currentItem = currentItem

    }
    fun getItem (i:Int) = viewPager.currentItem +i
}