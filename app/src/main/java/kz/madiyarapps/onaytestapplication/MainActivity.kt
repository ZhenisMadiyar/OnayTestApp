package kz.madiyarapps.onaytestapplication

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kz.madiyarapps.onaytestapplication.ui.tags.TagsFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TagsFragment.newInstance())
                    .commitNow()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}