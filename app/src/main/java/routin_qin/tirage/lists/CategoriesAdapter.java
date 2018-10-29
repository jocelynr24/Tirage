package routin_qin.tirage.lists;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import routin_qin.tirage.R;
import routin_qin.tirage.database.DataBaseHelper;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private List<String> titles;
    private List<String> descriptions;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtTitle;
        public TextView txtDescription;
        public ImageButton ibtEdit;
        public ImageButton ibtDelete;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtTitle = (TextView) v.findViewById(R.id.tv_categories_title);
            txtDescription = (TextView) v.findViewById(R.id.tv_categories_description);
            ibtEdit = (ImageButton) itemView.findViewById(R.id.ib_categories_edit);
            ibtDelete = (ImageButton) itemView.findViewById(R.id.ib_categories_delete);
        }
    }

    /*public void add(int position, String item) {
        titles.add(position, item);
        descriptions.add()
        notifyItemInserted(position);
    }

    public void remove(int position) {
        titles.remove(position);
        notifyItemRemoved(position);
    }*/

    // Provide a suitable constructor (depends on the kind of dataset)
    public CategoriesAdapter(List<String> title, List<String> description) {
        titles = title;
        descriptions = description;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_categories, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String title = titles.get(position);
        final String description = descriptions.get(position);
        holder.txtTitle.setText(title);

        holder.ibtEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Edit", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ibtDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Delete", Toast.LENGTH_SHORT).show();
                DataBaseHelper db = new DataBaseHelper(view.getContext());
                db.removeElement(title);
                titles.remove(position);
                notifyItemRemoved(position);
            }
        });

        holder.txtDescription.setText(description);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return titles.size();
    }

}