package com.hodachop93.hohoda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hodachop93.hohoda.R;
import com.hodachop93.hohoda.model.NavigationDrawerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hop on 04/03/2016.
 */
public class NavigationDrawerAdapter extends BaseAdapter {
    private Context mContext;
    private int selectedItem = -1;
    private List<NavigationDrawerItem> navItems;

    public NavigationDrawerAdapter(Context mContext) {
        this.mContext = mContext;
        navItems = createNavigationDrawerItems();
    }

    @Override
    public int getCount() {
        return (navItems == null) ? 0 : navItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public String getTitleSelectedItem(int position){
        return navItems.get(position).getTitle();
    }

    public void setSelectedItem(int position) {
        this.selectedItem = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.navigation_drawer_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        setValue(viewHolder, position);
        return convertView;
    }

    private void setValue(ViewHolder viewHolder, int position) {
        NavigationDrawerItem item = navItems.get(position);

        viewHolder.title.setText(item.getTitle());
        viewHolder.icon.setImageResource(item.getIconResourceId());
        viewHolder.divider.setVisibility(item.isShowDivider() ? View.VISIBLE : View.INVISIBLE);
    }

    private List<NavigationDrawerItem> createNavigationDrawerItems() {
        List<NavigationDrawerItem> items = new ArrayList<>();

        //add items here
        items.add(new NavigationDrawerItem(mContext.getString(R.string.nav_menu_item_dashboard),
                R.drawable.ic_nav_menu_item_dashboard, false));
        items.add(new NavigationDrawerItem(mContext.getString(R.string.nav_menu_item_notifications),
                R.drawable.ic_nav_menu_item_notifications, false));
        return items;
    }

    static class ViewHolder {
        @Bind(R.id.nav_drawer_item_icon)
        ImageView icon;
        @Bind(R.id.nav_drawer_item_title)
        TextView title;
        @Bind(R.id.nav_drawer_item_divider)
        View divider;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
