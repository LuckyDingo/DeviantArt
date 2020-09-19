package me.saket.inboxrecyclerview

import androidx.appcompat.app.AppCompatActivity

/**
 * An Activity that can be dismissed by pulling it vertically.
 * Requires these these properties to be present in the Activity theme:
 *
 * <item name="android:windowIsTranslucent">true</item>
 * <item name="android:colorBackgroundCacheHint">@null</item>
 */
//abstract class PullCollapsibleActivity : AppCompatActivity() {
//
//  private lateinit var activityPageLayout: StandaloneExpandablePageLayout
//
//  private var expandCalled = false
//  private var expandedFromRect: Rect? = null
//  private var standardToolbarHeight: Int = 0
//  private var pullCollapsibleEnabled = true
//  private var wasActivityRecreated: Boolean = false
//  private var entryAnimationEnabled = true
//
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    wasActivityRecreated = savedInstanceState == null
//
//    if (entryAnimationEnabled && pullCollapsibleEnabled) {
//      overridePendingTransition(0, 0)
//    }
//
//    standardToolbarHeight = Views.toolbarHeight(this)
//  }
//
//  override fun onStart() {
//    super.onStart()
//
//    if (expandCalled.not()) {
//      throw AssertionError("Did you forget to call expandFromTop()/expandFrom()?")
//    }
//  }
//
//  fun setEntryAnimationEnabled(entryAnimationEnabled: Boolean) {
//    this.entryAnimationEnabled = entryAnimationEnabled
//  }
//
//  /**
//   * Defaults to true. When disabled, this behaves like a normal Activity with no expandable page animations.
//   * Should be called before onCreate().
//   */
//  protected fun setPullToCollapseEnabled(enabled: Boolean) {
//    pullCollapsibleEnabled = enabled
//  }
//
//  override fun setContentView(layoutResID: Int) {
//    val parent = findViewById<ViewGroup>(android.R.id.content)
//    val view = layoutInflater.inflate(layoutResID, parent, false)
//    setContentView(view)
//  }
//
//  override fun setContentView(view: View) {
//    activityPageLayout = wrapInExpandablePage(view)
//    super.setContentView(activityPageLayout)
//    expandFromTop()
//  }
//
//  override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
//    activityPageLayout = wrapInExpandablePage(view)
//    super.setContentView(activityPageLayout, params)
//    expandFromTop()
//  }
//
//  private fun wrapInExpandablePage(view: View): StandaloneExpandablePageLayout {
//    val pageLayout = StandaloneExpandablePageLayout(this)
//    pageLayout.elevation = resources.getDimensionPixelSize(R.dimen.irv_pull_collapsible_activity_elevation).toFloat()
//    pageLayout.background = windowBackgroundFromTheme()
//
//    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//    if (pullCollapsibleEnabled) {
//      pageLayout.pullToCollapseThresholdDistance = standardToolbarHeight
//      pageLayout.onPageRelease = { collapseEligible ->
//        if (collapseEligible) {
//          finish()
//        }
//      }
//
//      pageLayout.addStateChangeCallbacks(object : SimplePageStateChangeCallbacks() {
//        override fun onPageCollapsed() {
//          super@PullCollapsibleActivity.finish()
//          overridePendingTransition(0, 0)
//        }
//      })
//
//    } else {
//      pageLayout.pullToCollapseEnabled = false
//      pageLayout.expandImmediately()
//    }
//
//    pageLayout.addView(view)
//    return pageLayout
//  }
//
//  protected fun expandFromTop() {
//    expandCalled = true
//    activityPageLayout.executeOnMeasure {
//      val toolbarRect = Rect(0, standardToolbarHeight, activityPageLayout.width, standardToolbarHeight)
//      expandFrom(toolbarRect)
//    }
//  }
//
//  protected fun expandFrom(fromRect: Rect) {
//    expandCalled = true
//
//    expandedFromRect = fromRect
//    activityPageLayout.executeOnMeasure {
//      if (wasActivityRecreated) {
//        activityPageLayout.expandFrom(fromRect)
//      } else {
//        activityPageLayout.expandImmediately()
//      }
//    }
//  }
//
//  override fun finish() {
//    // Note to self: It's important to check if expandedFromRect != null
//    // and not expandCalled, because expandCalled gets set after the page
//    // layout gets measured.
//
//    if (pullCollapsibleEnabled && expandedFromRect != null) {
//      activityPageLayout.collapseTo(expandedFromRect!!)
//    } else {
//      super.finish()
//    }
//  }
//
//  override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    return if (item.itemId == android.R.id.home) {
//      finish()
//      true
//
//    } else {
//      super.onOptionsItemSelected(item)
//    }
//  }
//
//  private fun windowBackgroundFromTheme(): Drawable {
//    val attributes = TypedValue()
//    theme.resolveAttribute(android.R.attr.windowBackground, attributes, true)
//    val isColorInt = attributes.type >= TypedValue.TYPE_FIRST_COLOR_INT && attributes.type <= TypedValue.TYPE_LAST_COLOR_INT
//
//    return when {
//      isColorInt -> ColorDrawable(attributes.data)
//      else -> ContextCompat.getDrawable(this, attributes.resourceId)!!
//    }
//  }
//}
class PullCollapsibleActivity : AppCompatActivity() {

}
