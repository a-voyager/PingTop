package com.pingtop.android.manager;

import android.content.Context;

import com.pingtop.android.R;
import com.pingtop.android.entities.PageItem;
import com.pingtop.android.views.fragments.main.CommunityFragment;
import com.pingtop.android.views.fragments.main.EngagementFragment;
import com.pingtop.android.views.fragments.main.HandpickFragment;
import com.pingtop.android.views.fragments.main.ZoneFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 2016/7/16 9:56.
 */
public class PageDataFactory {
    public static List<PageItem> createPages(Context context) {
        ArrayList<PageItem> pageItems = new ArrayList<>();
        pageItems.add(new PageItem(new HandpickFragment(), context.getString(R.string.title_handpick)));
        pageItems.add(new PageItem(new EngagementFragment(), context.getString(R.string.title_engagement)));
        pageItems.add(new PageItem(new CommunityFragment(), context.getString(R.string.title_community)));
        pageItems.add(new PageItem(new ZoneFragment(), context.getString(R.string.title_zone)));
        return pageItems;
    }
}
