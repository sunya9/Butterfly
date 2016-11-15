package net.unsweets.butterfly.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.unsweets.butterfly.R;

import java.util.List;

public class StreamAdapter<T> extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {
    private final static String TAG = StreamAdapter.class.getSimpleName();
    private final List<T> mDataset;

    public StreamAdapter(List<T> dataset) {
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mAvatar;
        private final TextView mTitle;
        private final TextView mBody;

        public ViewHolder(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.list_item_avatar);
            mTitle = (TextView) itemView.findViewById(R.id.list_item_title);
            mBody = (TextView) itemView.findViewById(R.id.list_item_body);
        }
    }
}
