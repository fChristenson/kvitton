package se.fredrik.kvitton;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by fredrik on 2017-01-03.
 */

public class ListAdapter extends BaseAdapter {
    private  Context context;
    private LayoutInflater inflater;
    private String[] strings;
    private Typeface face;
    private Typeface boldFace;

    public ListAdapter(Context context, String[] strings) {
        this.context = context;
        this.strings = strings;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.face = Typeface.createFromAsset(context.getAssets(), Constants.PRIMARY_FONT);
        this.boldFace = Typeface.createFromAsset(context.getAssets(), Constants.PRIMARY_FONT_BOLD);
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int i) {
        return strings[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = inflater.inflate(R.layout.row, viewGroup, false);

        TextView store = (TextView) row.findViewById(R.id.store);
        TextView date = (TextView) row.findViewById(R.id.date);
        TextView price = (TextView) row.findViewById(R.id.price);
        TextView code = (TextView) row.findViewById(R.id.code);

        store.setTypeface(face);
        date.setTypeface(face);
        price.setTypeface(boldFace);
        code.setTypeface(boldFace);

        return row;
    }
}
