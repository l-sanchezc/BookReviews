package edu.iit.lazaro.bookreviews;

/**
 * Created by Lazaro on 4/6/16.
 */
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Book> {

    private List<Book> items;

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public ListAdapter(Context context, int resource, List<Book> items) {
        super(context, resource, items);

        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlistrow, null);
        }

        Book p = getItem(position);

        if (p != null) {
            ImageView im = (ImageView) v.findViewById(R.id.image);
            TextView tt1 = (TextView) v.findViewById(R.id.title);
            TextView tt3 = (TextView) v.findViewById(R.id.author);
            RatingBar rb = (RatingBar) v.findViewById(R.id.rating);
            if (im != null) {
                if (p.getImageName().equals("beginning")) {
                    im.setImageResource(R.drawable.beginning);
                }
                if (p.getImageName().equals("hello")) {
                    im.setImageResource(R.drawable.hello);
                }
                if (p.getImageName().equals("professional")) {
                    im.setImageResource(R.drawable.professional);
                }
                if (p.getImageName().equals("programming")) {
                    im.setImageResource(R.drawable.programming);
                }
            }
            if (tt1 != null) {
                tt1.setText(p.getTitle());
            }
            if (tt3 != null) {
                tt3.setText(p.getAuthor());
            }
            if (rb != null) {
                float rating = Float.parseFloat(p.getRating());
                rb.setRating(rating);
            }
        }

        return v;
    }
}