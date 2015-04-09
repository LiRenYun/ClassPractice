package com.roy.listviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tcumi_H505 on 2015/4/9.
 */
public class ListAdapter extends BaseAdapter {
    private Integer[] fruitPictures = null;
    private String[] fruits = null;


    private Context mContext;
    private static LayoutInflater inflater = null;

    public ListAdapter(Context c , Integer i[],String s[]) {
        mContext = c;
        fruitPictures = i;
        fruits = s;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fruits.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        view = inflater.inflate(R.layout.list_item_layout, null);
        TextView text = (TextView) view.findViewById(R.id.textView);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);

        image.setImageResource(fruitPictures[position]);
        text.setText(fruits[position]);
        return view;
    }
}
